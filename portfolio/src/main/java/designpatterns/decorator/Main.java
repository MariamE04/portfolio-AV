package designpatterns.decorator;

public class Main {
    public static void main(String[] args) {
        Notifier notifier1 =
                new SMSDecorator(new EmailDecorator(new BasicNotifier()));

        Notifier notifier2 =
                new EmailDecorator(new SMSDecorator(new BasicNotifier()));

        System.out.println(".......");
        notifier1.send();
        System.out.println(".......");
        notifier2.send();
    }
}


// Decorator pattern passer til opgaven,
// fordi ekstra funktionalitet kan tilføjes til et objekt uden at ændre den originale klasse.

//`SMSDecorator` pakker en anden `Notifier` ind og tilføjer SMS-funktionalitet efter den originale `send()` metode bliver kaldt.

//Rækkefølgen kan have betydning, fordi decorators bliver udført i den rækkefølge de er pakket ind i.
// Det ændrer rækkefølgen af outputtet.