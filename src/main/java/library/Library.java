package library;

public class Library {
    private final String name;
    private Book[] books;
    private Member[] members;

    public Library(String name, int initialBookCap, int initialMemberCap) {
        this.name = name;
        this.books = new Book[initialBookCap];
        this.members = new Member[initialMemberCap];
    }


}
