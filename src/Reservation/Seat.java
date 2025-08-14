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
    private boolean isFree;

    public Seat(int number, boolean isFree) {
        this.number = number;
        this.isFree = isFree;
    }

    public int getNumber() {
        return number;
    }

    public boolean isIsFree() {
        return isFree;
    }

    @Override
    public String toString() {
        String availab = "";
        if (isFree) {
            availab = "free";
        } else {
            availab = "reserved";
        }

        return String.format("seat #%d : %s", number, isFree);
    }
}
