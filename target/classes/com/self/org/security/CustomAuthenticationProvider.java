package com.self.org;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.self.org.SecUser;
import com.self.org.UserService;
import com.self.org.db.dao.UserDAO;
import com.self.org.db.entity.User;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;

	@Autowired
	UserDAO userDAO;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();

		SecUser user = userService.loadUserByUsername(username);

		if (user == null) {
			throw new BadCredentialsException("Username not found.");
		}

		User loginUser = userDAO.byLoginCredentials(username, password);
		if (loginUser == null) {
			throw new BadCredentialsException("Invalid credentials.");
		}
		else{
			try {
				User originalUser = userDAO.byUsername(username);
				if(originalUser != null){
					originalUser.setCurrentlogin("Normal");
					int result = userDAO.update(originalUser);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Collection<? extends GrantedAuthority> authorities = user
				.getAuthorities();

		return new UsernamePasswordAuthenticationToken(username, password,
				authorities);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
