package library;

public class Library {
    private final String name;
    private Book[] books;
    private Member[] members;
    private Loan[] loans;
    private int bookCount = 0;
    private int memberCount = 0;
    private int loanCount = 0;

    //------------------CONSTRUCTOR------------------
    public Library(String name, int initialBookCap, int initialMemberCap) {
        this.name = name;
        this.books = new Book[initialBookCap];
        this.members = new Member[initialMemberCap];
        this.loans = new Loan[initialBookCap];
    }

    //--------------------METHODS--------------------

    public Book[] searchBook(String searchInput) {
        String search = searchInput.toLowerCase();
        Book[] matchingBooks = new Book[bookCount];
        int matchCount = 0;

        for (int i = 0; i < bookCount; i++) {
            if (books[i].author().toLowerCase().contains(search)
                    || books[i].title().toLowerCase().contains(search)) {
                matchingBooks[matchCount++] = books[i];
            }
        }
        return fitSearchArray(matchingBooks, matchCount);
    }

    private Book[] fitSearchArray(Book[] matchingBooks, int matchCount) {
        Book[] matchingBooksTemp = new Book[matchCount];
        System.arraycopy(matchingBooks, 0, matchingBooksTemp, 0, matchCount);
        return matchingBooksTemp;
    }

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

    private void expandMembersArray() {
        Member[] newMembers = new Member[members.length * 2];
        System.arraycopy(members, 0, newMembers, 0, memberCount);
        members = newMembers;
    }

    private void expandBooksArray() {
        Book[] newBooks = new Book[books.length * 2];
        System.arraycopy(books, 0, newBooks, 0, bookCount);
        books = newBooks;
    }

    //--------------------GETTERS--------------------
    public Book[] getBooks() {
        return books;
    }
    public Member[] getMembers() {
        return members;
    }
    public Loan[] getLoans() {
        return loans;
    }
    public int getBookCount() {
        return bookCount;
    }
    public int getMemberCount() {
        return memberCount;
    }
    public int getLoanCount() {
        return loanCount;
    }
    public String getName() {
        return name;
    }

    //--------------------SETTERS--------------------


}
