import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuiThreadExample extends JFrame{

    private JButton topButton = new JButton("start");
    private JButton bottomButton = new JButton("Click me");


    public GuiThreadExample(){

        super("Threads und GUI");
        this.setSize(400,400);

        Random random = new Random();
        int value = random.nextInt(5)+2;


        this.setLayout(new BorderLayout());

        this.add(topButton, BorderLayout.NORTH);
        this.add(bottomButton,BorderLayout.SOUTH);

        bottomButton.setEnabled(false);

        topButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Thread(){

                    public void run(){
                        bottomButton.setEnabled(true);

                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        bottomButton.setBackground(Color.GREEN);
                    }
                }.start();


            }
        });


        bottomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                bottomButton.setBackground(null);
                bottomButton.setEnabled(false);
            }
        });

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
