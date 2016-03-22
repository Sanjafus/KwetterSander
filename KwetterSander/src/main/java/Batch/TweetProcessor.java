/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Batch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import logic.UserProviderImpl;
import logic.TweetProviderImpl;
import Model.User;
import Model.Tweet;
import Service.TweetServiceInterface;

/**
 *
 * @author Sander
 */
@Dependent
@Named
public class TweetProcessor implements ItemProcessor {
    
    @Inject
    TweetServiceInterface tweetService;
    
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    @Override
    public Object processItem(Object item) throws Exception {
        System.out.print(item);
        RawTweet tweet = (RawTweet) item;
        String screenName = tweet.getScreenName();
        String text = tweet.getTweet();
        String postFrom = tweet.getPostedFrom();
        Date postDate = DATE_FORMAT.parse(tweet.getPostDate());
        User user = new User(screenName, "", "");
//        tweetService.createUser(user);
        
        Tweet tweetReturn = new Tweet(user,"");
        tweetReturn.setScreenName(screenName);
        tweetReturn.setTweet(text);
        tweetReturn.setPostedFrom(postFrom);
        tweetReturn.setPostDate(postDate);
        return tweetReturn;
    }
}
