package org;

import org.librarian.LoginPage;
import org.Entity.Admin_LogIn;
import org.Entity.UserPage;
import org.ValidationsAndOtherOperation.Terminal;


public class Library {

    void student(){
        new UserPage();
    }
    void admin(){
        new Admin_LogIn().adminLogIn();
    }
    void librarian(){
        new LoginPage().display();
    }
    void exit(){
        Terminal.end();
    }

    public static void main(String[] args){

        Library libraryObject=new Library();
        String user;
        while(true){
            Terminal.printString("----------------------WELCOME TO LIBRARY MANAGEMENT----------------------\n");
            Terminal.printString("""
                    1.Admin
                    2.Librarian
                    3.Student
                    4.Exit
                    Choose your Login ( 1-4 ):\s""");
            user= Terminal.getTempInt();
            switch (user) {
                case "1" -> libraryObject.admin();
                case "2" -> libraryObject.librarian();
                case "3" -> libraryObject.student();
                case "4" -> {
                    libraryObject.exit();
                    Terminal.printString("Thank you\n");
                    System.exit(0);
                }
                default -> Terminal.printString("Please Choose the number between 1-4\n");
            }
        }
    }
}
