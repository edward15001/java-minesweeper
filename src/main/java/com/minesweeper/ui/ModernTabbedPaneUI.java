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
        // Paint the background of the tab area with the main app background color
        g.setColor(Theme.BG_COLOR);
        g.fillRect(0, 0, tabPane.getWidth(), tabPane.getHeight());
        super.paintTabArea(g, tabPlacement, selectedIndex);
    }

    @Override
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h,
            boolean isSelected) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (isSelected) {
            g2.setColor(Theme.PANEL_BG);
        } else {
            g2.setColor(new Color(28, 35, 60)); // Slightly lighter than pure background for unselected tabs
        }

        // Draw the tab shape with rounded top corners
        int arc = 20;
        g2.fillRoundRect(x, y + 5, w, h + arc, arc, arc);

        g2.dispose();
    }

    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h,
            boolean isSelected) {
        // We handle the shape in paintTabBackground, so no default border
    }

    @Override
    protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex,
            Rectangle iconRect, Rectangle textRect, boolean isSelected) {
        // Remove the dotted focus outline around text
    }

    @Override
    protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
        // Remove the default 3D border around the tab's content panel
        int width = tabPane.getWidth();
        int height = tabPane.getHeight();
        Insets insets = tabPane.getInsets();

        int x = insets.left;
        int y = insets.top;
        int w = width - insets.right - insets.left;
        int h = height - insets.top - insets.bottom;

        y += calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight);
        h -= (y - insets.top);

        // Fill background of the content border area to avoid flashing gray/white
        g.setColor(Theme.PANEL_BG);
        g.fillRect(x, y, w, h);
    }

    @Override
    protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex, String title,
            Rectangle textRect, boolean isSelected) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setFont(Theme.BOLD_FONT);

        if (isSelected) {
            g2.setColor(Theme.FG_COLOR);
        } else {
            g2.setColor(new Color(150, 160, 200)); // Distinct inactive text color
        }

        int textX = textRect.x;
        int textY = textRect.y + metrics.getAscent() + 5; // offset slightly for new bounds
        g2.drawString(title, textX, textY);
        g2.dispose();
    }

    @Override
    protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
        return super.calculateTabWidth(tabPlacement, tabIndex, metrics) + 24;
    }

    @Override
    protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
        return super.calculateTabHeight(tabPlacement, tabIndex, fontHeight) + 12;
    }

    @Override
    protected Insets getTabInsets(int tabPlacement, int tabIndex) {
        return new Insets(5, 15, 5, 15);
    }
}
