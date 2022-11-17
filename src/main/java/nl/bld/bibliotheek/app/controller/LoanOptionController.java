package nl.bld.bibliotheek.app.controller;

import nl.bld.bibliotheek.app.domain.Book;
import nl.bld.bibliotheek.app.views.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoanOptionController {
    Scanner scanner = new Scanner(System.in);
    View view = new View();


    public void switchMenu() {

        int menuChoice = Integer.parseInt(scanner.nextLine());
        try {
            do {
                view.showOptionsLoanController();
                switch (menuChoice) {
                    case 1:
                        showDatabase();
                        break;
                    // Check out book
                    case 2:
                        checkOutBook();
                        break;
                    // Check in book
                    case 3:
                        checkInBook();
                        break;
                    default:
                        System.out.println("Please enter a number between 0 and 4. \n");
                        break;
                }
            } while (menuChoice != 0);
        } catch (NumberFormatException e) {
            System.out.println("Type a number");
        }


        if (menuChoice == 0) {
            System.out.println("Goodbye! \n");
        }
    }

    public void showDatabase() {
        List<Book> books = getBooks();
        view.printLibrary(books);
    }

    public void checkOutBook() {
        boolean checkOutAnother = true;
        List<Book> books = new ArrayList<>();
        while (checkOutAnother) {
            System.out.println("Give the serial number (ID) of your book: ");
            long serialNumber = scanner.nextLong();
            String sqlQuery = "SELECT b FROM Book b";
            Book b = em.find(Book.class, serialNumber);
            b.setBookQuantity(b.getBookQuantity() - 1);
            books.add(b);
            String response = menu.yesOrNo("Do you want to check out another book?");
            if (response.equals("N")) {
                checkOutAnother = false;
            }
        }
        tx.begin();
        for (Book b : books) {
            em.persist(b);
        }
        tx.commit();
    }

    public void checkInBook() {
        boolean checkOutAnother = true;
        List<Book> books = new ArrayList<>();
        while (checkOutAnother) {
            System.out.println("Give the serial number (ID) of your book: ");
            long serialNumber = scanner.nextLong();
            String sqlQuery = "SELECT b FROM Book b";
            Book b = em.find(Book.class, serialNumber);
            b.setBookQuantity(b.getBookQuantity() + 1);
            books.add(b);
            String response = menu.yesOrNo("Do you want to check in another book?");
            if (response.equals("N")) {
                checkOutAnother = false;
            }
        }
        tx.begin();
        for (Book b : books) {
            em.persist(b);
        }
        tx.commit();
    }
}
