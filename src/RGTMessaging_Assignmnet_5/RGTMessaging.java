package RGTMessaging_Assignmnet_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RGTMessaging {
    private Map<String, User> users;
    private List<Tweet> tweets;
    private User currentUser;

    public RGTMessaging() {
        this.users = new HashMap<>();
        this.tweets = new ArrayList<>();
        this.currentUser = null;
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    public void registerUser(String username, String password, String name, String bio) {
        User user = new User(username, password, name, bio);
        users.put(username, user);
    }

    public boolean login(String username, String password) {
        User user = users.get(username);

        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            return true;
        }

        return false;
    }

    public void logout() {
        currentUser = null;
    }

    public boolean postTweet(String content) {
        if (currentUser != null) {
            Tweet tweet = new Tweet(content, currentUser);
            currentUser.addTweet(tweet);
            tweets.add(tweet);
            return true;
        }
        return false;
    }

    public User searchUser(String username) {
        return users.get(username);
    }

    public Tweet searchTweet(int tweetId) {
        for (Tweet tweet : tweets) {
            if (tweet.getId() == tweetId) {
                return tweet;
            }
        }
        return null;
    }

    public List<Tweet> getTimeline() {
        if (currentUser != null) {
            List<Tweet> timeline = new ArrayList<>();
            for (User user : currentUser.getFollowings()) {
                timeline.addAll(user.getTweets());
            }
            return timeline;
        }
        return new ArrayList<>();
    }

    public User getProfile() {
        return currentUser;
    }

}

