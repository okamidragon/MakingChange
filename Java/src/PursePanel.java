import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse = new Purse();
    private static final int IMAGE_WIDTH = 150;
    private static final int IMAGE_HEIGHT = 100;

    public PursePanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT)); // Use FlowLayout to display images in rows
    }

    public void setPurse(Purse purse) {
        this.purse = purse;
        updateImages();
    }

    private void updateImages() {
        removeAll(); // Clear the panel before adding new images

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

    private Image resizeImage(Image originalImage, int width, int height) {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, width, height, null);
        g2d.dispose();
        return bufferedImage;
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 600); // Adjust as needed to fit the images
    }
}
