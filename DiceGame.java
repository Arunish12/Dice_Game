
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class DiceGame extends JFrame {
    private JLabel dice1Label, dice2Label, resultLabel;
    private JButton rollButton;
    private Random random;
    private ImageIcon[] diceIcons;

    public DiceGame() {
        super("Dice Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(3, 2));

        // Load dice images
        diceIcons = new ImageIcon[6];
        for (int i = 0; i < 6; i++) {
            diceIcons[i] = new ImageIcon("dice" + (i+1) + ".png");
        }

        dice1Label = new JLabel(diceIcons[0], SwingConstants.CENTER);
        dice2Label = new JLabel(diceIcons[0], SwingConstants.CENTER);
        resultLabel = new JLabel("Total: -", SwingConstants.CENTER);

        rollButton = new JButton("Roll Dice");

        random = new Random();

        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dice1 = random.nextInt(6);
                int dice2 = random.nextInt(6);
                int total = dice1 + dice2 + 2;

                dice1Label.setIcon(diceIcons[dice1]);
                dice2Label.setIcon(diceIcons[dice2]);
                resultLabel.setText("Total: " + total);
            }
        });

        add(dice1Label);
        add(dice2Label);
        add(resultLabel);
        add(new JLabel()); // Empty cell
        add(rollButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new DiceGame();
    }
}
