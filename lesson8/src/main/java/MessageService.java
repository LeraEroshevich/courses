import java.util.concurrent.Exchanger;

public class MessageService implements Runnable {
    private Exchanger<String> exchanger;
    private String message;

    public MessageService(Exchanger<String> exchanger, String message) {
        this.message = message;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            String reversedMessage = new StringBuilder(message).reverse().toString();
            System.out.println("MessageService: Reversed message: " + reversedMessage);
            String processedMessage = exchanger.exchange(reversedMessage);
            System.out.println("MessageService: Reversed message: " + processedMessage);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}