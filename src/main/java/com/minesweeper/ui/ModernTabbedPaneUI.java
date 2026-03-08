package com.minesweeper.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;

public class ModernTabbedPaneUI extends BasicTabbedPaneUI {

    @Override
    protected void installDefaults() {
        super.installDefaults();
        tabPane.setBackground(Theme.BG_COLOR);
        tabPane.setForeground(Theme.ACCENT_COLOR);
        tabPane.setOpaque(true);
    }

    @Override
    protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
        g.setColor(Theme.BG_COLOR);
        g.fillRect(0, 0, tabPane.getWidth(), tabPane.getHeight());
        super.paintTabArea(g, tabPlacement, selectedIndex);
    }

    @Override
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h,
            boolean isSelected) {
        Graphics2D g2 = (Graphics2D) g.create();

        if (isSelected) {
            g2.setColor(Theme.PANEL_BG);
            g2.fillRect(x, y, w, h);

            // Neon accent bar on top
            g2.setColor(Theme.ACCENT_COLOR);
            g2.fillRect(x, y, w, 2);
        } else {
            g2.setColor(Theme.BG_COLOR);
            g2.fillRect(x, y, w, h);

            // Dim border for inactive
            g2.setColor(Theme.DIM_COLOR);
            g2.drawRect(x, y, w - 1, h - 1);
        }

        g2.dispose();
    }

    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h,
            boolean isSelected) {
        if (isSelected) {
            g.setColor(Theme.ACCENT_COLOR);
            g.drawRect(x, y, w - 1, h); // Draw sides and bottom (top is handled by accent bar)
        }
    }

    @Override
    protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex,
            Rectangle iconRect, Rectangle textRect, boolean isSelected) {
        // No focus outline
    }

    @Override
    protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
        Graphics2D g2 = (Graphics2D) g.create();
        int width = tabPane.getWidth();
        int height = tabPane.getHeight();
        Insets insets = tabPane.getInsets();

        int y = insets.top + calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight);

        // Draw a sharp neon box for the content panel below the tabs
        g2.setColor(Theme.ACCENT_COLOR);
        g2.drawRect(insets.left, y, width - insets.right - insets.left - 1, height - y - insets.bottom - 1);

        g2.dispose();
    }

    @Override
    protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex, String title,
            Rectangle textRect, boolean isSelected) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setFont(Theme.BOLD_FONT);

        String displayTitle = " " + title; // Adds a bit of padding

        if (isSelected) {
            g2.setColor(Theme.ACCENT_COLOR);
        } else {
            g2.setColor(Theme.DIM_COLOR);
        }

        FontMetrics fm = g2.getFontMetrics();
        int textX = textRect.x + (textRect.width - fm.stringWidth(displayTitle)) / 2;
        int textY = textRect.y + (textRect.height - fm.getHeight()) / 2 + fm.getAscent();

        g2.drawString(displayTitle, textX, textY);
        g2.dispose();
    }

    @Override
    protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
        return super.calculateTabWidth(tabPlacement, tabIndex, metrics) + 20;
    }

    @Override
    protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
        return super.calculateTabHeight(tabPlacement, tabIndex, fontHeight) + 8;
    }

    @Override
    protected Insets getTabInsets(int tabPlacement, int tabIndex) {
        return new Insets(4, 15, 4, 15);
    }
}
