package controllers.manager;

import models.person.Customer;

import java.util.ArrayDeque;
import java.util.Queue;

public class CinemaManager {
    private static Queue<Customer> myQueue;

    public CinemaManager() {
        myQueue= new ArrayDeque<>();
    }

    public void addCustomer(Customer customer){
        myQueue.add(customer);
    }

    public void showCustomerCinema(){
        for (Customer customer: myQueue){
            System.out.println(customer.getFullName()+" IdCard:"+customer.getIdCard()+" bought a ticket");
        }
    }
}
