abstract class Employee
{
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    Employee(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

   abstract void calculatePay();
}

class HourlyEmployee extends Employee
{
    int hourlyRate;
    int hoursWorked;
    double overtimePay;
    double normalPay;

    HourlyEmployee(int hourlyRate, int hoursWorked) {
        super("Emily", 123);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public void calculatePay()
    {
        if(hoursWorked > 40)
        {
            int overtimeHour = hoursWorked - 40;
            overtimePay = 2 * (overtimeHour * hoursWorked);
            System.out.println("Your Hourly Worked Salary & Overtime -  " + overtimePay);
        }
        else
        {
            normalPay = hourlyRate * hoursWorked;
            System.out.println("Your Hourly Worked Salary - " + normalPay);
        }
    }
}

class SalariedEmployee extends Employee
{
    double annualSalary;
    double monthlySalary;

    SalariedEmployee(double annualSalary) {
        super("John", 456);
        this.annualSalary = annualSalary;
    }

    @Override
    public void calculatePay()
    {
        monthlySalary = annualSalary / 12;
        System.out.println("Your Monthly Salary - " + monthlySalary);
    }


}

public class Payroll {
    public static void main(String[] args) {
        Employee employee1 = new HourlyEmployee(15000,8);
        Employee employee2 = new SalariedEmployee(3000000);

        Employee[] employees = new Employee[]{employee1,employee2};
        for(int i=0; i<employees.length; i++)
        {
            System.out.println(employees[i].getName());
            employees[i].calculatePay();
            System.out.println();
        }
    }
}
