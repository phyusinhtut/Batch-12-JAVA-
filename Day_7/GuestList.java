import java.util.HashSet;
public class GuestList {
    public static void main(String[] args) {
        HashSet<String> guests = new HashSet<>();
        guests.add("John");
        guests.add("Marry");
        guests.add("David");
        guests.add("Sarah");
        guests.add("Mike");
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

        String removeGuest = "David";
        guests.remove(removeGuest);
        System.out.println(removeGuest + " has been removed");

        System.out.println("\nUpdated Guest List:");
        for (String guest : guests) {
            System.out.println(guest);
        }

        System.out.println("\nTotal guests now: " + guests.size());
    }
}
