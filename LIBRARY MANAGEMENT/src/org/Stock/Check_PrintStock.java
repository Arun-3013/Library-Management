package org.Stock;

import org.ValidationsAndOtherOperation.Terminal;
import org.ValidationsAndOtherOperation.Validations;

import java.util.ArrayList;
import java.util.TreeMap;

public class Check_PrintStock {
    TreeMap<String, stockStorageClass> stocksHash= Terminal.stockObjectTreeMap;

    protected void showAllBooks() {
        displayBookDetails("","");
    }

    private void displayBookDetails(String name,String validate){

        ArrayList<String[]> temporary=new ArrayList<>();

        for (stockStorageClass i : stocksHash.values()) {

            if(i.writerName.toLowerCase().contains(name.toLowerCase()) || i.bookName.toLowerCase().contains(name.toLowerCase()) || (Validations.isNumeric(name) && i.bookId.toLowerCase().contains(Integer.toString(Integer.parseInt(name.toLowerCase()))))) {
                String[] data= {i.bookId, i.bookName, i.writerName, i.quantity};
                temporary.add(data);
            }

        }
        if(temporary.size()>0){                                                                                                     //if the stock contains the required search element

            Terminal.printString("Books in the library\n");
            int index1=1,index2=1;

            if(validate.equals(""))
                Terminal.printString(String.format("\n%-10s%-30s%-30s%-30s%-30s\n", "SNo", "Book ID", "Book Name", "Author Name", "Quantity"));
            else
                Terminal.printString(String.format("\n%-10s%-30s%-30s%-30s%-30s\n", "SNo", "Book ID", "Book Name", "Author Name","Status"));

            for(String[] strings:temporary) {

                if (validate.equals("")) {
                    Terminal.printString(String.format("%-10s%-30s%-30s%-30s%-30s\n", index1, strings[0], strings[1], strings[2], strings[3]));
                    index1++;
                } else {
                    if (!strings[3].equals("0")) {
                        Terminal.printString(String.format("%-10s%-30s%-30s%-30s%-30s\n", index2, strings[0], strings[1], strings[2],"Available Right Now"));
                    } else {
                        Terminal.printString(String.format("%-10s%-30s%-30s%-30s%-30s\n", index1, strings[0], strings[1], strings[2], "No Available in the Stock Right Now"));
                    }
                    index2++;
                }
            }
            Terminal.printString("\n");
        }else{
            Terminal.printString("No Books Found\n");
        }

    }
    protected void checkByName(){
        String name = Validations.getBName("Enter the Book Name or Writer Name or Book ID: ", "Enter a Valid Book Name or Writer Name or Book ID: ");
        displayBookDetails(name,"");
    }
    public void checkByNameForStudent(){
        String name = Validations.notANull("Enter the Book Name or Writer Name or Book ID: ", "Enter a Valid Book Name or Writer Name or Book ID: ");
        displayBookDetails(name,"Student");
    }
}

