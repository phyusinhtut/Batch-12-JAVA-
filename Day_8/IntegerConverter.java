import java.util.ArrayList;
import java.util.List;

public class IntegerConverter {
    public static void main(String[] args) {
        List<String> strValues = new ArrayList<>();
        strValues.add("10");
        strValues.add("20");
        strValues.add("abc");
        strValues.add("30");

        ArrayList<Integer> intValues = new ArrayList<>();

        for(String values : strValues)
        {
            try
            {
                Integer value = Integer.parseInt(values);
                intValues.add(value);
            }
            catch (Exception e)
            {
                System.out.println("Skipping invalid input : " + values);
            }

        }
        System.out.println(intValues);

        int sum=0;
        for(int i : intValues)
        {
            sum+=i;
        }
        System.out.println("Sum of the valid integers : " + sum);

        int average = sum/intValues.size();
        System.out.println("Average of the valid integers : " + average);

        int maxValue = intValues.get(0);
        for(int i : intValues)
        {
            if(i > maxValue)
            {
                maxValue = i;
            }
        }
        System.out.println("Maximum value of the integers : " + maxValue);

        int minValue = intValues.get(0);
        for(int i : intValues)
        {
            if(i < minValue)
            {
                minValue = i;
            }
        }
        System.out.println("Minimum value of the integers : " + minValue);
    }
}
