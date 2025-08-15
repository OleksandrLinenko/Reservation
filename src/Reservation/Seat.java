/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reservation;

/**
 *
 * @author oleksandrlinenko
 */
public class Seat {

    private int number;
    private State state;

    public Seat(int number, State state) {
        this.number = number;
        this.state = state;
    }

    public int getNumber() {
        return number;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        String availab = "";
        if (state.equals(State.FREE)) {
            availab = "free";
        } else {
            availab = "reserved";
        }

        return String.format("seat #%d : %s", number, state.getState());
    }
}
