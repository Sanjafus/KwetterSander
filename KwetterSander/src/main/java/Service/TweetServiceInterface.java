/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Tweet;
import Model.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import logic.TweetProvider;
import logic.TweetProviderImpl;
import logic.UserProvider;
import logic.UserProviderImpl;

/**
 *
 * @author Sander
 */
public interface TweetServiceInterface {

    /**
     * Set gebruikerprovider as variabel in TweetService
     *
     * @param gebruikerProvider
     */
    public void setUserProvider(UserProviderImpl userProvider);

    /**
     * Set tweetprovider as variabel in TweetService
     *
     * @param kweetProvider
     */
    public void setTweetProvider(TweetProviderImpl tweetProvider);

    /**
     * Create User and put in database
     *
     * @param u
     * @return USerer class object
     */
    public User createUser(User u);

    /**
     * Return all User of database
     *
     * @return List <User>
     */
    public List<User> findAllUsers();

    /**
     * Return User associated by id
     *
     * @param id
     * @return User class object
     */
    public User findUserById(long id);

    /**
     * Return User associated by username
     *
     * @param username
     * @return Gebruiker class object
     */
    public User findUserByName(String username);

    /**
     * Return list of Tweet associated by username
     *
     * @param username
     * @return List tweet
     */
    public List<Tweet> findTweetByUser(String username);

    /**
     * Return list of User associated by partial string
     *
     * @param snippet
     * @return List User
     */
    public List<User> filterUsersBySnippet(String snippet);

    /**
     * Create Kweet and put in database
     *
     * @param t
     * @return Tweet class object
     */
    public Tweet createTweet(Tweet t);

    /**
     * Return list of Tweet associated by followed users
     *
     * @param following, yourself
     * @return List Tweet
     */
    public List<Tweet> findAllTweets(List<User> following, User yourself);

    /**
     * Return list of Tweet associated by partial string (called snippet)
     *
     * @param snippet
     * @return List Kweet
     * @throws KwetterServiceException
     */
    public List<Tweet> findTweetsBySnippet(String snippet);
}
