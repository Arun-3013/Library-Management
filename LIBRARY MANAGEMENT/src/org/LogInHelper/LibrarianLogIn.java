package org.LogInHelper;
import org.ValidationsAndOtherOperation.Terminal;
import org.ValidationsAndOtherOperation.Validations;

public class LibrarianLogIn extends LogInAbstract{

    private String userName,password;

    public String getUserName() {

        userName= Validations.getUserName("Enter your username:","Enter a Valid username:");
        return userName;
    }

    public String getPassword() {

        password = Terminal.scanAndPrint("Enter Librarian's password:").nextLine().trim();
        int count = 1;

        while (checkPass() && count < 3) {
            password = Terminal.scanAndPrint("Enter the right password:").nextLine().trim();
            count++;
        }

        if (count == 3 && checkPass())  {
            Terminal.printString("Use the Forget Password option\n ");
        }

        return password;
    }

    private boolean checkPass() {
        return !Terminal.librarianObjectTreeMap.get(userName).getPassword().equals(password);
    }
}
