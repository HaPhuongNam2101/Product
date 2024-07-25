package manager;

import model.Customer;

import java.util.ArrayList;

public class CustomerManger implements IManager<Customer> {
    ArrayList<Customer> listCustomers;

    public CustomerManger() {
        this.listCustomers = new ArrayList<>();
    }

    @Override
    public void add(Customer customer) {
        listCustomers.add(customer);
    }

    @Override
    public void remove(int id) {
        int index = findIndexById(id);
        if (index != -1) {
            listCustomers.remove(index);
        }
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < listCustomers.size(); i++) {
            if (listCustomers.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void update(int id, Customer customer) {
        int index = findIndexById(id);
        if (index != -1) {
            listCustomers.set(index, customer);
        }
    }

    @Override
    public ArrayList<Customer> findAll() {
        return listCustomers;
    }

    @Override
    public Customer findById(int id) {
        int index = findIndexById(id);
        if (index != -1) {
            return listCustomers.get(index);
        }
        return null;
    }

    @Override
    public ArrayList<Customer> findByName(String name) {
        ArrayList<Customer> result = new ArrayList<>();
        for (Customer customer : listCustomers) {
            if (customer.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(customer);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Customer> findByPriceRange(double minPrice, double maxPrice) {
        return null;
    }
}
