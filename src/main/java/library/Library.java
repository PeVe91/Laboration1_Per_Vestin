package library;

public class Library {
    private final String name;
    private Book[] books;
    private Member[] members;
    private int bookCount = 0;

    public Library(String name, int initialBookCap, int initialMemberCap) {
        this.name = name;
        this.books = new Book[initialBookCap];
        this.members = new Member[initialMemberCap];
    }

    //--------------------METHODS--------------------

    public void addBook(Book book) {
        if (bookCount == books.length) {
            expandBooksArray();
        }
        books[bookCount++] = book;
    }

    public void expandBooksArray() {
        Book[] newBooks = new Book[books.length * 2];
        System.arraycopy(books, 0, newBooks, 0, bookCount);
        books = newBooks;
    }



}
