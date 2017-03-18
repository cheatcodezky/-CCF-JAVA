import java.util.Scanner;

/**
 * Created by ZhouKeyu on 17-3-17.
 */
public class CCF_201612_3authorization {
    private static String[][] authority;
    private static Character_class[] character;
    private static User_class[] user;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        String[] p_input = new String[p];
        authority = new String[p][2];
        for (int i=0;i<p;i++)
        {
            p_input[i] = scanner.next();
        }
        deal_authority(p_input);

        int r = scanner.nextInt();
        scanner.nextLine();
        String[] r_input = new String[r];

        character = new Character_class[r];


        for (int i =0 ; i<r;i++)
        {
            r_input[i] = scanner.nextLine();

        }
        for (int i = 0 ; i<r; i++)
        {
            character[i] = new Character_class(r_input[i]);
        }

        int u = scanner.nextInt();
        scanner.nextLine();
        String[] u_input = new String[u];
        user = new User_class[u];
        for (int i= 0;i<u;i++)
        {
            u_input[i] = scanner.nextLine();
        }
        for(int i=0; i<u;i++)
        {
            user[i] = new User_class(u_input[i]);
        }

        int q = scanner.nextInt();
        scanner.nextLine();
        String[] q_input = new String[q];
        for (int i=0;i<q;i++)
        {
            q_input[i] = scanner.nextLine();
        }

        for (int i=0;i<q;i++)
        {
            int a = judge(q_input[i]);
            if(a ==Integer.MAX_VALUE)
                System.out.println("true");
            else if (a == Integer.MIN_VALUE)
                System.out.println("false");
            else
                System.out.println(a);
        }

    }
    public static void deal_authority(String[] p_input)
    {
        for (int i=0;i<p_input.length;i++)
        {
            String deal_aim =p_input[i];
            String[] a = deal_aim.split("\\:");
            if (a.length ==2)
            {
                authority[i][0] = a[0];
                authority[i][1] = a[1];
            }
            else
            {
                authority[i][0] = a[0];
                authority[i][1] = "0";
            }
        }
    }

    private static class Character_class
    {
        public String name;
        public String[][] charac_authority;
        public Character_class(String str)
        {
            String[] deal_str = str.split("\\ ");
            name = deal_str[0];
            charac_authority = new String[Integer.valueOf(deal_str[1])][2];
            for (int i =2 ; i<deal_str.length;i++)
            {
                String[] authro = autho_split(deal_str[i]);
                charac_authority[i-2][0] = authro[0];
                charac_authority[i-2][1] = authro[1];
            }
        }
    }
    public static class User_class
    {
        public String name;
        public String[] user_character;
        public Character_class[] user_character_class;
        public String[][] authority = new String[1000][2];
        public  int count = 0;
        public User_class(String str)
        {
            String[] deal_str = str.split("\\ ");
            name = deal_str[0];
            int number = Integer.valueOf(deal_str[1]);

            user_character = new String[number];
            user_character_class = new Character_class[number];
            for (int i =2;i<deal_str.length;i++)
            {
                user_character[i-2] = deal_str[i];
                for (int j =0;j<character.length;j++)
                {
                    if (user_character[i-2].equals(character[j].name))
                    {
                        user_character_class[i-2] = character[j];
                        break;
                    }
                }
            }

            for (int i =0;i<user_character_class.length;i++)
                for (int j=0;j<user_character_class[i].charac_authority.length;j++)
                {

                    authority[count][0] = user_character_class[i].charac_authority[j][0];
                    authority[count][1] = user_character_class[i].charac_authority[j][1];
                    count++;
                }

        }
    }
    public static String[] autho_split(String input)
    {
        String[] result = new String[2];
        String[] split_result = input.split("\\:");
        if (split_result.length==2)
        {
            result[0] = split_result[0];
            result[1] = split_result[1];
        }
        else
        {
            result[0] = split_result[0];
            result[1] = "-1";
        }
        return result;
    }
    public static int judge(String input)
    {
        String[] deal = input.split("\\ ");
        String[] aim = new String[3];
        aim[0] = deal[0];
        String[] authorization = autho_split(deal[1]);
        aim[1] = authorization[0];
        aim[2] = authorization[1];
        if (deal[1].split("\\:").length ==2)
            for (int i=0;i<user.length;i++)
            {
                if (user[i].name.equals(aim[0]))
                {
                    for (int j=0;j<user[i].count;j++)
                    {

                        if (user[i].authority[j][0].equals(aim[1])&&Integer.valueOf(user[i].authority[j][1])>=Integer.valueOf(aim[2]))
                            return Integer.MAX_VALUE;
                    }


                }
            }
        else
            for (int i=0;i<user.length;i++)
                if (user[i].name.equals(aim[0]))
                {
                    int max =Integer.MIN_VALUE;
                    for (int j=0;j<user[i].count;j++)
                    {
                        if (user[i].authority[j][0].equals(aim[1])&&Integer.valueOf(user[i].authority[j][1])>=Integer.valueOf(aim[2])&&Integer.valueOf(user[i].authority[j][1])>max)
                        {
                          max =   Integer.valueOf(user[i].authority[j][1]);
                        }
                    }
                    if (max == -1)
                        return Integer.MAX_VALUE;
                    else
                        return max;
                }
        return Integer.MIN_VALUE;
    }

}
