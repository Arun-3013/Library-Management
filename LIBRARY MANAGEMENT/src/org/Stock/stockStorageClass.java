package org.Stock;

import org.ValidationsAndOtherOperation.Terminal;

import java.util.ArrayList;
import java.util.TreeMap;

public class stockStorageClass {
    public String bookId;
    public String bookName;
    public String quantity;
    public String writerName;


    public stockStorageClass(String bookID, String bookName, String writerName, String quantity) {

        this.bookId =bookID ;
        this.bookName = bookName;
        this.writerName = writerName;
        this.quantity = quantity;

    }
    public stockStorageClass(){}
    public ArrayList<String[]> getStockArray() {

        ArrayList<String[]> stock=new ArrayList<>();
        TreeMap<String, stockStorageClass> stockObject= Terminal.stockObjectTreeMap;
        String[] temp1 ={"BOOK ID","BOOK NAME","WRITER NAME","QUANTITY"};
        stock.add(temp1);

        for (stockStorageClass stockClass : stockObject.values()) {
            String[] temp = {stockClass.bookId, stockClass.bookName, stockClass.writerName,stockClass.quantity};
            stock.add(temp);
        }

        return stock;
    }
}

