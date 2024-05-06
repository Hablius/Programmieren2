package ArtWebshop;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Customer> customers = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void purchaseProduct(Customer customer, Product product) {
        if (product.getStock() > 0) {
            product.setStock(product.getStock() - 1);
            transactions.add(new Transaction(customer, product));
            System.out.println("Purchase successful!");
        } else {
            System.out.println("Product out of stock!");
        }
    }

    public void listTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
 
