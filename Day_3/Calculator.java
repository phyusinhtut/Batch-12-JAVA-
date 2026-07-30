public class Calculator {
    public static int multiply(int a, int b)
    {
        return a*b;
    }
    public static int multiply(int x, int y, int z)
    {
        return x*y*z;
    }
    public static void main(String[] args){
        System.out.println(multiply(5,2));
        System.out.println(multiply(2,3,4));
    }
}
