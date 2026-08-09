import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class StudentMarks {
    public static void main(String[] args) {
        HashMap<String, Integer> studentInfo = new HashMap<>();

        studentInfo.put("Emily", 95);
        studentInfo.put("Tom", 80);
        studentInfo.put("Marry", 86);
        studentInfo.put("Bobby", 75);
        studentInfo.put("James", 100);

        Iterator<String> name = studentInfo.keySet().iterator();
        Iterator<Integer> mark = studentInfo.values().iterator();
        System.out.println("Student List");
        while(name.hasNext() && mark.hasNext()) {
            String studentName = name.next();
            int studentMark = mark.next();
            System.out.println("Name - " + studentName + ", Mark - " + studentMark);
        }


        Collection<Integer> markArr = studentInfo.values();
        int highestMark = Collections.max(markArr);
        System.out.println("\nHighest Mark - " + highestMark);

        System.out.println("\nOne Student is removed....");
        studentInfo.remove("Emily");

        System.out.println("\nUpdated Student List");
        Iterator<String> updatedName = studentInfo.keySet().iterator();
        Iterator<Integer> updatedMark = studentInfo.values().iterator();
        while(updatedName.hasNext() && updatedMark.hasNext()) {
            String studentName = updatedName.next();
            int studentMark = updatedMark.next();
            System.out.println("Name - " + studentName + ", Mark - " + studentMark);
        }




    }
}
