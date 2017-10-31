import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 95112 on 10/31/2017.
 */
public class HowToType {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        ArrayList<String> answers = new ArrayList<>();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            String input = scanner.nextLine();
            int start = 0;
            int end = 0;
            int dValue = 0;
            int sum = 0;
            int times = 0;
            boolean nowUp = false;
            boolean capsOn = false;
            boolean isUp = false;
            for (int j = 0; j < input.length(); j++) {

                char cache = input.charAt(j);

                if (cache - 'A' >= 0 && cache - 'A' <= 25) {
                    isUp = true;
                } else {
                        isUp = false;
                }
                if (isUp != nowUp){
                    times++;
                    dValue = end -start + 1;


                    if (j == 0){
                        sum++;
                        nowUp = isUp;
                        continue;
                    }
                    if ((dValue > 1 && capsOn != nowUp )|| (dValue >1&& start ==0 && nowUp  )){
                        capsOn = !capsOn;
                        sum++;
                    }
                    else if ((capsOn!=nowUp && dValue == 1) || (start == 0 && dValue == 1 && nowUp)){
                        sum++;
                    }
                    else if (capsOn == nowUp){

                    }
                    nowUp = isUp;
                    start = j;
                    end = j;
                }
                else{
                    end = j;
                }
                sum++;
            }
            dValue = end - start + 1;
            if (isUp){
                if (dValue > 1 && !capsOn)
                    sum += 2;
                else
                    sum += 1;
            }
            else{
                if (capsOn)
                    sum += 1;

            }

            answers.add(sum + "");
        }
        for (String answer : answers)
            System.out.println(answer);
    }
}
