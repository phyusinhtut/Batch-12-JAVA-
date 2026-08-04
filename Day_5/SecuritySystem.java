package Day_5;

public class SecuritySystem {

    private String secretCode;
    public final String serialNumber;

    SecuritySystem(String secretCode,String serialNumber)
    {
        this.secretCode = secretCode;
        this.serialNumber = serialNumber;
    }

    public void displaySerial()
    {
        System.out.println("SerialNumber - "+serialNumber);
    }
    public static void main(String[] args) {

        SecuritySystem sys = new SecuritySystem("tomato","to12ma34to56");
//        sys.serialNumber = "New123";
        System.out.println("SecretCode - " + sys.secretCode);
        sys.displaySerial();

    }
}
