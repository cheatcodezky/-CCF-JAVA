import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by 95112 on 2018/3/29.
 */
public class TalkingClock {
    private int interval;
    private boolean beep;
    public TalkingClock(int interval,boolean beep){
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {

    }

    private class TimePrinter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Date now = new Date();
            System.out.println("At the tone, the time is "+now);
            if(beep) Toolkit.getDefaultToolkit().beep();
        }
    }

}
