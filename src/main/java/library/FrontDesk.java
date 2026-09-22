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
                    handleSearchBook(sc, stadsbiblioteket);
                default -> System.out.println("Invalid choice.");


            }



        }


    }

    //--------------------METHODS--------------------
        //----------------(MENU CHOICES)-----------------
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
    
    public static void handleAddBook(Scanner scanner, Library library) {
        String author;
        while (true) {
        System.out.println("Enter Author: ");
        author = scanner.nextLine().trim();
            if (author.isBlank()) {
                System.out.println("Invalid input.");
            } else  {
                break;
            }
        }

        String title;
        while (true) {
            System.out.println("Enter title: ");
            title = scanner.nextLine().trim();
            if (title.isBlank()) {
                System.out.println("Invalid input.");
            } else {
                break;
            }
        }


        String isbn = "";
        while (true) {
            System.out.println("ISBN-number: ");
            isbn = scanner.nextLine().trim();
            if (isbn.isBlank()) {
                System.out.println("Invalid input.");
            } else  {
                break;
            }
        }

        Book book = new Book(author, title, isbn);
        library.addBook(book);
    }

    public static void handleAddMember(Scanner scanner, Library library) {
        String firstName = "";
        String lastName = "";

        while (true) {
            System.out.println("Enter first name: ");
            firstName = scanner.nextLine().trim();
            if (firstName.isBlank()) {
                System.out.println("Invalid input.");
            } else {
                break;
            }
        }
        while (true) {
            System.out.println("Enter last name: ");
            lastName = scanner.nextLine().trim();
            if (lastName.isBlank()) {
                System.out.println("Invalid input.");
            } else {
                break;
            }
        }

        Member member = new Member(firstName, lastName);
        library.addMember(member);
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

}
