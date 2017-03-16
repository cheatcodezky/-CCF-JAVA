import java.util.*;

/**
 * Created by ZhouKeyu on 17-3-16.
 */
public class FindSingle {
    private List<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] input = new int[number];
        for (int i=0;i < number;i++)
        {
            input[i] = scanner.nextInt();
        }
        findSingle(input);
    }
    public static void findSingle(int[] input)
    {
        Hashtable<Integer,Integer> hashtable = new Hashtable<>(input.length);
        for (int i=0;i<input.length;i++)
        {
            if(hashtable.containsKey(input[i]))
            {

               hashtable.remove(input[i]);
            }
            else
            {

                hashtable.put(input[i],input[i]);
            }
        }
//        for (int i=0;i<input.length;i++)
//            if (hashtable.containsKey(input[i]))
//                System.out.print(input[i]+" ");
        Iterator iterator = hashtable.entrySet().iterator();
        while(iterator.hasNext())
        {
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.print(entry.getValue()+" ");
        }
    }
}
