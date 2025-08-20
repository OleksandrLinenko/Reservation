/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands;

import Reservation.Application;
import Reservation.Ticket;
import UI.Ask;
import java.util.Iterator;

/**
 *
 * @author oleksandrlinenko
 */
public class CancleTicketCommand {

    public static CancleTicketCommand create() {
        return new CancleTicketCommand();
    }

    public void handle() throws Exception {
        int idNumber = Ask.create().askInt("Set ticket id number you want cancle: ");
        Ticket ticket = Application.getInstance().getTickets().findTicket(idNumber);
        if (ticket == null) {
            throw new Exception("No ticket with this id number");
        }

        for (Iterator<Ticket> iterator = Application.getInstance().getTickets().getTickets().iterator(); iterator.hasNext();) {
            Ticket tckt = iterator.next();
            if (tckt.getId() == idNumber) {
                iterator.remove();
            }
        }
    }
}
