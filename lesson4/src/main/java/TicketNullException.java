public class TicketNullException extends RuntimeException {
    public TicketNullException() {
        super("Билет не может быть null");
    }
}