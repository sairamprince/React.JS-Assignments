package RGTMessaging_Assignmnet_5;

import java.util.Scanner;

public class RGTMain {
	private static RGTMessaging rgtMessaging;

	public static void main(String[] args) {
		rgtMessaging = new RGTMessaging();
		rgtMessaging.loadData();

		Scanner scanner = new Scanner(System.in);
		displayWelcomeMessage();

		while (true) {
			System.out.print("\nPlease enter your choice: ");
			String input = scanner.nextLine().trim().toLowerCase();

			switch (input) {
			case "register":
				registerUser(scanner);
				break;
			case "login":
				loginUser(scanner);
				break;
			case "exit":
				rgtMessaging.saveData();
				System.out.println("Thank you for using RGTMessaging. Goodbye!");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void displayWelcomeMessage() {
		System.out.println("Welcome to RGTMessaging!");
		System.out.println("Please choose an option:");
		System.out.println(" - Register");
		System.out.println(" - Login");
		System.out.println(" - Exit");
	}

	private static void registerUser(Scanner scanner) {
		System.out.println("Please enter your username:");
		String username = scanner.nextLine().trim();

		if (rgtMessaging.userExists(username)) {
			System.out.println("Username already exists. Please try again.");
			return;
		}

		System.out.println("Please enter your password:");
		String password = scanner.nextLine().trim();
		System.out.println("Please enter your name:");
		String name = scanner.nextLine().trim();
		System.out.println("Please enter your bio:");
		String bio = scanner.nextLine().trim();

		rgtMessaging.registerUser(username, password, name, bio);
		System.out.println("User registered successfully.");
	}

	private static void loginUser(Scanner scanner) {
		System.out.println("Please enter your username:");
		String username = scanner.nextLine().trim();

		if (!rgtMessaging.userExists(username)) {
			System.out.println("Username does not exist. Please try again.");
			return;
		}

		System.out.println("Please enter your password:");
		String password = scanner.nextLine().trim();

		if (rgtMessaging.login(username, password)) {
			System.out.println("Login successful.");
			displayLoggedInOptions(scanner);
		} else {
			System.out.println("Incorrect password.s Please try again.");
		}
	}

	private static void displayLoggedInOptions(Scanner scanner) {
		while (true) {
			System.out.println("\nPlease choose an option:");
			System.out.println("1. Post: Post a tweet");
			System.out.println("2. Search User: Search for a user");
			System.out.println("3. Search Tweet: Search for a tweet");
			System.out.println("4. View Timeline: View your timeline");
			System.out.println("5. View Profile: View your profile");
			System.out.println("6. Logout: Logout and return to the main menu");
			System.out.println("7. Exit: Exit the application");

			System.out.print("Enter your choice: ");
			String input = scanner.nextLine().trim().toLowerCase();

			switch (input) {
			case "1":
				postTweet(scanner);
				break;
			case "2":
				searchUser(scanner);
				break;
			case "3":
				searchTweet(scanner);
				break;
			case "4":
				displayTimeline();
				break;
			case "5":
				displayProfile();
				break;
			case "6":
				logoutUser();
				return;
			case "7":
				rgtMessaging.saveData();
				System.out.println("Thank you for using RGTMessaging. Goodbye!");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void postTweet(Scanner scanner) {
		System.out.println("Please enter your tweet:");
		String content = scanner.nextLine().trim();

		if (rgtMessaging.postTweet(content)) {
			System.out.println("Tweet posted successfully.");
		} else {
			System.out.println("Failed to post tweet. Please try again.");
		}
	}

	private static void searchUser(Scanner scanner) {
		System.out.println("Please enter the username of the user you want to search:");
		String username = scanner.nextLine().trim();

		User user = rgtMessaging.searchUser(username);

		if (user != null) {
			System.out.println("Username: " + user.getUsername());
			System.out.println("Name: " + user.getName());
			System.out.println("Bio: " + user.getBio());
		} else {
			System.out.println("User not found.");
		}
	}

	private static void searchTweet(Scanner scanner) {
		System.out.println("Please enter the ID of the tweet you want to search:");
		int tweetId = Integer.parseInt(scanner.nextLine().trim());

		Tweet tweet = rgtMessaging.searchTweet(tweetId);

		if (tweet != null) {
			System.out.println("ID: " + tweet.getId());
			System.out.println("Content: " + tweet.getContent());
			System.out.println("Author: " + tweet.getAuthor().getUsername());
			System.out.println("Timestamp: " + tweet.getTimestamp());
		} else {
			System.out.println("Tweet not found.");
		}
	}

	private static void displayTimeline() {
		for (Tweet tweet : rgtMessaging.getTimeline()) {
			System.out.println(tweet.getAuthor().getUsername() + ": " + tweet.getContent());
		}
	}

	private static void displayProfile() {
		User user = rgtMessaging.getProfile();

		if (user != null) {
			System.out.println("Username: " + user.getUsername());
			System.out.println("Name: " + user.getName());
			System.out.println("Bio: " + user.getBio());
		} else {
			System.out.println("No user profile found.");
		}
	}

	private static void logoutUser() {
		rgtMessaging.logout();
		System.out.println("Logout successful.");
	}
}
