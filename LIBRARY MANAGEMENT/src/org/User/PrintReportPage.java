package org.User;

import org.ValidationsAndOtherOperation.Terminal;
import org.ValidationsAndOtherOperation.TerminalInterFace;

import java.util.HashMap;

public class PrintReportPage {


         public void printing(String phoneNumber){
             TerminalInterFace console=new Terminal();
             HashMap<String, bookStorageClass> tempHash=Terminal.bookObjectTreeMap.get(phoneNumber);
             if(tempHash.size()>0) {
                 Terminal.printString(String.format("\n%-10s%-20s%-20s%-20s%-20s%-20s\n", "SNo", "BookId", "BROUGHT DATE", "Submission Date", "Time Left", "Fine Amount"));
                 int i = 1;
                 for (bookStorageClass book : tempHash.values()) {
                     Terminal.printString(String.format("\n%-10s%-20s%-20s%-20s%-20s%-20s", i, book.bookID, book.broughtDate, book.submissionDate, console.calculate(console.getBroughtDate(), book.submissionDate), console.fineAmount(console.getBroughtDate(), book.submissionDate)));
                     i += 1;
                 }
                 Terminal.printString("\n");
             }else{
                 Terminal.printString("\tNo Books have Taken\n");
             }
         }
}



