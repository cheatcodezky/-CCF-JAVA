import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 95112 on 10/20/2017.
 */
public class TeamQueue {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int t ;
        int count =  0;
        List<ArrayList<String>> answers = new ArrayList<>();
        String paStr = "(\\d+)";
        Pattern pattern = Pattern.compile(paStr);
        Matcher matcher;
        do {
            t =  scanner.nextInt();
            if (t == 0 )
                break;
            answers.add(new ArrayList<String>());
            answers.get(count).add("Scenario #"+(count+1));
            Member first , last;
            last = null;
            first = null;
            Member[] teams = new Member[t];
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0 ;i < t ; i++)
            {
                int amountMember = scanner.nextInt();
                for (int j = 0 ; j <amountMember; j++)
                {
                    map.put(scanner.nextInt(),i);
                }
            }
            String input;
            do{
                int keyStop = 0;
                input = scanner.nextLine();
                String[] words = input.split(" ");
                for (int i = 0 ; i < words.length;i++)
                {
                    if (words[i].equals("STOP")) {
                        keyStop = 1;
                        break;
                    }
                    else if (words[i].equals("ENQUEUE")){
                        int dealNumber ;
                        if (i<words.length - 1)
                            dealNumber = Integer.valueOf(words[i+1]);
                        else
                            continue;
                        if (!map.containsKey(dealNumber))
                            continue;
                        int team = map.get(dealNumber);
                        Member newMember = new Member(dealNumber);
                        if (teams[team] == null){
                            teams[team] = newMember;
                            if (first == null){
                                first = newMember;
                                last = newMember;

                            }
                            else {
                                last.next = newMember;
                                newMember.pre = last;
                                last = newMember;
                            }
                        }
                        else{
                            newMember.next = teams[team].next;
                            newMember.pre = teams[team];
                            teams[team].next = newMember;
                            teams[team] = newMember;
                        }
                        i++;
                    }
                    else if (words[i].equals("DEQUEUE")){
                        if (first == null)
                            continue;
                        for (int j = 0 ;j < teams.length; j++)
                            if (first == teams[j]) {
                                teams[j] = null;
                                break;
                            }
                        answers.get(count).add(first.id+"");
                        first = first.next;
                        if (first != null)
                            first.pre = null;
                    }
                }

                if (input.contains("STOP"))
                    enqueue();
                if (input.contains("ENQUEUE"))
                {



                }
                else if (input.contains("DEQUEUE")){

                }

                if (keyStop == 1)
                    break;
            }while (true);


            count++;
        }while(true);

        int i = 0;
        for (ArrayList<String> answer : answers)
        {

            for (String output : answer)
                System.out.println(output);
            if (i != count-1)
                System.out.println("");
            i++;
        }
    }
    private static void enqueue() {
    }

    private void dequeue(){

    }
}
class Member{
    Member pre,next;
    int id;
    public Member(int id)
    {
        this.id = id;
    }

}
/*
2
3 101 102 103
3 201 202 203
ENQUEUE 101
ENQUEUE 201
ENQUEUE 102
ENQUEUE 202
ENQUEUE 103
ENQUEUE 203
DEQUEUE
DEQUEUE
DEQUEUE
DEQUEUE
DEQUEUE
DEQUEUE
STOP
2
5 259001 259002 259003 259004 259005
6 260001 260002 260003 260004 260005 260006
ENQUEUE 259001
ENQUEUE 260001
ENQUEUE 259002
ENQUEUE 259003
ENQUEUE 259004
ENQUEUE 259005
DEQUEUE
DEQUEUE
ENQUEUE 260002
ENQUEUE 260003
DEQUEUE
DEQUEUE
DEQUEUE
DEQUEUE
STOP
2
3 1 2 3
3 4 5 6
ENQUEUE 1
ENQUEUE 4
ENQUEUE 2
DEQUEUE
DEQUEUE
ENQUEUE 1
DEQUEUE
DEQUEUE
STOP
0

 */