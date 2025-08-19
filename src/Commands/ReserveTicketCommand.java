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
import java.util.concurrent.ThreadLocalRandom;

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
        Customer customer = null;
        for (Customer cstmr : Application.getInstance().getCustomers().getCustomers()) {
            if (cstmr.getName().equals(name)) {
                customer = cstmr;
            }
        }
        if (customer == null) {
            int id = ThreadLocalRandom.current().nextInt(100000, 1_000_000);
            customer = new Customer(id, name);
            Application.getInstance().getCustomers().add(customer);

        }
        ShowList.create().showFilms(Application.getInstance().getFilms());
        String filmName = Ask.create().askString("Set film you want buy tickets for: ");
        Film film = null;
        for (Film film1 : Application.getInstance().getFilms().getFilms()) {
            if (film1.getName().equals(filmName)) {
                film = film1;
                break;
            }
        }
        if (film == null) {
            throw new Exception("Film not found");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String timeString = Ask.create().askString("Set and date time you want in this fomat yyyy-MM-dd HH:mm: ");
        LocalDateTime time = null;
        try {
            time = LocalDateTime.parse(timeString, formatter);
        } catch (Exception e) {
            throw new Exception("Format error");
        }

        Seat seat = new Seat(Ask.create().askInt("Set seat: "));
        Session session = null;
        for (Session ses : Application.getInstance().getSessions().getSessions()) {
            if (ses.getFilmId() == film.getId() && seat.getNumber() <= ses.getMaxSeats() && ses.getTime().equals(time)) {
                session = ses;
            }
        }
        if (session == null) {
            throw new Exception("No session available for you request");
        }

        boolean occupied = false;
        for (Ticket ticket : Application.getInstance().getTickets().getTickets()) {
            if (ticket.getSessionId() == session.getId() && ticket.getSeat().getNumber() == seat.getNumber()) {
                occupied = true;
                break;
            }
        }
        if (occupied) {
            throw new Exception("Seat reserved already");
        }

        int ticketId = ThreadLocalRandom.current().nextInt(100000, 1_000_000);
        Ticket ticket = new Ticket(ticketId, customer.getId(), seat, session.getId());
        Application.getInstance().getTickets().getTickets().add(ticket);
    }
}
