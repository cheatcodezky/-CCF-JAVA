import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by max on 17-4-12.
 */
public class HDOJ2108 {
    static ArrayList<String> answer = new ArrayList<>();
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n;
        while ((n = scanner.nextInt())!=0)
        {

            int[] x,y;
            x = new int[n];
            y = new int[n];
            for (int i =  0 ;i< n ; i++)
            {
                x[i] = scanner.nextInt();
                y[i] = scanner.nextInt();
            }
            int key = 0;
            for (int i = 0 ; i<n-1 ; i++)
            {

                int j = (i+1)%n;
                double k = ((double)(y[j]-y[i]))/((double)(x[j]-x[i]));
                double b = y[i] - k*x[i];
                int judge = 0;
                int z = (j)%n;
                while(true)
                {

                    z = z+1;
                    z = z%n;
                    if (z == i)
                        break;

                    if (judge == 0)
                    {
                        judge = (int)(k*x[z] - b)-y[z]; //maybe wrong
                    }
                    else
                    {
                        if (judge*((k*x[z]-b)-y[z])<0)
                        {
                            key = 1;
                            break;
                        }
                    }
                }
                if (key==1)
                    break;
            }
            if (key==1)
            {
                answer.add("concave");
            }
            else
            {
                answer.add("convex");
            }
        }
        while(!answer.isEmpty())
        {
            System.out.println(answer.get(0));
            answer.remove(0);
        }
    }
}
