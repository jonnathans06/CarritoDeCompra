package ec.edu.ups.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.QuadCurve2D;

public class MiDesktopPane extends JDesktopPane {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Color azul personalizado
        Color azul = new Color(93, 173, 226);
        g2d.setColor(azul);

        // Fuente gruesa centrada
        Font fuente = new Font("Arial Black", Font.BOLD, 72);
        g2d.setFont(fuente);

        // Texto y métricas
        String texto = "C H O R A L";
        FontMetrics metrics = g2d.getFontMetrics(fuente);
        int textWidth = metrics.stringWidth(texto);
        int textHeight = metrics.getAscent();

        // Posición centrada
        int x = (getWidth() - textWidth) / 2;
        int y = (getHeight() + textHeight) / 2;

        // Dibujar texto
        g2d.drawString(texto, x, y);

        // --------------------
        // DIBUJAR LA FLECHA CURVA TIPO AMAZON
        // --------------------

        int arrowStartX = x + metrics.charWidth('C') / 2;
        int arrowEndX = x + textWidth - metrics.charWidth('L') / 2;
        int arrowY = y + 10;
        int controlX = (arrowStartX + arrowEndX) / 2;
        int controlY = arrowY + 30; // Altura de la curva

        // Curva de flecha
        QuadCurve2D curva = new QuadCurve2D.Float();
        curva.setCurve(arrowStartX, arrowY, controlX, controlY, arrowEndX, arrowY);

        g2d.setStroke(new BasicStroke(3f));
        g2d.draw(curva);

        // Punta de flecha
        int arrowSize = 10;
        Polygon flecha = new Polygon();
        flecha.addPoint(arrowEndX, arrowY); // punta
        flecha.addPoint(arrowEndX - arrowSize, arrowY - arrowSize);
        flecha.addPoint(arrowEndX - arrowSize, arrowY + arrowSize);
        g2d.fill(flecha);

        // --------------------
        // DIBUJAR "HIPERMERCADO" EN COLOR NARANJA
        // --------------------
        Color naranja = new Color(247, 220, 111);
        g2d.setColor(naranja);
        g2d.setFont(new Font("Arial", Font.BOLD, 36));
        g2d.drawString("HIPERMERCADOS", x + 80, y + 80);
    }
}
