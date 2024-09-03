/* Maddock Davis
Lab 1 - Making Change
Takes an amount of money from the user and shows how man coins or bills makes it. */
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

// Main class for the purse panel
public class PursePanel extends JPanel {
    private Purse purse = new Purse();
    private static final int IMAGE_WIDTH = 150;
    private static final int IMAGE_HEIGHT = 100;

    // Sets the layout of the panel
    public PursePanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    // Gets the information about the purse for the panel
    public void setPurse(Purse purse) {
        this.purse = purse;
        updateImages();
    }

    // Clear the panel before adding new images, also resizes images
    private void updateImages() {
        removeAll();

        for (Map.Entry<Denomination, Integer> entry : purse.getCash().entrySet()) {
            Denomination denoms = entry.getKey();
            int count = entry.getValue();
            ImageIcon icon = new ImageIcon(denoms.img());

            if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
                System.out.println("Failed to load image: " + denoms.img());
                continue;
            }

            Image resizedImage = resizeImage(icon.getImage(), IMAGE_WIDTH, IMAGE_HEIGHT);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);

            for (int i = 0; i < count; i++) {
                JLabel label = new JLabel(resizedIcon);
                add(label);
            }
        }

        revalidate();
        repaint();
    }

    // Makes the images fit on the screen
    private Image resizeImage(Image originalImage, int width, int height) {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, width, height, null);
        g2d.dispose();
        return bufferedImage;
    }

    // Sets the dimensions of the panel
    public Dimension getPreferredSize() {
        return new Dimension(600, 600); // Adjust as needed to fit the images
    }
}
