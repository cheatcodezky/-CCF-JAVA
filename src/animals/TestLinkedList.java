package animals;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 95112 on 2018/4/3.
 */
public class TestLinkedList  {
    public static void main(String[] args){
        List<String> staff = new LinkedList<>();
        staff.add("Jack");
        staff.add("Tom");
        staff.add("Mary");
        Iterator iterator = staff.iterator();
        iterator.next();
        iterator.remove();
        for (String aim : staff){
            System.out.println(aim);
        }

    }
}
