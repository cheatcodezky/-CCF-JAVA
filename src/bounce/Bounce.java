package bounce;

/**
 * Created by 95112 on 2018/4/3.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Bounce {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                JFrame frame = new BounceFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
class BounceFrame extends JFrame{
    private BallComponent ballComp;
    public static final int STEPS = 1000;
    public static final int DELAY =3;
    public BounceFrame(){
        setTitle("Ball Game");
        ballComp = new BallComponent();
        add(ballComp,BorderLayout.CENTER);
        JPanel buttonPanel =new JPanel();
        addButton(buttonPanel,"Start",new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addBall();
            }
        });
        addButton(buttonPanel, "Close", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(buttonPanel,BorderLayout.SOUTH);
        pack();
    }
    private void addBall() {
        try{
            Ball ball = new Ball();
            ballComp.add(ball);
            for(int i =1 ;  i < STEPS;i++)
            {
                ball.move(ballComp.getBounds());
                ballComp.paint(ballComp.getGraphics());
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addButton(JPanel buttonPanel, String start, ActionListener actionListener) {
        JButton button = new JButton(start);
        buttonPanel.add(button);
        button.addActionListener(actionListener);
    }
}

