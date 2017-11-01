import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 95112 on 11/1/2017.
 */
public class PK {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] A = new long[n];
        long[] B = new long[n];
        for (int i =0 ; i< n ; i++)
            A[i] = scanner.nextLong();
        for (int i= 0 ; i <n ;i++)
            B[i] = scanner.nextLong();
        boolean[] Bused = new boolean[n];
        boolean[] Aused = new boolean[n];
        int sum = 0 ;
        Arrays.sort(A);
        Arrays.sort(B);
        int count = 0;
        for (int i = n-1 ; i>=0 ; i-- ){
            for (int j = n-1 ; j>= 0 ; j--){
                if (Bused[j])
                    continue;
                if (A[i] == B[i])
                    break;
                if (A[i] > B[j]){
                    Aused[i] = true;
                    sum += 100;
                    Bused[j] = true;
                    count++;
                    break;
                }

            }
        }
        for (int i = n -1 ; i>=0 ; i--) {
            if (Aused[i])
                continue;
            for (int j = n-1; j >= 0; j--) {
                if (Bused[j])
                    continue;
                if (A[i] > B[j]){
                    Aused[i] = true;
                    sum += 100;
                    Bused[j] = true;
                    count++;
                    break;
                }
                if (A[i] == B[j]) {
                    Aused[i] = true;
                    Bused[j] = true;
                    count++;
                    break;
                }
            }
        }
        sum = sum - (n - count)*100;
        System.out.println(sum);
    }
}
/*
6
2 3 4 5 6 7
3 4 5 6 7 8

4
9 7 5 3
10 8 5 2
 */