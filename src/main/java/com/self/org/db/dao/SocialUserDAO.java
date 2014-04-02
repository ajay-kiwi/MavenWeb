package com.self.org.db.dao;

import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Criteria;

import java.util.List;

import com.self.org.db.entity.User;
import com.self.org.db.entity.SocialUser;

@Repository
public class SocialUserDAO {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public Long save(SocialUser social_user) {
        Session session = sessionFactory.getCurrentSession();
        return (Long) session.save(social_user);
    }
    
    @Transactional
    public int update(SocialUser social_user) {
    	try{
    		Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(social_user);
            return 1;
    	}
    	catch(Exception e)
    	{
    	}
    	return 0;
    }
    
    @Transactional
    public List<SocialUser> byUserId(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM user_social WHERE userId="+userId;
        return (List<SocialUser>) session.createSQLQuery(sql)
                .addEntity(SocialUser.class)
                .list();
    }
    
    @Transactional
    public SocialUser byLoginType(String type, Long userid) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM user_social WHERE type=:type AND userid=:userid";
        return (SocialUser) session.createSQLQuery(sql)
                .addEntity(SocialUser.class)
                .setString("type", type)
                .setLong("userid", userid)
                .uniqueResult();
    }
    
    @Transactional
    public List<SocialUser> byUserIdAndSocialStatus(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM user_social WHERE userId="+userId;
        return (List<SocialUser>) session.createSQLQuery(sql)
                .addEntity(SocialUser.class)
                .list();
    }
    
    @Transactional
    public List<SocialUser> byUserIdAndType(Long userId, String type) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM user_social WHERE userId="+userId+" and type='"+type+"'";
        return (List<SocialUser>) session.createSQLQuery(sql)
                .addEntity(SocialUser.class)
                .list();
    }  
    
    @Transactional
    public SocialUser byIdAndType(Long userId, String type) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM user_social WHERE userId=:userid and type=:type";
        return (SocialUser) session.createSQLQuery(sql)
                .addEntity(SocialUser.class)
                .setLong("userid", userId)
                .setString("type", type)
                .uniqueResult();
    }  
    
    @Transactional
    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        SocialUser myObject = (SocialUser) sessionFactory.getCurrentSession().load(SocialUser.class,id);
        session.delete(myObject);
    }
    
    @Transactional
    public SocialUser bySocialId(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM user_social WHERE userId=:userId";
        return (SocialUser) session.createSQLQuery(sql)
                .addEntity(SocialUser.class)
                .setLong("userId", userId)
                .uniqueResult();
    }
    
    @Transactional
    public SocialUser bySocialIdANDStatus(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM user_social WHERE userId=:userId and socialstatus=1";
        return (SocialUser) session.createSQLQuery(sql)
                .addEntity(SocialUser.class)
                .setLong("userId", userId)
                .uniqueResult();
    }
    
    @Transactional
    public SocialUser byUserSocialId(Long socialId) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM user_social WHERE id=:userId";
        return (SocialUser) session.createSQLQuery(sql)
                .addEntity(SocialUser.class)
                .setLong("userId", socialId)
                .uniqueResult();
    }
    
}
