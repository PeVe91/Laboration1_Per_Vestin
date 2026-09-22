package library;

public class Loan {
    private final Book book;
    private final Member member;

    //------------------CONSTRUCTOR------------------
    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
    }

    //--------------------GETTERS--------------------
    public Book getBook() {
        return book;
    }
    public Member getMember() {
        return member;
    }
}
