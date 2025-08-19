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
    
    public void add(Customer customer) {
        customers.add(customer);
    }
    
    public Customer find(int id) {
        for (Customer cstmr : customers) {
            if (cstmr.getId() == id) {
                return cstmr;
            }
        }
        
        return null;
    }
    
    public Customer find(String name) {
        for (Customer cstmr : customers) {
            if (cstmr.getName().equals(name)) {
                return cstmr;
            }
        }
        
        return null;
    }
}
