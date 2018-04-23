import java.util.Scanner;

/**
 * Created by 95112 on 1/24/2018.
 */
public class Hanxin {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a,b,c;
        int count = 1;
        while(scanner.hasNextInt()){
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            if ( a>=3 || b >= 5 || c >=7){
                System.out.println("Case "+count+": No answer");
            }
            else{
                boolean ifFind = false;
                for (int i = 10; i <= 100;i++){
                    if ( i % 3 == a && i % 5 == b && i % 7 == c){
                        System.out.println("Case "+count+": "+i);
                        ifFind = true;
                    }
                }
                if (!ifFind)
                    System.out.println("Case "+count+": No answer");

            }
            count++;
        }
    }
}
