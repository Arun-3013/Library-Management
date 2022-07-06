package org.Entity;
import org.Stock.StockPage;
import org.librarian.BorrowBooks;
import org.librarian.Report.ReportPage;

import org.librarian.ReturnBooks;
import org.ValidationsAndOtherOperation.Terminal;

public class LibrarianPage {

    private void borrowingBook()  {
        new BorrowBooks();
    }
    private void stocks(){
        new StockPage();
    }
    private void returningBook() {
        new ReturnBooks();
    }

    private void report() {
        new ReportPage();
    }

    public LibrarianPage(String name) {
        String temp;
        do {
            Terminal.printString("\n---------------------------Welcome "+name+"-------------------------------------\n");
            Terminal.printString("""
                       1.Issue Books
                       2.Return Books
                       3.Stocks
                       4.Report
                       5.Logout
                       Choose anyone option ( 1-5 ):\s""");
            temp = Terminal.getTempInt();
            Terminal.printString("\n");
            switch (temp) {
                case "1" -> borrowingBook();
                case "2" -> returningBook();
                case "3" -> stocks();
                case "4" -> report();
                case "5" -> Terminal.printString("\tThank you\n");
                default -> Terminal.printString("\tEnter a valid number\n");
            }
        }while(!temp.equals("5"));
    }
}
