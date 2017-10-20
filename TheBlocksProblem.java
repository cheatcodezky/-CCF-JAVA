import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by 95112 on 10/19/2017.
 */
public class TheBlocksProblem {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Block[] blocks = new Block[n];
        Stack<Block>[] platforms = new Stack[n];
        Stack<Block> tmpStack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ;i < n; i++)
        {
            blocks[i] = new Block(-1,i);
            platforms[i] = new Stack<>();
            platforms[i].push(blocks[i]);
            map.put(i,i);
        }
        String input ;
        do {
            input = scanner.nextLine();


            if (input.equals("quit"))
                break;
            String[] tmp = input.split(" ");
            if (tmp[0].equals("move"))
            {
                if (tmp[2].equals("onto"))
                {
                    int a = Integer.valueOf(tmp[1]);
                    int b = Integer.valueOf(tmp[3]);
                    int aPlatform = map.get(a);
                    int bPlatform = map.get(b);

                }
                else
                {

                }

            }
            else
            {

            }
        }while(true);

    }

}
class Block{
    int pre;
    int id;
    public Block(int pre, int id)
    {
        this.id = id;
        this.pre = pre;
    }
}
