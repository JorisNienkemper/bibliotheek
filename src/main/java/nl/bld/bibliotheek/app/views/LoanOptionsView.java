package nl.bld.bibliotheek.app.views;


import nl.bld.bibliotheek.app.domain.Book;

import java.util.List;

public class LoanOptionsView {

    public void showOptionsLoanController() {
        System.out.println("""
                -------------------------------------------
                | Please choose one of the options below: |
                |                                         |
                | Option 1: Show All Books                |
                | Option 2: Check Out Book                |
                | Option 3: Check In Book                 |
                | Option 4: Administrator menu            |
                | Option 0: Exit Application              |
                -------------------------------------------
                Enter your number:
                """);
    }
}

// WIP

//    public void printLibrary(List<Book> books) {
//        int columnSizeBookTitle = getColumnSize("Book title");
//        int columnSizeAuthor = getColumnSize("Author");
//        int columnSizeQuantity = getColumnSize("Quantity");
//        int totalSize = 17 + columnSizeBookTitle + columnSizeAuthor + columnSizeQuantity;
//
//        System.out.println("-".repeat(Math.max(0, totalSize)));
//        String secondLineSectionOne = " ".repeat(Math.max(0, (totalSize - 14) / 2));
//        if (totalSize % 2 != 0) {
//            String secondLineSectionTwo = " ".repeat(Math.max(0, (totalSize - 14) / 2) + 1);
//            System.out.println("|" + secondLineSectionOne + "List - Books" + secondLineSectionTwo + "|");
//        } else {
//            System.out.println("|" + secondLineSectionOne + "List - Books" + secondLineSectionOne + "|");
//        }
//        System.out.println("" + "-".repeat((Math.max(0, totalSize ))) + "");
//
//        String fourthLineBookTitleSectionOne = " ".repeat(Math.max(0, (columnSizeBookTitle - 10 + 2) / 2));
//        String fourthLineBookTitleSectionTwo = " ".repeat(Math.max(0, (columnSizeBookTitle - 10 + 2) / 2));
//        if (columnSizeBookTitle % 2 != 0) {
//            fourthLineBookTitleSectionTwo = " ".repeat(Math.max(0, (columnSizeBookTitle - 10 + 2) / 2) + 1);
//        }
//
//        String fourthLineAuthorSectionOne = " ".repeat(Math.max(0, (columnSizeAuthor - 6 + 2) / 2));
//        String fourthLineAuthorSectionTwo = " ".repeat(Math.max(0, (columnSizeAuthor - 6 + 2) / 2));
//        if (columnSizeAuthor % 2 != 0) {
//            fourthLineAuthorSectionTwo = " ".repeat(Math.max(0, (columnSizeAuthor - 6 + 2) / 2) + 1);
//        }
//        String fourthLineQuantitySectionOne = " ".repeat(Math.max(0, (columnSizeQuantity - 8 + 2) / 2));
//        String fourthLineQuantitySectionTwo = " ".repeat(Math.max(0, (columnSizeQuantity - 8 + 2) / 2));
//
//        if (columnSizeQuantity % 2 != 0) {
//            fourthLineQuantitySectionTwo = " ".repeat(Math.max(0, (columnSizeQuantity - 8 + 2) / 2) + 1);
//        }
//        System.out.println("|  ID  |" + fourthLineBookTitleSectionOne + "Book title" + fourthLineBookTitleSectionTwo + "|"
//                + fourthLineAuthorSectionOne + "Author" + fourthLineAuthorSectionTwo + "|"
//                + fourthLineQuantitySectionOne + "Quantity" + fourthLineQuantitySectionTwo + "|");
//        System.out.println("-".repeat(Math.max(0, totalSize)));
//
//        for (Book book : books) {
//            long serialNumber = book.getSerialNumber();
//            String bookTitle = book.getBookTitle();
//            String authorName = book.getAuthorName();
//            int bookQuantity = book.getBookQuantity();
//
//            System.out.println("| " + " ".repeat(Math.max(0, 4 - Integer.toString((int) serialNumber).length()))
//                    + serialNumber + " | " + bookTitle + " ".repeat(Math.max(0, (columnSizeBookTitle - bookTitle.length()))) + " | "
//                    + authorName + " ".repeat(Math.max(0, (columnSizeAuthor - authorName.length()))) + " | "
//                    + bookQuantity + " ".repeat(Math.max(0, (columnSizeQuantity - Integer.toString(bookQuantity).length()))) + " |");
//
//        }
//        System.out.println("-".repeat(Math.max(0, totalSize)));
//    }
//    private int getColumnSize(String columnName) throws RuntimeException {
//        String sqlQuery = "";
//        switch (columnName) {
//            case "Book title":
//                sqlQuery = "SELECT bookTitle FROM Book b";
//                break;
//            case "Author":
//                sqlQuery = "SELECT authorName FROM Book b";
//                break;
//            case "Quantity":
//                sqlQuery = "SELECT bookQuantity FROM Book b";
//                break;
//            default:
//                throw new RuntimeException("Invalid.");
//        }
//
//
//////        List column = em.createQuery(sqlQuery).getResultList();
//////        int size = 0;
//////        for (int i = 0; i < column.size(); i++) {
//////            int tempValue = column.get(i).toString().length();
//////            if (tempValue > size) {
//////                size = tempValue;
//////            }
//////        }
////        if (columnName.length() > size) {
////            return columnName.length();
////        } else {
////            return size;
//        }
//    }
//
//}
