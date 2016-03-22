/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Model.Tweet;

import Model.User;
import Service.TweetServiceInterface;
import Service.TweetServiceInterfaceImpl;
import java.util.List;
import logic.TweetProviderImpl;
import logic.UserProviderImpl;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Sander
 */
@RunWith(MockitoJUnitRunner.class)
public class KwetterTest {

    TweetServiceInterface service;
    Tweet tweet;
    @Mock
    UserProviderImpl up;
    @Mock
    TweetProviderImpl tp;

    @Before
    public void setUp() {
        user = new User("test", "test", "test");
        tweet = new Tweet(user, "TestTweet");

        service = new TweetServiceInterfaceImpl();
        service.setUserProvider(up);
        service.setTweetProvider(tp);

//        posting = new Posting(title, content);
//        service = new WebLogService();
//        service.setPostingDao(dao);
    }

    @After
    public void tearDown() {
    }

//    @Test
//    public void successfulPost() {
//        try{
//        service.createTweet(tweet);
//        verify(service, Mockito.times(1)).createTweet(tweet);
//        }
//        catch(Exception e)
//        {
//            fail("Post has not been successfully placed");
//        }
//    }
    
    @Test
    public void createUser()
    {
         try {
            up.createUser(user);
            verify(up, Mockito.times(1)).createUser(user);
        } catch (Exception e) {
            fail("User not created correctly");
        }
    }
    
    @Test
    public void findTweetByUser(){
     try {
            List<Tweet> tweetsByUser = up.findTweetByUser("test");
            assertNotNull(tweetsByUser);
            verify(up, Mockito.times(1)).findTweetByUser("test");
        } catch(Exception e){
            fail("Tweets can not be retrieved from user");
        }
    }
//    @Test
//    public void only5PostsAllowed() {
//        boolean postingOK;
//        when(dao.create(posting)).thenReturn(true);  //stubbing
//        for (int i = 0; i < 5; i++) {
//            posting.setTitle(title + i);
//            postingOK = service.addPosting(posting, user);
//            assertTrue(postingOK);
//        }
//        postingOK = service.addPosting(posting, user);
//        assertFalse(postingOK);
//        verify(dao, Mockito.times(5)).create(posting);
//    }

//    @Test
//    public void only5PostsAllowedBDD() {
//        boolean postingOK = false;
//        //given
//        given(dao.create(posting)).willReturn(true);  //stubbing
//        //when
//        for (int i = 0; i < 6; i++) {
//            posting.setTitle(title + i);
//            postingOK = service.addPosting(posting, user);
//        }
//        //then
//        assertFalse(postingOK);
//        verify(dao, Mockito.times(5)).create(posting);
//    }

    User user;
    String userName = "Jan";
    String title = "onderwerp";
    String content = "inhoud over onderwerp";
}
