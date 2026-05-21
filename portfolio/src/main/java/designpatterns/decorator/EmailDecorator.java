package designpatterns.decorator;

public class EmailDecorator implements Notifier {

    private Notifier wrappee;

    public EmailDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    public void send() {
        wrappee.send();
        System.out.println("Sending Email");
    }
}