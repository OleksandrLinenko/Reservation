/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands;

import Reservation.Application;
import Reservation.Customer;
import Reservation.Film;
import Reservation.Seat;
import Reservation.Session;
import Reservation.Ticket;
import UI.Ask;
import UI.ShowList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 *
 * @author oleksandrlinenko
 */
public class ReserveTicketCommand {

    public static ReserveTicketCommand create() {
        return new ReserveTicketCommand();
    }

    public void handle() throws Exception {
        String name = Ask.create().askString("Set your name: ");
        Customer customer = Application.getInstance().getCustomers().find(name);
        if (customer == null) {
            UUID guid = UUID.randomUUID();
            int id = guid.hashCode();
            customer = new Customer(id, name);
            Application.getInstance().getCustomers().add(customer);
        }

        ShowList.create().showFilms(Application.getInstance().getFilms());
        String filmName = Ask.create().askString("Set film you want buy tickets for: ");
        Film film = Application.getInstance().getFilms().find(filmName);
        if (film == null) {
            throw new Exception("Film not found");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String timeString = Ask.create().askString("Set and date time you want in this fomat yyyy-MM-dd HH:mm: ");
        ShowList.create().showSessions(Application.getInstance().getSessions());
        LocalDateTime time = null;
        try {
            time = LocalDateTime.parse(timeString, formatter);
        } catch (Exception e) {
            throw new Exception("Format error");
        }

        Seat seat = new Seat(Ask.create().askInt("Set seat: "));
        Session session = Application.getInstance().getSessions().find(film, time, seat);
        if (session == null) {
            throw new Exception("No session available for you request");
        }

        if (Application.getInstance().getTickets().isOccup(session, seat)) {
            throw new Exception("Seat reserved already");
        }

        UUID guid = UUID.randomUUID();
        int ticketId = guid.hashCode();
        Ticket ticket = new Ticket(ticketId, customer.getId(), seat, session.getId());
        Application.getInstance().getTickets().getTickets().add(ticket);
    }
}
