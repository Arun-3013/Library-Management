package org.ValidationsAndOtherOperation;

final public class FineDeduction {

    TerminalInterFace console=new Terminal();
    public String fineDeduction(String broughtDate, String submissionDate) {

        long due=console.calculate(broughtDate,submissionDate);
        if(due<0){
            var fineAmount=Math.abs(due)*5;
            return fineAmount+"\n";
        } else {
            return "NIL\n";
        }
    }
}
