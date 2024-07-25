import view.MenuCustomer;
import view.MenuProduct;
public class Main {
    public static void main(String[] args) {
        MenuProduct menu = new MenuProduct();
        menu.showMainMenu();
        MenuCustomer customer = new MenuCustomer();
        customer.menuMainMenu();

    }
}
