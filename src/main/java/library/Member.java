package library;

public class Member {

    private final String firstName;
    private final String lastName;
    private final int memberId;
    private static int nextMemberId = 100;
    private int borrowedCount;

    //------------------CONSTRUCTOR------------------
    public Member(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberId = nextMemberId++;
        this.borrowedCount = 0;
    }

    //--------------------METHODS--------------------

    //--------------------GETTERS--------------------
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getMemberId() {
        return memberId;
    }
    public int getBorrowedCount() {
        return borrowedCount;
    }
    //--------------------SETTERS--------------------
    public void setBorrowedCount(int borrowedCount) {
        this.borrowedCount = borrowedCount;
    }
}
