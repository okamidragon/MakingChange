import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse = new Purse();

    public void setPurse(Purse purse) {
        this.purse = purse;
        repaint(); // Repaint when purse is updated
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = 10, y = 20;
        for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
            Denomination denom = entry.getKey();
            int count = entry.getValue();
            ImageIcon icon = new ImageIcon( denom.img());
            System.out.print("attempting to load: " + denom.img());

            for (int i = 0; i < count; i++) {
                g.drawImage(icon.getImage(), x, y, this);
                x += icon.getIconWidth() + 5;
                if (x > getWidth() - 100) {
                    x = 10;
                    y += icon.getIconHeight() + 5;
                }
            }
        }
    }
}
