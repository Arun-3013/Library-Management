package org.Entity;

import org.LogInHelper.AdminLogIn;
import org.LogInHelper.LogInAbstract;
import org.librarian.SignUpPage;
import org.ValidationsAndOtherOperation.Terminal;

public class Admin_LogIn {
    public void adminLogIn() {

        Terminal.printString("\n----------------------------ADMIN----------------------------------------\n");
        LogInAbstract adminLogIn =new AdminLogIn();
        String userName = Terminal.scanAndPrint("Enter Adminer's UserName:").nextLine().trim();

        if (userName.equalsIgnoreCase(adminLogIn.getUserName())) {

            String password = Terminal.scanAndPrint("Enter Adminer's Password:").nextLine().trim();
            if (password.equals(adminLogIn.getPassword())) {
                new SignUpPage();
            }else{
                Terminal.printString("Invalid Password\n");
            }

        } else {
            Terminal.printString("Invalid UserName\n");
        }
    }
}
