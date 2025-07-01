package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TicketBookingSystem {
    public static void main(String[] args) {
        int numberOfBookings = 5;
        int poolSize = 3;

        ExecutorService pool = Executors.newFixedThreadPool(poolSize);

        for (int i = 1; i <= numberOfBookings; i++) {
            pool.execute(new TicketBooking(i));
        }

        pool.shutdown();
    }
}
