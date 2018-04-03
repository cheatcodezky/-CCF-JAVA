/**
 * Created by 95112 on 2/13/2018.
 */
public class GamePlayerProxy implements IGamePlayer {

    private  IGamePlayer player = null;
    public GamePlayerProxy (IGamePlayer _gamePlayer){
        player = _gamePlayer;
    }

    @Override
    public void login(String user, String password) {
        this.player.login(user,password);
    }

    @Override
    public void killBoss() {
        this.player.killBoss();
    }

    @Override
    public void upgrade() {
        this.player.upgrade();
    }
}
