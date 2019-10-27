package service;


import java.util.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.*;

import model.TweetEntity;

/**
 * Session Bean implementation class TweetEJB
 */
@Stateless
@LocalBean
public class TweetEJB {

	@PersistenceContext
	private EntityManager twt;
	
    public TweetEJB() {
        // TODO Auto-generated constructor stub
    	
    	
    }
    
    public void addNew(TweetEntity tweetEntity)
    {
    	System.out.println("======adding tweet to database========");
        
    	
    	twt.persist(tweetEntity);
    	
    	
    }
    
    public ArrayList<TweetEntity> getTweets() throws Exception {
        Query query = twt.createQuery("SELECT m FROM tweet_tbl as m");
        ArrayList<TweetEntity> resultList = (ArrayList<TweetEntity>) query.getResultList();
		return resultList;
    }

}
