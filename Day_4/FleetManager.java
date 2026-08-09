class Vehicle
{
    private String Country;
    private int year;
    public static int counter;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    Vehicle(String Country, int year)
    {
        this.Country = Country;
        this.year = year;
    }

    public void startEngine()
    {
        System.out.println("Engine is starting...");
    }
    public void drive()
    {
        System.out.println("Your vehicle is driving...");
    }
    public void displayInfo()
    {
        System.out.println("Country - " + Country);
        System.out.println("Year - " + year);
        counter++;
    }
}

class Car extends Vehicle
{

    Car() {
        super("USA", 2018);
    }

    @Override
    public void startEngine()
    {
        System.out.println("Your car's engine is starting...");
    }

    @Override
    public void drive()
    {
        System.out.println("Your car is driving...");
    }

}

class Motorcycle extends Vehicle
{

    Motorcycle() {
        super("Thailand", 2006);
    }

    @Override
    public void startEngine()
    {
        System.out.println("Your motorcycle's engine is starting...");
    }

    @Override
    public void drive()
    {
        System.out.println("Your motorcycle is driving...");
    }

}
public class FleetManager {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Car();
        Vehicle vehicle2 = new Motorcycle();

        Vehicle[] vehicles = new Vehicle[2];
        vehicles[0] = vehicle1;
        vehicles[1] = vehicle2;

        for(int i = 0 ; i<vehicles.length ; i++)
        {
            vehicles[i].displayInfo();
            vehicles[i].startEngine();
            vehicles[i].drive();
            System.out.println("Vehicle count - " + Vehicle.counter);
            System.out.println();
        }

    }
}
