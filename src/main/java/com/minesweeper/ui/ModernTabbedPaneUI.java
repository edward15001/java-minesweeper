package com.minesweeper.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;

public class ModernTabbedPaneUI extends BasicTabbedPaneUI {

    @Override
    protected void installDefaults() {
        super.installDefaults();
        tabPane.setBackground(Theme.BG_COLOR);
        tabPane.setForeground(Theme.FG_COLOR);
        tabPane.setOpaque(true);
    }

    @Override
    protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
        // Paint the background of the tab area to match the app background
        g.setColor(Theme.BG_COLOR);
        g.fillRect(0, 0, tabPane.getWidth(), tabPane.getHeight());
        super.paintTabArea(g, tabPlacement, selectedIndex);
    }

    @Override
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h,
            boolean isSelected) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Calculate a perfect capsule shape
        int arc = h - 8;

        if (isSelected) {
            // Selected tabs use the vibrant accent color
            g2.setColor(Theme.ACCENT_COLOR);
            g2.fillRoundRect(x + 2, y + 4, w - 4, h - 6, arc, arc);
        } else {
            // Inactive tabs use the panel background color and are slightly smaller/lower
            g2.setColor(Theme.PANEL_BG);
            g2.fillRoundRect(x + 2, y + 6, w - 4, h - 8, arc, arc);
        }

        g2.dispose();
    }

    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h,
            boolean isSelected) {
        // We handle the shape entirely in paintTabBackground
    }

    @Override
    protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex,
            Rectangle iconRect, Rectangle textRect, boolean isSelected) {
        // Remove the dotted focus outline around text for a cleaner look
    }

    @Override
    protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = tabPane.getWidth();
        int height = tabPane.getHeight();
        Insets insets = tabPane.getInsets();

        int y = insets.top + calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight);

        // Draw a clean subtle line/box for the content panel below the tabs
        g2.setColor(Theme.PANEL_BG);
        g2.drawRoundRect(insets.left, y, width - insets.right - insets.left - 1, height - y - insets.bottom - 1, 10,
                10);

        g2.dispose();
    }

    @Override
    protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex, String title,
            Rectangle textRect, boolean isSelected) {
        Graphics2D g2 = (Graphics2D) g.create();
        // Enable high quality text rendering
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setFont(Theme.BOLD_FONT);

        if (isSelected) {
            g2.setColor(Color.WHITE); // High contrast for accent background
        } else {
            g2.setColor(new Color(160, 170, 210)); // Soft grayish blue for readability
        }

        FontMetrics fm = g2.getFontMetrics();
        // Dynamically measure true center for the string
        int textX = textRect.x + (textRect.width - fm.stringWidth(title)) / 2;
        int textY = textRect.y + (textRect.height - fm.getHeight()) / 2 + fm.getAscent();

        // Adjust text height slightly to match the pill's visual center
        if (isSelected) {
            textY -= 1;
        } else {
            textY += 1;
        }

        g2.drawString(title, textX, textY);
        g2.dispose();
    }

    @Override
    protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
        // Give tabs much more horizontal breathing room
        return super.calculateTabWidth(tabPlacement, tabIndex, metrics) + 40;
    }

    @Override
    protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
        // Give tabs more vertical height for the capsule shape
        return super.calculateTabHeight(tabPlacement, tabIndex, fontHeight) + 16;
    }

    @Override
    protected Insets getTabInsets(int tabPlacement, int tabIndex) {
        return new Insets(6, 20, 6, 20);
    }
}
