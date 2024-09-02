import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Main class for the register panel
public class RegisterPanel extends JPanel {
    private final Register register = new Register();
    private final JTextField input = new JTextField(10);
    private final PursePanel changePanel = new PursePanel();

    // Creates the register panel
    public RegisterPanel() {
        input.addActionListener(new InputListener());
        add(new JLabel("Enter Amount:"));
        add(input);
        add(changePanel);
    }

    // Takes the amount input by the user
    private class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(input.getText());
                Purse purse = register.makeChange(amount);
                changePanel.setPurse(purse);
            }

            // Checks if the amount input is invalid
            catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(RegisterPanel.this, "Invalid amount");
            }
        }
    }
}
