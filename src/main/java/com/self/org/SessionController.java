package com.self.org;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import com.self.org.db.dao.UserDAO;
import com.self.org.db.entity.User;

@RequestMapping(value = "/logout")
@Controller
public class SessionController extends BaseController {
	@Autowired
	UserDAO userDAO;
/*
	@RequestMapping(method = RequestMethod.POST)
	public String login(
			HttpServletRequest request,
			@RequestParam(value = "username_email", required = true) String usernameOrEmail,
			@RequestParam(required = true) String password,
			@RequestParam(required = false) String next, Model model) {

		User viewer = getViewer(request);

		if (viewer != null) {
			return "redirect:/";
		}
		User loginUser = userDAO.byLoginCredentials(usernameOrEmail, password);
		if (loginUser == null) {
			model.addAttribute("error", "Error: Bad Credentials!");
			return "login";
		}
		// TODO: there must be a cleaner way to do this
		request.getSession().setAttribute("user_id", loginUser.getId());
		return "redirect:/";
	}
*/
	
	@RequestMapping(method = RequestMethod.DELETE)
	public String logout(HttpServletRequest request) {
		User viewer = getViewer(request);
		if (viewer == null) {
			return authRedirect(request);
		}
		request.getSession().invalidate();
		org.springframework.security.core.context.SecurityContextHolder.clearContext();
		return "redirect:/";
	}
}
