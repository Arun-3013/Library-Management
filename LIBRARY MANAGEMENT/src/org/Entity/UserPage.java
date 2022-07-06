package org.Entity;

import org.Stock.Check_PrintStock;
import org.User.PrintReportPage;
import org.ValidationsAndOtherOperation.Terminal;
import org.ValidationsAndOtherOperation.Validations;


public class UserPage {
    private final String userPhoneNumber;
    private void printingOfFile() {
        new PrintReportPage().printing(userPhoneNumber);
    }


    public UserPage(){
        Terminal.printString("----------------------------------USER LOGIN----------------------------------\n");
        userPhoneNumber= Validations.numberValidation("Enter your Mobile number: ");
        if(Terminal.userObjectTreeMap.containsKey(userPhoneNumber)){

            Terminal.printString("\n\tHello "+Terminal.userObjectTreeMap.get(userPhoneNumber).name);
            String temp1;
            do{
                Terminal.printString("\n1.View the Books Taken\n2.Search the Book by their Name/Book ID/Writer Name\n3.Logout\nEnter a number to perform the operations:");
                temp1=Terminal.getTempInt();
                switch (temp1) {
                    case "1" -> printingOfFile();
                    case "2" -> new Check_PrintStock().checkByNameForStudent();
                    case "3" -> Terminal.printString("Thank you\n");
                    default -> Terminal.printString("\tEnter a valid number");
                }
            }while(!temp1.equals("3"));

        }else{

            Terminal.printString("\tYour are not a user.\n");

        }

    }
}
