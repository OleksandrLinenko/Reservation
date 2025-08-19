/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reservation;

/**
 *
 * @author oleksandrlinenko
 */
public class Ticket {

    private int id;
    private int customerId;
    private Seat seat;
    private int sessionId;

    public Ticket(int id, int customerId, Seat seat, int sessionId) {
        if (id <= 0 || customerId <= 0 || sessionId <= 0) {
            throw new IllegalArgumentException("Illegal argument");
        }
        this.id = id;
        this.customerId = customerId;
        this.seat = seat;
        this.sessionId = sessionId;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Seat getSeat() {
        return seat;
    }

    public int getSessionId() {
        return sessionId;
    }

    @Override
    public String toString() {
        return String.format("%d, %d, %s, %d", id, customerId, seat.getNumber(), sessionId);
    }
}
