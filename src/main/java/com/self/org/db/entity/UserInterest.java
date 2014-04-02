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
@Table(name = "user_interests")
public class UserInterest {

    @Id
    @GeneratedValue
    Long u_id;
    
    @Column(nullable = false, length = 11)
    int user_id;
    
    @Column(nullable = false, length = 11)
    int interest_id;
    
    public Long getU_id() {
        return u_id;
    }
    public void setU_id(Long u_id) {
        this.u_id = u_id;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getInterest_id() {
        return interest_id;
    }
    public void setInterest_id(int interest_id) {
        this.interest_id = interest_id;
    }
}
