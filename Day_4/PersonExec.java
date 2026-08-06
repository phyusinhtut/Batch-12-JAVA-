class Person
{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void Introduce()
    {
        System.out.println("Hello! My name is " + getName() + " and I'm " + getAge() + " years old.");
    }

    public void getRole()
    {
        System.out.println("My Role is Person");
    }
}

class Student extends Person
{
    int gradeLevel = 1;

    Student()
    {
        super("Emily",23);
    }
    @Override
    public void Introduce()
    {
        System.out.println("Hello! My name is "+ getName() + " and I'm " + getAge() + " years old.");
        System.out.println("My Grade Level is " + gradeLevel);
    }

    @Override
    public void getRole()
    {
        System.out.println("My Role is Student");
    }

}
class Teacher extends Person
{
    Teacher()
    {
        super("John",45);
    }
    @Override
    public void Introduce()
    {
        System.out.println("Hello! My name is "+ getName() + " and I'm " + getAge() + " years old.");
        System.out.println("I'm currently teaching web-development.");
    }

    @Override
    public void getRole()
    {
        System.out.println("My Role is Teacher");
    }

}
public class PersonExec {
    public static void main(String[] args) {
        Person person1 = new Student();
        Person person2 = new Teacher();

        Person[] persons = new Person[2];
        persons[0] = person1;
        persons[1] = person2;

        for(int i = 0; i<persons.length; i++)
        {
            persons[i].Introduce();
            persons[i].getRole();
            System.out.println();
        }
    }
}
