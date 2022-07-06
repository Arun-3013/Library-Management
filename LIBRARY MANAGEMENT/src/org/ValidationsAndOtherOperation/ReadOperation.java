package org.ValidationsAndOtherOperation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadOperation {
    /***
     *Reading the data from the file and returning as an Arraylist of String list (2D Array).
     *It is a parent class for PrintReport(Student), ReportGenerate(librarian), CheckFile(both student and librarian)
     */
    public ArrayList copyingToString(String filepath) {

        File filename = new File(filepath);
        var arrayList = new ArrayList(new ArrayList());

        String line;

        try {
            BufferedReader input = new BufferedReader(new FileReader(filename));
            while ((line = input.readLine()) != null) {
                arrayList.add(line.split(","));
            }
            input.close();
        } catch (Exception e) {
            //System.out.println("ERROR");
        }
        return arrayList;
    }

}
