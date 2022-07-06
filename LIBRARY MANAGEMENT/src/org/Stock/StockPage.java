package org.Stock;

import org.ValidationsAndOtherOperation.Terminal;

public class StockPage {
    String user;
    public StockPage() {
        do {
            Terminal.printString("""
                    ----------------------------------STOCKS----------------------------------
                    1.Add New Stock & Quantity
                    2.Remove Existing Stock & Quantity
                    3.Check Stocks
                    4.Show All Stocks
                    5.Back
                    Choose your Option ( 1-5 ):\s""");
            user = Terminal.getTempInt();
            switch (user) {
                case "1" -> new Add_RemoveStock().addBookStock();
                case "2" -> new Add_RemoveStock().removeBookStock();
                case "3" -> new Check_PrintStock().checkByName();
                case "4" -> new Check_PrintStock().showAllBooks();
                case "5" -> Terminal.printString("Thank you\n");
                default -> Terminal.printString("Please Choose the number between 1-4\n");
            }
        }while (!user.equals("5"));
    }

}

