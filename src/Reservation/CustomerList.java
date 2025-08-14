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
public class CustomerList {

    private List<Customer> customers = new ArrayList();

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    
    public boolean isRegistered(Customer customer) {
        for(Customer cstmr : customers) {
            if(cstmr.getIdNumder() != customer.getIdNumder()) {
                customers.add(customer);
                return false;
            }
        }
        
        return true;
    }
}
