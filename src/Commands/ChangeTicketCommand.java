/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commands;

import Reservation.Application;
import Reservation.Ticket;
import UI.Ask;
import UI.ErrorMessage;
import UI.Message;

/**
 *
 * @author oleksandrlinenko
 */
public class ChangeTicketCommand {

    public static ChangeTicketCommand create() {
        return new ChangeTicketCommand();
    }

    public void handle() throws Exception {
        int idNumber = Ask.create().askInt("Set ticket id number you want change: ");
        Ticket ticket = Application.getInstance().getTickets().findTicket(idNumber);
        if (ticket == null) {
            throw new Exception("No ticket with this id number");
        }

        Message.create().show("1 for film changing");
        Message.create().show("2 for time changing");
        Message.create().show("3 for seat changing");
        int option = Ask.create().askInt("Pick the option: ");

        switch (option) {
            case 1:
                changeFilm();
                break;
            case 2:
                changeTime();
                break;
            case 3:
                changeSeat();
                break;
            default:
                ErrorMessage.create().show("Undefined option");
        }
    }

    public static void changeFilm() {

    }

    public static void changeTime() {

    }

    public static void changeSeat() {

    }
}
