import javax.swing.*;

public class MakingChange {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Making Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setContentPane(new RegisterPanel(new Register()));
        frame.setVisible(true);
    }
}
