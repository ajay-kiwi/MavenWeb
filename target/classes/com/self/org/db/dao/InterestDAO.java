package com.self.org.db.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.self.org.db.entity.*;

@Repository
public class InterestDAO {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public List<Interest> getInterest() {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM interests";
        return (List<Interest>) session.createSQLQuery(sql)
                .addEntity(Interest.class)
                .list();
    }
    
    @Transactional
    public List<Interest> getUserInterest(Long uid) {
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT i.* FROM user_interests u, interests i WHERE u.user_id=:uid AND u.interest_id=i.interest_id";
        return (List<Interest>) session.createSQLQuery(sql)
				                .addEntity(Interest.class)
				                .setLong("uid", uid)
				                .list();
    }
    
    @Transactional
    public Long save(UserInterest user) {
        Session session = sessionFactory.getCurrentSession();
        return (Long) session.save(user);
    }
    
    @Transactional
    public boolean deleteInterest(Long userid) {
      Session session = sessionFactory.getCurrentSession();
      String sql = "SELECT * FROM user_interests WHERE user_id=:userid";
      List<UserInterest> li = session.createSQLQuery(sql)
				                .addEntity(UserInterest.class)
				                .setLong("userid", userid)
				                .list();
      for (UserInterest ui : li) {
          session.delete(ui);
      }
          return true;
    }
    
    @Transactional
    public int update(UserInterest user) {
    	try{
    		Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(user);
            return 1;
    	}
    	catch(Exception e)
    	{
    	}
    	return 0;
    }
    
}
