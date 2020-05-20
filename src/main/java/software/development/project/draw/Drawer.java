package software.development.project.draw;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Drawer implements Draw {

    public Drawer() {
    }

    private void drawStringMultiLine(Graphics g, String text, int lineWidth, int x, int y, Rectangle rect) {
        FontMetrics m = g.getFontMetrics();
        if (m.stringWidth(text) < lineWidth) {
            x = rect.x + (rect.width - m.stringWidth(text)) / 2;
            g.drawString(text, x, y);
        } else {
            String[] words = text.split(" ");
            String currentLine = words[0];
            for (int i = 1; i < words.length; i++) {
                if (m.stringWidth(currentLine + words[i]) < lineWidth) {
                    currentLine += " " + words[i];
                } else {
                    x = rect.x + (rect.width - m.stringWidth(currentLine)) / 2;
                    y -= m.getHeight() / 2;
                    g.drawString(currentLine, x, y);
                    y += m.getHeight();
                    currentLine = words[i];
                }
            }
            if (currentLine.trim().length() > 0) {
                x = rect.x + (rect.width - m.stringWidth(currentLine)) / 2;
                g.drawString(currentLine, x, y);
            }
        }
    }

    public void drawBlock(Graphics g, String text, Font font, Rectangle rect, Color colorText, Color colorRect) {
        Graphics2D g2 = (Graphics2D) g;
        int x;
        int y;
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        x = rect.x + (rect.width - metrics.stringWidth(text.split(" ")[0])) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();

        // Set the font
        g2.setFont(font);
        // Draw the String
        g2.setColor(colorRect);
        g2.drawRect(rect.x, rect.y, rect.width, rect.height);
        g2.fillRect(rect.x, rect.y, rect.width, rect.height);
        g2.setColor(colorText);
        drawStringMultiLine(g, text, rect.width - 10, x, y, rect);
    }

    public void drawVerticalText(Graphics g, String text, Font font, int x, int y, Color color) {
        Graphics2D g2 = (Graphics2D) g;

        // Define rendering hint, font name, font style and font size
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(font);
        g2.setColor(color);

        // Rotate 90 degree to make a vertical text
        AffineTransform orig = g2.getTransform();

        AffineTransform at = new AffineTransform();
        at.rotate(-Math.PI / 2);
        g2.setTransform(at);

        g2.drawString(text, -y, x);

        g2.setTransform(orig);
    }

    @Override
    public void drawRect(Graphics g, Rectangle rect, Color fill, Color border) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(border);
        g2.drawRect(rect.x, rect.y, rect.width, rect.height);
        g2.setColor(fill);
        g2.fillRect(rect.x, rect.y, rect.width, rect.height);
    }
}
