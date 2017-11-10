import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by 95112 on 11/10/2017.
 */
public class CleaningShifts {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N,T;
        N = scanner.nextInt();
        T = scanner.nextInt();
        cow[] cows = new cow[N];
        for (int i =0 ; i< N; i++)
        {
            cows[i] = new cow(scanner.nextInt(), scanner.nextInt());


        }
        Arrays.sort(cows, new Comparator<cow>() {
            @Override
            public int compare(cow o1, cow o2) {
                if (o1.left < o2.left)
                    return -1;
                else
                    return 1;
            }
        });
        int newStart = Integer.MAX_VALUE;
        int end = 0;
        int newEnd = 0;
        int count = 0;
        for (int i = 0 ; i < N;i++)
        {
            if (cows[i].left <= end+1 && cows[i].right > newEnd) {
                newEnd = cows[i].right;
                newStart = cows[i].left;
            }
            else if (cows[i].left > end+1)
            {
                if (newStart <= end+1 && cows[i].left <= newEnd + 1)
                {
                    end = newEnd;
                    count++;
                    if (end == T)
                    {
                        System.out.println(count);
                        return;
                    }

                }
                else {
                    System.out.println("-1");
                    return;
                }
                if (cows[i].left <= end+1 && cows[i].right > newEnd) {
                    newEnd = cows[i].right;
                    newStart = cows[i].left;
                }

            }
        }
        if (newEnd == T )
            count++;
        else
        {
            System.out.println("-1");
            return;
        }
        System.out.println(count);
    }

}
class cow{
    int left;
    int right;
    public cow(int left,int right)
    {
        this.left = left;
        this.right = right;
    }
}
