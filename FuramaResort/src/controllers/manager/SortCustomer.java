package controllers.manager;

import models.person.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class SortCustomer implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(o1.getBirthday());
            date2 = new SimpleDateFormat("dd/MM/yyyy").parse(o2.getBirthday());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int a = o1.getFullName().compareTo(o2.getFullName());
        if (a == 0) {
            return date1.compareTo(date2);
        }
        return a;
    }
}
