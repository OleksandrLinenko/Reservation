/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reservation;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author oleksandrlinenko
 */
public class Ticket {

    private int idNumber;
    private Date date;
    private Seat seat;
    private String filmName;

    public Ticket(int idNumber, Date date, Seat seat, String filmName) {
        this.idNumber = idNumber;
        this.date = date;
        this.seat = seat;
        this.filmName = filmName;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public Date getDate() {
        return date;
    }

    public Seat getSeat() {
        return seat;
    }

    public String getFilmName() {
        return filmName;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String dateString = formatter.format(date);
        return String.format("%d, %s, %s, %s", idNumber, dateString, seat.toString(), filmName);
    }

}
