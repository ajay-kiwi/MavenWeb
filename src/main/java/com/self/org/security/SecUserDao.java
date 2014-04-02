package com.self.org;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.self.org.SecUser;
import com.self.org.Role;
import com.self.org.db.dao.UserDAO;
import com.self.org.db.entity.User;

@Repository
public class SecUserDao {

	@Autowired
	UserDAO userDAO;

	public SecUser loadUserByUsername(String username) {
		SecUser user = new SecUser();

		try {

			User originalUser = userDAO.byUsername(username);

			if (originalUser == null) {
				originalUser = userDAO.byEmail(username);
			}

			if (originalUser != null) {
				user.setUsername(originalUser.getUsername());
				user.setEmail(originalUser.getEmail());
				user.setPassword(originalUser.getEncryptedPassword(originalUser));
				Role r = new Role();
				r.setName("ROLE_USER");
				List<Role> roles = new ArrayList<Role>();
				roles.add(r);
				user.setAuthorities(roles);
			} 
		} catch (Exception e) {
			return user;
		}
		return user;
	}
	
	public void updateUser(String email, String data) {
		try {
			User originalUser = userDAO.byEmail(email);
			originalUser.setCurrentlogin(data);
			int result = userDAO.update(originalUser);
		} catch (Exception e) {
			return;
		}
	}
	public void updateUserStatus(String username, String data) {
		try {
			User originalUser = userDAO.byUsername(username);
			originalUser.setCurrentlogin(data);
			int result = userDAO.update(originalUser);
		} catch (Exception e) {
			return;
		}
	}

}
