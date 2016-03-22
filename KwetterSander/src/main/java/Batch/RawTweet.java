/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Batch;


/**
 *
 * @author Sander
 */
public class RawTweet {

	private final String screenName;
	private final String tweet;
	private final String postedFrom;
	private final String postDate;

	public RawTweet(String screenName, String tweet, String postedFrom,
			String postDate) {
		this.screenName = screenName;
		this.tweet = tweet;
		this.postedFrom = postedFrom;
		this.postDate = postDate;
	}

	public String getScreenName() {
		return screenName;
	}

	public String getTweet() {
		return tweet;
	}

	public String getPostedFrom() {
		return postedFrom;
	}

	public String getPostDate() {
		return postDate;
	}

	@Override
	public String toString() {
		return "Tweet = [screenName=" + screenName + ", postedFrom="
				+ postedFrom + ", postDate=" + postDate + "]";
	}
}
