abstract class Superhero
{
    private String heroName;
    private int powerLevel;

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    Superhero(String heroName, int powerLevel)
    {
        this.heroName = heroName;
        this.powerLevel = powerLevel;
    }

    abstract void usePower();

    public void powerBoost()
    {
        powerLevel++;
        System.out.println("Power Level - " + powerLevel);
    }
}

class FlyingHero extends Superhero
{
    FlyingHero() {
        super("Flying Hero", 50);
    }

    @Override
    public void usePower()
    {
        System.out.println("FlyingHero use his flying superpower...");
    }
}

class  StrengthHero extends Superhero
{
    StrengthHero() {
        super("Strength Hero", 70);
    }

    @Override
    public void usePower()
    {
        System.out.println("StrengthHero use his strength as superpower...");
    }
}
class SpeedHero extends Superhero
{
    SpeedHero() {
        super("Speed Hero", 75);
    }

    @Override
    public void usePower()
    {
        System.out.println("SpeedHero use his speed as superpower...");
    }
}
public class Hero {
    public static void main(String[] args) {
        Superhero hero1 = new FlyingHero();
        Superhero hero2 = new StrengthHero();
        Superhero hero3 = new SpeedHero();
        Superhero[] heroes = new Superhero[]{hero1,hero2,hero3};

        for(int i = 0; i<heroes.length; i++)
        {
            heroes[i].usePower();
            heroes[i].powerBoost();
        }
    }
}
