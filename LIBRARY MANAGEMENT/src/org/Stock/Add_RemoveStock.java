package org.Stock;

import org.ValidationsAndOtherOperation.Terminal;
import org.ValidationsAndOtherOperation.Validations;


public class Add_RemoveStock {

    private String quantity;

    private void getQuantity() {

        quantity = Validations.notANull("Enter the Quantity: ","Enter a Valid Number: ");
        while (!Validations.isNumeric(quantity)) {
            quantity = Terminal.scanAndPrint("Enter the Quantity as number: ").nextLine().trim();
        }
        quantity=Integer.toString(Integer.parseInt(quantity));

    }
    protected void addBookStock() {

        String  bookId=Validations.getBookID("Enter the Book id: ","Book ID can a be number or a Alphabet \nEnter a valid Book id: ");                           //getting the details from the user

        if (Terminal.stockObjectTreeMap.containsKey(bookId)){                                                                                                    //checking whether the bookId is an existing user or not

            getQuantity();
            Terminal.stockObjectTreeMap.get(bookId).quantity =addExistingStock(bookId);
            Terminal.printString("The Book have Successfully added in the Stock \nTherefore the Quantity of the Book in the stock is: "+Terminal.stockObjectTreeMap.get(bookId).quantity +"\n");

        } else {

            String bookName = Validations.getBName("Enter the Book name: ","Enter a Valid Book name: ");
            String writerName=Validations.getBName("Enter the Author name: ","Enter a Valid Author name: ");
            getQuantity();
            Terminal.stockObjectTreeMap.put(bookId,new stockStorageClass(bookId,bookName,writerName,quantity));
            Terminal.printString("The Book have Successfully added in the Stock\n");

        }

    }

    private String addExistingStock(String bookId) {

        int prevQuantity=Integer.parseInt(Terminal.stockObjectTreeMap.get(bookId).quantity);
        int newQuantity=Integer.parseInt(quantity);
        return Integer.toString(newQuantity+prevQuantity);

    }
    protected void removeBookStock() {

        new Check_PrintStock().showAllBooks();
        String  bookId=Validations.getBookID("Enter the Book id: ","Book ID can a be number or a Alphabet of at least 3 characters \nEnter a valid Book id: ");

        if (Terminal.stockObjectTreeMap.containsKey(bookId) && Integer.parseInt(Terminal.stockObjectTreeMap.get(bookId).quantity)>=0){

            getQuantity();
            quantity="-"+quantity;

            if(Integer.parseInt(addExistingStock(bookId))>=0) {

                Terminal.stockObjectTreeMap.get(bookId).quantity = addExistingStock(bookId);
                Terminal.printString("\nThe Book in the stock is: " + Terminal.stockObjectTreeMap.get(bookId).quantity + "\n");

            }else{
                Terminal.printString("InSufficient Stocks\nThe Book in the stock is: " + Terminal.stockObjectTreeMap.get(bookId).quantity + "\n");
            }

        }else{

            Terminal.printString("InSufficient Stocks\n");

        }
    }
}

