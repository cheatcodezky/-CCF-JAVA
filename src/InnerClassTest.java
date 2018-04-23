import javax.swing.*;

/**
 * Created by 95112 on 2018/3/29.
 */
public class InnerClassTest {
    public static void main(String[] args){
        TalkingClock clock = new TalkingClock(1000,true);
        clock.start();
        JOptionPane.showMessageDialog(null,"Quit programe");
        System.exit(0);
    }
}
