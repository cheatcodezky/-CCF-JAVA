import java.util.Scanner;

/**
 * Created by 95112 on 10/22/2017.
 */
public class Magnet {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int group = 1;
        int pre = scanner.nextInt();
        for (int i = 1 ; i < n; i++){
            int tmp = scanner.nextInt();
            if (tmp != pre)
            {
                group++;
                pre = tmp;
            }
        }
        System.out.println(group);
    }
}
