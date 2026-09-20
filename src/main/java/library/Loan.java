package library;

public class Loan {

    private Book book;
    private Member member;
    private int loanCount;

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
