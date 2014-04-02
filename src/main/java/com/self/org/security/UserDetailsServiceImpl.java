package com.self.org;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import com.self.org.db.dao.UserDAO;


@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SecUserDao userDao;

       
    
    @PostConstruct
    public void init() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	SecUser u = userDao.loadUserByUsername(username);
        return new User(u.getEmail(), u.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }

}
