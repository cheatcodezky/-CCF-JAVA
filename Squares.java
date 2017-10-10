import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by 95112 on 10/10/2017.
 */
public class Squares {
    static Point[][] map;
    public static void main(String[] args)
    {
        int amountAnswers = 0;
        ArrayList<HashMap> allAnswers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            HashMap<Integer,Integer> answers = new HashMap<>();
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            answers.put(-1,n);
            answers.put(0,0);
            String key = "";
            map = new Point[n + 1][n + 1];
            for (int i = 0; i < n + 1; i++)
                for (int j = 0; j < n + 1; j++)
                    map[i][j] = new Point();
            int x, y;
            for (int i = 0; i < m; i++) {
                key = scanner.next();
                x = scanner.nextInt();
                y = scanner.nextInt();
                if (key.equals("H")) {

                    map[x][y].right = true;
                } else {
                    map[y][x].down = true;
                }
            }
            int sum = 0;
            for (int i = 1; i < n; i++)
                for (int j = 1; j < n; j++) {
                    x = i;
                    y = j;
                    int maxSize = 0;
                    int pointSum = 0;
                    while (map[x][y].down && (x <= n)) {
                        maxSize++;
                        x++;
                    }

                    for (int z = 1; z <= maxSize; z++) {
                        if ((i + z) > n || (j + z) > n)
                            continue;
                        if (checkSquare(i, j, z)) {
                            answers.put(0,1);
                            if (answers.containsKey(z))
                            {
                                int count = answers.get(z);
                                count ++;
                                answers.put(z,count);
                            }
                            else
                            {
                                answers.put(z,1);
                            }
                            pointSum++;
                        }
                    }
                    sum += pointSum;

                }
                allAnswers.add(answers);
            amountAnswers++;
        }
        for (int i =0; i< amountAnswers ;i++)
        {
            HashMap<Integer,Integer> answer = allAnswers.get(i);
            int cc = i+1;
            System.out.println("Problem #"+cc);
            System.out.println("");
            if (answer.get(0) == 0)
            {
                System.out.println("No completed squares can be found.");
            }
            for ( int j = 1; j <= answer.get(-1);j++)
            {

                if(answer.containsKey(j))
                {
                    System.out.println(answer.get(j)+" square (s) of size "+j);
                }

            }
            if (i != amountAnswers-1) {
                System.out.println("");
                System.out.println("**********************************");
                System.out.println("");
            }
        }

    }
    private static boolean checkSquare(int x,int y,int size)
    {

        for (int i = 0 ; i < size; i++)
        {
            if (map[x+i][y].down != true )
                return false;
            if (map[x+i][y+size].down != true)
                return false;
            if (map[x][y+i].right != true)
                return false;
            if (map[x+size][y+i].right !=true)
                return false;
        }
        return true;
    }

}
class Point{
    public boolean down = false;
    public boolean right = false;
}
/*
4
4
H 1 1
H 2 1
V 1 1
V 2 1
4
16
H 1 1
H 1 3
H 2 1
H 2 2
H 2 3
H 3 2
H 4 2
H 4 3
V 1 1
V 2 1
V 2 2
V 2 3
V 3 2
V 4 1
V 4 2
V 4 3
 */
