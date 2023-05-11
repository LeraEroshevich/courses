public class User<T extends Ticket> {
    private String login;
    private String password;

    User(T ticketTo, T ticketFrom) throws TicketNullException {
        if (ticketTo == null) {
            throw new TicketNullException("Билет не может быть null");
        } else if (ticketFrom == null) {
            throw new TicketNullException("Билет не может быть null");
        }
        System.out.println(ticketTo);
        System.out.println(ticketFrom);
    }
}
