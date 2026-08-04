package Day_5;

public class Laptop {

    private String brand;
    private int ram;
    private double price;

    Laptop(String brand, int ram, double price)
    {
        this.brand = brand;
        this.ram = ram;
        this.price = price;
    }
    public static void main(String[] args) {
        Laptop laptop = new Laptop("Dell",128,800000);
        System.out.println("Brand Name - "+laptop.brand);
        System.out.println("Installed RAM - "+laptop.ram);
        System.out.println("Price - "+laptop.price);

    }
}
