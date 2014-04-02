package com.self.org;

import java.io.*;
import java.util.*;

import com.self.org.ApplicationURL;

import org.apache.commons.io.*;
import org.apache.commons.codec.binary.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;

import com.self.org.config.Configuration;
import com.self.org.db.dao.UserDAO;
import com.self.org.db.entity.User;
import com.self.org.SecUser;
import com.github.sendgrid.SendGrid;

import org.springframework.security.core.Authentication;

import com.self.org.util.*;
import com.self.org.db.dao.UserDAO;
import com.self.org.db.entity.User;
import com.self.org.db.dao.SocialUserDAO;
import com.self.org.db.entity.SocialUser;

import org.joda.time.Instant;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.self.org.util.StringUtils;
import com.self.org.db.entity.SocialUser;
import com.self.org.db.entity.Interest;
import com.self.org.db.dao.InterestDAO;
import com.self.org.db.entity.UserInterest;

public class BaseController {
	@Autowired
	protected InterestDAO interestDAO;
	
	@Autowired
	protected UserDAO userDAO;
	
	@Autowired
	protected SocialUserDAO social_userDAO;

	@Autowired
	protected SecUserDao secUserDao;

	@Autowired
	protected Configuration env;
	
	boolean flag = false;
	
	protected User getViewer(HttpServletRequest request) {
		try {

			String activeUser = SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal().toString();

						
			User user = null;

			try {
				org.springframework.security.core.userdetails.User activeUser1 = (org.springframework.security.core.userdetails.User) SecurityContextHolder
						.getContext().getAuthentication().getPrincipal();
				activeUser = activeUser1.getUsername();
			} catch (Exception e) {
			}
			if (user == null) {
				user = userDAO.byUsername(activeUser);
			}

			if (user == null) {
				user = userDAO.byEmail(activeUser);
			}
			
			SecUserDao secUserDao = new SecUserDao();

			SecUser u = secUserDao.loadUserByUsername(activeUser);

			if (user == null) {
				user = userDAO.byEmail(u.getUsername());
			}

			if (user == null) {
				user = userDAO.byUsername(u.getUsername());
			}

			if (user == null) {
				Long userId = (Long) request.getSession().getAttribute(
						"user_id");

				if (userId == null) {
					ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
							.currentRequestAttributes();
					userId = (Long) attr.getRequest().getSession()
							.getAttribute("user_id");
					if (userId == null) {
						return null;
					} else {
						user = userDAO.byID(userId);
					}
				} else {

					user = userDAO.byID(userId);
				}
			}
			return user;
		} catch (ClassCastException e) {
			return null;
		}
	}

	protected void sendMail(String url, User newUser, String uid, String subject, String msg, String uri)
	{
		String username = newUser.getUsername();
		String email = newUser.getEmail();
		int end = url.indexOf("/", 7);
		String weburl = url.substring(0, end);
		System.out.println(weburl+" "+end);
		String msgTxt = "Dear "+username
				+msg +weburl+uri+ uid
				+"\n\nIf you have any questions or concerns, please email us at help@intel.com."
				+"\n\nThanks,\n\nThe Intel Team";
		SendGrid sendgrid = new SendGrid(env.get("sendgrid.username"), env.get("sendgrid.password"));
		sendgrid.addTo(email);
		sendgrid.setFrom(env.get("sendgrid.from"));
		sendgrid.setSubject(subject);
		sendgrid.setText(msgTxt);
		sendgrid.send();
	}

	protected boolean getUIDValidate(String uid) {
		try {
			User usr = userDAO.byRegToken(uid);
			if (usr != null) {
				int result = userDAO.updateAccountStatus(uid);
				if( result == 1)
					return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	protected List<Interest> getUserInterests() {
		try {
			List<Interest> usr = interestDAO.getInterest();
			if (usr != null) {
					return usr;
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	
	protected List<Interest> getSelectedInterest(Long uid) {
		try {
			List<Interest> usr = interestDAO.getUserInterest(uid);
			if (usr != null) {
					return usr;
			}
		} catch (Exception e) {
			System.out.println("Error: Data not fetch.");
		}
		return null;
	}
	
	protected boolean getForgotUIDValidate(String uid) {
		try {
			User usr = userDAO.byForgotToken(uid);
			if (usr != null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	protected boolean getUsernameValidation(String username) {
		try {
			User usr = userDAO.byUsername(username);
			if (usr != null) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	protected String isGmailUser(Long id) {
		try {
			SocialUser su = social_userDAO.bySocialId(id);
			if(su != null){
				return su.getType();
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}
	
    protected boolean getUpdatePassword(String pass, String uid) {
        try {
            String encryptedPassword = User.getEncryptedPassword(pass);
        	int result = userDAO.updatePassword(encryptedPassword, uid);
        	if (result == 1) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
	}
    
	protected boolean getEmailValidation(String email) {
		try {
			User usr = userDAO.byEmail(email);
			if (usr != null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	protected List<SelectedInterest> getUserInterests(User viewer) {
		
			List<Interest> interest = getUserInterests();
	        List<Interest> userinterest = getSelectedInterest(viewer.getId());
	        List<SelectedInterest> list = new ArrayList<SelectedInterest>();
	    try {
	        int size1 = interest.size();
	        int size2 = userinterest.size();
	        Interest intst1 = null, intst2 = null;
	        SelectedInterest si = null;
	        boolean istrue = false;
	        int test = 0;
	        for(int i=0 ; i < size1 ; i++){
	        	intst1 = interest.get(i);
	        	for(int j=0 ; j < size2 ; j++){
	            	intst2 = userinterest.get(j);
	            	if(intst1.getInterest_id() == intst2.getInterest_id()){
	            		istrue = true;
	            		test = 1;
	            		break;
	            	}
	        	}
	        	if(istrue == true && test == 1){
	        		si = new SelectedInterest();
	        		si.setInterest_id(intst1.getInterest_id());
	        		si.setInterest_name(intst1.getInterest_name());
	        		si.setStatus("y");
	        		list.add(si);
	        		istrue = false;
	        		test = 0;
	        	}
	        	else{
	        		si = new SelectedInterest();
	        		si.setInterest_id(intst1.getInterest_id());
	        		si.setInterest_name(intst1.getInterest_name());
	        		list.add(si);
	        		istrue = false;
	        		test = 0;
	        	}
	        }
		} catch (Exception e) {
			return null;
		}
		return list;
	}
	
	protected User getUserByEmail(String email) {
		try {
			User usr = userDAO.byEmail(email);
			if (usr != null) {
				return usr;
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	
	protected boolean getEmailOrUsername(String email, String username) {
		try {
			User usr = userDAO.byEmailOrUsername(email, username);
			if (usr != null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	protected User forgotPassword(String email) {
		try 
		{
			User usr = userDAO.byEmail(email);
			if (usr != null) 
			{
				String uid = UUID.randomUUID().toString(); // Generate Unique ID append with email;
				usr.setForgotToken(uid);
				int result = userDAO.update(usr);
				if( result == 1)
					return usr;
			}
		} catch (Exception e) {
		}
		return null;
	}
	
    public byte[] getProfilePic(HttpServletRequest request, MultipartFile file) {
        
        try {
        	if(!file.isEmpty()){
	        	byte[] imgdata = new byte[request.getContentLength()];
	            InputStream fileInputStream = file.getInputStream();
	            BufferedInputStream bin = new BufferedInputStream(fileInputStream);
	       	     //convert file into array of bytes
	            imgdata = IOUtils.toByteArray(bin);
	       	    bin.close();
	            fileInputStream.close();
	    	    return imgdata;
        	}	
        }
        catch (Exception fne) {
        }
        return null;
    }
	
	protected String authRedirect(HttpServletRequest request) {
		String next = request.getRequestURI();
		return "redirect:/login?next=" + next;
	}

	protected long saveFacebookUser(HttpServletRequest request, String email, String name, String username, String usernameCopy) {
		long userId = 0;
		Short time_zone = new Short((short)1); 
		String uid = UUID.randomUUID().toString(); // Generate Unique ID append with email;
		Instant joinedAt = Instant.now();
		User newUser = new User();
		if(username == null){
	        int endIndex = email.lastIndexOf("@");
	        username = email.substring(0, endIndex);
		}
		newUser.setUsername(username);
		newUser.setDisplayname(name);
		newUser.setEmail(email);
		newUser.setPassword(uid);
		String encryptedPassword = User.getEncryptedPassword(uid);
		newUser.setPassword(uid);
		newUser.setRegToken(uid);
		newUser.setLoginstatus(0);
		newUser.setEmailConfirm(0);
		if(!getEmailValidation(email)){
			String url = request.getRequestURL().toString();
			ApplicationURL ap = ApplicationURL.getInstance();
			ap.setUrl(url);
	        sendMail(url,newUser, uid, env.get("email.registration.subject"), env.get("email.registration.message"), "/account/activate?uid=");
			userId = userDAO.save(newUser);
		}else{
			User user = userDAO.byEmail(email);
			userId = user.getId();
		}
		
		List<SocialUser> su = social_userDAO.byUserIdAndType(userId, "Facebook");
		if(su.isEmpty()){
			SocialUser socialUser = new SocialUser();
			socialUser.setUserId(userId);
			socialUser.setName(name);
			socialUser.setSocialUserId(1l);
			socialUser.setType("Facebook");
			socialUser.setUrl("http://graph.facebook.com/"+username+"/picture");
			social_userDAO.save(socialUser);
		}
		return userId;
	}
	
	protected void updateSocialStatus(Long id) {
		try 
		{
			User usr = userDAO.byID(id);
			usr.setCurrentlogin("");
			int result  = userDAO.update(usr);
		} catch (Exception e) {
		}
	}
	
	protected boolean getSocialStatus(Long id, String currentlogin) {
		try 
		{
			SocialUser usr = social_userDAO.byIdAndType(id, currentlogin);
			if (usr != null) 
			{
				if(usr.getSocialstatus() == 1)
					return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	protected boolean getOpenidSocialStatus(String email) {
		try 
		{
			User usr = userDAO.byEmail(email);
			if (usr != null) 
			{
				SocialUser su = social_userDAO.byIdAndType(usr.getId(), "Gmail");
				if(su != null)
					return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	protected boolean getFacebookSocialStatus(String email) {
		try 
		{
			User usr = userDAO.byEmail(email);
			if (usr != null) 
			{
				SocialUser su = social_userDAO.byIdAndType(usr.getId(), "Facebook");
				if(su != null)
					return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	protected int byType(User type) {
		SocialUser usr = null;
		try 
		{
			if(type.getCurrentlogin().equals("Normal")){
				int res = type.getLoginstatus();
				return res;
			}
			else{
				 usr = social_userDAO.byLoginType(type.getCurrentlogin(), type.getId());
			}
			if (usr != null) {
				return usr.getLoginstatus();
			}
		} catch (Exception e) {
			System.out.println("Error occured in byTpe method basecontroller");
		}
		return 1;
	}
	
	protected long saveGmailUser(String email, String name, String username) {
		long userId = 0;
		Short time_zone = new Short((short)1); 
		String uid = UUID.randomUUID().toString(); // Generate Unique ID append with email;
		Instant joinedAt = Instant.now();
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setDisplayname(name);
		newUser.setEmail(email);
		String encryptedPassword = User.getEncryptedPassword(uid);
		newUser.setPassword(encryptedPassword);
		newUser.setRegToken(uid);
		newUser.setLoginstatus(0);
		newUser.setEmailConfirm(0);
		if(!getEmailValidation(email)){
			ApplicationURL ap = ApplicationURL.getInstance();
			String url = ap.getUrl();
	        sendMail(url,newUser, uid, env.get("email.registration.subject"), env.get("email.registration.message"), "/account/activate?uid=");
			userId = userDAO.save(newUser);
		}else{
			User user = userDAO.byEmail(email);
			userId = user.getId();
		}

		List<SocialUser> su = social_userDAO.byUserIdAndType(userId, "Gmail");
		if(su.isEmpty()){
			SocialUser socialUser = new SocialUser();
			socialUser.setUserId(userId);
			socialUser.setName(name);
			socialUser.setSocialUserId(1l);
			socialUser.setType("Gmail");
			String emailHash = StringUtils.toHexHash(email, "MD5");
	        socialUser.setUrl("https://www.gravatar.com/avatar/" + emailHash + "?d=identicon");
			social_userDAO.save(socialUser);
		}
		return userId;
	}

}
