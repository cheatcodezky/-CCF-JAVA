package 回溯;

/**
 * Created by max on 17-5-14.
 */
public class DifficultNumber {

    static int n ;
    static int[] S ;
    static int L;
    static int dfs(int cur)
    {
        if (cur == n)
        {
            for (int i = 0 ; i <cur ; i++)
            {
                System.out.print(" "+('A'+S[cur]));
            }
            System.out.println(" ");
            return 0;
        }


        for (int i = 0; i<L; i++)
        {
            S[cur]  = i;
            boolean ok =true;

            for (int j =1;j*2<=cur+1;j++)
            {
                int equal = 1;
                for (int k = 0;k<j;k++)
                    if (S[cur-k]!=S[cur-k-j]){equal=0;break;}
                if (equal==1)
                {
                    ok = false;
                    break;
                }
                if (ok)if(dfs(cur+1)!=1)return 0;
            }
        }
        return 1;
    }
    public static void main(String[] args)
    {
        
    }

}
