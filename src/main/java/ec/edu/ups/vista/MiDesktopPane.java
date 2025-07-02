package ec.edu.ups.vista;


import javax.swing.*;
import java.awt.*;

public class MiDesktopPane extends JDesktopPane {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        g2d.setColor(new Color(245, 245, 245));
        g2d.fillRect(0, 0, w, h);

        Color azul = new Color(30, 100, 200);
        Color gris = new Color(80, 80, 80);
        Color negro = new Color(30, 30, 30);
        Color verdeChip = new Color(34, 139, 34);

        // Dibujo ordenado de elementos tecnológicos
        int filas = 3;
        int columnas = 6;
        int separacionX = w / (columnas + 1);
        int separacionY = h / (filas + 1);

        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                int x = separacionX * (col + 1) - 30;
                int y = separacionY * (fila + 1) + 10;

                int tipo = (fila + col) % 3;

                switch (tipo) {
                    case 0: // Monitor
                        drawMonitor(g2d, x, y, azul, negro);
                        break;
                    case 1: // Celular
                        drawCelular(g2d, x, y, gris);
                        break;
                    case 2: // Chip
                        drawChip(g2d, x, y, verdeChip);
                        break;
                }
            }
        }

        // Título central "Guish"
        String titulo = "Guish";
        g2d.setFont(new Font("SansSerif", Font.BOLD, 50));
        FontMetrics fm = g2d.getFontMetrics();
        int xTitulo = (w - fm.stringWidth(titulo)) / 2;
        g2d.setColor(azul);
        g2d.drawString(titulo, xTitulo, 80);

        g2d.dispose();
    }

    // === DIBUJOS TECNOLÓGICOS ===

    private void drawMonitor(Graphics2D g2d, int x, int y, Color marco, Color base) {
        g2d.setColor(marco);
        g2d.fillRect(x, y, 60, 40);

        g2d.setColor(Color.WHITE);
        g2d.fillRect(x + 5, y + 5, 50, 30);

        g2d.setColor(base);
        g2d.fillRect(x + 20, y + 42, 20, 5);
        g2d.fillRect(x + 25, y + 47, 10, 5);
    }

    private void drawCelular(Graphics2D g2d, int x, int y, Color color) {
        g2d.setColor(color);
        g2d.fillRoundRect(x, y, 30, 60, 10, 10);

        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(x + 5, y + 10, 20, 35);

        g2d.setColor(Color.DARK_GRAY);
        g2d.fillOval(x + 12, y + 50, 5, 5);
    }

    private void drawChip(Graphics2D g2d, int x, int y, Color color) {
        g2d.setColor(color);
        g2d.fillRect(x, y, 40, 40);

        g2d.setColor(Color.BLACK);
        for (int i = 0; i < 4; i++) {
            g2d.drawLine(x - 5, y + 5 + i * 10, x, y + 5 + i * 10); // izquierda
            g2d.drawLine(x + 40, y + 5 + i * 10, x + 45, y + 5 + i * 10); // derecha
            g2d.drawLine(x + 5 + i * 10, y - 5, x + 5 + i * 10, y); // arriba
            g2d.drawLine(x + 5 + i * 10, y + 40, x + 5 + i * 10, y + 45); // abajo
        }

        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(x + 10, y + 10, 20, 20);
    }
}
