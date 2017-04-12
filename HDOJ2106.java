import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.pow;

/**
 * Created by max on 17-4-12.
 */
public class HDOJ2106 {
    public static void main(String[] args) {
        ArrayList<Long> end = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int N;
        while (scanner.hasNextInt()) {

            N = scanner.nextInt();
            scanner.nextLine();
            long answer = 0;
            for (int i = 0; i < N; i++) {

                long tmp = 0;

                String input = scanner.nextLine();

             //   System.out.println("input : "+input);
                String[] input_deal = input.split("\\(");

                String[] input_deal2 = input_deal[1].split("\\)");
                long number = Long.valueOf(input_deal[0]);
                int divider = Integer.valueOf(input_deal2[0]);
                double times = 0;
                while (number != 0) {
                    tmp += number % 10 * (pow(divider, times++));
                    number = (int) number / 10;
                }

                answer += tmp;
            }
            end.add(answer);
            scanner.nextLine();
        }
        while (!end.isEmpty())
        {
            System.out.println(end.get(0));
            end.remove(0);
        }
    }

}
//    static ArrayList<Double> end_answer = new ArrayList<>();
//    public static void main(String[] args)
//    {
//
//        Scanner scanner = new Scanner(System.in);
//        int N;
//        while(scanner.hasNextInt())
//        {
//            N = scanner.nextInt();
//            scanner.nextLine();
//            double answer = 0;
//            for (int i=0;i<N;i++)
//            {
//                String input = scanner.nextLine();
//
//                String[] input_deal = input.split("\\(");
//
//                String[] input_deal2 = input_deal[1].split("\\)");
//
//                int x = Integer.valueOf(input_deal2[0]);
//                double tmp = 0;
//                for (int j = 0;j<input_deal[0].length();j++)
//                {
//
//                    tmp +=Double.valueOf(String.valueOf(input_deal[0].charAt(j)));
//                    if (j<(input_deal[0].length()-1))
//                        tmp *= x;
//                }
//                answer +=tmp;
//            }
//
//            end_answer.add(answer);
//            scanner.nextLine();
//
//        }
//
//        while (!end_answer.isEmpty())
//        {
//            System.out.printf("%.0f\n",end_answer.get(0));
//            end_answer.remove(0);
//        }
//    }