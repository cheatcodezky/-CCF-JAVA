/**
 * Created by 95112 on 2018/4/20.
 */
public class XOR {
    public static void main(String[] args)
    {
        int a = 256;
        int b = 391;
        long startTime = System.currentTimeMillis();
        for (int i =0;i< 1000000;i++) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        long endTime = System.currentTimeMillis();

        System.out.println(endTime-startTime);

        startTime = System.currentTimeMillis();
        for (int i =0;i< 1000000;i++) {
            int temp = a;
            a = b;
            b = temp;
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        System.out.println(a+" "+b);
        System.out.println(-10%2);
    }
}
