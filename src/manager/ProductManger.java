package manager;

import model.Product;

import java.util.ArrayList;

public class ProductManger implements IManager<Product> {
    ArrayList<Product> listProducts;

    public ProductManger() {
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void add(Product product) {
        listProducts.add(product);
    }

    @Override
    public void remove(int id) {
        int index = findIndexById(id);
        listProducts.remove(index);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void update(int id, Product product) {
        int index = findIndexById(id);
        listProducts.set(index, product);
    }

    @Override
    public ArrayList<Product> findAll() {
        return listProducts;
    }
}
