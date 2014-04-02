package com.self.org;


import java.util.*;
import com.self.org.SecUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.AuthorityUtils;

import com.self.org.BaseController;

import javax.servlet.http.*;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Service("OpenIdUserDetailsService")
public class OpenIdUserDetailsService extends BaseController implements UserDetailsService,
        AuthenticationUserDetailsService<OpenIDAuthenticationToken> {

	@Autowired
    private SecUserDao userDao;
	
    public UserDetails loadUserDetails(OpenIDAuthenticationToken openIDToken)
            throws UsernameNotFoundException {

    	String id = openIDToken.getIdentityUrl();
        String email = null;
        String firstName = null;
        String lastName = null;
        List<OpenIDAttribute> attributes = openIDToken.getAttributes();
        
        for (OpenIDAttribute attribute : attributes) {
        	
            if (attribute.getName().equals("email")) {
                email = attribute.getValues().get(0);
            }
        }

        int endIndex = email.lastIndexOf("@");
        String name = email.substring(0, endIndex);
        
		if(!getOpenidSocialStatus(email)){
			while(getUsernameValidation(name)){
				name = name + (int)(Math.random() * 500 + 1);
			}
			saveGmailUser(email, name, name);
		}
		userDao.updateUser(email, "Gmail");
        return new User(email, "test", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }

    public UserDetails loadUserByUsername(String id)
            throws UsernameNotFoundException {
    	
    	SecUser u = userDao.loadUserByUsername(id);
    	
        return new User(u.getEmail(), u.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }

}