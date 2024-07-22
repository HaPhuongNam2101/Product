package model;

public class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private static int idIncrement = 1;
    public Product( String name, String category, double price) {
        this.id = idIncrement;
        this.name = name;
        this.category = category;
        this.price = price;
        idIncrement++;
    }
    public Product( int id ,String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static int getIdIncrement() {
        return idIncrement;
    }

    public static void setIdIncrement(int idIncrement) {
        Product.idIncrement = idIncrement;
    }

    @Override
    public String toString() {
        return "Mã sản phẩm: " + id + " | Tên sản phẩm: " + name + " | Loại sản phẩm: " + category + " | Giá sản phẩm: " + price;
    }
}
