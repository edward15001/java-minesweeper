package com.minesweeper.ui;

import javax.swing.*;
import java.awt.*;

public class Theme {
    public static final Color BG_COLOR = new Color(21, 26, 48); // #151A30 Dark Blue
    public static final Color PANEL_BG = new Color(34, 43, 69); // #222B45 Lighter Blue Panels
    public static final Color FG_COLOR = Color.WHITE;
    public static final Color ACCENT_COLOR = new Color(51, 102, 255); // #3366FF Light Blue
    public static final Font MAIN_FONT = new Font("Monospaced", Font.PLAIN, 14);
    public static final Font BOLD_FONT = new Font("Monospaced", Font.BOLD, 14);
    public static final Font TITLE_FONT = new Font("Monospaced", Font.BOLD, 22);

    public static void applyTheme(Component comp) {
        if (comp instanceof JPanel || comp instanceof JScrollPane || comp instanceof JViewport) {
            comp.setBackground(BG_COLOR);
            comp.setForeground(FG_COLOR);
        } else if (comp instanceof JButton) {
            Boolean isGrid = (Boolean) ((JButton) comp).getClientProperty("isGrid");
            if (isGrid != null && isGrid) {
                // Do not apply generic button styles to grid, to keep custom board look
            } else {
                comp.setBackground(ACCENT_COLOR);
                comp.setForeground(Color.WHITE);
                ((JButton) comp).setFocusPainted(false);
                comp.setFont(BOLD_FONT);
                ((JButton) comp).setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
                ((JButton) comp).setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        } else if (comp instanceof JLabel) {
            comp.setForeground(FG_COLOR);
            comp.setFont(MAIN_FONT);
            if (((JLabel) comp).getFont().getSize() >= 20) {
                comp.setFont(TITLE_FONT);
            }
        } else if (comp instanceof JTextField) {
            comp.setBackground(PANEL_BG);
            comp.setForeground(Color.WHITE);
            comp.setFont(MAIN_FONT);
            ((JTextField) comp).setCaretColor(Color.WHITE);
            ((JTextField) comp).setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(ACCENT_COLOR, 1),
                    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        } else if (comp instanceof JTable) {
            comp.setBackground(PANEL_BG);
            comp.setForeground(FG_COLOR);
            comp.setFont(MAIN_FONT);
            ((JTable) comp).setGridColor(BG_COLOR);
            ((JTable) comp).getTableHeader().setBackground(BG_COLOR);
            ((JTable) comp).getTableHeader().setForeground(ACCENT_COLOR);
            ((JTable) comp).getTableHeader().setFont(BOLD_FONT);
            ((JTable) comp).setRowHeight(25);
        } else if (comp instanceof JComboBox) {
            comp.setBackground(PANEL_BG);
            comp.setForeground(Color.WHITE);
            comp.setFont(MAIN_FONT);
        } else if (comp instanceof JList) {
            comp.setBackground(PANEL_BG);
            comp.setForeground(FG_COLOR);
            comp.setFont(MAIN_FONT);
            ((JList<?>) comp).setSelectionBackground(ACCENT_COLOR);
            ((JList<?>) comp).setSelectionForeground(Color.WHITE);
        } else if (comp instanceof JTabbedPane) {
            comp.setBackground(PANEL_BG);
            comp.setForeground(FG_COLOR);
            comp.setFont(BOLD_FONT);
            ((JTabbedPane) comp).setUI(new ModernTabbedPaneUI());
        }

        if (comp instanceof Container) {
            for (Component child : ((Container) comp).getComponents()) {
                applyTheme(child);
            }
        }
    }
}
