package multithreading;

public class TicketBooking implements Runnable {
    private final int bookingId;

    TicketBooking (int bookingId) {
        this.bookingId = bookingId;
    }

    public void bookTicket () {
        System.out.println("Booking " + bookingId + ": Booking received");
    }

    public void processPayment () {
        System.out.println("Booking " + bookingId + ": Payment processed");
    }

    public void confirmTicket () {
        System.out.println("Booking " + bookingId + ": Ticket confirmed");
    }

    @Override
    public void run () {
        bookTicket();
        processPayment();
        confirmTicket();
    }
}
