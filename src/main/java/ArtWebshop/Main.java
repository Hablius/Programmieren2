package ArtWebshop;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\nAvailable actions:\n1. Add Customer\n2. Add Product\n3. Purchase Product\n4. List Transactions\n5. Exit");
            System.out.print("Select an action: ");
            int action = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (action) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer email: ");
                    String email = scanner.nextLine();
                    shop.addCustomer(new Customer(name, email));
                    System.out.println("Customer added successfully!");
                    break;
                case 2:
                    System.out.print("Enter product title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product description: ");
                    scanner.nextLine(); // consume the remaining newline
                    String description = scanner.nextLine();
                    System.out.print("Enter product stock quantity: ");
                    int stock = scanner.nextInt();
                    System.out.print("Enter artist name: ");
                    scanner.nextLine(); // consume the remaining newline
                    String artist = scanner.nextLine();
                    System.out.print("Enter year of creation: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter medium used: ");
                    scanner.nextLine(); // consume the remaining newline
                    String medium = scanner.nextLine();
                    System.out.print("Enter artistic style: ");
                    String style = scanner.nextLine();
                    shop.addProduct(new Product(title, price, description, stock, artist, year, medium, style));
                    System.out.println("Product added successfully!");
                    break;
                case 3:
                    System.out.print("Enter customer index (0-" + (shop.getCustomers().size() - 1) + "): ");
                    int customerIndex = scanner.nextInt();
                    System.out.print("Enter product index (0-" + (shop.getProducts().size() - 1) + "): ");
                    int productIndex = scanner.nextInt();
                    shop.purchaseProduct(shop.getCustomers().get(customerIndex), shop.getProducts().get(productIndex));
                    break;
                case 4:
                    System.out.println("Listing all transactions:");
                    shop.listTransactions();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
