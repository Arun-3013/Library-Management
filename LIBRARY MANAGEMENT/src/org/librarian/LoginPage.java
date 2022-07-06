package org.librarian;

import org.LogInHelper.LogInAbstract;
import org.Entity.LibrarianPage;
import org.ValidationsAndOtherOperation.Terminal;
import org.LogInHelper.LibrarianLogIn;


public class LoginPage{
    private  String userName;
    LogInAbstract librarian_LogIn =new LibrarianLogIn();

    public void display() {

        String check;
        do {
            Terminal.printString("""
                    ----------------------------------LIBRARIAN------------------------------
                    1.Login
                    2.Forget Password
                    3.Back
                    Choose anyone option ( 1-3 ):\s""");
            check = Terminal.getTempInt();
            Terminal.printString("\n");

            switch (check) {
                case "1" -> librarianLogIn();
                case "2" -> forGetPassword();
                case "3" -> Terminal.printString("\tThank you\n");
                default -> Terminal.printString("\tEnter a valid number between (1-3)\n");
            }

        } while (!check.equals("3"));

    }

    private void forGetPassword() {
        userName = librarian_LogIn.getUserName();
        if (Terminal.librarianObjectTreeMap.containsKey(userName)) {

            String number = Terminal.scanAndPrint("Enter your Mobile Number:").nextLine().trim();
            if (number.equals(Terminal.librarianObjectTreeMap.get(userName).phoneNumber)) {
                Terminal.librarianObjectTreeMap.get(userName).setPassword(SignUpPage.getPassword("Enter your New Password:"));
                Terminal.printString("Password Successfully Updated\n");

            } else {
                Terminal.printString("Wrong Phone number\n");
            }

        } else {
            Terminal.printString("No User Found\n");
        }
    }

    private void librarianLogIn()  {
        userName= librarian_LogIn.getUserName();

        if (Terminal.librarianObjectTreeMap.containsKey(userName)) {
            if(Terminal.librarianObjectTreeMap.get(userName).getPassword().equals(librarian_LogIn.getPassword())){
                String librarianName=Terminal.librarianObjectTreeMap.get(userName).name;
                new LibrarianPage(librarianName);
            }

        } else {
            Terminal.printString("USER not Found. Sign in to become a USER\n");
        }
    }
}
