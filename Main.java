import java.util.*;

class Product {
    private String name;
    private double price;
    private int quantity;
    private int calories; // Новое свойство

    public Product(String name, double price, int quantity, int calories) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCalories() {
        return calories;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class VendingMachine {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
    }

    public void buyProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                if (product.getQuantity() > 0) {
                    System.out.println("You bought: " + product.getName());
                    product.setQuantity(product.getQuantity() - 1);
                } else {
                    System.out.println("Sorry, " + product.getName() + " is out of stock.");
                }
                return;
            }
        }
        System.out.println("Product not found: " + productName);
    }
}

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        
        Product cola = new Product("Cola", 1.5, 5, 140);
        Product chips = new Product("Chips", 2.0, 3, 220);
        
        // Новый продукт "Chocolate" с добавленным свойством "calories"
        Product chocolate = new Product("Chocolate", 1.8, 4, 250);

        vendingMachine.addProduct(cola);
        vendingMachine.addProduct(chips);
        vendingMachine.addProduct(chocolate);

        vendingMachine.displayProducts();

        System.out.println("\nBuying products:");
        vendingMachine.buyProduct("Cola");
        vendingMachine.buyProduct("Chips");
        vendingMachine.buyProduct("Chocolate");
        vendingMachine.buyProduct("Chocolate");
        vendingMachine.buyProduct("Chocolate");
        vendingMachine.buyProduct("Chocolate");
    }
}
