import java.util.concurrent.Exchanger;

public class MessageClientService implements Runnable {
    private Exchanger<String> exchanger;

    public MessageClientService(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            String receivedMessage = exchanger.exchange(null);
            String processedMessage = new StringBuilder(receivedMessage).reverse().toString();
            System.out.println("MessageClientService: Processed message: " + processedMessage);
            exchanger.exchange(processedMessage);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}