import java.util.Scanner;

/**
 * Created by 95112 on 2/22/2018.
 */
public class CharacterDelete {
    public static int residue(String deal){
        int length = deal.length();
        if (length == 0)
            return 0;
        char[] aimDeal = deal.toCharArray();
        StringBuffer nextDeal = new StringBuffer();
        char now = aimDeal[0];
        int count = 1;
        for (int i = 1 ; i < length; i++){
            if (now == aimDeal[i]){
                count++;
            }
            else{
                if (count == 1){
                    nextDeal.append(now);
                    now = aimDeal[i];
                }
                else{
                    count = 1;
                    now = aimDeal[i];
                }
            }
        }
        if (count == 1)
            nextDeal.append(now);
        if (nextDeal.length() == length )
            return length;
        else {
           return residue(nextDeal.toString());
        }

    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        while(number>0){
            int min = 111;
            String input = scanner.nextLine();
            StringBuffer deal = new StringBuffer(input);
            for (int i = 0 ; i <= deal.length();i++){
                for (char c = 'A';c <= 'C';c++){
                    StringBuffer stringBuffer = new StringBuffer(input);
                    stringBuffer.insert(i,c);
                    int now = residue(stringBuffer.toString());
                    min = min < now? min : now;
                }
            }
            System.out.println(deal.length() - min +1);
            number--;
        }
    }
}
