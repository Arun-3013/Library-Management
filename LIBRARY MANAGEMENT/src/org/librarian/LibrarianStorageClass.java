package org.librarian;

import org.ValidationsAndOtherOperation.Terminal;

import java.util.ArrayList;
import java.util.TreeMap;

public class LibrarianStorageClass {
    public String userName;
    public String name;
    public String phoneNumber;
    private String password;

    public String getPassword() {
        return password;
    }

    protected void setPassword(String Pass){
        this.password=Pass;
    }

    public LibrarianStorageClass(String userName, String name, String phoneNumber, String passWord){

        this.userName=userName;
        this.password =passWord;
        this.name=name;
        this.phoneNumber=phoneNumber;

    }

    public LibrarianStorageClass(){}

    public ArrayList<String[]> getLibrarianArray() {

        ArrayList<String[]> admin=new ArrayList<>();
        TreeMap<String, LibrarianStorageClass> adminObj= Terminal.librarianObjectTreeMap;
        String[] temp1 ={"USERNAME","NAME","PHONE NUMBER","PASSWORD"};
        admin.add(temp1);

        for (LibrarianStorageClass librarianClass : adminObj.values()) {
            String[] temp = {librarianClass.userName, librarianClass.name, librarianClass.phoneNumber, librarianClass.password};
            admin.add(temp);
        }

        return admin;
    }

}
