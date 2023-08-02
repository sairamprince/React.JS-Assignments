package RGTMessaging_Assignmnet_5;

import java.util.ArrayList;
import java.util.List;

public class User 
{
	private String username;
	private String password;
	private String name;
	private String bio;
	private List<User> followings;
	private List<User> followers;
	private List<Tweet> tweets;

public User(String username, String password, String name, String bio) {
	this.username = username;
	this.password = password;
	this.name = name;
	this.bio = bio;
	this.followings = new ArrayList<>();
	this.followers = new ArrayList<>();
	this.tweets = new ArrayList<>();
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getBio() {
		return bio;
	}

	public List<User> getFollowings() {
		return followings;
	}

	public List<User> getFollowers() {
		return followers;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void addFollowing(User user) {
		followings.add(user);
	}

	public void addFollower(User user) {
		followers.add(user);
	}

	public void addTweet(Tweet tweet) {
		tweets.add(tweet);
	}
}

