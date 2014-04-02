package com.self.org.db.dao;

import java.util.*;

import com.self.org.db.entity.SocialUser;
import com.self.org.db.entity.User;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAO {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public User byID(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        return null;    
    }
    
    @Transactional
    public User byRegToken(String rtoken) {
        Session session = sessionFactory.getCurrentSession();
        return null;    
    }
    
    @Transactional
    public User byLoginCredentials(String rtoken, String uname) {
        Session session = sessionFactory.getCurrentSession();
        return null;    
    }
    
    @Transactional
    public int updateAccountStatus(String uid) {
        Session session = sessionFactory.getCurrentSession();
        return 0;
    }
    
    @Transactional
    public User byForgotToken(String ftoken) {
        Session session = sessionFactory.getCurrentSession();
        return null;    
    }
    
    @Transactional
    public int updatePassword(String encpass, String uid) {
        Session session = sessionFactory.getCurrentSession();
        return 0;    
    }
   
    @Transactional
    public User byStringname(String name) {
        Session session = sessionFactory.getCurrentSession();
        return null;    
    }
    
    @Transactional
    public User byEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        return null;    
    }
    
    @Transactional
    public User byEmailOrStringname(String name) {
        Session session = sessionFactory.getCurrentSession();
        return null;    
    }
    
    @Transactional
    public User byEmailOrUsername(String name, String uname) {
        Session session = sessionFactory.getCurrentSession();
        return null;    
    }
    
    @Transactional
    public User byUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        return null;    
    }
    
    @Transactional
    public int update(User username) {
        Session session = sessionFactory.getCurrentSession();
        return 0;    
    }
    
    @Transactional
    public int save(User username) {
        Session session = sessionFactory.getCurrentSession();
        return 0;    
    }
    
    @Transactional
    public boolean deleteAccount(Long uid, List<SocialUser> su) {
        Session session = sessionFactory.getCurrentSession();
        return false;    
    }
}
