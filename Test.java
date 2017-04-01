import java.util.Vector;

/**
 * Created by max on 17-3-18.
 */
public class Test {
    public static void main(String[] args)
    {
        Vector<Integer> ts = new Vector<Integer>(4);
        ts.add(1);
        ts.add(2);
        ts.add(3);
        for (int i =0;i<3;i++)
        {
            System.out.println(ts.get(i));
        }
    }

}
