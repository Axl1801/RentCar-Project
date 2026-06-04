package Utilities;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboBoxUI;

import java.awt.*;

public class ComboBoxRounded<E> extends JComboBox<E> {

	private boolean bloqueado = false;
    private Color backgroundColor = Color.WHITE;
    private Color borderColor = new Color(200, 200, 200);
    private int radius = 10;

    // Constructor vacío
    public ComboBoxRounded() {
        super();
        initialize();
    }

    // Constructor con elementos
    public ComboBoxRounded(E[] items) {
        super(items);
        initialize();
    }
    
    //Constructor para arrays
    public ComboBoxRounded(java.util.Collection<E> items) {
        super();

        for (E item : items) {
            addItem(item);
        }

        initialize();
    }

    private void initialize() {

        setOpaque(false);
        setFocusable(false);
        setBorder(new EmptyBorder(5, 10, 5, 10));
        setBackground(backgroundColor);
        setForeground(Color.BLACK);
        setFont(new Font("Poppins", Font.PLAIN, 14));

        // Flecha personalizada
        setUI(new BasicComboBoxUI() {

            @Override
            protected JButton createArrowButton() {

                JButton button = new JButton() {

                    @Override
                    protected void paintComponent(Graphics g) {

                        Graphics2D g2 = (Graphics2D) g.create();

                        g2.setRenderingHint(
                                RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);

                        g2.setColor(new Color(80, 80, 80));

                        int w = getWidth();
                        int h = getHeight();

                        int size = 8;

                        int x = (w - size) / 2;
                        int y = (h - size) / 2;

                        Polygon arrow = new Polygon();

                        arrow.addPoint(x, y);
                        arrow.addPoint(x + size, y);
                        arrow.addPoint(x + size / 2, y + size);

                        g2.fill(arrow);

                        g2.dispose();
                    }
                };

                button.setBorder(null);
                button.setContentAreaFilled(false);
                button.setFocusPainted(false);
                button.setOpaque(false);

                return button;
            }
        });
        
        //deshabilitar el popup
        addPopupMenuListener(new PopupMenuListener() {

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {

                if (bloqueado) {
                    SwingUtilities.invokeLater(() -> hidePopup());
                }
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {}
        });

        // Renderer personalizado
        setRenderer(new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(
                    JList<?> list,
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus) {

                JLabel label = (JLabel) super.getListCellRendererComponent(
                        list,
                        value,
                        index,
                        isSelected,
                        cellHasFocus);

                label.setBorder(new EmptyBorder(5, 10, 5, 10));
                label.setHorizontalAlignment(SwingConstants.CENTER);

                // Mantener colores aunque esté deshabilitado
                label.setForeground(Color.BLACK);

                if (isSelected) {
                    label.setBackground(new Color(230, 230, 230));
                } else {
                    label.setBackground(Color.WHITE);
                }

                return label;
            }
        });
    }

    @Override
    public void setEnabled(boolean enabled) {

        super.setEnabled(enabled);

        // Mantener colores personalizados
        setForeground(Color.BLACK);
        setBackground(backgroundColor);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Fondo redondeado
        g2.setColor(backgroundColor);
        g2.fillRoundRect(
                0,
                0,
                getWidth(),
                getHeight(),
                radius,
                radius);

        g2.dispose();

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(borderColor);

        g2.drawRoundRect(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1,
                radius,
                radius);

        g2.dispose();
    }

    public void setBorderColor(Color color) {
        this.borderColor = color;
        repaint();
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        setBackground(color);
        repaint();
    }

    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }
    
    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
}