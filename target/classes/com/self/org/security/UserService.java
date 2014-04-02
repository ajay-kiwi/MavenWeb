package com.self.org;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.self.org.SecUserDao;
import com.self.org.SecUser;


@Service
@Transactional
public class UserService implements UserDetailsService {

	@Autowired
	private SecUserDao userDao;

	@Override
	public SecUser loadUserByUsername(final String username) throws UsernameNotFoundException {
		return userDao.loadUserByUsername(username);
	}

}
