import java.util.ArrayList;
import java.util.Scanner;

class Student
{
    String name;
    int id;

    Student(String name, int id)
    {
        this.name = name;
        this.id = id;
    }
}

public class StudentInfo {
    public static void main(String[] args) {
        String searchName = "";
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        Student student1 = new Student("Emily",101);
        Student student2 = new Student("Holland",102);
        Student student3 = new Student("John",103);
        Student student4 = new Student("Tom",104);
        Student student5 = new Student("James",105);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        System.out.println("All Students List");
        for(Student s : students)
        {
            System.out.println("ID : " + s.id + " , Name : " + s.name);
        }

        boolean isfound = false;
        while(!isfound)
        {
            System.out.print("\nEnter name to search : ");
            searchName = scanner.nextLine();

            for(Student s : students)
            {
                if(s.name.equalsIgnoreCase(searchName))
                {
                    System.out.println("Found!");
                    System.out.println("ID : "+s.id + ", Name : "+s.name);
                    isfound = true;
                    break;
                }
            }
            if(!isfound)
            {
                System.out.println("Not found! Try again...");
            }
        }

        boolean idFound = false;
        while(!idFound)
       {
           try
           {

               System.out.print("\nEnter ID to remove : ");
               int removeId = Integer.parseInt(scanner.nextLine());
               for(int i=0; i<students.size(); i++)
               {
                   if(students.get(i).id == removeId && students.get(i) != null)
                   {
                       idFound = true;
                       students.remove(i);
                       System.out.println("Student removed!");
                       break;
                   }
               }
               if(!idFound)
               {
                   System.out.println("No ID found! Try again...");
               }
           }
            catch (Exception e)
            {
                System.out.println("Invalid Input! Try again...");;
            }

       }



        System.out.println("\nTotal Students : " + students.size());

        System.out.println("\nUpdated Students List");
        for(Student s : students)
        {
            System.out.println("ID : " + s.id + " , Name " + s.name);
        }



    }

}
