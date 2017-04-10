import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by max on 17-4-10.
 */
public class HDOJ2104 {
    static ArrayList<String> answer = new ArrayList<>();
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        long N=0,M=0,mid;
        do{

            N = scanner.nextInt();
            M = scanner.nextInt();

            if (N+M==-2)
                break;
            while(M!=0&&M!=1)
            {
                mid = N%M;
                N = M;
                M = mid;

            }
            if (M==1)
            {
                answer.add("YES");
            }
            else
            {
                answer.add("POOR Haha");
            }
        }while(N!=-1&&M!=-1);
        while (!answer.isEmpty())
        {
            System.out.println(answer.get(0));
            answer.remove(0);
        }
    }
}
