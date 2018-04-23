/**
 * Created by 95112 on 2/13/2018.
 */
public class Client {
    public static void main(String[] args)
    {
        IGamePlayer player = new GamePlayer("Jack");
        System.out.println("time 10:05 2/13/2018");
        player.login("zzze","0sdf1");
        player.killBoss();
        player.upgrade();
    }
}
