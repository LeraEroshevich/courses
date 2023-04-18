public class Task3 {
    public static void main(String[] args) throws Exception {
        TicketTrain trainTicket = new TicketTrain();
        TicketBus busTicket = new TicketBus();
        Ticket ticket = new Ticket();
        User<TicketTrain, Ticket> user1 = new User<>(trainTicket, ticket); // valid
        User<TicketBus, Ticket> user2 = new User<>(busTicket, ticket); // valid
        User<TicketCinema, Ticket> user3 = new User<>(new TicketCinema(), ticket); // compile error
    }
}

