import java.util.Scanner;

/**
 * Created by ZhouKeyu on 17-3-18.
 */
public class Ticket_System {
    private static int[] seats = new int[101];
    public static void main(String[] args)
    {

        seats[0] = 1;
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int input[] = new int[number];
        for(int i =0;i<number;i++)
        {
            input[i] = scanner.nextInt();
        }
        int sum = 0;
        for (int i = 0; i<number;i++)
        {
            int[] answer = arrange(input[i]);
            for (int j=0;j<answer.length;j++)
            {
                System.out.print(answer[j]);
                if (j!=answer.length-1)
                    System.out.print(" ");
            }
            System.out.print('\n');
        }

    }
    public static int[] arrange(int ask)
    {
        int end = -1;
        int[] arrange_number = new int[ask];
        for (int i=0;i<20;i++) {
            int count = 0;

            for (int j = 1; j <= 5; j++) {
                if (seats[(j+i*5)] ==0) {
                    count++;
                    if (count>=ask)
                    {
                        end = j+i*5;
                        break;
                    }
                }
            }
            if (end!=-1)
            {

                int j = 0;
                for (int z = end-ask+1;z<=(end);z++)
                {
                    seats[z] = 1;
                    arrange_number[j++] = z;
                }
                return arrange_number;
            }
        }
        if (end==-1)
        {
            int custom = ask;
            for (int i =1;i<101||ask>0;i++)
            {
                if (seats[i]==0)
                {
                    seats[i] = 1;
                    arrange_number[custom-ask] =i;
                    ask--;
                }
            }
        }
        return arrange_number;
    }
}
