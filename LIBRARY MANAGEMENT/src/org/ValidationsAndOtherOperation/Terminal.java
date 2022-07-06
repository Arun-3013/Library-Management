package org.ValidationsAndOtherOperation;

import org.Stock.stockStorageClass;
import org.StorageClasses.*;
import org.User.bookStorageClass;
import org.User.userStorageClass;
import org.librarian.LibrarianStorageClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Terminal implements TerminalInterFace {

    private static final String USER_PATH ="E:\\LIBRARY MANAGEMENT\\files\\user.csv";               //to store user details
    private static final String LIBRARIAN_PATH ="E:\\LIBRARY MANAGEMENT\\files\\librarian.csv";             //to store librarian details
    private static final String STOCK_PATH ="E:\\LIBRARY MANAGEMENT\\files\\Stocks.csv";


    public static TreeMap<String, LibrarianStorageClass> librarianObjectTreeMap;
    public static TreeMap<String, userStorageClass> userObjectTreeMap;
    public static TreeMap<String, stockStorageClass> stockObjectTreeMap;
    public static TreeMap<String, HashMap<String, bookStorageClass>> bookObjectTreeMap;

    public static void end(){
        new ArrayToFileCreation(Terminal.librarianArrayList(), LIBRARIAN_PATH,false);
        new ArrayToFileCreation(Terminal.stockArrayList(), STOCK_PATH,false);
        new ArrayToFileCreation(Terminal.userArrayList(), USER_PATH,false);
        new bookStorageClass().writeBookArrayToFile();
    }

    public static ArrayList<String[]> librarianArrayList(){
        return new LibrarianStorageClass().getLibrarianArray();
    }

    public static ArrayList<String[]> userArrayList(){
        return new userStorageClass().getUserArray();
    }

    public static ArrayList<String[]> stockArrayList(){
        return new stockStorageClass().getStockArray();
    }

    static {
        Storage storageObj =new StorageImplement();
        librarianObjectTreeMap =storageObj.librarianStore(LIBRARIAN_PATH);
        stockObjectTreeMap =storageObj.stockStore(STOCK_PATH);
        userObjectTreeMap =storageObj.userStore(USER_PATH);
        bookObjectTreeMap=storageObj.userBooksStore(USER_PATH);
    }

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void printString(String s) {
        System.out.print(s);
    }

    public static Scanner scanAndPrint(String s) {
        printString(s);
        return getScanner();
    }
    public  String getBroughtDate() {
        Date dNow = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(dNow);
    }

    public String getSubDate() {
        Date dNow = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(dNow);
        c.add(Calendar.DATE, 15);

        return sdf.format(c.getTime());
    }

    public static String getFilePath(String s) {
        return "E:\\LIBRARY MANAGEMENT\\files\\"+s+".csv";    //mostly phoneNumber is passed
    }

    public  long calculate(String startDate,String endDate)  {
        SimpleDateFormat sdfObject = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        Date secondDate = null;
        Date firstDate = null;
        try {
            firstDate = sdfObject.parse(startDate);
            secondDate = sdfObject.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long diff = secondDate.getTime() - firstDate.getTime();
        TimeUnit time = TimeUnit.DAYS;
        return time.convert(diff, TimeUnit.MILLISECONDS);
    }
    public static String getTempInt(){
        String user=Terminal.getScanner().nextLine().trim();
        if(Validations.isNumeric(user)){
            user=Integer.toString(Integer.parseInt(user));
        }
        return user;
    }

    public String fineAmount(String broughtDate, String submissionDate) {
        return new FineDeduction().fineDeduction(broughtDate, submissionDate);
    }

}
