package org.librarian;
import org.User.bookStorageClass;
import org.User.userStorageClass;
import org.ValidationsAndOtherOperation.Terminal;
import org.ValidationsAndOtherOperation.TerminalInterFace;
import org.ValidationsAndOtherOperation.Validations;
import java.util.HashMap;

public class BorrowBooks {
    TerminalInterFace console=new Terminal();
    private final String phoneNumber,bookId,name,email;

    public BorrowBooks() {
        phoneNumber= Validations.numberValidation("Enter User's Mobile number: ");//getting the details from the user
        if (Terminal.userObjectTreeMap.containsKey(phoneNumber)){
            name =Terminal.userObjectTreeMap.get(phoneNumber).name;
            email = Terminal.userObjectTreeMap.get(phoneNumber).emailID;
        }else{
             name =Validations.getName("Enter User's Name:","Enter a Valid Name:");
             email = Validations.eMailValidation();
        }
        bookId =Validations.getBookID("Enter the Book id:","Enter the Book id from the above:");
        if (Terminal.stockObjectTreeMap.containsKey(bookId)) {

            if (Integer.parseInt(Terminal.stockObjectTreeMap.get(bookId).quantity) - 1 >= 0) {
                Terminal.stockObjectTreeMap.get(bookId).quantity = Integer.toString(Integer.parseInt(Terminal.stockObjectTreeMap.get(bookId).quantity) - 1);
                addingToUserHash();
            } else {
                if (Terminal.bookObjectTreeMap.containsKey(phoneNumber)) {
                    if (Terminal.bookObjectTreeMap.get(phoneNumber).containsKey(bookId)) {
                        Terminal.printString("You already have this book\n");
                    }
                } else {
                    Terminal.printString("Insufficient Stocks\n");
                }
            }
        }else {
                Terminal.printString("Book Not Found\n");
        }
    }

    private void addingToUserHash() {
        if(!Terminal.userObjectTreeMap.containsKey(phoneNumber)){
            Terminal.userObjectTreeMap.put(phoneNumber,new userStorageClass(phoneNumber,name,email));
        }
        if (Terminal.bookObjectTreeMap.containsKey(phoneNumber)) {
            if (!Terminal.bookObjectTreeMap.get(phoneNumber).containsKey(bookId)) {
                Terminal.bookObjectTreeMap.get(phoneNumber).put(bookId, new bookStorageClass(bookId, console.getBroughtDate(), console.getSubDate()));
                Terminal.printString("Book Borrowed Successfully\n");
            } else {
                Terminal.printString("You already have this book\n");
            }
        } else {

            HashMap<String,bookStorageClass> n=new HashMap<>();
            n.put(bookId, new bookStorageClass(bookId, console.getBroughtDate(), console.getSubDate()));
            Terminal.bookObjectTreeMap.put(phoneNumber,n);
            Terminal.printString("Book Borrowed Successfully\n");
        }
    }
}

