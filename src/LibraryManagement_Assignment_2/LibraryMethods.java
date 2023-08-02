package LibraryManagement_Assignment_2;


public class LibraryMethods 
{
	private static final int MAX_BOOKS = 100;
	private static final int MAX_PATRONS = 100;

	private String[] bookTitles;
	private int[] bookCopies;
	private int totalBooks;

	private String[] patronNames;
	private int totalPatrons;

	public LibraryMethods() 
	{
		bookTitles = new String[MAX_BOOKS];
		bookCopies = new int[MAX_BOOKS];
		totalBooks = 0;
		patronNames = new String[MAX_PATRONS];
		totalPatrons = 0;
	}

	public void addBook(String title, int copies) 
	{
		if (totalBooks < MAX_BOOKS) 
		{
			bookTitles[totalBooks] = title;
			bookCopies[totalBooks] = copies;
			totalBooks++;
			System.out.println("Book added successfully.");
			System.out.println("---------------------------->");
		} else 
		{
			System.err.println("Library is full. Cannot add more books :(");
		}
	}


	public void addPatron(String name) 
	{
		if (totalPatrons < MAX_PATRONS) 
		{
			patronNames[totalPatrons] = name;
			totalPatrons++;
			System.out.println("Patron added successfully.");
			System.out.println("---------------------------->");
		} else 
		{
			System.err.println("Maximum number of patrons reached. Can't add more patrons.");
		}
	}

	public void borrowBook(String title) 
	{
		int bookIndex = findBookIndex(title);
		if (bookIndex == -1) 
		{
			System.out.println("Book not found in the library.");
		} else 
		{
			if (bookCopies[bookIndex] > 0) 
			{
				bookCopies[bookIndex]--;
				System.out.println("Book borrowed successfully.");
				System.out.println("---------------------------->");
			} else 
			{
				System.err.println("No copies of the book available to borrow.");
				System.out.println("------------------------------------------>");
			}
		}
	}

	public void returnBook(String title) 
	{
		int bookIndex = findBookIndex(title);
		if (bookIndex == -1) 
		{
			System.out.println("Book not found in the library.");
			System.out.println("---------------------------->");
		} else 
		{
			bookCopies[bookIndex]++;
			System.out.println("Book returned successfully.");
			System.out.println("---------------------------->");
		}
	}

	private int findBookIndex(String title) 
	{
		for (int i = 0; i < totalBooks; i++) {
			if (bookTitles[i].equalsIgnoreCase(title)) 
			{
				return i;
			}
		}
		return -1;
	}
	
}

