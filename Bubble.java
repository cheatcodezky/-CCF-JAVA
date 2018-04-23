import java.sql.Time;
import java.util.Random;

/**
 * Created by 95112 on 2018/4/21.
 */
public class Bubble {
    public static void main(String[] args)
    {
        Random random = new Random(System.currentTimeMillis());
        int[] deal = new int[10];
        for (int i=0; i<10;i++){
            deal[i] = random.nextInt();
        }
        for (int i = 0 ; i<deal.length;i++){
            for (int j=0;j<deal.length - i-1;j++){
                if (deal[j+1] < deal[j]){
                    deal[j+1] = deal[j+1]^deal[j];
                    deal[j] = deal[j+1]^deal[j];
                    deal[j+1] = deal[j+1]^deal[j];
                }
            }
        }
        for (int i = 0; i<deal.length;i++){
            System.out.print(deal[i]+" ");
        }
    }
}
