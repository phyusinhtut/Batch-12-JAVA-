import java.util.Scanner;
public class BMI {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your weight in lbs : ");
        double weight = scanner.nextDouble();

        System.out.print("Enter your height in inches : ");
        double height = scanner.nextDouble();

        double bmi = (weight/(height*height))*703;
        System.out.printf("Your BMI - %.2f",bmi);
        System.out.println();
        if(bmi < 18.5)
        {
            System.out.println("Underweight");
        }
        else if (bmi >= 18.5 && bmi <25)
        {
            System.out.println("Normal weight");
        }
        else if(bmi >= 25 && bmi < 30)
        {
            System.out.println("Overweight");
        }
        else if(bmi >= 30)
        {
            System.out.println("Obese");
        }

        scanner.close();
    }
}
