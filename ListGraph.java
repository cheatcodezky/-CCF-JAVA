import java.util.ArrayList;

/**
 * Created by max on 17-5-9.
 */
public class ListGraph {
    ListNode[] listNodes;
    int length ;
    ArrayList<Integer> vertices;

    public ListGraph(int lenght)
    {
        this.length = lenght;
        listNodes = new ListNode[length];
        vertices = new ArrayList<>();
        for (int i=0;i<length;i++)
        {
            listNodes[i] = new ListNode();
            vertices.add(i);
        }
    }
    public void addEdge(int start,int end)
    {
        int i = vertices.indexOf(start);
        int j = vertices.indexOf(end);
        if (j!=-1&&i!=-1)
        {
            listNodes[i].insertAtBeginning(j);
            listNodes[j].insertAtBeginning(i);
        }
    }

}
