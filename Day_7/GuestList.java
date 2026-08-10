import java.util.HashSet;
import java.util.Scanner;

public class GuestList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> guests = new HashSet<>();
        guests.add("John");
        guests.add("Marry");
        guests.add("David");
        guests.add("Sarah");  // Set --> does not allow duplicates
        guests.add("Mike");   // ignore duplicates
        guests.add("John");
        guests.add("Ali");
        guests.add("Marry");

        System.out.println("All Unique Guests:");
        for (String guest : guests) {
            System.out.println(guest);
        }

        System.out.println("\nTotal unique guests: " + guests.size());

        String searchGuest = "Ali";
        if (guests.contains(searchGuest)) {
            System.out.println(searchGuest + " is on the guest list");
        } else {
            System.out.println(searchGuest + " is NOT on the guest list");
        }

        String removeGuest;
        boolean isfound = false;
        while(!isfound)
        {
            System.out.print("Enter the guest name to remove : ");
            removeGuest = scanner.nextLine();
            if(!guests.contains(removeGuest))
            {
                System.out.println("No guest found! Try again...");
            }
            else {
                guests.remove(removeGuest);
                System.out.println(removeGuest + " has been removed");
                isfound = true;
                break;
            }
        }



        System.out.println("\nUpdated Guest List:");
        for (String guest : guests) {
            System.out.println(guest);
        }

        System.out.println("\nTotal guests now: " + guests.size());
    }
}
