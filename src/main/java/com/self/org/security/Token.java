package com.self.org;

import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persistent_logins")
public class Token {

	@Column(nullable = false, length = 64, unique = true)
    String username;
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Id	
    @Column(nullable = false, length = 64, unique = true)
    String series;
	
	@Column(nullable = false, length = 64)
    String token;
	
	@Column(nullable = false)
    Date last_used;

    public Token() {
    }

    public Token(PersistentRememberMeToken persistentRememberMeToken) {
        this.username = persistentRememberMeToken.getUsername();
        this.series = persistentRememberMeToken.getSeries();
        this.last_used = persistentRememberMeToken.getDate();
        this.token = persistentRememberMeToken.getTokenValue();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getTokenValue() {
        return token;
    }

    public void setTokenValue(String tokenValue) {
        this.token = tokenValue;
    }

    public Date getDate() {
        return last_used;
    }

    public void setDate(Date date) {
        this.last_used = date;
    }
}
