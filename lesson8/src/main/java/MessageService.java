import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageService implements Runnable {
    private final ConcurrentLinkedQueue<String> queue;

    public MessageService(ConcurrentLinkedQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            String message = generateMessage();
            String formattedMessage = formatMessage(message);
            System.out.println(formattedMessage);
            queue.add(formattedMessage);
        }
    }

    private String generateMessage() {
        return "Hello, World!";
    }

    private String formatMessage(String message) {
        return new StringBuilder(message).reverse().toString();
    }
}