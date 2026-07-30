public class PrimeNumber {
    public static void isPrime()
    {
        int count=0;
        for(int i = 1 ; i <=100 ; i++)
        {
            if(i <= 1)
            {
                System.out.println( i+" = This is not a prime number!");
            }
            else if( i==2 || i%2 != 0)
            {
                System.out.println(i +" = This is prime number!");
                count++;
            }
            else
            {
                System.out.println(i + " = This is not a prime number!");
            }
        }
        System.out.println("Total prime number : " + count);

    }
    public static void main(String[] args){
        isPrime();

    }
}
