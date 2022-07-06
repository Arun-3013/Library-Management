package org.ValidationsAndOtherOperation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;

public class ArrayToFileCreation {
    public ArrayToFileCreation(ArrayList<String[]> arrayList,String path,boolean flag){

        File filename = new File(path);
        try {

            Writer op = new BufferedWriter(new FileWriter(filename,flag));
            for (String[] strings : arrayList) {
                String data = "";

                for (int j = 0; j < strings.length - 1; j++)
                    data += strings[j] + ",";

                data += strings[strings.length - 1];
                op.write(data + "\n");
            }
            op.flush();
            op.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
