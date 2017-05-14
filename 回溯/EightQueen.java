package 回溯;

/**
 * Created by max on 17-5-14.
 */
public class EightQueen {
    private static byte[][] map;
    static int key = 0;
    static byte[] row = new byte[8];
    static int[] answer = new int[8];
    public static void main(String[] args)
    {
        map = new byte[8][8];
        location(0);


    }
    public static void location(int column)
    {

        if (column==8)
        {
            for (int i = 0 ;i<8;i++)
                System.out.print(" " + answer[i]);
            System.out.println(" ");
            return;
        }
        for (int i = 0;i<8 ;i++)
        {
            if (i!= 0)
                map[i-1][column] = 0;
            if (row[i] == 1)
                continue;
            row[i] = 1;


            answer[column] = i;
            if (attack(i,column))
            {
                location(column+1);
            }

            if (i==7)
                map[7][column] = 0;
            row[i] = 0;
        }


    }

    public static boolean attack(int x,int y)
    {
        int i = 0;

        while(x+i<8&&y+i<8)
        {
            if (map[x+i][y+i] ==1)
            {
                return false;
            }
            i++;
        }

        i = 0;
        while(x-i>=0&&y-i>=0)
        {
            if (map[x-i][y-i] == 1)
            {
                return false;
            }
            i++;
        }

        i = 0;
        while (x-i>=0&&y+i<8)
        {
            if (map[x-i][y+i] == 1)
            {
                return false;
            }
            i++;

        }

        i = 0;
        while (x+i<8&&y-i>=0)
        {
            if (map[x+i][y-i] == 1)
            {
                return false;
            }
            i++;

        }

        i = 0;
        while(i<8)
        {
            if (map[x][i]==1||map[i][y]==1)
            {
                return false;
            }
            i++;
        }

        map[x][y] = 1;
        return true;
    }
}
