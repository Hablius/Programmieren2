package ArtWebshop;

public class Product {
    private String title;
    private double price;
    private String description;
    private int stock;
    private String artist;
    private int year;
    private String medium;
    private String style;

    public Product(String title, double price, String description, int stock, String artist, int year, String medium, String style) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.artist = artist;
        this.year = year;
        this.medium = medium;
        this.style = style;
    }

    public String getTitle() {
        return title;
    }
    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getMedium() {
        return medium;
    }
    public void setMedium(String medium) {
        this.medium = medium;
    }
    public String getStyle() {
        return style;
    }
    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", artist='" + artist + '\'' +
                ", year=" + year +
                ", medium='" + medium + '\'' +
                ", style='" + style + '\'' +
                '}';
    }
}


