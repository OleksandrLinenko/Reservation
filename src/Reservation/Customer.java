/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reservation;

/**
 *
 * @author oleksandrlinenko
 */
public class Customer {

    private int idNumber;
    private String name;

    public Customer(int id, String name) {
        this.idNumber = id;
        this.name = name;
    }

    public int getIdNumder() {
        return idNumber;
    }

    public String getName() {
        return name;
    }
}
