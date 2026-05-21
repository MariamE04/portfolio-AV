package designpatterns.command;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl(2);

        remote.setCommand(0, lightOn);
        remote.setCommand(1, lightOff);

        remote.pressButton(0);
        remote.pressButton(1);

        System.out.println("Undo:");

        remote.undoLast();
    }
}


// Der blev tilføjet en metode `undo()` til `Command`-interfacet.

//I `LightOnCommand` blev `undo()` implementeret til at slukke lyset, fordi fortrydelse af at tænde lyset er at slukke det igen.

//I `LightOffCommand` blev `undo()` implementeret til at tænde lyset, fordi fortrydelse af at slukke lyset er at tænde det igen.

//`RemoteControl` blev udvidet med en liste, som gemmer de kommandoer der bliver udført. Derudover blev metoden `undoLast()` lavet, så den seneste kommando kan fortrydes.

//I testen i main blev lyset først tændt, derefter slukket og til sidst fortrudt. Resultatet blev derfor, at lyset blev tændt igen.