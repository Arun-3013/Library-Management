package org.User;

import org.ValidationsAndOtherOperation.ArrayToFileCreation;
import org.ValidationsAndOtherOperation.Terminal;

import java.io.File;
import java.util.HashMap;
import java.util.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class bookStorageClass {
    public String bookID;
    public String broughtDate;
    public String submissionDate;
    public bookStorageClass(String bookID, String broughtDate, String submissionDate){
        this.bookID=bookID;
        this.broughtDate=broughtDate;
        this.submissionDate=submissionDate;
    }
    public bookStorageClass(){}

    public void writeBookArrayToFile() {
        boolean check;
        TreeMap<String, HashMap<String,bookStorageClass>> bookObj= Terminal.bookObjectTreeMap;
        Set<Map.Entry<String, HashMap<String, bookStorageClass>>> bookTreeMap=bookObj.entrySet();
        for( Map.Entry<String, HashMap<String, bookStorageClass>> entry:bookTreeMap){
            ArrayList<String[]> books=new ArrayList<>();
            Set<Map.Entry<String,bookStorageClass>> temporaryHash=entry.getValue().entrySet();
            check=false;
            for(Map.Entry<String,bookStorageClass> book:temporaryHash){
                check=true;
                String[] tempArray={book.getValue().bookID, book.getValue().broughtDate,book.getValue().submissionDate};
                books.add(tempArray);
            }
            File tempFile=new File(Terminal.getFilePath(entry.getKey()));
            tempFile.delete();
            if(check)
                new ArrayToFileCreation(books,Terminal.getFilePath(entry.getKey()),false);
        }
    }
}

