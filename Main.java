
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by max on 17-3-18.
 */
public class Main {
    public static void main(String[] arg)
    {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] RC = new int[N][2];
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0 ; i<N;i++)
        {
            RC[i][0] =scanner.nextInt();
            RC[i][1] =scanner.nextInt();
            Node newNode = new Node(RC[i][0],RC[i][1]);
            if (!x.contains(RC[i][0]))
            {
                x.add(RC[i][0]);
            }
            else
            {
                int key = 0;
                for (int j = 0 ; j<nodes.size();j++)
                {

                    Node tmp = nodes.get(j);
                    if(tmp.x==RC[i][0]) {
                        while (tmp.rightNode != null) {
                            tmp = tmp.rightNode;
                        }

                        tmp.rightNode = newNode;
                        key =1;
                    }
                    if (key ==1)
                    {
                        break;
                    }
                }
            }
            if (!y.contains(RC[i][1]))
                y.add(RC[i][1]);
            else
            {
                int key =0 ;
                for (int j = 0 ; j<nodes.size();j++)
                {
                    Node tmp = nodes.get(j);
                    if(tmp.y==RC[i][1]) {
                        while (tmp.donwNode != null) {
                            tmp = tmp.donwNode;
                        }

                        tmp.donwNode = newNode;
                        key =1;
                    }
                    if (key ==1)
                        break;
                }
            }
            nodes.add(newNode);
        }
        int answer = 0;
        for (int i =0 ;i<nodes.size();i++)
        {
            int x_count= 1;
            int y_count =1;
            int z_count = 0;
            Node aim = nodes.get(i);
            Node aim_test1 = nodes.get(i);
            Node aim_test2 = nodes.get(i);
            while (aim_test1.rightNode!=null)
            {
                x_count++;
                aim_test1 = aim_test1.rightNode;
            }
            while(aim_test2.donwNode!=null)
            {
                y_count++;
                aim_test2 = aim_test2.donwNode;
            }
            for (int z = i+1 ;z<nodes.size();z++) {
                Node test_node = nodes.get(z);
                if (Math.abs(test_node.x - aim.x) == Math.abs(test_node.y - aim.y)) {
                    System.out.println("aim:"+aim.x+","+aim.y+" "+"test:"+test_node.x+","+test_node.y);
                    z_count++;

                }
            }

            answer = (answer+ jieci(x_count-1)+jieci(y_count-1)+z_count);
        }
        System.out.println(answer);
    }
    static class Node{
        public int x = 0 ;
        public int y = 0 ;
        public Node donwNode = null;
        public Node rightNode = null;
        public Node(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int jieci(int a)
    {
        if (a<1)
        {
            return 0;
        }
        int answer = 0;
        for (int i= 1;i<=a;i++)
            answer+=i;
        return answer;
    }

}
