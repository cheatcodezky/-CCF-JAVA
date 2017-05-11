/**
 * Created by max on 17-5-9.
 */
public class Graph {
    private boolean[][] map ;
    private int length;
    public Graph(int length)//生成图
    {
        this.length = length;
        map = new boolean[length][length];
    }
    public void addEdge(int i,int j)//加边
    {
        if (map == null)
        {
            if (i>j)
            {
                map = new boolean[i][i];
                length = i;
            }
            else
            {
                map = new boolean[j][j];
                length = j;
            }
        }
        map[i][j]  = true;
        map[j][i]  = true;
    }

    public void removeEdge(int i,int j)//去边
    {
        if (map == null || j>=length||i>=length)
            return;
        else {
            map[i][j] = false;
            map[j][i] = false;
        }
    }
    public boolean isEdge(int i,int j)//判断是否联通
    {
        if (map==null||i>=length||j>=length)
            return false;
        else
            return true;
    }
}
