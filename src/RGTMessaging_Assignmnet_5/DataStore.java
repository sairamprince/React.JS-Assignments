package RGTMessaging_Assignmnet_5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataStore {
    private static final String USER_DATA_FILE = "users.dat";
    private static final String TWEET_DATA_FILE = "tweets.dat";

    public void saveData(List<User> users, List<Tweet> tweets) {
        try (ObjectOutputStream userOutputStream = new ObjectOutputStream(
                new FileOutputStream(USER_DATA_FILE));
             ObjectOutputStream tweetOutputStream = new ObjectOutputStream(
                     new FileOutputStream(TWEET_DATA_FILE))) {

            userOutputStream.writeObject(users);
            tweetOutputStream.writeObject(tweets);

            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save data: " + e.getMessage());
        }
    }

    public List<User> loadUsers() {
        try (ObjectInputStream userInputStream = new ObjectInputStream(
                new FileInputStream(USER_DATA_FILE))) {

            List<User> users = (List<User>) userInputStream.readObject();
            System.out.println("Users loaded successfully.");
            return users;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to load users: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public List<Tweet> loadTweets() {
        try (ObjectInputStream tweetInputStream = new ObjectInputStream(
                new FileInputStream(TWEET_DATA_FILE))) {

            List<Tweet> tweets = (List<Tweet>) tweetInputStream.readObject();
            System.out.println("Tweets loaded successfully.");
            return tweets;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to load tweets: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}

