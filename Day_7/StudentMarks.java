import java.util.*;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

//        System.out.println("\nOne Student is removed....");
//        studentInfo.remove("Emily");


        boolean isfound = false;
        while(!isfound)
        {
            try
            {
                System.out.print("Enter the name of the student you want to remove : ");
                String searchName = scanner.nextLine();
                String removeName = null;
                for(String s : studentInfo.keySet())
                {
                    if (searchName.equalsIgnoreCase(s))
                    {
                        removeName = s;
                        break;
                    }
                }
                if(removeName != null)
                {
                    studentInfo.remove(removeName);
                    System.out.println(removeName + " is removed");
                    isfound=true;
                }
                else {
                    System.out.println("No Username found! Try again....");
                }
            }
            catch (Exception e)
            {
                System.out.println("Invalid Input! Try again...");
                scanner.nextLine();
            }
        }

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
