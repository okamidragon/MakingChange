/* Maddock Davis
Lab 1 - Making Change
Takes an amount of money from the user and shows how man coins or bills makes it. */
import javax.swing.*;

// The main function of the program
public class MakingChange {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Making Change");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.add(new RegisterPanel());
            frame.setVisible(true);
        });
    }
}
