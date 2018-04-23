/**
 * Created by 95112 on 2018/4/21.
 */
public class Diamond {
    public static void main(String[] args)
    {

        int end = 31;
        int halfWidth = end/2+1;
        for(int i = 1 ; i<=end;i++)
        {

            for (int j = 1; j <= Math.abs(halfWidth-i);j++){
                System.out.print(" ");
            }
            System.out.print("*");
            if (i!= 1 && i!= end) {
                for (int j = 1; j <(halfWidth - Math.abs(halfWidth - i) - 1) * 2; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
