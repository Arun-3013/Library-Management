package org.librarian.Report;

import org.ValidationsAndOtherOperation.Terminal;

import java.util.ArrayList;

/**
 * Used for two purposes to print the report in student page and the view the report in librarian page
 */
public class PrintReportPage {

    ArrayList<String[]> arrayList;

    protected PrintReportPage(ArrayList<String[]> arrayList) {
        this.arrayList = arrayList;
        int arrayLength;

        if (arrayList.size() != 1) {

            if (arrayList.get(1).length == 5) {

                Terminal.printString(String.format("%-10s%-30s%-30s%-30s%-30s%-30s\n", "SNo", "Name", "EmailID", "Mobile number", "Book Taken", "Due Books"));
                arrayLength = arrayList.get(1).length - 2;

            } else {

                Terminal.printString(String.format("%-10s%-30s%-30s%-30s%-30s\n", "SNo", "Name", "EmailID", "Mobile number", "Book Taken"));
                arrayLength = arrayList.get(1).length;

            }

            for (int i = 1; i < arrayList.size(); i++) {

                Terminal.printString(String.format("\n%-10s", i));

                for (int j = 1; j < arrayLength; j++) {
                    Terminal.printString(String.format("%-30s", arrayList.get(i)[j]));
                }

                Terminal.printString(String.format("%-30s", arrayList.get(i)[0]));
                if(Terminal.bookObjectTreeMap.containsKey(arrayList.get(i)[0]))
                    Terminal.printString(String.format("%-30s", Terminal.bookObjectTreeMap.get(arrayList.get(i)[0]).size()));
                else
                    Terminal.printString(String.format("%-30s",0));

                if (arrayList.get(1).length == 5) {
                    Terminal.printString(String.format("%-30s", arrayList.get(i)[3]));
                }
            }

        } else {
            Terminal.printString("\tNo Record Found");
        }
        Terminal.printString("\n");
    }
}
