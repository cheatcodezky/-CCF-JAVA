import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 95112 on 10/17/2017.
 */
public class DroppingBalls {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> answer = new ArrayList<>();
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            TreePoint firstPoint = new TreePoint(1);
            if (n >= 1) {
                createTree(n - 1, firstPoint);
            }
            else
            {
                answer.add(0);
                continue;
            }
            for (int i = 0 ;i < m;i++)
            {
                TreePoint dex = new TreePoint(0);
                dex.left = firstPoint;
                while (dex.left != null)
                {
                    if (dex.change)
                    {
                        dex.change = !dex.change;
                        dex = dex.right;
                    }
                    else
                    {
                        dex.change = !dex.change;
                        dex = dex.left;
                    }
                }
                if (i == m-1) {

                    answer.add(dex.id);

                }
            }
        }
        for (int ans:answer)
            System.out.println(ans);
    }
    private static void createTree(int deep,TreePoint treePoint)
    {
        if (deep == 0)
            return;
        treePoint.left = new TreePoint(treePoint.id*2);
        treePoint.right = new TreePoint(treePoint.id*2+1);
        createTree(deep-1,treePoint.left);
        createTree(deep-1,treePoint.right);
    }
}
class TreePoint{
    public TreePoint left,right;
    public boolean change  = false;
    public int id;
    public TreePoint(int id)
    {
        this.id = id;
    }

}

/*
4 2
3 4
10 1
2 2
8 128
16 12345


 */