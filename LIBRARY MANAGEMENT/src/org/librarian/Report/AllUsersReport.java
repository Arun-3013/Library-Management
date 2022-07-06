package org.librarian.Report;
import org.ValidationsAndOtherOperation.ReadOperation;
import org.ValidationsAndOtherOperation.Terminal;
import org.ValidationsAndOtherOperation.Validations;

import java.util.ArrayList;

public class AllUsersReport extends ReadOperation {

    ArrayList<String[]> arrayList = Terminal.userArrayList();

    private int getDetails(String find) {

        String number = find;
        while (!Validations.isNumeric(number) || Integer.parseInt(number) >= arrayList.size() || Integer.parseInt(number) == 0) {
            number = Terminal.scanAndPrint("\nPlease Enter the number between the above listed: ").nextLine().trim();
        }
        return Integer.parseInt(number);
    }

    protected void printingTheDetails() {

        new PrintReportPage(arrayList);
        String find = Terminal.scanAndPrint("\nPress the above number to view the details or Press Enter to exit: ").nextLine().trim();

        if (!find.equals("")) {
            new org.User.PrintReportPage().printing(arrayList.get(getDetails(find))[0]);
        }
    }
}
