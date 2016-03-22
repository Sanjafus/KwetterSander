/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import Model.User;
import java.util.List;
import Model.Tweet;

/**
 *
 * @author Chunsing
 */
public interface UserProvider {
        
    User createUser(User u) ;
    
    List<User> findAllUsers() ;
    
    User findUserById(long id) ;

    User findUserByName(String username);
    
    List<Tweet> findTweetByUser(String username);
    
    List<User> filterUsersBySnippet(String snippet);
    
    boolean followUser(User u, User following);
    
    int getFollowerAmount(User u);

}
