package src.main.java.com.ui;

import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton {
    private int cornerRadius;

    public RoundedButton(String text, int cornerRadius) {
        super(text);
        this.cornerRadius = cornerRadius;
        setContentAreaFilled(false); // Menghilangkan area default tombol
        setFocusPainted(false); // Menghilangkan garis fokus tombol
        setBorderPainted(false); // Menghilangkan border default tombol
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        g2.setColor(getForeground());
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(getText());
        int textHeight = fm.getHeight();
        int textX = (getWidth() - textWidth) / 2;
        int textY = (getHeight() + textHeight) / 2 - fm.getDescent();
        g2.drawString(getText(), textX, textY);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
        g2.dispose();
    }
}
