import java.util.LinkedList;

public class WaitingList {
    public static void main(String[] args) {
        LinkedList<String> waitingQueue = new LinkedList<>();

        waitingQueue.add("John");
        waitingQueue.add("Holland");
        waitingQueue.add("Tom");
        waitingQueue.add("Cherry");
        waitingQueue.add("Marry");

        System.out.println("Persons in waiting list");
        System.out.println();
        for(String wl : waitingQueue)
        {
            System.out.println(wl);
        }
        System.out.println("-------------------------------------");
        System.out.println(waitingQueue.get(0)+ " is served....");
        waitingQueue.poll();

        waitingQueue.add("Bobby");
        System.out.println("-------------------------------------");
        System.out.println("Updated waiting list");
        System.out.println();
        for(String wl : waitingQueue)
        {
            System.out.println(wl);
        }

        System.out.println("-------------------------------------");
        System.out.println("Current waiting persons : " + waitingQueue.size());




    }
}
