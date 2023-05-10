import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageClientService implements Runnable {
    private final ConcurrentLinkedQueue<String> queue;

    public MessageClientService(ConcurrentLinkedQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            if (!queue.isEmpty()) {
                String message = queue.poll();
                String formattedMessage = formatMessage(message);
                System.out.println(formattedMessage);
            }
        }
    }

    private String formatMessage(String message) {
        return message.toUpperCase();
    }
}
