public class Task2 {
    static void task2() {
        TicketTrain ticket1 = new TicketTrain();
        TicketBus ticket2 = new TicketBus();
        Ticket ticket3 = new Ticket();
        User<TicketTrain> user1 = new User<>(ticket1, ticket1);
        User<Ticket> user2 = new User<>(ticket3, ticket3);
        User<Ticket> user3 = new User<>(ticket1, ticket3);
        User<Ticket> user4 = new User<>(ticket3, ticket1);
        User<TicketBus> user5 = new User<>(ticket2, ticket2);
    }
}