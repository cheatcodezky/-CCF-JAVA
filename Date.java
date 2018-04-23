import java.util.*;

/**
 * Created by 95112 on 2018/4/19.
 */
public class Date {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T =  scanner.nextInt();
        ArrayList<Boolean> answer = new ArrayList<>();
        int N,M;
        int u,v;
        while(T>0){
            N = scanner.nextInt();
            M = scanner.nextInt();
//            boolean[][] map = new boolean[N][N];
            Stack<Integer>[] map = new Stack[N];
            for (int i=0; i < N;i++)
                map[i] = new Stack();
            while (M>0){
                u = scanner.nextInt();
                v = scanner.nextInt();
                map[u-1].push(v-1);
                map[v-1].push(u-1);
//                map[u-1][v-1] = true;
//                map[v-1][u-1] = true;
                M--;
            }
            int[] people = new int[N];
            Queue<Integer> queue = new LinkedList<>();
            boolean error = false;
            for (int i = 0 ; i<N;i++){
                if (people[i] == 0)
                    people[i] = 1;
                else
                    continue;
                queue.offer(i);
                int who;
                while(!queue.isEmpty()){

                    who = queue.poll();
                    for (int next:map[who]){
                        if (people[next] == 0) {
                            people[next] = -people[who];
                            queue.offer(next);
                        }
                        else if(people[next] == people[who])
                            error = true;
                        if (error)
                            break;
                    }
                    if (error)
                        break;
                }
                if (error)
                    break;
            }
            if (error)
                answer.add(false);
            else
                answer.add(true);
            T--;
////            Stack<Integer> stack = new Stack<>();
////            stack.push(0);
//            boolean error = false;
//            HashMap<Integer,Boolean> passed = new HashMap<>();
//            for (int j=0; j< N;j++) {
//                if (passed.containsKey(j))
//                    continue;
//                people[j] = 1;
//                passed.put(j,true);
//                queue.offer(j);
//                int who;
//                while (!queue.isEmpty()) {
////                who = stack.pop();
//                    who = queue.poll();
//                    for (int i = 0; i < N; i++) {
//                        if (i == who)
//                            continue;
//                        if (map[who][i]) {
//                            passed.put(i,true);
//                            if (people[i] == 0) {
//                                people[i] = -people[who];
//                                //stack.push(i);
////                                for (int z =0; z < N;z++){
////                                    System.out.print(people[z]+" ");
////                                }
////                                System.out.println(" ____"+"who : "+who+" i : "+i);
//                                queue.offer(i);
//                            }
//                            if (people[i] == people[who]) {
//                                error = true;
//                                break;
//                            }
//                        }
//                    }
//                    if (error)
//                        break;
//                }
//                if (error)
//                    break;
//            }
//            if (error)
//                answer.add(false);
//            else
//                answer.add(true);

        }
        for (Boolean b : answer){
            if (b)
                System.out.println("Correct");
            else
                System.out.println("Wrong");
        }
    }
}
