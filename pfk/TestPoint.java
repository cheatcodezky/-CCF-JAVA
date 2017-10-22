package pfk;

/**
 * Created by 95112 on 10/21/2017.
 */
public class TestPoint {
    public static void main(String[] args)
    {
        AboutPoint first = new AboutPoint();
        first.id = 0;
        for (int i = 1; i<10;i++ )
        {
            first.next = new AboutPoint();
            first.next.pre = first;
            first = first.next;
            first.id = i;


        }
        while (first.pre != null)
            first = first.pre;
        while (first.next != null)
        {

            System.out.println(first.id);
            first =first.next;
        }
    }
}
class AboutPoint{
    AboutPoint next,pre;
    int id;
}
