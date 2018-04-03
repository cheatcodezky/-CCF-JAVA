import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 95112 on 2/22/2018.
 */
public class AAddB {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> answers = new ArrayList<>();
        int a,b;
        while(scanner.hasNextInt()){
            a = scanner.nextInt();
            b = scanner.nextInt();
            answers.add(a+b);
        }
        for (int c : answers){
            System.out.println(c);
        }
    }
}
