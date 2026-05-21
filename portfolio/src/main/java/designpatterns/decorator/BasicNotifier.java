package designpatterns.decorator;

public class BasicNotifier implements Notifier {

    public void send() {
        System.out.println("Base notification");
    }
}