import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 95112 on 10/17/2017.
 */
public class Room {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n,x;
        int[] room ;
        n = scanner.nextInt();
        x = scanner.nextInt() - 1;
        room = new int[n];
        int min =  Integer.MAX_VALUE;
        int all = 0;
        ArrayList<Integer> location = new ArrayList<>();
        for (int i =0 ; i<n;i++) {
            room[i] = scanner.nextInt();

            if (min > room[i]) {
                location = new ArrayList<>();
                min = room[i];
                location.add(i);
            }
            else if (min == room[i])
                location.add(i);
        }
        int[] test = new int[n];
        for (int loca : location)
        {

            int time = room[loca];
            for (int i = 0 ;i < n;i++) {
                test[i] = room[i] - time;
                if (test[i] < 0)
                    continue;
            }
            if (x < loca)
            {
                for (int i = 0; i <=x ; i++) {
                    test[i] = test[i] - 1;
                    test[loca]++;
                    if (test[i] < 0)
                        continue;
                }
                for (int i = loca+1 ; i < n; i++) {
                    test[i] = test[i] - 1;
                    test[loca]++;
                    if (test[i] < 0)
                        continue;
                }
            }
            else  {
                for (int i = loca + 1; i <= x; i++) {
                    test[i] = test[i] - 1;
                    test[loca]++;
                    if (test[i] < 0)
                        continue;
                }
            }
            test[loca] += time*n ;
            for (int i = 0 ; i < n;i++)
            {

                System.out.print(test[i]);
                if (i!=n-1)
                    System.out.print(" ");
            }
            return;
        }


    }
}
/*


 */