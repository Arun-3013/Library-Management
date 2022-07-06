package org.librarian;

import org.ValidationsAndOtherOperation.Terminal;
import org.ValidationsAndOtherOperation.Validations;


public class SignUpPage {

    private static String password;

    public SignUpPage() {

        Terminal.printString("\n----------------------------ADMIN----------------------------------------\n");
        Terminal.printString("To Create a Account for Librarian\n ");
        String userName=Validations.getUserName("Enter your Username: ","Enter a valid Username: ");

        if (!Terminal.librarianObjectTreeMap.containsKey(userName)) {

            String name =Validations.getName("Enter your Name: ","Enter a Valid Name: ");
            String phoneNumber = Validations.numberValidation("Enter your Mobile number: ").trim();
            setPassword(getPassword("Enter your password"));
            Terminal.librarianObjectTreeMap.put(userName,new LibrarianStorageClass(userName, name, phoneNumber,password));

        } else {
            Terminal.printString("Already a User\n");
        }
    }

     static String getPassword(String displayLine) {

        Terminal.printString(displayLine);
        password = Validations.passwordValidation();
        String confirmPass = Terminal.scanAndPrint("Confirm Password: ").nextLine().trim();

        while (!password.equals(confirmPass)) {
            confirmPass = Terminal.scanAndPrint("Please enter the Correct Password: ").nextLine().trim();
        }

        return password;
    }

    private void setPassword(String password) {
        SignUpPage.password = password;
    }
}
