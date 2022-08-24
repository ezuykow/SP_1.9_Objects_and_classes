public class ObjectsAndClasses {
    public static void main(String[] args) {
        //Easy-level
        var authorHSchildt = new Author("Herbert", "Schildt");
        var authorABhargava = new Author("Aditya", "Bhargava");

        var bookJava = new Book("Java: The Complete Reference, Eleventh Edition",
                authorHSchildt, 2018);
        var bookAlgorithms = new Book("Grokking Algorithms",
                authorABhargava, 1962);

        bookAlgorithms.setYearOfWriting(2017);

        //Middle-level
        int booksCount = 10; //Size of array for books
        Book[] booksArray = new Book[booksCount];

        addBookToArray(bookJava, booksArray);
        addBookToArray(bookAlgorithms, booksArray);

        printBooksFromArray(booksArray);

        //Hard-level
        var library = new Library(10);

        library.addBookToArray(bookJava);
        library.addBookToArray(bookAlgorithms);
        library.addBookToArray(new Book("The Stand", new Author("Stephen", "King"), 1978));

        System.out.println("\nAll books in library:");
        library.printBooksFromArray();

        System.out.println("\nBook by title (The Stand):");
        library.printBookByTitle("The Stand");

        System.out.println("\nChange year of writing by title (The Stand):");
        library.changeYearOfWriting("The Stand", 2020);
        library.printBookByTitle("The Stand");
    }

    private static void addBookToArray(Book book, Book[] books) {
        boolean success = false;

        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                success = true;
                break;
            }
        }

        if (!success) {
            System.out.println("Array is full. Book is not added.");
        }
    }

    private static void printBooksFromArray(Book[] books) {
        for (Book book : books) {
            if (book != null) {
                System.out.printf("%s %s: \"%s\": %d\n", book.getAuthor().getName(),
                        book.getAuthor().getSurname(), book.getTitle(), book.getYearOfWriting());
            } else {
                break;
            }
        }
    }
}
