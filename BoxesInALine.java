import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

/**
 * Created by 95112 on 10/13/2017.
 */
public class BoxesInALine {
    public static void main(String[] args)
    {
        int n ,m ;
        Box box = new Box();
        Box dox = box;
        Box index = box;

        box.number = 1;
        dox.number = -1;
        System.out.println(box.number + " "+ dox.number);
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 0 ; i< m;i++)
        {

        }
    }
}
class Box
{
    int number;
    Box pre,next;
}
