public class User<T extends Ticket> {
    private String login;
    private String password;

    User(T ticketTo, T ticketFrom) {
        if (ticketTo == null) {
            throw new TicketNullException();
        } else if (ticketFrom == null) {
            throw new TicketNullException();
        }
        System.out.println(ticketTo);
        System.out.println(ticketFrom);
    }
}
