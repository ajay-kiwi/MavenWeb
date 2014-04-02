package com.self.org.db.entity;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.joda.time.Instant;

import com.self.org.util.StringUtils;

/**
 * 
 * @author Evan Savage <savage.evan@gmail.com>
 *
 * User objects represent users in our system; that is, these are local users, rather than users of
 * third-party services.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    Long id;
    
    /**
     * Username for this user.
     */
    @Column(nullable = false, length = 255, unique = true)
    String username;
    
    @Column(nullable = false, length = 255, unique = true)
    String displayname;
    
    /**
     * Email address for this user.
     */
    @Column(nullable = false, length = 255, unique = true)
    String email;
    
    /**
     * SHA-256 hashed password for this user.
     */
    @Column(nullable = false, length = 255)
    String password;
    
    /**
     * Biographical details provided by the user.
     */
    @Lob
    @Column(nullable = true)
    String bio;
    
    /**
     * account status either active or not.
     */
    @Column(nullable = false, length = 1)
    int emailConfirm = 0;
    
    /**
     * Unique token append with email.
     */
    @Column(nullable = false, length = 255)
    String regToken;
    
    /**
     * Unique token append with email.
     */
    @Column(nullable = true, length = 255)
    String forgotToken;
    
    @Column(nullable = true, length = 500)
    String about;
    
    @Column(nullable = false, length = 1)
    int loginstatus = 0;
    
    @Column(nullable = true, length = 10)
    String currentlogin;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getDisplayname() {
        return displayname;
    }
    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }
    public String getBio() {
    	return bio;
   	}
   	public void setBio(String bio) {
    	this.bio = bio;
   	}
	public int getEmailConfirm() {
		return emailConfirm;
    }
	public void setEmailConfirm(int emailConfirm) {
		this.emailConfirm = emailConfirm;
	}
    public String getRegToken() {
        return regToken;
    }
    public void setRegToken(String regToken) {
        this.regToken = regToken;
    }
    public String getForgotToken() {
        return forgotToken;
    }
    public void setForgotToken(String forgotToken) {
        this.forgotToken = forgotToken;
    }
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public int getLoginstatus() {
		return loginstatus;
	}
	public void setLoginstatus(int loginstatus) {
		this.loginstatus = loginstatus;
	}
	public String getCurrentlogin() {
		return currentlogin;
	}
	public void setCurrentlogin(String currentlogin) {
		this.currentlogin = currentlogin;
	}
    public static String getEncryptedPassword(String password) {
    	return StringUtils.toHexHash(password, "SHA-256");
    }
    public static String getEncryptedPassword(User user) {
    	return getEncryptedPassword(user.getPassword());
    }
}
