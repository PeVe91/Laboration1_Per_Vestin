package library;

import java.util.Scanner;

public class FrontDesk {
    static void main() {
        Library stadsbiblioteket = new Library
                ("Stadsbilblioteket", 2, 10);
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;

        while (true) {

            printMenu();
            String choice = sc.nextLine().trim();
            switch (choice.toLowerCase()) {
                case "e" -> {
                    isRunning = false;
                    return;
                }
                case "1" ->
                    handleAddBook(sc, stadsbiblioteket);
                case "2" ->
                    handleAddMember(sc, stadsbiblioteket);
                case "5" ->
                    handleSearchBook();
                default -> System.out.println("Invalid choice.");


            }



        }


    }

    //--------------------METHODS--------------------

    public static void handleSearchBook() {

    }

    public static void handleAddBook(Scanner scanner, Library library) {
        System.out.println("Enter Author: ");
        String author = scanner.nextLine().trim();
        System.out.println("Enter title: ");
        String title = scanner.nextLine().trim();
        System.out.println("ISBN-number: ");
        String isbn = scanner.nextLine().trim();

        Book book = new Book(author, title, isbn);
        library.addBook(book);
    }

    public static void handleAddMember(Scanner scanner, Library library) {
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine().trim();
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine().trim();

        Member member = new Member(firstName, lastName);
        library.addMember(member);
    }

    public static void printMenu() {
        IO.println("""
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
}
