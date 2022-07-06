package org.librarian;

import org.User.PrintReportPage;
import org.ValidationsAndOtherOperation.Terminal;
import org.ValidationsAndOtherOperation.TerminalInterFace;
import org.ValidationsAndOtherOperation.Validations;

public class ReturnBooks {
    TerminalInterFace console=new Terminal();

    private String phoneNumber, bookId;
    public ReturnBooks() {

        if (Terminal.bookObjectTreeMap.size() != 1) {

            phoneNumber = Validations.numberValidation("Enter user's Mobile number: ");

            if (Terminal.userObjectTreeMap.containsKey(phoneNumber)) {                                                  //checking where the entered number is an existing user or not

                if(Terminal.bookObjectTreeMap.get(phoneNumber).size()>0){
                    Terminal.printString("Brought Books:\n");

                    new PrintReportPage().printing(phoneNumber);                                                               //to show the particular member details

                    bookId = Validations.getBookID("Enter the Book id: ","Enter the Book id from the above: ");
                    while(!Terminal.bookObjectTreeMap.get(phoneNumber).containsKey(bookId)) {
                        bookId = Validations.getBookID("Please Enter the above Book ID: ", "Enter the Book id from the above: ");
                    }
                    deleteEntry();
                    Terminal.printString("Book Returned Successfully\n");
                    Terminal.stockObjectTreeMap.get(bookId).quantity = Integer.toString(Integer.parseInt(Terminal.stockObjectTreeMap.get(bookId).quantity) +1);


                } else {
                    Terminal.printString("\t\tNo Book Found\n");
                }

            } else {
                Terminal.printString("\t\tTake a book to become a user\n");
            }

        }else{
            Terminal.printString("\t\tNo Record Found\n"); //if no person have registered in the library
        }

    }

    private void deleteEntry() {
        if(Terminal.bookObjectTreeMap.get(phoneNumber).containsKey(bookId)){
            String amt=console.fineAmount(console.getBroughtDate(), Terminal.bookObjectTreeMap.get(phoneNumber).get(bookId).submissionDate);
            Terminal.printString("Fine to be paid:" + amt + "\n");
            Terminal.bookObjectTreeMap.get(phoneNumber).remove(bookId);
        }else{
            Terminal.printString("\tBook not found Thank you \n" );
        }
    }
}
