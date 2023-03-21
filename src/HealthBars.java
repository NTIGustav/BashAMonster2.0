import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;

public class HealthBars extends JPanel implements ActionListener {
    private int player1Health;
    private int player2Health;
    private int maxHealth = 100;
    private JButton player1Button;
    private JButton player2Button;
    private Random random;

    public HealthBars() {
        // Metoden för start "healthbar"
        player1Health = maxHealth;
        player2Health = maxHealth;

        // En knapp per "Spelare"
        player1Button = new JButton("Punch p2");
        player1Button.addActionListener(this);
        player2Button = new JButton("Kick p1");
        player2Button.addActionListener(this);

        // Lägger till knappen till window
        add(player1Button);
        add(player2Button);

        // Random skada
        random = new Random();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Fonttexten samt färgen på texten
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.BLACK);

        // Spelare 1 healthbar
        g.drawString("Player 1", 50, 50);
        g.setColor(Color.RED);
        g.fillRect(50, 60, player1Health, 20);

        // Spelare 2 healthbar
        g.setColor(Color.BLACK);
        g.drawString("Player 2", 50, 100);
        g.setColor(Color.BLUE);
        g.fillRect(50, 110, player2Health, 20);
    }

    public void actionPerformed(ActionEvent e) {
        // Kolla att knappen var klickad
        if (e.getSource() == player1Button) {
            // Skapar skadan lite random så där för spelare 2
            int damage = random.nextInt(maxHealth / 10) + 1;

            // ta bort hp från spelare 2
            player2Health = Math.max(player2Health - damage, 0);

            // uppdatera healthbaren
            repaint();
        } else if (e.getSource() == player2Button) {
            // Skapar skan lite random så där för spelare 1
            int damage = random.nextInt(maxHealth / 10) + 1;

            // samma som där uppe fast för spelare 1
            player1Health = Math.max(player1Health - damage, 0);

            // uppdatera hp
            repaint();
        }
    }

}

