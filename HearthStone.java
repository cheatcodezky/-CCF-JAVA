
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by max on 17-3-18.
 */

public class HearthStone {
    public static User[] users= new User[2];
    public static int key =0;
    public static void main(String[] args)
    {
        users[0] = new User(0);
        users[1] = new User(1);

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        String[] input = new String[number];
        for (int i = 0 ; i<number;i++)
        {
            input[i] = scanner.nextLine();
        }
        int who = 0;
        for (int i = 0; i< number ; i++)
        {
            String[] deal = input[i].split("\\ ");
            if (deal[0].equals("summon"))
            {

                users[who%2].summon(Integer.valueOf(deal[1]),Integer.valueOf(deal[2]),Integer.valueOf(deal[3]));
            }
            else if(deal[0].equals("end"))
            {

                who++;
            }
            else if (deal[0].equals("attack"))
            {

                users[who%2].attack(users[who%2],users[(1+(who%2))%2],Integer.valueOf(deal[1]),Integer.valueOf(deal[2]));
            }
        }
        System.out.println(0);
        for (int i = 0; i < 2&&key==0; i++) {
            System.out.println(users[i].health);
            System.out.print(users[i].follwers_number);
            for (int j = 0; j < users[i].follwers_number; j++) {
                System.out.print(" " + users[i].followers.get(j).health);
            }
            System.out.print('\n');
        }

    }
    static class Follower
    {
        public int health;
        public int attack;
        public int location=-1;
        public Follower(int location,int attack,int health)
        {
            this.health = health;
            this.attack = attack;
            this.location = location;
        }

    }
    static class User
    {
        public static int id;
        public int health ;
        public int follwers_number;
        public Vector<Follower> followers = new Vector<Follower>(7) ;
        public User(int id)
        {
            this.id = id;
            health = 30;
            follwers_number = 0;
        }
        public void summon(int position,int attack,int health)
        {
            if (position == (follwers_number+1))
                followers.add(new Follower(position,attack,health));
            else
                followers.add(position-1,new Follower(position,attack,health));
            follwers_number++;
        }
        public void attack(User user_attack,User user_defend,int attacker,int defender)
        {
            attacker=attacker-1;
            if (defender==0)
            {
                user_defend.health = user_defend.health - user_attack.followers.get(attacker).attack;

            }
            else
            {
                defender =defender-1;
                user_defend.followers.get(defender).health = user_defend.followers.get(defender).health - user_attack.followers.get(attacker).attack;
                user_attack.followers.get(attacker).health = user_attack.followers.get(attacker).health - user_defend.followers.get(defender).attack;

            }
            refresh();


        }
        public void refresh()
        {
            for (int i= 0; i<=1;i++) {
                int count ;
                int judge = 0;

                while (judge==0)
                {

                    count =0;
                    for (int j = 0; j < users[i].follwers_number; j++) {
                        if (users[i].followers.get(j).health <= 0) {
                            users[i].followers.remove(j);
                            users[i].follwers_number--;
                            count = 1;
                            break;
                        }
                    }
                    if (count ==1)
                        continue;
                    judge = 1;

                }


            }
            if(users[0].health<=0||users[1].health<=0) {
                if (users[0].health <= 0)
                    System.out.println("-1");
                else
                    System.out.println("1");
                for (int i = 0; i < 2; i++) {
                    System.out.println(users[i].health);
                    System.out.print(users[i].follwers_number);
                    for (int j = 0; j < users[i].follwers_number; j++) {
                        System.out.print(" " + users[i].followers.get(j).health);
                    }
                    System.out.print('\n');
                    key =1;
                }

            }
        }

    }


}

