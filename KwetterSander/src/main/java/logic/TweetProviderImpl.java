/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import Model.Tweet;
import Model.User;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.faces.bean.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Chunsing
 */
@Local
@Stateless
public class TweetProviderImpl implements TweetProvider {

    @PersistenceContext
    EntityManager em;

    public TweetProviderImpl() {
    }

    @Override
    public Tweet createTweet(Tweet k) {
        em.persist(k);
        return k;
    }

    @Override
    public List<Tweet> findAllTweets(List<User> following, User me) {
        List<Tweet> allTweets = new ArrayList<Tweet>();
        for (User u : following) {
            allTweets.addAll(u.getTweets());
        }
        return allTweets;
    }

    @Override
    public List<Tweet> findTweetsBySnippet(String snippet) {
        Query query = em.createNamedQuery("findKweetsBySnippet").setParameter("snippet", snippet);
        return (List<Tweet>) query.getResultList();
    }

}
