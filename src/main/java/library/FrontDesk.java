package library;

import java.util.Scanner;

public class FrontDesk {
    static void main() {
        Library stadsbiblioteket = new Library
                ("Stadsbilblioteket", 2, 10);
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {

            printMenu();
            String choice = sc.nextLine().trim();
            switch (choice.toLowerCase()) {
                case "e" ->
                    isRunning = false;
                case "1" ->
                    handleAddBook(sc, stadsbiblioteket);
                case "2" ->
                    handleAddMember(sc, stadsbiblioteket);
                case "3" ->
                    handleAddLoan(sc, stadsbiblioteket);
                case "4" ->
                    handleReturnBook(sc, stadsbiblioteket);
                case "5" ->
                    handleSearchBook(sc, stadsbiblioteket);
                case "6" ->
                    handleShowBooksAndStatus(stadsbiblioteket);
                default -> System.out.println("Invalid choice.");

            }

        }

    }

    //--------------------METHODS--------------------
        //----------------(MENU CHOICES)-----------------
    public static void printMenu() {
        System.out.println("""
                Bibliotekshanteraren
                ====================
                1. Lägg till bok
                2. Registrera medlem
                3. Låna bok
                4. Lämna tillbaka bok
                5. Sök bok (titel eller författare)
                6. Visa alla böcker och status
                e. Avsluta
                """);
    }

    public static void handleAddBook(Scanner sc, Library library) {
        String author;
        while (true) {
        System.out.println("Enter Author: ");
        author = sc.nextLine().trim();
            if (author.isBlank()) {
                System.out.println("This field cannot be left blank.");
            } else if (!author.matches("^[a-zA-ZåäöÅÄÖ\\s-]+$")) {
                System.out.println("Can only contain letters.");
            } else
                break;
        }

        String title;
        while (true) {
            System.out.println("Enter title: ");
            title = sc.nextLine().trim();
            if (title.isBlank()) {
                System.out.println("This field cannot be left blank.");
            } else {
                break;
            }
        }

        String isbn;
        do {
            long randomNumber = (long) (Math.random() * 9_000_000_000L) + 1_000_000_000L;
            isbn = String.valueOf(randomNumber);

        } while (library.isbnAlreadyExists(isbn));
        /*
        while (true) {
            System.out.println("ISBN-number: ");
            isbn = sc.nextLine().trim();
            if (isbn.isBlank()) {
                System.out.println("This field cannot be left blank.");
            } else if (!isbn.matches("\\d+"))  {
                System.out.println("ISBN-number may only contain numbers.");
            } else
                break;
        }
         */



        Book book = new Book(author, title, isbn);
        library.addBook(book);

    }

    public static void handleAddMember(Scanner sc, Library library) {
        String firstName = "";
        String lastName = "";

        while (true) {
            System.out.println("Enter first name: ");
            firstName = sc.nextLine().trim();
            if (firstName.isBlank()) {
                System.out.println("This field cannot be left blank.");
            } else if (!firstName.matches("^[a-zA-ZåäöÅÄÖ\\s-]+$")) {
                System.out.println("First name may only contain letters.");
            } else
                break;
        }
        while (true) {
            System.out.println("Enter last name: ");
            lastName = sc.nextLine().trim();
            if (lastName.isBlank()) {
                System.out.println("This field cannot be left blank.");
            } else if (!lastName.matches("^[a-zA-ZåäöÅÄÖ\\s-]+$")) {
                System.out.println("Last name may only contain letters.");
            } else
                break;
        }

        Member member = new Member(firstName, lastName);
        library.addMember(member);

        library.welcomeNewMember (firstName, member.getMemberId());
    }

    public static void handleAddLoan (Scanner sc, Library library) {

        String isbn;
        int memberId;

        while (true) {
            System.out.println("Enter the ISBN-number of the book you wish to borrow:");
            isbn = sc.nextLine().trim();

            if (isbn.isBlank()) {
                System.out.println("This field cannot be left blank.");
            } else
                break;
        }


        while (true) {
            System.out.println("Enter your Member ID:");

            try {
                memberId = Integer.parseInt(sc.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Member ID may only contain numbers.");
            }
        }

        boolean success = library.newLoan(memberId, isbn);

        if (success) {
            System.out.println("Loan successful!");
        } else {
            System.out.println("Loan failed!");
        }

    }

    public static void handleReturnBook(Scanner sc, Library library) {
        String title;
        while (true) {
            System.out.println("Enter the title of the book you wish to return:");
            title = sc.nextLine().trim();
            if (title.isBlank()) {
                System.out.println("Title cannot be empty.");
            } else  {
                break;
            }
        }

        boolean success = library.returnBook(title);

        if (success) {
            System.out.println("Return successful!");
        } else {
            System.out.println("This book is currently not lent out!");
        }

    }

    public static void handleSearchBook(Scanner sc, Library library) {
        System.out.println("Search for an author or a title:");
        String searchInput = sc.nextLine().trim();

        if (searchInput.isBlank()) {
            System.out.println("Invalid input.");
            return;
        }

        Book[] result = library.searchBook(searchInput);

        System.out.println("Number of matching items: " + result.length);
    }

    public static void handleShowBooksAndStatus(Library library) {
        library.showAllBooks();
    }



}
