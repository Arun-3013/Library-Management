package org.librarian.Report;

import org.ValidationsAndOtherOperation.Terminal;


public class ReportPage {
    public ReportPage() {
        String temp;
        do {
            Terminal.printString("""
                    ----------------------------------View Report----------------------------------
                    1.All user
                    2.User who brought
                    3.User who is delayed to submit
                    4.Back
                    Choose anyone option ( 1-4 ):\s""");
            temp = Terminal.getTempInt();;
            Terminal.printString("\n");
            switch (temp) {
                case "1" -> new AllUsersReport().printingTheDetails();
                case "2" -> new BorrowYetToReturnReport().broughtArray();
                case "3" -> new BorrowYetToReturnReport().yetToSubmitArray();
                case "4" -> Terminal.printString("\tThank you\n");
                default -> Terminal.printString("\tEnter a valid number\n");
            }
        } while (!temp.equals("4"));
    }
}
