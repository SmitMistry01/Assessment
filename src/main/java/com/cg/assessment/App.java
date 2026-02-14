package com.cg.assessment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class App 
{
	public static void main(String[] args) {
      
        Booking newBooking = new Booking("John Doe", "Deluxe", "2026-02-20", "2026-02-25");
        Booking newBooking1 = new Booking("Smit Mistry", "Suite", "2026-01-10", "2026-01-12");
        Booking newBooking2= new Booking("Naman Arora", "Deluxe", "2026-02-19", "2026-02-26");

        addBooking(newBooking);
        addBooking(newBooking1);
        addBooking(newBooking2);
        
        updateBooking(1, "Suite");
        updateBooking(3,"Standard");
        
        viewAllBookings();
        
        deleteBooking(3);
        
        HibernateUtil.getSessionFactory().close();
    }

   public static void addBooking(Booking booking) {

    long days = ChronoUnit.DAYS.between(
        LocalDate.parse(booking.getCheckInDate()), 
        LocalDate.parse(booking.getCheckOutDate())
    );

    double pricePerDay = 0;
    switch (booking.getRoomType()) {
        case "Standard":
            pricePerDay = 2000.0;
            break;
        case "Deluxe":
            pricePerDay = 3500.0;
            break;
        case "Suite":
            pricePerDay = 5000.0;
            break;
        default:
            pricePerDay = 0.0;
    }

    
    booking.setTotalAmount(days * pricePerDay);

    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        session.save(booking);
        transaction.commit();
        System.out.println("Booking saved successfully for: " + booking.getCustomerName());
    } catch (Exception e) {
        if (transaction != null) transaction.rollback();
        e.printStackTrace();
    }
}

    public static void viewAllBookings() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Booking> bookings = session.createQuery("from Booking", Booking.class).list();
            System.out.println("\nAll Booking Records");
            for (Booking b : bookings) {
                System.out.println("ID: " + b.getBookingId() + " | Name: " + b.getCustomerName() + 
                                   " | Type: " + b.getRoomType() + " | Total: " + b.getTotalAmount());
            }
        }
    }
    
    public static void updateBooking(int id, String newRoomType) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Booking booking = session.get(Booking.class, id);

            if (booking != null) {
               
                booking.setRoomType(newRoomType);
                
                long days = ChronoUnit.DAYS.between(
                    LocalDate.parse(booking.getCheckInDate()), 
                    LocalDate.parse(booking.getCheckOutDate())
                );
                
                double pricePerDay = 0;
                switch (newRoomType) {
                    case "Standard": pricePerDay = 2000.0; break;
                    case "Deluxe":   pricePerDay = 3500.0; break;
                    case "Suite":     pricePerDay = 5000.0; break;
                }
                booking.setTotalAmount(days * pricePerDay);

                session.update(booking);
                transaction.commit();
                System.out.println("Booking ID " + id + " updated to " + newRoomType);
            } else {
                System.out.println("Booking not found!");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public static void deleteBooking(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Booking booking = session.get(Booking.class, id);
            
            if (booking != null) {
                session.delete(booking);
                transaction.commit();
                System.out.println("Booking ID " + id + " deleted successfully.");
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
