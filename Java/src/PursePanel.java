import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse = new Purse();

    public void setPurse(Purse purse) {
        this.purse = purse;
        repaint();  // Request to repaint the panel when the purse is updated
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the content of the purse
        int y = 20;  // Starting y position for drawing
        g.setFont(new Font("Arial", Font.PLAIN, 14));  // Set font for better readability

        for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
            Denomination denom = entry.getKey();
            int count = entry.getValue();
            String text = String.format("%d %s",  count, denom.name());
            g.drawString(text, 20, y);
            y += 20;  // Move down for the next line
        }
    }
}
