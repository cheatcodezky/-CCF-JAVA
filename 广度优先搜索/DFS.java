package 广度优先搜索;

import sun.misc.Queue;

import java.util.ArrayList;

import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by max on 17-5-9.
 */
public class DFS {
    private class Vertics
    {
        public char label;
        public boolean visited;
        public Vertics(char label)
        {
            this.label  = label;
            visited = false;
        }
    }
    private class Graph
    {
        private boolean[][] map;
        private ArrayList<Vertics> vertices;
        private  int countVertices;
        private Stack<Integer> stack;
        private ArrayBlockingQueue queue = new ArrayBlockingQueue(20);
        public Graph(int length)
        {
            stack = new Stack<>();
            countVertices = 0;
            vertices = new ArrayList<>();
            map = new boolean[length][length];
        }
        public Graph()
        {
            stack = new Stack<>();
            int length =20;
            countVertices = 0;
            vertices = new ArrayList<>();
            map = new boolean[length][length];
        }

        public void addVertice(char label)
        {
            vertices.add(new Vertics(label));
            countVertices++;
        }

        public void addEdge(int i,int j)
        {
            map[i][j] = true;
            map[j][i] = true;
        }
        public void removeEdge(int i ,int j)
        {
            map[i][j] = false;
            map[j][i] = false;
        }

        public void showLabel(int i)
        {
            System.out.print(" "+vertices.get(i).label);
        }
        public void dfs()
        {
            showLabel(0);
            vertices.get(0).visited = true;
            stack.push(0);
            while(!stack.isEmpty())
            {
                int v =getNextNode(stack.peek());
                if (v==-1)
                {
                    stack.pop();
                }
                else
                {
                    vertices.get(v).visited=true;
                    showLabel(v);
                    stack.push(v);
                }
            }
            for (int i = 0 ;i<countVertices;i++)
                vertices.get(i).visited=false;
        }
        private int getNextNode(int peek) {
            for (int i = 0; i < countVertices; i++)
            {
                if (map[peek][i]==true&&vertices.get(i).visited==false)
                    return i;
            }
            return -1;

        }
        public void bfs()
        {
            showLabel(0);
            vertices.get(0).visited = false;
            queue.add(0);
            int ans;
            int deal;
            while(!queue.isEmpty())
            {
                deal = (int) queue.remove();
                while ((ans = getNextNode(deal))!=-1)
                {
                    vertices.get(ans).visited=true;
                    showLabel(ans);
                    queue.add(ans);
                }
            }
            for (int i = 0 ;i<countVertices;i++)
                vertices.get(i).visited=false;
        }
    }


}
