package RGTMessaging_Assignmnet_5;

import java.time.LocalDateTime;

public class Tweet {
	private static int tweetCount = 0;

	private int id;
	private String content;
	private User author;
	private LocalDateTime timestamp;

	public Tweet(String content, User author) {
		this.id = generateTweetId();
		this.content = content;
		this.author = author;
		this.timestamp = LocalDateTime.now();
	}

	public int getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public User getAuthor() {
		return author;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	private static int generateTweetId() {
		return ++tweetCount;
	}
}
