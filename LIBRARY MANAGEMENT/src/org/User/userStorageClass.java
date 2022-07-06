package org.User;

import org.ValidationsAndOtherOperation.Terminal;

import java.util.ArrayList;
import java.util.TreeMap;

public class userStorageClass {

    public String name;
    public String phoneNumber;
    public String emailID;
    public userStorageClass(){}

    public userStorageClass(String phoneNumber, String name, String emailID) {

        this.emailID = emailID;
        this.name = name;
        this.phoneNumber = phoneNumber;

    }

    public ArrayList<String[]> getUserArray() {

        ArrayList<String[]> user=new ArrayList<>();
        TreeMap<String, userStorageClass> userObj= Terminal.userObjectTreeMap;
        String[] temp1 ={"PHONE NUMBER","NAME","EMAIL ID"};
        user.add(temp1);

        for (userStorageClass userClass : userObj.values()) {

            String[] temp = {userClass.phoneNumber, userClass.name, userClass.emailID};
            user.add(temp);

        }
        return user;
    }

}