package nl.bld.bibliotheek.app.testDao;

import nl.bld.bibliotheek.app.domain.Book;
import nl.bld.bibliotheek.app.domain.Loan;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class testLoanOptionController {

    dummyBookDAoService bookDao = new dummyBookDAoService();
    dummyLeningDaoService leningDao = new dummyLeningDaoService();
    //    innerClassView view = new innerClassView();
    Scanner scanner = new Scanner(System.in);

    @Test
    @DisplayName("test checkout book")
    void testCheckOutBook() {
        Book book = null;
        int oldBookQuantity = 0;
        int newbookQuantity = 0;
        int newBookCounter = 0;

        // Arrange
        boolean checkOutAnother = true;
        List<Book> books = new ArrayList<>();
        List<Loan> loans = new ArrayList<>();
        while (checkOutAnother) {
            System.out.println("Give the serial number (ID) of your book: ");
            long serialNumber = scanner.nextLong();
            book = bookDao.getBookById(serialNumber);
            Loan loan = new Loan();
            loan.setBook(book); // member ook nog toevoegen
            oldBookQuantity = book.getBookQuantity();
            book.setBookQuantity(book.getBookQuantity() - 1);
            newbookQuantity = book.getBookQuantity();
            books.add(book);
            loans.add(loan);
            String response = yesOrNo("Do you want to check out another book?");
            if (response.equals("N")) {
                checkOutAnother = false;
            }
            newBookCounter += 1;
        }
        for (Book b : books) {
            bookDao.save(b);
        }
        for (Loan l : loans) {
            leningDao.save(l);
        }
        // Act

        //Assert
        assertThat(oldBookQuantity).isEqualTo(newbookQuantity + 1);
        assertThat(newBookCounter).isEqualTo(books.size());
    }

    @Test
    @DisplayName("test checkin book")
    void testCheckInBook() {
        Book book = null;
        int oldBookQuantity = 0;
        int newBookQuantity = 0;
        int newBookCounter = 0;


        // Arrange
        boolean checkOutAnother = true;
        List<Book> books = new ArrayList<>();
//        List<Loan> loans = new ArrayList<>();
        while (checkOutAnother) {
            System.out.println("Give the serial number (ID) of your book: ");
            long serialNumber = scanner.nextLong();
            book = bookDao.getBookById(serialNumber);


            oldBookQuantity = book.getBookQuantity();
            book.setBookQuantity(book.getBookQuantity() + 1);
            //book.getLoan()
            newBookQuantity = book.getBookQuantity();
            books.add(book);
            //loans.add(loan);
            String response = yesOrNo("Do you want to check out another book?");
            if (response.equals("N")) {
                checkOutAnother = false;
            }
            newBookCounter += 1;
        }
        for (Book b : books) {
            bookDao.save(b);
        }
//        for (Loan l : loans) {
//            leningDao.remove(l);
//        }
        // Act

        //Assert
        assertThat(oldBookQuantity).isEqualTo(newBookQuantity + 1);
        assertThat(newBookCounter).isEqualTo(books.size());
    }
    @Test
    @DisplayName("Test swicht board van loan option controller")
    void testOptionSwitch() {
    // Arrange

    // Act
        int menuChoice = 0;

            do {
                try {
                System.out.println("Hier komt het menu met opties. Kies 1, 2, 3 of 0 (voor exit)");
                menuChoice = Integer.parseInt(scanner.nextLine());
                switch (menuChoice) {
                    case 1:
                        System.out.println(1);
                        break;
                    // Check out book
                    case 2:
                        System.out.println(2);
                        break;
                    // Check in book
                    case 3:
                        System.out.println(3);
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
    //Assert
    assertThat(menuChoice).isEqualTo(0);
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

//    class innerClassView() {
//        public void printLibrary(List<Book> books) {
//            int columnSizeBookTitle = getColumnSize("Book title");
//            int columnSizeAuthor = getColumnSize("Author");
//            int columnSizeQuantity = getColumnSize("Quantity");
//            int totalSize = 17 + columnSizeBookTitle + columnSizeAuthor + columnSizeQuantity;
//
//            System.out.println("-".repeat(Math.max(0, totalSize)));
//            String secondLineSectionOne = " ".repeat(Math.max(0, (totalSize - 14) / 2));
//            if (totalSize % 2 != 0) {
//                String secondLineSectionTwo = " ".repeat(Math.max(0, (totalSize - 14) / 2) + 1);
//                System.out.println("|" + secondLineSectionOne + "List - Books" + secondLineSectionTwo + "|");
//            } else {
//                System.out.println("|" + secondLineSectionOne + "List - Books" + secondLineSectionOne + "|");
//            }
//            System.out.println("" + "-".repeat((Math.max(0, totalSize))) + "");
//
//            String fourthLineBookTitleSectionOne = " ".repeat(Math.max(0, (columnSizeBookTitle - 10 + 2) / 2));
//            String fourthLineBookTitleSectionTwo = " ".repeat(Math.max(0, (columnSizeBookTitle - 10 + 2) / 2));
//            if (columnSizeBookTitle % 2 != 0) {
//                fourthLineBookTitleSectionTwo = " ".repeat(Math.max(0, (columnSizeBookTitle - 10 + 2) / 2) + 1);
//            }
//
//            String fourthLineAuthorSectionOne = " ".repeat(Math.max(0, (columnSizeAuthor - 6 + 2) / 2));
//            String fourthLineAuthorSectionTwo = " ".repeat(Math.max(0, (columnSizeAuthor - 6 + 2) / 2));
//            if (columnSizeAuthor % 2 != 0) {
//                fourthLineAuthorSectionTwo = " ".repeat(Math.max(0, (columnSizeAuthor - 6 + 2) / 2) + 1);
//            }
//            String fourthLineQuantitySectionOne = " ".repeat(Math.max(0, (columnSizeQuantity - 8 + 2) / 2));
//            String fourthLineQuantitySectionTwo = " ".repeat(Math.max(0, (columnSizeQuantity - 8 + 2) / 2));
//
//            if (columnSizeQuantity % 2 != 0) {
//                fourthLineQuantitySectionTwo = " ".repeat(Math.max(0, (columnSizeQuantity - 8 + 2) / 2) + 1);
//            }
//            System.out.println("|  ID  |" + fourthLineBookTitleSectionOne + "Book title" + fourthLineBookTitleSectionTwo + "|"
//                    + fourthLineAuthorSectionOne + "Author" + fourthLineAuthorSectionTwo + "|"
//                    + fourthLineQuantitySectionOne + "Quantity" + fourthLineQuantitySectionTwo + "|");
//            System.out.println("-".repeat(Math.max(0, totalSize)));
//
//            for (Book book : books) {
//                long serialNumber = book.getSerialNumber();
//                String bookTitle = book.getBookTitle();
//                String authorName = book.getAuthorName();
//                int bookQuantity = book.getBookQuantity();
//
//                System.out.println("| " + " ".repeat(Math.max(0, 4 - Integer.toString((int) serialNumber).length()))
//                        + serialNumber + " | " + bookTitle + " ".repeat(Math.max(0, (columnSizeBookTitle - bookTitle.length()))) + " | "
//                        + authorName + " ".repeat(Math.max(0, (columnSizeAuthor - authorName.length()))) + " | "
//                        + bookQuantity + " ".repeat(Math.max(0, (columnSizeQuantity - Integer.toString(bookQuantity).length()))) + " |");
//
//            }
//            System.out.println("-".repeat(Math.max(0, totalSize)));
//        }
//
//        private int getColumnSize(String columnName) throws RuntimeException {
//            String sqlQuery = "";
//            switch (columnName) {
//                case "Book title":
//                    // book dao query
//                    sqlQuery = "SELECT bookTitle FROM Book b";
//                    break;
//                case "Author":
//                    // book dao query
//                    sqlQuery = "SELECT authorName FROM Book b";
//                    break;
//                case "Quantity":
//                    // book dao query
//                    sqlQuery = "SELECT bookQuantity FROM Book b";
//                    break;
//                default:
//                    throw new RuntimeException("Invalid.");
//            }
//
//
//            List column = em.createQuery(sqlQuery).getResultList();
//            int size = 0;
//            for (int i = 0; i < column.size(); i++) {
//                int tempValue = column.get(i).toString().length();
//                if (tempValue > size) {
//                    size = tempValue;
//                }
//            }
//            if (columnName.length() > size) {
//                return columnName.length();
//            } else {
//                return size;
//            }
//        }
//    }
//}
