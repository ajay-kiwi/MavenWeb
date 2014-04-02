/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.quickstart.user;

import java.util.List;
import com.self.org.SecUserDao;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Reference;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.social.connect.UserProfile;

import com.self.org.util.*;
import com.self.org.db.dao.*;
import com.self.org.db.entity.*;

import org.joda.time.Instant;

import com.self.org.BaseController;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.Long;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Signs the user in by setting the currentUser property on the {@link SecurityContext}.
 * Remembers the sign-in after the current request completes by storing the user's id in a cookie.
 * This is cookie is read in {@link UserInterceptor#preHandle(HttpServletRequest, HttpServletResponse, Object)} on subsequent requests.
 */
public final class SimpleSignInAdapter extends BaseController implements SignInAdapter {
	
	@Autowired
    private SecUserDao userDao;
	
	long user_id;
	private final UserCookieGenerator userCookieGenerator = new UserCookieGenerator();
	
	
	public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
		userCookieGenerator.addCookie(userId, request.getNativeResponse(HttpServletResponse.class));
		UserProfile fp = connection.fetchUserProfile();
		
		String email = fp.getEmail();
		String name = fp.getName();
		String username = fp.getUsername();

		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		String usernameCopy = username;

		user_id = saveFacebookUser(attr.getRequest(), email, name, username, usernameCopy);
		userDao.updateUser(email, "Facebook");
		
	    attr.getRequest().getSession().setAttribute("user_id", user_id);
		return null;
	}

}
