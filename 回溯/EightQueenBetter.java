package 回溯;

/**
 * Created by max on 17-5-14.
 */
public class EightQueenBetter {
    static int row[] = new int[8];
    public static void main(String[] args)
    {
        search2(0);

    }
     static void search(int row_number)
     {
         if (row_number == 8) {
             showAnswer();
             return;
         }
         for (int i =0 ;i<8;i++)
         {
             boolean ok = true;
             row[row_number] = i;
             for (int j = 0 ;j<row_number;j++)
             {
                 if (row[row_number]==row[j]||row_number-row[row_number]==j-row[j]||row_number+row[row_number]==j+row[j])
                 {
                     ok = false;
                     break;
                 }
             }
             if (ok)
                 search(row_number+1);
         }
     }
     static void showAnswer()
     {
         for (int i = 0 ;i<8;i++)
             System.out.print(" "+row[i]);
         System.out.println("");

     }
     private static byte[][] accupied = new byte[3][15];
     static void search2(int column)
     {
         if (column==8) {
             showAnswer();
             return;
         }
         for (int i = 0;i<8;i++)
         {

             if (accupied[0][i]==0&&accupied[1][column+i]==0&&accupied[2][7-column+i]==0)
             {
                 row[column] = i;
                 accupied[0][i]=1;
                 accupied[1][column+i]=1;
                 accupied[2][7-column+i]=1;
                 search2(column+1);
                 accupied[0][i]=0;
                 accupied[1][column+i]=0;
                 accupied[2][7-column+i]=0;
             }
         }

     }


}
