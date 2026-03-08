package com.minesweeper.ui;

import javax.swing.*;
import java.awt.*;

public class Theme {
    public static final Color BG_COLOR = new Color(17, 17, 17); // #111111 Very Dark Grey/Black
    public static final Color PANEL_BG = new Color(26, 26, 26); // #1A1A1A Dark Grey
    public static final Color ACCENT_COLOR = new Color(204, 255, 0); // #CCFF00 Neon Chartreuse Green
    public static final Color DIM_COLOR = new Color(85, 102, 17); // Dark Olive/Grid color
    public static final Color FG_COLOR = ACCENT_COLOR; // Text is now uniformly neon

    public static final Font MAIN_FONT = new Font("Monospaced", Font.PLAIN, 14);
    public static final Font BOLD_FONT = new Font("Monospaced", Font.BOLD, 14);
    public static final Font TITLE_FONT = new Font("Monospaced", Font.BOLD, 20);

    public static void applyTheme(Component comp) {
        if (comp instanceof JPanel || comp instanceof JScrollPane || comp instanceof JViewport) {
            comp.setBackground(BG_COLOR);
            comp.setForeground(FG_COLOR);

            // Give titled borders the neon color
            if (comp instanceof JPanel) {
                JPanel jp = (JPanel) comp;
                if (jp.getBorder() instanceof javax.swing.border.TitledBorder) {
                    javax.swing.border.TitledBorder tb = (javax.swing.border.TitledBorder) jp.getBorder();
                    tb.setTitleColor(ACCENT_COLOR);
                    tb.setTitleFont(BOLD_FONT);
                    tb.setBorder(BorderFactory.createLineBorder(DIM_COLOR, 1));
                }
            }
        } else if (comp instanceof JButton) {
            Boolean isGrid = (Boolean) ((JButton) comp).getClientProperty("isGrid");
            if (isGrid != null && isGrid) {
                // Do not apply generic button styles to grid, GamePanel handles it
            } else {
                comp.setBackground(BG_COLOR);
                comp.setForeground(ACCENT_COLOR);
                ((JButton) comp).setFocusPainted(false);
                comp.setFont(BOLD_FONT);
                // Sharp 1px neon border
                ((JButton) comp).setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(ACCENT_COLOR, 1),
                        BorderFactory.createEmptyBorder(6, 15, 6, 15)));
                ((JButton) comp).setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        } else if (comp instanceof JLabel) {
            comp.setForeground(FG_COLOR);
            comp.setFont(MAIN_FONT);
            if (((JLabel) comp).getFont().getSize() >= 20) {
                comp.setFont(TITLE_FONT);
            }
        } else if (comp instanceof JTextField) {
            comp.setBackground(BG_COLOR);
            comp.setForeground(ACCENT_COLOR);
            comp.setFont(MAIN_FONT);
            ((JTextField) comp).setCaretColor(ACCENT_COLOR);
            ((JTextField) comp).setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(ACCENT_COLOR, 1),
                    BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        } else if (comp instanceof JTable) {
            comp.setBackground(BG_COLOR);
            comp.setForeground(ACCENT_COLOR);
            comp.setFont(MAIN_FONT);
            ((JTable) comp).setGridColor(DIM_COLOR);
            ((JTable) comp).getTableHeader().setBackground(BG_COLOR);
            ((JTable) comp).getTableHeader().setForeground(ACCENT_COLOR);
            ((JTable) comp).getTableHeader().setFont(BOLD_FONT);
            // Sharp border for header
            ((JTable) comp).getTableHeader().setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ACCENT_COLOR));
            ((JTable) comp).setRowHeight(25);
            ((JTable) comp).setSelectionBackground(ACCENT_COLOR);
            ((JTable) comp).setSelectionForeground(BG_COLOR);
        } else if (comp instanceof JComboBox) {
            comp.setBackground(BG_COLOR);
            comp.setForeground(ACCENT_COLOR);
            comp.setFont(MAIN_FONT);
            ((JComboBox<?>) comp).setBorder(BorderFactory.createLineBorder(ACCENT_COLOR, 1));
        } else if (comp instanceof JList) {
            comp.setBackground(BG_COLOR);
            comp.setForeground(ACCENT_COLOR);
            comp.setFont(MAIN_FONT);
            ((JList<?>) comp).setSelectionBackground(ACCENT_COLOR);
            ((JList<?>) comp).setSelectionForeground(BG_COLOR);
        } else if (comp instanceof JTabbedPane) {
            comp.setBackground(BG_COLOR);
            comp.setForeground(ACCENT_COLOR);
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
