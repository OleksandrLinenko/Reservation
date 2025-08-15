/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reservation;

/**
 *
 * @author oleksandrlinenko
 */
public class Application {

    private static Application app = new Application();
    private CustomerList customers = new CustomerList();
    private TicketList tickets = new TicketList();

    private Application() {

    }

    public static Application getInstance() {
        return app;
    }

    public CustomerList getCustomers() {
        return customers;
    }

    public TicketList getTickets() {
        return tickets;
    }
}
