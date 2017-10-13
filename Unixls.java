import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 95112 on 10/11/2017.
 */
public class Unixls {
    public static void main(String[] args)
    {
        int columns = 60;
        Scanner scanner = new Scanner(System.in);
        String [][] answers ;
        int maxSize = 0;
        int n = scanner.nextInt();
        String[] files = new String[n];
        for (int i = 0 ; i< n ; i++) {
            files[i] = scanner.next();
            if (maxSize<files[i].length())
                maxSize = files[i].length();
        }
        int numberPerRow = (columns - maxSize)/(maxSize + 2) + 1;
        int row = n / numberPerRow;
        if (n%numberPerRow != 0)
            row++;
        String zero = "";
        for (int i = 0 ; i < maxSize+2 ;i ++)
            zero =zero + " ";
        Arrays.sort(files);
        answers = new String[row][numberPerRow];
        for (int j = 0 ; j < numberPerRow ;j++)
            for (int i = 0 ;i < row ; i++)
            {
                if ((i+j*row)>=files.length)
                {
                    answers[i][j] = zero;
                    continue;

                }
                answers[i][j] = files[i + j * row] ;
                if (j != numberPerRow-1)
                {
                    int difference = maxSize + 2 - answers[i][j].length();
                    for (int z = 0; z < difference;z++)
                        answers[i][j] += " ";
                }
            }
        for (int i = 0 ; i< row;i++)
            for (int j = 0 ; j<numberPerRow;j++)
            {
               System.out.print(answers[i][j]);
               if (j == (numberPerRow -1 ) )
                   System.out.println("");
            }

    }
}
