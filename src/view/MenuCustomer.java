package view;


import manager.CustomerManger;
import model.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuCustomer {
   CustomerManger customerManger = new CustomerManger();
    Scanner inputInt = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
     public void menuMainMenu() {
         int choice;
         do {
             System.out.println("===== Menu Khách Hàng ===== ");
             System.out.println("1. Thêm mới khách hàng");
             System.out.println("2. Sửa thông tin khách hàng");
             System.out.println("3. Xóa khách hàng");
             System.out.println("4. Hiển thị tất cả khách hàng");
             System.out.println("5. Hiển thị thông tin khách hàng theo mã");
             System.out.println("6. Tìm kiếm khách hàng theo tên gần đúng");
             System.out.println("0. Thoát chương trình");
             System.out.print("Nhập lựa chọn: ");

             choice = inputInt.nextInt();
             switch (choice) {
                 case 1:
                     showMenuAdd();
                     break;
                 case 2:
                     showAll();
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
                     showMenuFindByName();
                     break;
                 default:
                     System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
                     break;
             }
         } while (choice != 0);
     }
     public void showMenuAdd() {
         System.out.println("===== Đây là menu thêm mới =====");
         System.out.print("Nhập tên khách hàng: ");
         String name = inputString.nextLine();
         System.out.print("Nhập tuổi khách hàng: ");
         int age = inputInt.nextInt();
         inputInt.nextLine();  // Clear the buffer
         System.out.print("Nhập địa chỉ khách hàng: ");
         String address = inputString.nextLine();
         Customer customer = new Customer(name, age, address);
         customerManger.add(customer);
         System.out.println("===== Thêm thành công =====");
     }
     public void showAll() {
         System.out.println("Danh sách khách hàng là: ");
         ArrayList<Customer> listCustomers = customerManger.findAll();
         for (Customer customer : listCustomers) {
             System.out.println(customer);
         }
     }
     public void showMenuRemove() {
         System.out.println("===== Xóa khách hàng ===== ");
         System.out.print("Nhập mã khách hàng: ");
         int idDelete = inputInt.nextInt();
         customerManger.remove(idDelete);
         System.out.println("===== Xóa thành công =====");
     }
     public void showMenuEdit() {
         System.out.println("===== Sửa thông tin khách hàng =====");
         System.out.print("Nhập mã khách hàng muốn sửa: ");
         int idEdit = inputInt.nextInt();
         inputInt.nextLine();  // Clear the buffer
         System.out.print("Nhập tên khách hàng: ");
         String name = inputString.nextLine();
         System.out.print("Nhập tuổi khách hàng: ");
         int age = inputInt.nextInt();
         inputInt.nextLine();  // Clear the buffer
         System.out.print("Nhập địa chỉ khách hàng: ");
         String address = inputString.nextLine();
         Customer newCustomer = new Customer(name, age, address);
         customerManger.update(idEdit, newCustomer);
         System.out.println("===== Sửa thành công =====");
     }
     public void showMenuFindById() {
         System.out.println("===== Hiển thị thông tin khách hàng theo mã =====");
         System.out.print("Nhập mã khách hàng: ");
         int id = inputInt.nextInt();
         Customer customer = customerManger.findById(id);
         if (customer != null) {
             System.out.println(customer);
         } else {
             System.out.println("Không tìm thấy khách hàng với mã: " + id);
         }
     }
    public void showMenuFindByName() {
        System.out.println("===== Tìm kiếm khách hàng theo tên gần đúng =====");
        System.out.print("Nhập tên khách hàng: ");
        String name = inputString.nextLine();
        ArrayList<Customer> customers = customerManger.findByName(name);
        if (!customers.isEmpty()) {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        } else {
            System.out.println("Không tìm thấy khách hàng với tên gần đúng: " + name);
        }
    }
}