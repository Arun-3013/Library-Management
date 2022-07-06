package org.librarian.Report;

import org.User.bookStorageClass;
import org.ValidationsAndOtherOperation.Terminal;
import org.ValidationsAndOtherOperation.TerminalInterFace;

import java.util.ArrayList;

public class BorrowYetToReturnReport extends AllUsersReport {

    ArrayList<String[]> temporaryArray = new ArrayList<>();
    TerminalInterFace console=new Terminal();

    protected void broughtArray() {

        temporaryArray.add(arrayList.get(0));                                         //to store user details if they have brought the Temporary Array

        for (int index = 1; index < arrayList.size(); index++) {
            if(Terminal.bookObjectTreeMap.containsKey(arrayList.get(index)[0])) {
                if (Terminal.bookObjectTreeMap.get(arrayList.get(index)[0]).size() > 0) {
                    temporaryArray.add(arrayList.get(index));
                }
            }
        }
        new PrintReportPage(temporaryArray);
    }

    protected void yetToSubmitArray() {

        temporaryArray.add(arrayList.get(0));
        int countOfDue, iterate;

        for (int index = 1; index < arrayList.size(); index++) {
            if (Terminal.bookObjectTreeMap.containsKey(arrayList.get(index)[0])) {
                countOfDue = 0;

                for(bookStorageClass s:Terminal.bookObjectTreeMap.get(arrayList.get(index)[0]).values()){
                    if(!(console.fineAmount(console.getBroughtDate(), s.submissionDate)).equals("NIL\n"))
                        countOfDue++;
                }
                if(countOfDue!=0) {
                    String[] tempStringArray = new String[arrayList.get(index).length + 2];

                    for (iterate = 0; iterate < arrayList.get(index).length; iterate++)
                        tempStringArray[iterate] = arrayList.get(index)[iterate];

                    tempStringArray[iterate] = Integer.toString(countOfDue);
                    temporaryArray.add(tempStringArray);
                }
            }
        }
        new PrintReportPage(temporaryArray);
    }
}
