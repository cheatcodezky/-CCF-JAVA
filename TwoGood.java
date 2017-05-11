/**
 * Created by max on 17-5-3.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TwoGood {
    private static ArrayList arrayList;
    static Object[] aim;
    public static void main(String[] args)
    {

        Random random = new Random();
         arrayList = new ArrayList();
        int i = 30;
        while (i>=0)
        {
            arrayList.add(random.nextInt(100));
            i--;
        }
        aim = arrayList.toArray();
        Arrays.sort(aim);

        for (i = 0;i<aim.length;i++)
            System.out.print(" "+aim[i]);


        if(search(20))
        {
         System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }

    }


    public static boolean search(int key)
    {

        return search(key,0,aim.length-1);
    }
    private static boolean search(int key,int start,int end)
    {

        if (key>(Integer)aim[end])
            return false;
        else if (key<(Integer)aim[start])
            return false;
        if (start>end)
            return false;
        int p =(int)(start+ (key-(Integer)aim[start]+0.0)/((Integer)aim[end]-(Integer)aim[start])*(end-start));
        System.out.println("P : "+p+" start : "+start+" end : "+end+ " "+(int)(key-(Integer)aim[start]+0.0)+" "+((Integer)aim[end]-(Integer)aim[start]));
        if (((Integer)aim[p]).equals(key))
        {
            return true;
        }
        else if (((Integer)aim[p])<key)
        {
            return search(key,p+1,end);
        }
        else
        {
            return search(key,start,p-1);
        }
    }
}
