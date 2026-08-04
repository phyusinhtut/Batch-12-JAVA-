package Day_5;

public class Counter {

    public int instanceCount = 0;
    public static int globalCount = 0;

    Counter()
    {
        instanceCount++;
        globalCount++;
    }
    public static void main(String[] args) {

        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();

        System.out.println("instanceCount for c3: " + c3.instanceCount);

        System.out.println("globalCount: " + Counter.globalCount);
    }
}
