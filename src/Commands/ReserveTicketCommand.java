/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands;

import Reservation.Application;
import Reservation.Customer;
import Reservation.Seat;
import Reservation.State;
import Reservation.Ticket;
import UI.Ask;
import UI.ErrorMessage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author oleksandrlinenko
 */
public class ReserveTicketCommand {
    
    public static ReserveTicketCommand create() {
        return new ReserveTicketCommand();
    }
    
    public void handle() throws ParseException {
        try {
            String name = Ask.create().askString("Set name: ");
            Random random = new Random();
            int number = 100000 + random.nextInt(900000);
            Customer customer = new Customer(number, name);
            if (!Application.getInstance().getCustomers().isRegistered(customer)) {
                Application.getInstance().getCustomers().addCustomer(customer);
            }
            
            String film = Ask.create().askString("Set film name: ");
            int seatNumber = Ask.create().askInt("Set seat number: ");
            Seat seat = new Seat(seatNumber, State.OCCUP);
            String dateString = Ask.create().askString("Set date in format dd.MM.yyyy): ");
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date date = sdf.parse(dateString);
            Ticket ticket = new Ticket(number, date, seat, name);
            Application.getInstance().getTickets().reserveTicket(ticket);
        } catch (ParseException ex) {
            ErrorMessage.create().show(ex.getMessage());
        }
    }
}
