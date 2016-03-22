/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Tweet;
import Model.User;
import java.util.List;
import javax.inject.Inject;
import logic.TweetProvider;
import logic.TweetProviderImpl;
import logic.UserProvider;
import logic.UserProviderImpl;

public class TweetServiceInterfaceImpl implements TweetServiceInterface {

    @Inject
    UserProvider userProvider;

    @Inject
    TweetProvider tweetProvider;

    @Override
    public void setUserProvider(UserProviderImpl userProvider) {
        this.userProvider = userProvider;
    }

    @Override
    public void setTweetProvider(TweetProviderImpl tweetProvider) {
        this.tweetProvider = tweetProvider;
    }

    @Override
    public User createUser(User u) {
        return userProvider.createUser(u);
    }

    @Override
    public List<User> findAllUsers() {
        return userProvider.findAllUsers();
    }

    @Override
    public User findUserById(long id) {
        return userProvider.findUserById(id);
    }

    @Override
    public User findUserByName(String username) {
        return userProvider.findUserByName(username);
    }

    @Override
    public List<Tweet> findTweetByUser(String username) {
        return userProvider.findTweetByUser(username);
    }

    @Override
    public List<User> filterUsersBySnippet(String snippet) {
        return userProvider.filterUsersBySnippet(snippet);
    }

    @Override
    public Tweet createTweet(Tweet t) {
        return tweetProvider.createTweet(t);
    }

    @Override
    public List<Tweet> findAllTweets(List<User> following, User yourself) {
        return tweetProvider.findAllTweets(following, yourself);
    }

    @Override
    public List<Tweet> findTweetsBySnippet(String snippet) {
        return tweetProvider.findTweetsBySnippet(snippet);
    }

}
