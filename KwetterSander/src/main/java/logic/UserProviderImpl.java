/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import Model.Tweet;
import Model.User;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sander
 */
@Local
@Stateless
public class UserProviderImpl implements UserProvider {

    @PersistenceContext(unitName="Pu1")
    EntityManager em;

    public UserProviderImpl() {
    }

    @Override
    public User createUser(User u) {
//        try {
//            Query query = em.createNamedQuery("findGebruikerByName").setParameter("username", u.getUsername());
//            if (query.getSingleResult() == null) {
//            }
//        } catch (NoResultException ex) {
//            em.persist(u);
//            return u;
//        }
        em.persist(u);
        return u;
    }

    @Override
    public List<User> findAllUsers() {
        Query query = em.createNamedQuery("findAllUsers");
        return (List<User>) query.getResultList();

    }

    @Override
    public User findUserById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public User findUserByName(String username) {
        Query query = em.createNamedQuery("findUserByName").setParameter("username", username);
        return (User) query.getSingleResult();
    }

    @Override
    public List<Tweet> findTweetByUser(String username) {
        Query query = em.createNamedQuery("findTweetByUser").setParameter("username", username);
        return (List<Tweet>) query.getResultList();
    }

    @Override
    public List<User> filterUsersBySnippet(String snippet) {
        Query query = em.createNamedQuery("filterGebruikersBySnippet").setParameter("snippet", snippet);
        return (List<User>) query.getResultList();
    }

    @Override
    public boolean followUser(User u, User follower) {
        for (User follow : u.getFollowers()) {
            if (follow.getUsername().equals(follower.getUsername())) {
                return false;
            }
        }
        u.addFollower(follower);
        return true;
    }

    @Override
    public int getFollowerAmount(User u) {
        return u.getFollowers().size();
    }
}
