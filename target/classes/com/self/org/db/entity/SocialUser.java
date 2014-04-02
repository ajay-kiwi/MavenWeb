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
@Table(name = "user_social")
public class SocialUser {
    @Id
    @GeneratedValue
    Long id;
    
    /**
     * Username for this user.
     */
    @Column(nullable = false, length = 11, unique = false)
    Long userId;
    
    /**
     * Email address for this user.
     */
    @Column(nullable = true, length = 11, unique = false)
    Long socialUserId;
    
    @Column(nullable = false, length = 255, unique = false)
    String name;
    
    @Column(nullable = false, length = 255, unique = false)
    String url;
    
    @Column(nullable = false, length = 255, unique = false)
    String type;
    
    @Column(nullable = false, length = 1)
    int socialstatus = 0;
    
    @Column(nullable = false, length = 1)
    int loginstatus = 0;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getSocialUserId() {
        return socialUserId;
    }
    public void setSocialUserId(Long socialUserId) {
        this.socialUserId = socialUserId;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
	public int getSocialstatus() {
		return socialstatus;
	}
	public void setSocialstatus(int socialstatus) {
		this.socialstatus = socialstatus;
	}
	public int getLoginstatus() {
		return loginstatus;
	}
	public void setLoginstatus(int loginstatus) {
		this.loginstatus = loginstatus;
	}
}
