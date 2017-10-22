import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by 95112 on 10/20/2017.
 */
public class CodeForces {
    private static sPoint first;
    private static sPoint last;
    private static sPoint start;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        BigInteger n,l,r ;
        n = new BigInteger(scanner.next());
        l = new BigInteger(scanner.next());
        r = new BigInteger(scanner.next());
        first = new sPoint(n);
        sPoint index;
        index = first;
        last = first;
        start = first;
        int over = 0;
        while (true){

            while((index.id.equals(new BigInteger("1"))) || (index.id.equals(new BigInteger("0"))))
            {
                index = index.next;
                if (!(index.id.equals(new BigInteger("1"))) && !(index.id.equals(new BigInteger("0")))) {

                    break;
                }
                if (index.next == null)
                {
                    over = 1;
                    break;
                }
            }
            if (over == 1)
                break;
            sPoint left = new sPoint(index.id.divide(new BigInteger("2")));
            sPoint right = new sPoint(index.id.divide(new BigInteger("2")));
            addBefore(left,index);
            addAfter(right,index);
            index.id = index.id.mod(new BigInteger("2"));
            index = start;

        }


        index = first;
        sPoint test = new sPoint(new BigInteger("0"));
        test.count = new BigInteger("0");
        test.next = first;
        test.next.pre = test;
        BigInteger count = new BigInteger("1");
        index.count = count;
        int end,start;
        start = 0;
        end = 0;
        BigInteger sum = new BigInteger("0");
        while (test.next != null){
            test = test.next;
            test.count = test.pre.count.add(new BigInteger("1"));
            if (test.count.equals(l))
                start = 1;
            if (test.count.equals(r))
                end = 1;
            if (start ==1 && end != 1) {
                sum = sum.add(test.id);
            }
            if (end == 1 ){
                sum = sum.add(test.id);
                System.out.println(sum.toString());
                break;
            }


        }



    }
    private static void addAfter(sPoint newNode, sPoint node)
    {
        newNode.pre = node;
        newNode.next = node.next;
        newNode.pre.next = newNode;
        if (newNode.next != null)
            newNode.next.pre = newNode;
        else
            last = newNode;




    }
    private static void addBefore(sPoint newNode, sPoint node)
    {
        newNode.next = node;
        newNode.pre = node.pre;
        newNode.next.pre = newNode;
        if (newNode.pre != null)
            newNode.pre.next = newNode;
        else
            first = newNode;
        start = newNode;
    }

}
class sPoint{
    sPoint pre,next;

    BigInteger id;
    BigInteger count;
    public sPoint(BigInteger bg){
        id = bg;
        pre = null;
        next = null;
    }

}

