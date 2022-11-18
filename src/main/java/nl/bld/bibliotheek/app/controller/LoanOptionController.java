package nl.bld.bibliotheek.app.controller;

import nl.bld.bibliotheek.app.daos.BookDaoServiceContract;
import nl.bld.bibliotheek.app.daos.LoanDaoService;
import nl.bld.bibliotheek.app.daos.LoanDaoServiceContract;
import nl.bld.bibliotheek.app.domain.Book;
import nl.bld.bibliotheek.app.domain.Loan;
import nl.bld.bibliotheek.app.views.LoanOptionsView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoanOptionController {
    Scanner scanner = new Scanner(System.in);
    LoanOptionsView view = new LoanOptionsView();
    LoanDaoServiceContract loanDao = new LoanDaoService();
    BookDaoServiceContract bookDao = new BookDaoService();

    public void switchMenu() {

        int menuChoice = 0;

        do {
            try {
                System.out.println("Hier komt het menu met opties. Kies 1, 2, 3 of 0 (voor exit)");
                menuChoice = Integer.parseInt(scanner.nextLine());
                switch (menuChoice) {
                    case 1:
                        //showDatabase(); WIP
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
            } catch (NumberFormatException e) {
                System.out.println("Type a number");
            }
        } while (menuChoice != 0);


        if (menuChoice == 0) {
            System.out.println("Goodbye! \n");
        }
    }
// WIP
//    public void showDatabase() {
//        //List<Book> books = getBooks();
//        //view.printLibrary(books);
//    }

    public void checkOutBook() {
        boolean checkOutAnother = true;
        List<Book> books = new ArrayList<>();
        List<Loan> loans = new ArrayList<>();
        while (checkOutAnother) {
            System.out.println("Give the serial number (ID) of your book: ");
            long serialNumber = scanner.nextLong();
            Book book = bookDao.getBookById(serialNumber);
            Loan loan = new Loan();
            loan.setBook(book); // member ook nog toevoegen

            book.setBookQuantity(book.getBookQuantity() - 1);

            books.add(book);
            loans.add(loan);
            String response = yesOrNo("Do you want to check out another book?");
            if (response.equals("N")) {
                checkOutAnother = false;
            }

        }
        for (Book b : books) {
            bookDao.save(b);
        }
        for (Loan l : loans) {
            loanDao.save(l);
        }
    }

    public void checkInBook() {
        boolean checkOutAnother = true;
        List<Book> books = new ArrayList<>();
//        List<Loan> loans = new ArrayList<>();
        while (checkOutAnother) {
            System.out.println("Give the serial number (ID) of your book: ");
            long serialNumber = scanner.nextLong();
            Book book = bookDao.getBookById(serialNumber);



            book.setBookQuantity(book.getBookQuantity() + 1);
            //book.getLoan()

            books.add(book);
            //loans.add(loan);
            String response = yesOrNo("Do you want to check out another book?");
            if (response.equals("N")) {
                checkOutAnother = false;
            }

        }
        for (Book b : books) {
            bookDao.save(b);
        }
//        for (Loan l : loans) {
//            leningDao.remove(l);
//        }
    }

    public String yesOrNo(String string) {
        System.out.println(string);
        Scanner yesOrNoInput = new Scanner(System.in);
        System.out.println("""
                Press 'Y' for 'yes'.
                Press 'N' for 'no'.
                """);
        String yesOrNoAnswer = yesOrNoInput.nextLine().toUpperCase();
        if (!yesOrNoAnswer.equals("Y") && !yesOrNoAnswer.equals("N")) {
            System.out.println("Please try again.");
            yesOrNo(string);
        }
        return yesOrNoAnswer;
    }
}
