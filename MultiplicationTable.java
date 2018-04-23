import java.math.BigDecimal;

/**
 * Created by 95112 on 2018/4/21.
 */
public class MultiplicationTable {
    public static void main(String[] args)
    {
        for (int i = 1; i <= 9 ; i++){
            for (int j = 1; j <= i ; j++){
                System.out.print(j +" * "+i+" = "+i*j+"\t");
            }
            System.out.println("\n");
        }
        BigDecimal sum = new BigDecimal(0);
        BigDecimal factory = new BigDecimal(1);
        for (int i = 2; i <=21;i++){
            sum  = sum.add(factory);
            factory = factory.multiply(new BigDecimal(1.0/i));
        }
        System.out.println(sum);
    }
}
