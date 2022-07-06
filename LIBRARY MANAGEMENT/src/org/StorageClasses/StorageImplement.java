package org.StorageClasses;

import org.Stock.stockStorageClass;
import org.User.bookStorageClass;
import org.User.userStorageClass;
import org.ValidationsAndOtherOperation.ReadOperation;
import org.ValidationsAndOtherOperation.Terminal;
import org.librarian.LibrarianStorageClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class StorageImplement extends ReadOperation implements Storage{
    @Override
    public TreeMap<String, LibrarianStorageClass> librarianStore(String adminPath) {

        TreeMap<String, LibrarianStorageClass> adminObj=new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        ArrayList<String []> admin=copyingToString(adminPath);

        for (int i = 1; i < admin.size(); i++) {
            String[] strings = admin.get(i);
            adminObj.put(strings[0], new LibrarianStorageClass(strings[0], strings[1], strings[2], strings[3]));
        }

        return  adminObj;
    }


    @Override
    public TreeMap<String, stockStorageClass> stockStore(String stockPath) {

        TreeMap<String , stockStorageClass> stockObj=new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        ArrayList<String []> stock=copyingToString(stockPath);

        for(int i=1;i<stock.size();i++){
            stockObj.put(stock.get(i)[0],new stockStorageClass(stock.get(i)[0],stock.get(i)[1],stock.get(i)[2],stock.get(i)[3]));
        }

        return  stockObj;
    }


    @Override
    public TreeMap<String, userStorageClass> userStore(String userPath) {

        TreeMap<String, userStorageClass> userObj=new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        ArrayList<String []> user=copyingToString(userPath);

        for (int i = 1; i < user.size(); i++) {
            String[] strings = user.get(i);
            userObj.put(strings[0], new userStorageClass(strings[0], strings[1], strings[2]));
        }

        return  userObj;
    }

    @Override
    public TreeMap<String, HashMap<String, bookStorageClass>> userBooksStore(String tempUSerPath) {

        TreeMap<String, HashMap<String,bookStorageClass>> tempUserObj=new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        ArrayList<String[]> temp=copyingToString(tempUSerPath),temp1;
        String filePath;
        for(int i=1;i<temp.size();i++){
            filePath=Terminal.getFilePath(temp.get(i)[0]);
            temp1=copyingToString(filePath);
            HashMap<String,bookStorageClass> tempArray=new HashMap<>();
            for (String[] strings : temp1) {
                tempArray.put(strings[0], new bookStorageClass(strings[0], strings[1], strings[2]));
            }
            tempUserObj.put(temp.get(i)[0],tempArray);
        }
        return tempUserObj;

    }

}
