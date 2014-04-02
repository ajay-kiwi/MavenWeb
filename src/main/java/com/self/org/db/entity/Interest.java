package com.self.org.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

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
@Table(name = "interests")
public class Interest {

    @Id
    @GeneratedValue
    Long interest_id;
    
    @Column(nullable = false, length = 25)
    String interest_name;
    
    public Long getInterest_id() {
        return interest_id;
    }
    public void setInterest_id(Long interest_id) {
        this.interest_id = interest_id;
    }
    public String getInterest_name() {
        return interest_name;
    }
    public void setInterest_name(String interest_name) {
        this.interest_name = interest_name;
    }
}
