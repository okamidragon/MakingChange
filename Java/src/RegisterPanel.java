import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private final Register register;
    private final JTextField input;
    private final PursePanel changePanel;

    public RegisterPanel(Register register) {
        this.register = register;
        this.input = new JTextField(10);
        this.changePanel = new PursePanel();

        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Amount:"));
        inputPanel.add(input);
        add(inputPanel, BorderLayout.NORTH);
        add(changePanel, BorderLayout.CENTER);

        input.addActionListener(new InputListener());
    }

    private class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(input.getText());
                Purse change = register.makeChange(amount);
                changePanel.setPurse(change);
                changePanel.repaint();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(RegisterPanel.this, "Invalid amount");
            }
        }
    }
}
