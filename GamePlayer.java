/**
 * Created by 95112 on 2/13/2018.
 */
public class GamePlayer implements IGamePlayer {
    private String name = "";
    public GamePlayer(String _name){
        this.name = _name;
    }
    @Override
    public void login(String user, String password) {
        System.out.println("User : "+user+ " name : "+this.name+" login in successfully");
    }

    @Override
    public void killBoss() {
        System.out.println(this.name + " is killing Boss!");
    }

    @Override
    public void upgrade() {
        System.out.println(this.name + " upgrade!!");
    }
}
