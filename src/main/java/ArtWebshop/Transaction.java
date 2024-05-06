package ArtWebshop;
import java.time.LocalDateTime;

public class Transaction {
    private Customer customer;
    private Product product;
    private LocalDateTime dateTime;

    public Transaction(Customer customer, Product product) {
        this.customer = customer;
        this.product = product;
        this.dateTime = LocalDateTime.now();
    }

    public Customer getCustomer() { return customer; }
    public Product getProduct() { return product; }
    public LocalDateTime getDateTime() { return dateTime; }

    @Override
    public String toString() {
        return "Transaction{" +
                "customer=" + customer +
                ", product=" + product +
                ", dateTime=" + dateTime +
                '}';
    }
}
