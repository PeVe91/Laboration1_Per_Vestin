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

    private Loan[] fitSearchArray(Loan[] matchingLoans, int matchCount) {
        Loan[] matchingLoansTemp = new Loan[matchCount];
        System.arraycopy(matchingLoans, 0, matchingLoansTemp, 0, matchCount);
        return matchingLoansTemp;
    }

    private void sortBooksByTitle () {

        for (int i = 0; i < bookCount - 1; i++) {

            for (int j = i + 1; j < bookCount; j++) {
                if (books[i].title().compareToIgnoreCase(books[j].title()) > 0) {
                    Book temp = books[j];
                    books[j] = books[i];
                    books[i] = temp;
                }
            }

        }
    }

    public boolean newLoan(int memberId, String bookTitle) {

        Member member = searchMemberId(memberId);
        Book book = searchBookTitle(bookTitle);

        if (member == null ||
                book == null ||
                isBookBorrowed(book) ||
                getActiveLoansCount(memberId) >= 3) {
            return false;
        }

        Loan loan = new Loan(book, member);

        addLoan(loan);

        return true;
    }

    public boolean returnBook (String bookTitle) {

        for (int i = 0; i < loanCount; i++) {
            if (loans[i].getBook().title().equalsIgnoreCase(bookTitle)) {

                loans[i] = loans[loanCount - 1];
                loans[loanCount - 1] = null;
                loanCount--;

                return true;
            }
        }
        return false;
    }

    public boolean isBookBorrowed (Book book) {

        for (int i = 0; i < loanCount; i++) {

            if (loans[i].getBook().equals(book)) {
                return true;
            }
        }
        return false;
    }

        //------------------ADD OBJECTS------------------

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
        sortBooksByTitle();
    }

    public void addLoan(Loan loan) {
        if (loanCount == loans.length) {
            expandLoansArray();
        }
        loans[loanCount++] = loan;
    }

    public Member searchMemberId(int memberId) {

        for (int i = 0; i < memberCount; i++) {
            if (members[i].getMemberId() == memberId) {
                return members[i];
            }
        }
        return null;
    }

    public Book searchBookTitle(String bookTitle) {

        for (int i = 0; i < bookCount; i++) {
            if (books[i].title().equalsIgnoreCase(bookTitle.trim())) {
                return books[i];
            }
        }
        return null;
    }


        //-------------------EXPANDERS-------------------

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

    private void expandLoansArray() {
        Loan[] newLoans = new Loan[loans.length * 2];
        System.arraycopy(loans, 0, newLoans, 0, loanCount);
        loans = newLoans;
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
    public int getActiveLoansCount(int memberId) {
        int count = 0;

        for (int i = 0; i < loanCount; i++) {
            // Om lånet tillhör medlemmen vi letar efter -> plussa på 1
            if (loans[i].getMember().getMemberId() == memberId) {
                count++;
            }
        }
        return count;
    }


        //--------------------SETTERS--------------------


}
