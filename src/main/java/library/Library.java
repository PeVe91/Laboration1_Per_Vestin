package library;

public class Library {
    private final String name;
    private Book[] books;
    private Member[] members;
    private int bookCount = 0;
    private int memberCount = 0;

    //------------------CONSTRUCTOR------------------
    public Library(String name, int initialBookCap, int initialMemberCap) {
        this.name = name;
        this.books = new Book[initialBookCap];
        this.members = new Member[initialMemberCap];
    }

    //--------------------METHODS--------------------

    public void addMember(Member member) {
        if (memberCount == members.length) {
            expandMembersArray();
        }
        members[memberCount++] = member;
    }

    public void addBook(Book book) {
        if (bookCount == books.length) {
            expandBooksArray();
        }
        books[bookCount++] = book;
    }

    public void expandMembersArray() {
        Member[] newMembers = new Member[members.length * 2];
        System.arraycopy(members, 0, newMembers, 0, memberCount);
        members = newMembers;
    }

    public void expandBooksArray() {
        Book[] newBooks = new Book[books.length * 2];
        System.arraycopy(books, 0, newBooks, 0, bookCount);
        books = newBooks;
    }

    //--------------------GETTERS--------------------

    //--------------------SETTERS--------------------


}
