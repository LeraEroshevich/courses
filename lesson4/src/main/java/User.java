public class User<T extends Ticket, S extends Ticket> {
    private T departureTicket;
    private S arrivalTicket;

    public User(T departureTicket, S arrivalTicket) throws Exception {
        if (departureTicket == null || arrivalTicket == null) {
            throw new Exception("Билет не может быть null");
        }
        this.departureTicket = departureTicket;
        this.arrivalTicket = arrivalTicket;
    }
}
