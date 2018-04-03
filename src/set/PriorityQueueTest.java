package set;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.PriorityQueue;

/**
 * Created by 95112 on 2018/4/3.
 */
public class PriorityQueueTest {
    public static void main(String[] args)
    {
        Hashtable<String,String> hashtable = new Hashtable<>();

        PriorityQueue<GregorianCalendar> priorityQueue = new PriorityQueue();
        priorityQueue.add(new GregorianCalendar(1906, Calendar.DECEMBER,3));
        priorityQueue.add(new GregorianCalendar(2006, Calendar.DECEMBER,3));
        priorityQueue.add(new GregorianCalendar(1806, Calendar.DECEMBER,3));
        priorityQueue.add(new GregorianCalendar(2009, Calendar.DECEMBER,3));
        priorityQueue.add(new GregorianCalendar(1907, Calendar.DECEMBER,3));
        System.out.println("_____________________________");
        for (GregorianCalendar calendar : priorityQueue){
            System.out.println(calendar.getTime());
        }
        System.out.println("______________________________");
        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.remove().get(Calendar.YEAR));
        }
    }
}
