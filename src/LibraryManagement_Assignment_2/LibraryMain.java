package LibraryManagement_Assignment_2;
import java.util.Scanner;


public class LibraryMain 
{
	public static void main(String[] args) {
		LibraryMethods library = new LibraryMethods();
		Scanner scanner = new Scanner(System.in);
		int option;

		do {
			System.out.println("**** Library Management System ****");
			System.out.println(" ");
			System.out.println("Follow below options to do perform operation: ");
			System.out.println("1. Add Book");
			System.out.println("2. addPatron");
			System.out.println("3. Borrow Book");
			System.out.println("4. Return Book");
			System.out.println("5. Exit");
			System.out.println(" ");
			System.out.print("Enter your choice: ");
			option = scanner.nextInt();

			switch (option) {
			case 1:
				System.out.print("Enter book title: ");
				scanner.nextLine();
				String title = scanner.nextLine();
				System.out.print("Enter number of copies: ");
				int copies = scanner.nextInt();
				library.addBook(title, copies);
				break;
			case 2:
				System.out.print("Enter patron name: ");
				scanner.nextLine(); 
				String name = scanner.nextLine();
				library.addPatron(name);
				break;
			case 3:
				System.out.print("Enter book title to borrow: ");
				scanner.nextLine();
				String borrowTitle = scanner.nextLine();
				library.borrowBook(borrowTitle);
				break;
			case 4:
				System.out.print("Enter book title to return: ");
				scanner.nextLine(); 
				String returnTitle = scanner.nextLine();
				library.returnBook(returnTitle);
				break;
			case 5:
				System.err.println("Exiting from the Library...!!!!");
				break;
			default:
				System.err.println("Your choice was Invalid. Please try again.");
				break;
			}

			System.out.println();

		} 
		while (option != 5);
		System.out.println();
	}


}