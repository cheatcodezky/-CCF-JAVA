import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 95112 on 10/9/2017.
 */
public class Dispose {
    private static int key = -1;
    private static HashMap<Integer,Student> students;
    public static HashMap<Integer,Student> resolve(HashMap input_students,int input_key)
    {
        key = input_key;
        students = input_students;
        switch (key)
        {
            case 0:

                break;
            case 1:
                add();
                break;
            case 2:
                remove();
                break;
            case 3:
                query();
                break;
            case 4:
                showRanking();
                break;
            case 5:
                showStatistics();
                break;


        }
        return students;
    }
    private static void add()
    {
        System.out.println("Please enter the SID,CID,name and four scores.Enter 0 to finish.");
    }
    private static void remove()
    {

    }
    private static void query()
    {

    }
    private static void showRanking()
    {

    }
    private static void showStatistics()
    {

    }
}
