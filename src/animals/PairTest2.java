package animals;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by 95112 on 2018/4/3.
 */
public class PairTest2 {
    public static void main(String[] args){
        GregorianCalendar[] birthdays = {
                new GregorianCalendar(1906, Calendar.DECEMBER,20),
                new GregorianCalendar(1888,Calendar.APRIL,2),
                new GregorianCalendar(2007,Calendar.JANUARY,3),
        };
        Pair<GregorianCalendar> mm = ArrayAlg.minmax(birthdays);
        System.out.println(mm.getFirst().getTime());
        System.out.println(mm.getSecond().getTime());
    }
}
class ArrayAlg{
    public static <T extends Comparable> Pair<T> minmax(T[] a){
        if(a == null || a.length == 0){
            return null;
        }
        T min =a[0];
        T max =a[0];
        for (int i = 1 ; i < a.length; i++)
        {
            if (min.compareTo(a[i])>0)min = a[i];
            if (max.compareTo(a[i])<0)max = a[i];
        }
        return new Pair<T>(min,max);
    }
}
