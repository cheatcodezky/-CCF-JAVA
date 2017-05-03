/**
 * Created by max on 17-5-3.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TwoGood {
    public static void main(String[] args)
    {

        Random random = new Random();
        ArrayList arrayList = new ArrayList();
        int i = 10;
        while (i>=0)
        {
            arrayList.add(random.nextInt());
            i--;
        }
        Object[] aim = arrayList.toArray();
        Arrays.sort(aim);
        for (i =0;i<aim.length;i++)
        {
            System.out.print(" "+aim[i]);
        }

    }
}
