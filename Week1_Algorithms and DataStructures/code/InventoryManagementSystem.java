import java.util.HashMap;
import java.util.Scanner;

public class InventoryManagementSystem {

    static class Product {
        private int productId;
        private String productName;
        private int quantity;
        private double price;

        public Product(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        public int getProductId() { return productId; }
        public String getProductName() { return productName; }
        public int getQuantity() { return quantity; }
        public double getPrice() { return price; }

        public void setProductName(String productName) { this.productName = productName; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
        public void setPrice(double price) { this.price = price; }

        @Override
        public String toString() {
            return "ProductID: " + productId + ", Name: " + productName +
                   ", Quantity: " + quantity + ", Price: $" + price;
        }
    }

    private HashMap<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
        System.out.println("Product added: " + product);
    }

    public void updateProduct(int productId, String name, int quantity, double price) {
        if (products.containsKey(productId)) {
            Product product = products.get(productId);
            product.setProductName(name);
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println(" Product updated: " + product);
        } else {
            System.out.println("Product not found with ID: " + productId);
        }
    }

    public void deleteProduct(int productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
            System.out.println("Product with ID " + productId + " deleted.");
        } else {
            System.out.println(" Product not found.");
        }
    }

    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        for (Product p : products.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display All Products");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    ims.addProduct(new Product(id, name, qty, price));
                    break;

                case 2:
                    System.out.print("Enter Product ID to update: ");
                    int uid = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String uname = scanner.nextLine();
                    System.out.print("Enter New Quantity: ");
                    int uqty = scanner.nextInt();
                    System.out.print("Enter New Price: ");
                    double uprice = scanner.nextDouble();
                    ims.updateProduct(uid, uname, uqty, uprice);
                    break;

                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    int did = scanner.nextInt();
                    ims.deleteProduct(did);
                    break;

                case 4:
                    ims.displayAllProducts();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
