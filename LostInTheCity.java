import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by 95112 on 2/26/2018.
 */
public class LostInTheCity {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N,M;
        char[][] map;
        String input;
        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine();
        map = new char[N][M];
        for (int i = 0 ; i < N; i++) {
            input = scanner.nextLine();
            map[i] =  input.toCharArray();
        }
        char[][] location = new char[3][3];
        for (int i = 0 ; i < 3; i++){
            input = scanner.nextLine();
            location[i] = input.toCharArray();
        }
        char[][] l2,l3,l4;
        l2 = new char[3][3];
        l3 = new char[3][3];
        l4 = new char[3][3];
        for (int i = 0; i< 3; i++)
            for(int j = 0 ; j < 3 ; j++)
            {
                char tmp = location[i][j];
                l2[2-j][i] = tmp;
                l3[2-i][2-j] = tmp;
                l4[j][2-i] = tmp;
            }
        ArrayList<int[]> answers = new ArrayList<>();
        answers.addAll(find(map,location));
        answers.addAll(find(map,l2));
        answers.addAll(find(map,l3));
        answers.addAll(find(map,l4));
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1==null)
                    return 1;
                else if (o2 == null)
                    return -1;
                else {
                    if (o1[0] < o2[0])
                        return -1;
                    else if (o1[0] > o2[0])
                        return 1;
                    else {
                        if (o1[1] < o2[1])
                            return -1;
                        else
                            return 1;
                    }
                }
            }
        };
        answers.sort(comparator);
        HashMap<Integer,ArrayList<Integer>> hashmap = new HashMap<>();
        for (int[] answer:answers){
            if (!hashmap.containsKey(answer[0])) {
                System.out.println(answer[0] + " " + answer[1]);
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(answer[1]);
                hashmap.put(answer[0],arrayList);
            }
            else{
                ArrayList<Integer> arrayList = hashmap.get(answer[0]);
                if (!arrayList.contains(answer[1])){
                    System.out.println(answer[0] + " " + answer[1]);
                    arrayList.add(answer[1]);
                    hashmap.put(answer[0],arrayList);
                }
            }
        }


    }
    private static ArrayList<int[]> find(char[][] map, char[][] around){
        int N,M;
        N = map.length;
        M = map[0].length;
        ArrayList<int[]> answers  = new ArrayList<>();
        for (int i = 0 ; i < N-2;i++)
            for (int j = 0 ; j < M-2; j++)
            {
                if (map[i][j] == around[0][0]){
                    boolean isError = false;
                    for (int x = 0;x <3 ;x++) {
                        if (isError)
                            break;
                        for (int y = 0; y < 3; y++) {
                            if (map[i + x][j + y] != around[x][y]) {
                                isError = true;
                            }
                        }
                    }
                    if (isError == false) {
                        int[] answer = new int[2];
                        answer[0] = i+2;
                        answer[1] = j+2;
                        answers.add(answer);
                    }
                }
            }

        return answers;
    }
}
