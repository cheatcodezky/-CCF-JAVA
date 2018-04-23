package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by 95112 on 2018/4/3.
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        long Time = 0;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String words = in.next();
            long callTime = System.currentTimeMillis();
            set.add(in.next());
            callTime = System.currentTimeMillis() - callTime;
            Time += callTime;
        }
        Iterator<String> iter = set.iterator();
        while (iter.hasNext())
            System.out.print(iter.next());
        System.out.println("....");
        System.out.println(set.size()+" distinct words. "+Time+" milliseconds.");
    }
}
