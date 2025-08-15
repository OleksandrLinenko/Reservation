/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reservation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oleksandrlinenko
 */
public class TicketList {

    private List<Ticket> tickets = new ArrayList();

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void reserveTicket(Ticket ticket) {
        for (Ticket tickt : tickets) {
            if (tickt.getDate().equals(ticket.getDate())
                    || tickt.getFilmName().equals(ticket.getFilmName())
                    || tickt.getSeat().getNumber() == ticket.getSeat().getNumber()
                    || tickt.getSeat().getState().equals(State.FREE)) {
                tickt.getSeat().setState(State.OCCUP);
            } else {
                Application.getInstance().getTickets().addTicket(ticket);
            }
        }
    }
}
