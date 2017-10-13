import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by 95112 on 10/9/2017.
 */
public class Test {
    private static HashMap<Integer,Student> students = new HashMap<>();
    public static void main(String[] args)
    {
        int key;
        showInfo();
        do {
            Scanner scanner = new Scanner(System.in);
             key = scanner.nextInt();
            students = Dispose.resolve(students, key);
        }while (key!=0);
    }
    private static void showInfo(){
        System.out.println("Welcome to Student Performance Management System (SPMS).\n1 - Add\n2 - Remove\n3 - Query\n4 - Show ranking\n5 -Show Statistics\n0 - Exit");
    }
}
