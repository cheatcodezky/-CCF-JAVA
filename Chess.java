import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 95112 on 10/9/2017.
 */
public class Chess {
    static ArrayList<String> answers = new ArrayList<>();
    static String[][] map = new String[11][10];
    static int redX = 0;
    static int redY = 0;
    static int blackX = 0;
    static int blackY = 0;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        do {
            refreshMap();
            int N = scanner.nextInt();
            int x,y;
            String piece;
            blackX = scanner.nextInt();
            blackY = scanner.nextInt();
            if (N == 0 && blackX == 0 && blackY == 0 )
                break;

            for (int i = 0; i < N; i++) {
                piece = scanner.next();
                x = scanner.nextInt();
                y = scanner.nextInt();
                map[x][y] = piece;
                if (piece == "G")
                {
                    redX = x;
                    redY = y;
                }
            }
            if (redY == blackY) {
                int min,max;
                if (redX < blackX) {
                    min = redX;
                    max = blackX;
                }
                else {
                    max =redX;
                    min = blackX;
                }
                int count = 0;
                for (int i = min+1 ; i < max; i++)
                {
                    if (map[i][redY] != "")
                    {
                        count++;
                        break;
                    }
                }
                if (count == 0)
                {
                    answers.add("YES");
                    continue;
                }
            }
            int[] dexX = {blackX+1 , blackX-1 , blackX , blackX};
            int[] dexY = {blackY , blackY , blackY+1 , blackY-1};
            String save = "";
            boolean all_kill = true;
            for (int i=0 ; i<4;i++)
            {
                x =dexX[i];
                y =dexY[i];
                if (((x>=1 && x<=3 ) || (x <= 10 && x >= 8))&& y<=6 && y>= 4)
                {

                }
                else
                    continue;
                if ((x<=0 || x>= 11 || y <=0 || y >= 10))
                        continue;
                save = map[x][y];
                map[x][y] = "BG";
                boolean kill = true;
                for ( int j = 1 ; j < 11;j++  ) {
                    for (int z = 1; z < 10; z++) {
                        kill = dealPiece(j, z);
                        if (kill)
                            break;
                    }
                    if (kill)
                        break;
                }
                map[x][y] = save;
                all_kill = all_kill && kill;
                if (!all_kill)
                    break;
            }
            if (all_kill)
                answers.add("YES");
            else
                answers.add("NO");
        }while (true);
        for ( String answer : answers)
            System.out.println(answer);

    }

    private static boolean dealPiece(int j, int z) {
        switch (map[j][z]){
            case "C":
                return cannon(j,z);
            case "H":
                return horse(j,z);
            case "R":
                return general_chariot(j,z,"R");
            case "G":
                return general_chariot(j,z,"G");
            default:
                return false;
        }
    }
    private static boolean general_chariot(int j, int z,String key) {
        int[] changeX;
        int[] changeY;
        if (key == "G") {
            changeX = new int[]{1, -1};
            changeY = new int[]{0, 0};
        }
        else
        {
            changeX = new int[]{0, 0, 1, -1};
            changeY = new int[]{1, -1, 0, 0};
        }
        int x,y;
        for (int i = 0 ;i < changeX.length; i++)
        {
            x = j + changeX[i];
            y = z + changeY[i];
            while (x>=1 && x<= 10 && y >= 1 && y <= 9)
            {
                if (map[x][y] == "")
                {
                    x += changeX[i];
                    y += changeY[i];
                    continue;
                }
                else if (map[x][y] == "BG")
                {
                    return true;
                }
                else
                {
                    break;
                }
            }
        }
        return false;
    }


    private static boolean horse(int j, int z) {
        int[] changeX = {0,0,1,-1};
        int[] changeY = {1,-1,0,0};
        boolean kill = false;
        for (int i = 0 ;i < changeX.length;i++)
        {
           kill = kill || horseCheck(j,z,changeX[i],changeY[i]);
        }
        return kill;
    }
    private static boolean horseCheck(int j, int z, int changeX, int changeY)
    {
        int x,y;
        x = j + changeX;
        y = z + changeY;
        if ( x < 1 || x > 10 || y < 1 || y > 9 || map[x][y] != "")
            return false;
        if (changeX == 0)
        {
         x = j + 1;
         y = y + changeY;
         if (x>=1 && x<= 10 && y >= 1 && y <= 9 && map[x][y] == "BG")
             return true;
         x = j - 1;
         if (x>=1 && x<= 10 && y >= 1 && y <= 9 && map[x][y] == "BG")
             return true;
         return false;
        }
        else
        {
            y = z + 1;
            x = x + changeX;
            if (x>=1 && x<= 10 && y >= 1 && y <= 9 && map[x][y] == "BG")
                return true;
            y = z - 1;
            if (x>=1 && x<= 10 && y >= 1 && y <= 9 && map[x][y] == "BG")
                return true;
            return false;


        }
    }

    private static boolean cannon(int j, int z) {
        int[] changeX = {0,0,1,-1};
        int[] changeY = {1,-1,0,0};
        int x,y;
        int key ;
        for (int i = 0 ;i < changeX.length; i++)
        {
            key = 0;
            x = j + changeX[i];
            y = z + changeY[i];
            while (x>=1 && x<= 10 && y >= 1 && y <= 9)
            {
                if (map[x][y] == "")
                {
                    x += changeX[i];
                    y += changeY[i];
                    continue;
                }
                else if (map[x][y] == "BG")
                {
                    if (key == 1)
                        return true;
                    else
                        return false;
                }
                else
                {
                    key++;
                    x += changeX[i];
                    y += changeY[i];
                    if (key>=2)
                        break;
                }
            }
        }
        return false;

    }

    private static void refreshMap() {
        for (int i = 0 ; i < 11; i++)
            for (int j = 0; j < 10 ; j++)
            {
                map[i][j] = "";
            }


    }

}
/*

2 1 4
G 10 5
R 6 4

3 2 6
H 2 4
C 2 3
G 10 4

3 1 6
H 1 4
C 1 3
G 10 3

0 0 0
 */