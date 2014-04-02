package com.self.org;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.Date;

@Repository
@Transactional(readOnly = false)
public class TokenDao {

	@Resource
	private SessionFactory sessionFactory;

	@Transactional(readOnly = false)
	public void createNewToken(Token token) {
		sessionFactory.getCurrentSession().save(token);
	}

	@Transactional(readOnly = false)
	public void updateToken(String series, String tokenValue, Date lastUsed) {

		Token existingToken = (Token) sessionFactory.getCurrentSession().get(
				Token.class, series);
		existingToken.setTokenValue(tokenValue);
		existingToken.setDate(lastUsed);
		sessionFactory.getCurrentSession().merge(existingToken);
	}

	public Token getTokenForSeries(String seriesId) {
		return (Token) sessionFactory.getCurrentSession().get(Token.class,
				seriesId);
	}

	@Transactional
	public void removeUserTokens(final String username) throws Exception {

/*		Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM persistent_logins WHERE username=:username";
        Token token = (Token) session.createSQLQuery(sql)
        					.addEntity(Token.class)
					        .setString("username", username)
					        .uniqueResult();*/
		 Token token = (Token)sessionFactory.getCurrentSession().get(Token.class, 1);
        
    	if (token != null) {
			sessionFactory.getCurrentSession().delete(token);
		}
		
	}
}
