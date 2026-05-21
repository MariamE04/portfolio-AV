package designpatterns.adapter;

public class Main {
    public static void main(String[] args) {
        NewPrinter printer = new PrinterAdapter(new OldPrinter());
        printer.print();
    }
}


// PrinterAdapter gør det muligt at bruge OldPrinter gennem NewPrinter‑interfacet
// ved at oversætte det nye kald print() til det gamle kald printOld().
// Main kender kun NewPrinter og ikke OldPrinter.