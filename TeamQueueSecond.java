import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by 95112 on 10/20/2017.
 */
public class TeamQueueSecond {
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<String>> answers = new ArrayList<>();
        int count = 1;
        do {

            LinkedList<Integer>[] teamList;
            LinkedList<Integer> mList = new LinkedList<>();
            int t = scanner.nextInt();
            if (t == 0)
                break;

            ArrayList<String> tmpArrayList = new ArrayList<>();
            tmpArrayList.add("Scenario #"+count);


            teamList = new LinkedList[t];
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0 ; i < t ; i++)
            {
                int tmp = scanner.nextInt();
                while (tmp!=0){
                    map.put(scanner.nextInt(),i);
                    tmp--;
                }

            }
            String input;
            do {
                input = scanner.next();
                if (input.equals("STOP"))
                    break;
                else if (input.equals("ENQUEUE")){
                    String num = scanner.next();
                    int number = Integer.valueOf(num);
                    int key = map.get(number);
                    if (teamList[key] == null){
                        teamList[key] = new LinkedList<>();
                        teamList[key].add(number);
                        mList.add(key);

                    }
                    else {
                        if (teamList[key].isEmpty())
                        {
                            teamList[key].add(number);
                            mList.add(key);

                        }
                        else {
                            teamList[key].add(number);
                        }
                    }
                }
                else {
                    int teamId = mList.getFirst();
                    tmpArrayList.add(teamList[teamId].removeFirst()+"");
                    if (teamList[teamId].isEmpty())
                        mList.removeFirst();
                }
            }while(true);
            answers.add(tmpArrayList);
            count++;
        }while(true);
        for (ArrayList<String> answer : answers){
            for (String a : answer)
                System.out.println(a);
            System.out.println("");
        }
    }
}
