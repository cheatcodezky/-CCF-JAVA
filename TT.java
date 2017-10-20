import java.util.ArrayList;
import java.util.List;

/**
 * Created by 95112 on 10/18/2017.
 */
public class TT {
    public static void main(String[] args)
    {
        List<Integer> input = new ArrayList();
        input.add(1);
        input.add(2);
        for (int i =0 ; i< input.size();i++)
        {
            input.add(1);
            System.out.println("output");
        }
    }
}
