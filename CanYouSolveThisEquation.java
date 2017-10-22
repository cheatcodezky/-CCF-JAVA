import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 95112 on 10/21/2017.
 */
public class CanYouSolveThisEquation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String>  answers = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0 ; i < n; i++){
            double input = scanner.nextDouble();
            if (input < 6 || input > deal(100))
            {
                answers.add("No solution!");
                continue;
            }
            double x = 0;
            double y = 100;
            double mid = 0;
            while ( y - x > 1e-10){
                mid  = (y + x) / 2;
                double tmp = deal(mid);
                double dValue = tmp - input;
                if (dValue < 0)
                {
                    x = mid + 1e-11;
                    continue;
                }
                else {
                    y = mid - 1e-11;
                    continue;
                }
            }
            BigDecimal bg = new BigDecimal(mid).setScale(4,BigDecimal.ROUND_HALF_UP);
            DecimalFormat df = new DecimalFormat("0.0000");
            answers.add(df.format(bg));
        }
        for (String output : answers)
            System.out.println(output);
    }
    private static double deal(double x){
        return  8 * Math.pow(x,4) + 7 * Math.pow(x,3) + 2 * Math.pow(x,2) + 3 * x + 6;
    }
}
