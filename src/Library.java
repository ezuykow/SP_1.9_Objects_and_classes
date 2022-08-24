class Library {
    private Book[] booksArray;

    public Library(int booksCount) {
        booksArray = new Book[booksCount];
    }

    public void addBookToArray(Book book) {
        boolean success = false;

        for (int i = 0; i < booksArray.length; i++) {
            if (booksArray[i] == null) {
                booksArray[i] = book;
                success = true;
                break;
            }
        }

        if (!success) {
            System.out.println("Array is full. Book is not added.");
        }
    }

    public void printBooksFromArray() {
        for (Book book : booksArray) {
            if (book != null) {
                System.out.printf("%s %s: \"%s\": %d\n", book.getAuthor().getName(),
                        book.getAuthor().getSurname(), book.getTitle(), book.getYearOfWriting());
            } else {
                break;
            }
        }
    }

    public void printBookByTitle(String title) {
        boolean success = false;

        for (Book book : booksArray) {
            if (book != null) {
                if (book.getTitle().equals(title)) {
                    System.out.printf("\"%s\" by %s %s was published in %d\n", book.getTitle(),
                            book.getAuthor().getName(), book.getAuthor().getSurname(), book.getYearOfWriting());
                    success = true;
                    break;
                }
            }
        }

        if (!success) {
            System.out.println("Book \"" + title + "\" not found");
        }
    }

    public void changeYearOfWriting(String title, int newYear) {
        boolean success = false;

        for (Book book : booksArray) {
            if (book != null) {
                if (book.getTitle().equals(title)) {
                    book.setYearOfWriting(newYear);
                    success = true;
                    break;
                }
            }
        }

        if (!success) {
            System.out.println("Book \"" + title + "\" not found");
        }
    }
}
