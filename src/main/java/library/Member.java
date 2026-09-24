package library;

public class Member {

    private final String firstName;
    private final String lastName;
    private final int memberId;
    private static int nextMemberId = 101;

    //------------------CONSTRUCTOR------------------
    public Member(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberId = nextMemberId++;
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
    //--------------------SETTERS--------------------
}
