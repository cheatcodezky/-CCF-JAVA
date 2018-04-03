package bounce;

import java.awt.*;

/**
 * Created by 95112 on 2018/4/3.
 */
public class bounceThread {
    public static void main(String[] args)
    {

    }
}
class BallRunnable implements Runnable{
    private Ball ball;
    private Component component;
    public static final int STEPS = 2000;
    public static final int DELAY = 5;
    public BallRunnable(Ball aBall,Component aComponent){
        ball = aBall;
        component = aComponent;
    }
    @Override
    public void run() {
        try{
            for(int i=0;i<=STEPS;i++){
                ball.move(component.getBounds());
                component.repaint();
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

