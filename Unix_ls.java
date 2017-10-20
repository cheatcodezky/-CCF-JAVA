import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by 95112 on 10/20/2017.
 */
public class Unix_ls {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<String>> answers = new ArrayList<>();
        int[][] attribution = new int[10000][3];
        int count = 0;
        while (scanner.hasNextInt())
        {
            int n = scanner.nextInt();
            if (n==0)
                break;
            ArrayList<String> storage = new ArrayList<>();
            String input;
            int standardLength = 60;
            int maxSize = 0;
            for (int i =0 ; i < n;i++)
            {

                input = scanner.next();
                if (maxSize<input.length())
                    maxSize = input.length();
                storage.add(input);
            }
            Collections.sort(storage);
             int columns = (standardLength - maxSize)/(maxSize+2)+1;
             int rows = 0;
             while(rows * columns < storage.size())
                 ++rows;
             attribution[count][0] = rows;
             attribution[count][1] = columns;
             attribution[count][2] = maxSize;
             count++;
             answers.add(storage);
        }

        for (int i =0 ; i< answers.size();i++)
        {
            ArrayList<String> answer = answers.get(i);
            String[][] show = new String[attribution[i][0]][attribution[i][1]];
            int rows = attribution[i][0];
            int columns = attribution[i][1];
            int maxSize = attribution[i][2];
            System.out.println("------------------------------------------------------------");
            for (int y =0; y < columns; y++)
                for (int x = 0; x < rows ; x++)
                {
                    String tmp;
                    if (x + y*rows < answer.size())
                        tmp = answer.get(x + y*rows);
                    else
                        tmp = " ";
                    if (y != columns -1)
                        while (tmp.length() < maxSize+2)
                            tmp = tmp + " ";
                    show[x][y] = tmp;
                }
            for (int x = 0 ; x < rows ; x++) {
                for (int y = 0 ; y < columns;y++)
                {
                    System.out.print(show[x][y]);
                }
                System.out.println("");
            }
        }

    }
}
