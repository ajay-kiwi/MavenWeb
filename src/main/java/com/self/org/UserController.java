package com.self.org;

import java.util.*;
import java.io.*;

import javax.servlet.http.HttpServletRequest;

import com.self.org.db.dao.InterestDAO;
import com.self.org.config.Configuration;
import com.self.org.db.entity.UserInterest;

import org.joda.time.Instant;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.commons.io.*;
import org.apache.commons.codec.binary.*;

import com.self.org.util.*;
import com.self.org.db.dao.UserDAO;
import com.self.org.db.entity.User;
import com.self.org.util.StringUtils;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.self.org.db.dao.SocialUserDAO;

import net.sf.cglib.proxy.Factory;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import com.self.org.db.entity.SocialUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.FileHandler;
import java.util.logging.Handler;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.ResponseBody;

import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaFactory;

import com.self.org.ApplicationURL;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletOutputStream;

import org.apache.commons.fileupload.FileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.io.FileDeleteStrategy;

@RequestMapping(value = "/users")
@Controller
public class UserController extends BaseController {
    @Autowired
    UserDAO userDAO;
    
    @Autowired
    SocialUserDAO socialuserDAO;

	@Autowired
	Configuration env;

    @RequestMapping(method = RequestMethod.POST)
    public String createUser(HttpServletRequest request,
                             @RequestParam(required = true) String username,
                             @RequestParam(required = true) String displayname,
                             @RequestParam(required = true) String email,
                             @RequestParam(required = true) String password,
                             @RequestParam(value = "confirm_password", required = true) String confirmPassword,
                             @RequestParam(value = "timezone_id", required = true) Short timezoneId, Model model) {
    	ReCaptcha c = ReCaptchaFactory.newReCaptcha(env.get("recaptcha.publickey"),env.get("recaptcha.privatekey") , false);//Here put your own key like Publike_Key, Private_Key, False respectively
        String results = c.createRecaptchaHtml("Invalid captcha!", "clean", 1);
        model.addAttribute("recaptcha", results);
        User viewer = getViewer(request);
        
        if (viewer != null) {
            return authRedirect(request);
        }

        if (!password.equals(confirmPassword)) {
            return authRedirect(request);
        }
        
        String remoteAddr = request.getRemoteAddr();
        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey(env.get("recaptcha.privatekey"));
		String challenge = request.getParameter("recaptcha_challenge_field");
		String uresponse = request.getParameter("recaptcha_response_field");
		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
		
		String response = "";
		int flag = 0;
		if(!reCaptchaResponse.isValid()){
			response = "landing";
			model.addAttribute("error", "Invalid captcha!");
			model.addAttribute("username", username);
			model.addAttribute("email", email);
			request.getSession().setAttribute("rerror", "Invalid captcha!");
			flag = 1;
		}else if(getUsernameValidation(username)){
			response = "landing";
			model.addAttribute("error", "Username already exists!");
			model.addAttribute("username", username);
			model.addAttribute("email", email);
			request.getSession().setAttribute("rerror", "Username already exists!");
			flag = 1;
		}else if(getEmailValidation(email)){
			response = "landing";
			model.addAttribute("error", "Email already exists!");
			model.addAttribute("username", username);
			model.addAttribute("email", email);
			request.getSession().setAttribute("rerror", "Email already exists!");
			flag = 1;
		}else{
			String uid = UUID.randomUUID().toString(); // Generate Unique ID append with email;
	        Instant joinedAt = Instant.now();
	        User newUser = new User();
	        newUser.setUsername(username);
	        newUser.setDisplayname(displayname);
	        newUser.setEmail(email);
	        newUser.setPassword(password);
	        String encryptedPassword = User.getEncryptedPassword(newUser);
	        newUser.setPassword(encryptedPassword);
	        newUser.setRegToken(uid);
	        newUser.setLoginstatus(0);
	        newUser.setCurrentlogin("Normal");
	        long userId = userDAO.save(newUser);
	        request.getSession().setAttribute("user_id", userId);
			String url = request.getRequestURL().toString();
			ApplicationURL.getInstance().setUrl(url);
	        sendMail(url,newUser, uid, env.get("email.registration.subject"), env.get("email.registration.message"), "/account/activate?uid=");
	        request.getSession().setAttribute("user_id", newUser.getId());
	        request.getSession().setAttribute("created", 1);
		}
		if(flag == 1){
        	response = "redirect:/#modal_join";
        }
        else{
        	response = "redirect:/";
        }
        return response;
    }
    
    @RequestMapping(value = "/{username}/updateprofile",method = RequestMethod.POST)
    public String updateUser(HttpServletRequest request,
 				    		 @RequestParam(value = "displayname", required = true) String displayname,
				    		 @RequestParam(value = "copydisplayname", required = true) String copydisplayname,
                             @RequestParam(value = "email", required = true) String email,
                             @RequestParam(value = "copyemail", required = true) String copyemail,
                             @RequestParam(value = "about", required = true) String aboutyou,
                             @RequestParam(value = "copyabout", required = true) String copyaboutyou,
                             Model model) throws Exception{
    	
    	User newuser = getViewer(request);
    	boolean isEmailChanged = false;
        if (newuser == null) {
            return authRedirect(request);
        }
        
    	String[] words = request.getParameterValues("interestcheck");
		UserInterest usr = new UserInterest();
		interestDAO.deleteInterest(newuser.getId());
		if(words != null){
	    	for (String str : words) {
				if(str != null && !str.equals("0")){
				    usr.setUser_id(newuser.getId().intValue());
				    usr.setInterest_id(Integer.parseInt(str));
				    interestDAO.save(usr);
				    model.addAttribute("key", "error");
		        	model.addAttribute("value", "Your profile has been updated Successfully!");
				}
			}
		}
        
        try{
        String response = "";
        int flag = 0;
	        if (!displayname.equals(copydisplayname)) {
	    		newuser.setDisplayname(displayname);
		        flag = 1;
	    	}
        	if (!email.equals(copyemail)) {
                String uid = UUID.randomUUID().toString(); // Generate Unique ID append with email;
    	        newuser.setEmail(email);
            	newuser.setEmailConfirm(0);
            	newuser.setRegToken(uid);
				String url = ApplicationURL.getInstance().getUrl();
		        sendMail(url,newuser, uid, env.get("email.registration.subject"), env.get("email.registration.message"), "/account/activate?uid=");
		        flag = 1;
		        isEmailChanged = true;
	        }
        	if (!aboutyou.equals(copyaboutyou)) {
	        		newuser.setAbout(aboutyou);
			        flag = 1;
	        	}
        	if(flag == 1)
        	{
		        int result = userDAO.update(newuser);
		        if(isEmailChanged == true){
		        	request.getSession().invalidate();
		    		org.springframework.security.core.context.SecurityContextHolder.clearContext();
		            model.addAttribute("commonmsg", "Your email-id has been changed. Please complete verification through the link sent to your email-id. <a href='/resend?email="+newuser.getEmail()+"' > Resend e-mail</a>!");  
		            return "common";
		        }
		        	
		        if(result == 1)
		        {
	            	model.addAttribute("key", "error");
		        	model.addAttribute("value", "Your profile has been updated Successfully!");
		        }
		        else{
	            	model.addAttribute("key", "error");
		        	model.addAttribute("value", "Email-id already exist!");
		        }
        	}
        }catch(Exception e){
        	model.addAttribute("key", "error");
        	model.addAttribute("value", "Email-id already exist!");
        	return "redirect:/users/"+newuser.getUsername()+"/profile";
        }
	        model.addAttribute("viewer", newuser);
        return "redirect:/users/"+newuser.getUsername()+"/profile";
    }
    
    @RequestMapping(value = "/{username}/uploadphoto",method = RequestMethod.POST)
    public @ResponseBody String uploadPhotos(HttpServletRequest request,
    		@RequestParam(value = "pic", required = false) MultipartFile file, Model model) throws IOException{
    	
    	String files = null;
        User newuser = getViewer(request);
        if (newuser == null) {
            return authRedirect(request);
        }
    try {
          String rtoken = UUID.randomUUID().toString(); // Generate Unique ID append with email;
	      String imgpath = new File("").getAbsolutePath();
	      String randomToken = newuser.getBio();
	      if(randomToken != null){
	    	  files = newuser.getId()+"_" + randomToken + ".jpg";
	    	  String filepath = imgpath+"//src//main//webapp//resources//profilepics//" + files;
	          File newFile = new File(filepath);
	          newFile.delete();
	          rtoken = randomToken;
	      }
	      
	      files = newuser.getId()+"_" + rtoken + ".jpg";
          String filepath = imgpath+"//src//main//webapp//resources//profilepics//" + files;
          File newFiles = new File(filepath);  
	        	  newFiles.createNewFile();
	        	  file.transferTo(newFiles);
	        	  newuser.setBio(rtoken);
	        	  int result = userDAO.update(newuser);
         } catch (IOException e) {  
          e.printStackTrace();  
         }  
    	return "redirect:/users/"+newuser.getUsername()+"/profile";
    }
    
    @RequestMapping(value = "/{username}/delete_image",method = RequestMethod.GET)
    public String deleteImage(HttpServletRequest request,
    		                 @RequestParam(value = "userId", required = true) Long userid,
    		                  Model model) throws Exception{
    	
        User viewer = getViewer(request);
        
        if (viewer == null) {
            return authRedirect(request);
        }
        String files = viewer.getId()+"_" + viewer.getBio() + ".jpg";
        String imgdata = null;
        viewer.setBio(imgdata);
	    int result = userDAO.update(viewer);
	    if(result == 1)
	        {
	    		String imgpath = new File("").getAbsolutePath();
	    		String filepath = imgpath+"//src//main//webapp//resources//profilepics//" + files;
	    		File newFile = new File(filepath);
	    		newFile.delete();
	        }
	        Long userId = viewer.getId();
       	    List<SocialUser> socialusers = socialuserDAO.byUserId(userId);
       		model.addAttribute("socialusers", socialusers);
       		if(viewer.getBio() == "" || viewer.getBio() == null)
       		 model.addAttribute("cross", 0);
	        model.addAttribute("viewer", viewer);
        	return "redirect:/users/"+viewer.getUsername()+"/profile?key=yesno&value=yes";
    }
    
    @RequestMapping(value = "/{username}/delete_social",method = RequestMethod.GET)
    public String deleteSocial(HttpServletRequest request,
    		                 @RequestParam(value = "social_id", required = true) Long social_id,
                             Model model) {

    	User newuser = getViewer(request);
        if (newuser == null) {
            return authRedirect(request);
        }
        newuser.setCurrentlogin("Normal");
		int result = userDAO.update(newuser);
        SocialUser su = socialuserDAO.byUserSocialId(social_id);
        su.setSocialstatus(1);
        socialuserDAO.update(su);
        model.addAttribute("key", "error");
        model.addAttribute("value", "Social profile has been removed successfully!");
		model.addAttribute("viewer", newuser);
   		model.addAttribute("socialusers", su);
    	return "redirect:/users/"+newuser.getUsername()+"/profile";
    }
    
    @RequestMapping(value = "/{username}/msgs",method = RequestMethod.GET)
    public String deleteSocial(HttpServletRequest request,
                             Model model) {
    	User newuser = getViewer(request);
        if (newuser == null) {
            return authRedirect(request);
        }
    	model.addAttribute("key", "error3");
        model.addAttribute("value", "Password has been changed successfully!");
    	return "redirect:/users/"+newuser.getUsername()+"/profile";
    }
    
    
    @RequestMapping(value = "/{username}/change",method = RequestMethod.POST)
    public @ResponseBody String changePass(HttpServletRequest request,
    		                 @RequestParam(value = "oldpassword", required = false) String oldpassword,
    		                 @RequestParam(value = "password", required = false) String newpassword,
    		                 @RequestParam(value = "socialurl", required = false) String socialurl,
                             Model model) {
    	
    	User newuser = getViewer(request);
        if (newuser == null) {
            return authRedirect(request);
        }
        String response = "";
			String encryptedOldPassword = User.getEncryptedPassword(oldpassword);
			String currentPassword = newuser.getPassword();

			if( !encryptedOldPassword.equals(currentPassword)){
				response = "<div class='alert alert-danger'><img src='/resources/img/warning.png' />Current password is not correct!</div>";
			}else{
            	newuser.setPassword(newpassword);
	            String encryptedPassword = User.getEncryptedPassword(newuser);
	            newuser.setPassword(encryptedPassword);
		        int result = userDAO.update(newuser);
		        if(result != 1){
					response = "<div class='alert alert-danger'>Some error occured try later!</div>";
		        }
            	model.addAttribute("key", "error3");
		        model.addAttribute("value", "Password has been changed successfully!");
		        model.addAttribute("viewer", newuser);
		        response = "ok";
            }
        return response;
    }
    
    @RequestMapping(value = "/{username}/setpassword",method = RequestMethod.POST)
    public String setPass(HttpServletRequest request,
    		                 @RequestParam(value = "password", required = false) String newpassword,
    		                 @RequestParam(value = "socialurl", required = false) String socialurl,
                             Model model) {
    	
    	User newuser = getViewer(request);
        if (newuser == null) {
            return authRedirect(request);
        }
        String response = "";
	        String encryptedPassword = User.getEncryptedPassword(newpassword);
	        newuser.setPassword(encryptedPassword);
	        int res = userDAO.update(newuser);
	        if(res == 1){
		        model.addAttribute("key", "error");
		        model.addAttribute("value", "Password has been set successfully!");
		        model.addAttribute("viewer", newuser);
	        	response = "redirect:" + socialurl;
	        }
	        else{
		        model.addAttribute("key", "error");
		        model.addAttribute("value", "Please try later!");
		        model.addAttribute("viewer", newuser);
	        	response = "redirect:" + socialurl;
	        }
        return response;
    }
    
    @RequestMapping(value = "/{username}/deleteaccount", method = RequestMethod.GET)
    public String getUserProfilePic(HttpServletRequest request,
						    		@RequestParam(value = "userid", required = true) Long userid,
						    		Model model) {
    	User viewer = getViewer(request);
    	if(viewer == null)
    		authRedirect(request);
    	List<SocialUser> su = socialuserDAO.byUserId(viewer.getId());
        if (userDAO.deleteAccount(viewer.getId(), su)) {
        	request.getSession().invalidate();
    		org.springframework.security.core.context.SecurityContextHolder.clearContext();
            model.addAttribute("commonmsg", "Your account has been deleted successfully!");  
            return "common";
        }
    	model.addAttribute("key", "error");
        model.addAttribute("value", "Some internal problem occur try later!");  
        return "redirect:/users/"+viewer.getUsername()+"/profile";
    }
    
    @RequestMapping(value = "/{username}/interest", method = RequestMethod.GET)
    public String setUsersInterest(HttpServletRequest request,
						    		Model model) {
    try{
    	User viewer = getViewer(request);
    	String[] words = request.getParameterValues("iid");
		UserInterest usr = new UserInterest();
		interestDAO.deleteInterest(viewer.getId());
    	for (String str : words) {
			if(str != null && !str.equals("0")){
			    usr.setUser_id(viewer.getId().intValue());
			    usr.setInterest_id(Integer.parseInt(str));
			    interestDAO.save(usr);
			}
		}
    	String status = viewer.getCurrentlogin();
	    if(status.equals("Normal")){
	    	viewer.setLoginstatus(1);
	    	userDAO.update(viewer);
	    }
	    else if(status.equals("Facebook")){
	    	SocialUser su = socialuserDAO.byIdAndType(viewer.getId(), "Facebook");
	    	su.setLoginstatus(1);
	    	socialuserDAO.update(su);
	    }
	    else if(status.equals("Gmail")){
	    	SocialUser su = socialuserDAO.byIdAndType(viewer.getId(), "Gmail");
	    	su.setLoginstatus(1);
	    	socialuserDAO.update(su);
	    }
    }catch(Exception e){
    	System.out.println(e);
    	model.addAttribute("key", "error");
        model.addAttribute("value", "Some internal problem occur try later!");
    }
        return "redirect:/";
    }
    
    
    @RequestMapping(value = "/{username}/updateinterest", method = RequestMethod.GET)
    public String updateInterest(HttpServletRequest request,
						    		Model model) {
    	User viewer = getViewer(request);
  try{
	    String status = viewer.getCurrentlogin();
	    if(status.equals("Normal")){
	    	viewer.setLoginstatus(1);
	    	userDAO.update(viewer);
	    }
	    else if(status.equals("Facebook")){
	    	SocialUser su = socialuserDAO.byIdAndType(viewer.getId(), "Facebook");
	    	su.setLoginstatus(1);
	    	socialuserDAO.update(su);
	    }
	    else if(status.equals("Gmail")){
	    	SocialUser su = socialuserDAO.byIdAndType(viewer.getId(), "Gmail");
	    	su.setLoginstatus(1);
	    	socialuserDAO.update(su);
	    }
    }catch(Exception e){
    	model.addAttribute("key", "error");
        model.addAttribute("value", "Some internal problem occur try later!");
    }
        return "redirect:/";
    }
    
    @RequestMapping(value = "/{username}/profilePic", method = RequestMethod.GET)
    public String getUserProfilePic(HttpServletRequest request,
                                    @PathVariable String username, Model model) {
        User user = userDAO.byUsername(username);
        if (user == null) {
//            throw new NotFoundException("no such user: " + username);
        }
        if(user.getBio() != null){
        	String filess = "/resources/profilepics/" + user.getId()+"_"+user.getBio()+".jpg";
    			  return "redirect:" + filess;
        }
        String emailHash = StringUtils.toHexHash(user.getEmail(), "MD5");
        return "redirect:https://www.gravatar.com/avatar/" + emailHash + "?d=identicon";
    }
    
    @RequestMapping(value = "/{username}/profile", method = RequestMethod.GET)
    public String getUserProfile(HttpServletRequest request,
    		                     @RequestParam(value = "key", required = false, defaultValue = "") String key,
    		                     @RequestParam(value = "value", required = false, defaultValue = "") String value,
                                 @PathVariable String username, Model model) throws Exception {
    	User viewer = getViewer(request);
        if (viewer == null) {
        	return authRedirect(request);
        }

       		Long userId = viewer.getId();
       	    List<SocialUser> socialusers = socialuserDAO.byUserIdAndSocialStatus(userId);
       	    List<SelectedInterest> list = getUserInterests(viewer);
       		model.addAttribute(key, value);
       		model.addAttribute("socialusers", socialusers);
       		model.addAttribute("logintype", viewer.getCurrentlogin());
       		if(viewer.getBio() == "" || viewer.getBio() == null){
       		 String emailHash = StringUtils.toHexHash(viewer.getEmail(), "MD5");
       		   model.addAttribute("cross", 0);
       		   model.addAttribute("userimg","https://www.gravatar.com/avatar/" + emailHash + "?d=identicon");
       		}
       		else{
       			long timestamp = new Date().getTime();
       			model.addAttribute("userimg","/resources/profilepics/" + viewer.getId()+"_"+viewer.getBio()+".jpg?"+timestamp);
       		}
	        model.addAttribute("viewer", viewer);
	        model.addAttribute("newinterest", list);
	        return "profile";
    }

}
