package service;

import bean.Customer;

public class CustomerList {
    private Customer[] customers;
    private int total = 0;

    /**
     * make customer list
     *
     * @param totalCustomer ,list long ,not total
     */
    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    /**
     * add customer in list
     *
     * @param customer
     * @return success or unsuccess
     */
    public boolean addCustomer(Customer customer) {
        if (total >= customers.length) {
            return false;
        }
        customers[total] = customer;
        total++;
        return true;
    }

    /**
     * fix customer at index
     *
     * @param index
     * @param customer
     * @return success or unsuccess
     */
    public boolean replaceCustomer(int index, Customer customer) {
        if (0 > index || index >= total) {
            return false;
        }
        customers[index] = customer;
        return true;
    }

    /**
     * delete customer at index
     *
     * @param index
     * @return
     */
    public boolean deleteCustomer(int index) {
        if (0 > index || index >= total) {
            return false;
        }
        for (int i = index; i < total - 1; i++) {
            customers[i] = customers[i + 1];
        }

        //last one is null
        customers[total - 1] = null;
        total--;
        return true;
    }

    public Customer[] getAllCustomers() {
        Customer[] cuts = new Customer[total];
        for (int i = 0; i < total; i++) {
            cuts[i] = customers[i];
        }
        return cuts;
    }

    public  Customer getCustomer(int index){
        if(index<0 || index>=total){
            return null;
        }
        return customers[index];
    }

    public int getTotal(){
        return total;
    }
}
