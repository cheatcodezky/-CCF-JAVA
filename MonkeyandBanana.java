import java.util.*;

/**
 * Created by 95112 on 10/24/2017.
 */
public class MonkeyandBanana {
    public static void main(String[] args)
    {
        int count = 1;
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> answers = new ArrayList<>();
        do {
            int n = scanner.nextInt();
            if (n == 0){
                break;
            }

            long[][] input = new long[n][3];
            long[] dp = new long[n*6+1];
            MonkeyBlock[]  blocks  = new MonkeyBlock[6*n];
            int max = 0;

            int amountMap = 0;
            int key =0;
            for (int i = 0 ; i < n ;i++)
            {
                for (int j = 0 ; j < input[0].length;j++)
                {
                    input[i][j] = scanner.nextInt();
                }
                for (int j = 0 ; j < 3 ; j++)
                {

                    blocks[key]= new MonkeyBlock();
                    blocks[key].area= input[i][j]*input[i][(j+1)%3];
                    blocks[key].height = input[i][(j+2)%3];
                    blocks[key].x = input[i][j];
                    blocks[key].y = input[i][(j+1)%3];
                    key++;
                    blocks[key]= new MonkeyBlock();
                    blocks[key].area= input[i][j]*input[i][(j+1)%3];
                    blocks[key].height = input[i][(j+2)%3];
                    blocks[key].x = input[i][(j+1)%3];
                    blocks[key].y = input[i][j];
                    key++;

                }

            }
            Arrays.sort(blocks);
            for (int i = 0 ; i < n*6; i++){
                dp[i] = blocks[i].height;
                for (int j = i-1 ; j >=0; j--){

                    if (blocks[j].x < blocks[i].x && blocks[j].y < blocks[i].y){
                        dp[i] = max(dp[i],dp[j]+blocks[i].height);
                    }
                }
            }

            answers.add("Case "+count+": maximum height = "+dp[6*n-1]+"\n");
            count++;
        }while(true);
        for (String answer:answers)
            System.out.print(answer);
    }
    private static long min(long a,long b)
    {
        if (a>b)
            return  b;
        else
            return a;
    }

    private static long max(long a, long b)
    {
        if (a>b)
            return a;
        else
            return b;
    }
    private static int max(int a,int b)
    {
        if (a>b)
            return a;
        else
            return b;
    }
}
class MonkeyBlock implements Comparable<MonkeyBlock>{
    long area;
    long x;
    long y;
    long height;

    @Override
    public int compareTo(MonkeyBlock o) {
        long dValue = area - o.area;
        return Integer.valueOf( dValue+"");
    }
}