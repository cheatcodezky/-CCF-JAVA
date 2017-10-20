import java.util.*;

/**
 * Created by 95112 on 10/19/2017.
 */
public class WhereIsTheMarble {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        List<List<String>> answers = new ArrayList<>();
        int N, Q;

        ArrayList<Integer> map;
        int count = 0;
        do {
            N  = scanner.nextInt();
            Q = scanner.nextInt();
            if (N == 0 && Q == 0)
                break;
            answers.add(new ArrayList());
            map = new ArrayList<>();
            int input ;
            for (int i=0 ;i < N; i++)
            {
                input = scanner.nextInt();
                map.add(input);
            }
            Collections.sort(map);

            HashMap<Integer,Integer> test = new HashMap<>();
            int tmp ;
            for (int i = 0 ; i < map.size(); i++)
            {
                tmp = map.get(i);
                if (!test.containsKey(tmp))
                    test.put(tmp,i+1);
            }
            for (int i = 0 ; i < Q; i++)
            {
                input = scanner.nextInt();
                if (test.containsKey(input))
                {

                    answers.get(count).add(input + " found at "+ (test.get(input)));
                }
                else
                {
                    answers.get(count).add(input + " not found");
                }
            }
            count++;

        }while (true);
        for (int i = 0; i < answers.size();i++)
        {
            System.out.println("CASE# "+ (i+1)+":");
            for (String answer : answers.get(i))
                System.out.println(answer);
        }
    }
}
