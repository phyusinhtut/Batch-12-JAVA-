abstract class Animal
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

    Animal(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    abstract void makeSound();

    public void displayInfo()
    {
        System.out.println("Animal's Name - " + name);
        System.out.println("Age - " + age);
    }
}
class Lion extends Animal
{
    Lion() {
        super("Lion",12);
    }


    @Override
    public void makeSound()
    {
        System.out.println("Lion makes sound Wron");
    }
}

class Elephant extends Animal
{
    Elephant()
    {
        super("Elephant" , 8);
    }

    @Override
    public void makeSound()
    {
        System.out.println("Elephant makes sound Moo");
    }
}

public class AnimalExec {
    public static void main(String[] args) {
        Animal animal1 = new Lion();
        Animal animal2 = new Elephant();

        Animal[] animals = new Animal[2];
        animals[0]  = animal1;
        animals[1] = animal2;

        for(int i=0 ; i<animals.length ; i++)
        {
            animals[i].displayInfo();
            animals[i].makeSound();
            System.out.println();
        }
    }
}
