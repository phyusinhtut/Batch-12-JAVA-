import java.util.Scanner;
public class Grade {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int avgGrade;
        System.out.println("Enter your marks (0 to 100)");

        System.out.print("Myanmar : ");
        int myan = scanner.nextInt();

        System.out.print("English : ");
        int eng = scanner.nextInt();

        System.out.print("Mathematics : ");
        int math = scanner.nextInt();

        System.out.print("Physics : ");
        int phy = scanner.nextInt();

        System.out.print("Chemistry : ");
        int chem = scanner.nextInt();

        avgGrade = (myan + eng + math + phy + chem ) / 5;
        if(avgGrade >= 90 && avgGrade <=100)
        {
            System.out.println("Your Grade = GRADE-A");
        }
        else if(avgGrade >= 80 && avgGrade <=89)
        {
            System.out.println("Your Grade = GRADE-B");
        }
        else if(avgGrade >= 70 && avgGrade <=79)
        {
            System.out.println("Your Grade = GRADE-C");
        }
        else if(avgGrade >= 60 && avgGrade <=69)
        {
            System.out.println("Your Grade = GRADE-D");
        }
        else
        {
            System.out.println("Your Grade = GRADE-F");
        }
        scanner.close();

    }
}
