package software.development.project.draw;

import java.awt.*;

public interface Draw {
    void drawBlock(Graphics g, String text, Font font, Rectangle rect, Color colorText, Color colorRect);
    void drawVerticalText(Graphics g, String text, Font font, int x, int y, Color color);
    void drawRect(Graphics g, Rectangle rect, Color fill, Color border);
}
