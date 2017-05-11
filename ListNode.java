/**
 * Created by max on 17-5-9.
 */
public class ListNode {
    public int i ;
    public boolean visited;
    public ListNode next;
    public void insertAtBeginning(int location)
    {
        ListNode tmp = this;

        i = location;
        visited = false;

        next = tmp;
    }
}
