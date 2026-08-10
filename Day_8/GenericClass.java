import java.util.ArrayList;

class Printer<T> {
    ArrayList<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public void printAll() {
        System.out.println( "Printing Array...");
        for (int i = 0; i < items.size(); i++) {
            System.out.print(items.get(i).toString() + " , ");
        }
        System.out.println();
    }

}

public class GenericClass {
    public static void main(String[] args) {
        Printer<Integer> intArr = new Printer<>();
        intArr.add(10);
        intArr.add(20);
        intArr.add(30);
        intArr.printAll();

        Printer<Double> doubleArr = new Printer<>();
        doubleArr.add(1.1);
        doubleArr.add(2.5);
        doubleArr.add(4.6);
        doubleArr.printAll();

    }
}
