import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;

public class Window {
    // gör så att skiten fungerar
    JFrame frame = new JFrame();
Window(){
    //fönster storleken
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.getContentPane().setBackground(Color.white);
            frame.setTitle("BashAMonster2.0");
            frame.setLayout(new BorderLayout());
            frame.setVisible(true);

            HealthBars panel = new HealthBars();
            panel.setPreferredSize(new Dimension(300, 200));

            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);
}

//så att healthbaren syns
}
