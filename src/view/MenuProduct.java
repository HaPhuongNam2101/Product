package view;

import manager.ProductManger;
import model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuProduct {
    ProductManger productManger = new ProductManger();
    Scanner inputInt = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);

    public void showMainMenu() {
        int choice;
        do {
            System.out.println("===== Menu Sản Phẩm  ===== ");
            System.out.println("1. Thêm mới sản phẩm ");
            System.out.println("2. Sửa thông tin sản phẩm ");
            System.out.println("3. Xóa sản phẩm ");
            System.out.println("4. Hiển thị tất cả sản phẩm ");
            System.out.println("5. Hiển thị thông tin sản phẩm theo mã ");
            System.out.println("6. Tìm kiếm sản phẩm theo khoảng giá ");
            System.out.println("7. Tìm kiếm sản phẩm theo tên gần đúng");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");

            choice = inputInt.nextInt();
            switch (choice) {
                case 1:
                    showMenuAdd();
                    break;
                case 2:
                    showMenuEdit();
                    break;
                case 3:
                    showMenuRemove();
                    break;
                case 4:
                    showAll();
                    break;
                case 5:
                    showMenuFindById();
                    break;
                case 6:
                    showMenuFindByPriceRange();
                    break;
                case 7:
                    showMenuFindByName();
                    break;
            }
        } while (choice != 0);
    }

    public void showMenuAdd() {
        System.out.println("===== Đây là menu thêm mới =====");
        System.out.print("Nhập tên sản phẩm: ");
        String name = inputString.nextLine();
        System.out.print("Nhập loại sản phẩm: ");
        String category = inputString.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = inputString.nextDouble();
        inputString.nextLine();
        Product product = new Product(name, category, price);
        productManger.add(product);
        System.out.println("===== Thêm thành công =====");
    }

    public void showAll() {
        System.out.println("Danh sách sản phẩm là: ");
        ArrayList<Product> listProducts = productManger.findAll();
        for (Product product : listProducts) {
            System.out.println(product);
        }
    }

    public void showMenuRemove() {
        System.out.println("===== Xóa sản phẩm ===== ");
        System.out.print("Nhập mã sản phẩm: ");
        int idDelete = inputInt.nextInt();
        productManger.remove(idDelete);
        System.out.println("===== Xóa thành công =====");
    }

    public void showMenuEdit() {
        System.out.println("===== Sửa thông tin sản phẩm =====");
        System.out.print("Nhập mã sản phẩm muốn sửa: ");
        int idEdit = inputInt.nextInt();
        inputInt.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String name = inputString.nextLine();
        System.out.print("Nhập loại sản phẩm: ");
        String category = inputString.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = inputString.nextDouble();
        inputString.nextLine();
        Product newProduct = new Product(idEdit, name, category, price);
        productManger.update(idEdit, newProduct);
        System.out.println("===== Sửa thành công =====");
    }

    public void showMenuFindById() {
        System.out.println("===== Hiển thị thông tin sản phẩm theo mã =====");
        System.out.print("Nhập mã sản phẩm: ");
        int id = inputInt.nextInt();
        Product product = productManger.findById(id);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Không tìm thấy sản phẩm với mã: " + id);
        }
    }
    public void showMenuFindByName() {
        System.out.println("===== Tìm kiếm sản phẩm theo tên gần đúng =====");
        System.out.print("Nhập tên sản phẩm: ");
        String name = inputString.nextLine();
        ArrayList<Product> products = productManger.findByName(name);
        if (!products.isEmpty()) {
            for (Product product : products) {
                System.out.println(product);
            }
        } else {
            System.out.println("Không tìm thấy sản phẩm với tên gần đúng: " + name);
        }
    }
    public void showMenuFindByPriceRange() {
        System.out.println("===== Tìm kiếm sản phẩm theo khoảng giá =====");
        System.out.print("Nhập giá tối thiểu: ");
        double minPrice = inputInt.nextDouble();
        System.out.print("Nhập giá tối đa: ");
        double maxPrice = inputInt.nextDouble();
        ArrayList<Product> products = productManger.findByPriceRange(minPrice, maxPrice);
        if (!products.isEmpty()) {
            for (Product product : products) {
                System.out.println(product);
            }
        } else {
            System.out.println("Không tìm thấy sản phẩm trong khoảng giá: " + minPrice + " - " + maxPrice);
        }
    }
}

