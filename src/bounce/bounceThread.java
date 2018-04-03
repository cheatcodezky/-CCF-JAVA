package bounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 95112 on 2018/4/3.
 */
public class bounceThread {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new BounceFrame1();
                frame.setTitle("Ball Game");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });

    }
}
class BallRunnable implements Runnable{
    private Ball ball;
    private Component component;
    public static final int STEPS = 20000;
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
class BounceFrame1  extends JFrame {
    private BallComponent comp;
    public BounceFrame1()
    {
        comp = new BallComponent();
        add(comp,BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel,"Start",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addBall();
            }
        });
        addButton(buttonPanel,"Exit",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(buttonPanel,BorderLayout.SOUTH);
        pack();
    }

    private void addBall() {
        Ball b = new Ball();
        comp.add(b);
        Runnable r = new BallRunnable(b,comp);
        Thread t = new Thread(r);
        t.start();
    }

    private void addButton(JPanel buttonPanel, String start, ActionListener actionListener) {
        JButton button = new JButton(start);
        buttonPanel.add(button);
        button.addActionListener(actionListener);
    }
}

