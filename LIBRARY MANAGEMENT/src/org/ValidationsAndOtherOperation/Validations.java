package org.ValidationsAndOtherOperation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
    public static String numberValidation(String print) {

        String number = Terminal.scanAndPrint(print).nextLine().trim();
        Pattern pattern = Pattern.compile("(0|91)?[7-9][0-9]{9}");
        Matcher matcher = pattern.matcher(number);
        boolean value = (matcher.find() && matcher.group().equals(number));
        while (!isNumeric(number) || !value) {
            number = Terminal.scanAndPrint("Please Enter your Mobile number: ").nextLine().trim();
            matcher = pattern.matcher(number);
            value = (matcher.find() && matcher.group().equals(number));
        }
        return number;

    }

    public static String eMailValidation() {

        String eMail = Terminal.scanAndPrint("Enter your Email ID:").nextLine().trim();
        String regex = "^[a-zA-Z][a-zA-Z0-9_-]*@[a-zA-Z]+[.][A-Za-z]{2,}([.][A-Za-z]{2,})?$"; //"^[a-zA-Z0-9._-]+@[a-zA-Z-]+[.][A-Za-z]{2,}([.][A-Za-z]{2,})?$"
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(eMail);

        while (!matcher.matches()) {
            eMail = Terminal.scanAndPrint("Please Enter a valid Email ID:").nextLine().trim();
            matcher = pattern.matcher(eMail);
        }

        return eMail;
    }

    public static String passwordValidation() {


        String password = Terminal.scanAndPrint("""   
                   (Your password should contain at-least one number,UPPER case ,lower case alphabet and [@#$%^&+=].
                   The length should be at-least 8 characters.)
                   """).nextLine().trim();

        // Should contain at-least one number,UPPER case ,lower case alphabet and special character.
        // The length should be at-least 8 characters.

        String regex = "^(?=.*[0-9])+(?=.*[a-z])(?=.*[A-Z])+(?=.*[@#$%^&+=])+(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        while (!matcher.matches()) {
            password = Terminal.scanAndPrint("Please Enter a valid Password :").nextLine().trim();
            matcher = pattern.matcher(password);
        }

        return password;
    }

    public static String notANull(String display1, String display2) {
        String userName = Terminal.scanAndPrint(display1).nextLine().trim();
        while (userName.equals(""))
            userName = Terminal.scanAndPrint(display2).nextLine().trim();
        return userName;
    }
    public static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    public static String getBookID(String display1,String display2) {
        String bookID = Terminal.scanAndPrint(display1).nextLine().trim();
        while(!bookID.matches("([0-9A-Za-z]+){3,}"))
            bookID=Terminal.scanAndPrint(display2).nextLine().trim();
        if(isNumeric(bookID))
            bookID=Integer.toString(Integer.parseInt(bookID));
        return bookID;
    }
    public static String getName(String display1,String display2) {
        String name = Terminal.scanAndPrint(display1).nextLine().trim();
        while( !name.matches("^[A-Za-z]{3,}+([\\sA-Za-z0-9]+)?"))
            name = Terminal.scanAndPrint(display2).nextLine().trim();
        return name;
    }
    public static String getBName(String display1, String display2) {
        String name = Terminal.scanAndPrint(display1).nextLine().trim();
        while( name.equals("") || name.contains(","))
            name = Terminal.scanAndPrint(display2).nextLine().trim();
        return name;
    }
    public static String getUserName(String display1,String display2){
        String userName = Terminal.scanAndPrint(display1).nextLine().trim();
        while (!userName.matches("([A-Za-z0-9]+){4,}"))
            userName = Terminal.scanAndPrint(display2).nextLine().trim();
        return userName;
    }
}
