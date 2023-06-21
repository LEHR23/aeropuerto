package aeropuerto;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;

public class Grafo extends JLabel {
    
    public Grafo(){
        this.setOpaque(false);
    }
    
    
    public void dibujarLinea(int x1, int y1, int x2, int y2, Color color){
            Graphics g = this.getGraphics();
            ((Graphics2D)g).setStroke(new BasicStroke(4));
            ((Graphics2D)g).setColor(color);
            ((Graphics2D)g).drawLine(x1, y1, x2, y2);
    }
    
    public void dibujarNodo(int x, int y, Color color, Boolean fill, String text){
        Graphics g = this.getGraphics();
         ((Graphics2D)g).setStroke(new BasicStroke(2));
         ((Graphics2D)g).setColor(color);
         if(fill){
            ((Graphics2D)g).fillOval(x, y, 15, 15);
         }
         ((Graphics2D)g).drawOval(x, y, 15, 15);
         ((Graphics2D)g).setFont(new Font("Times New Roman", Font.BOLD, 20));
         ((Graphics2D)g).drawString(text, x, y);
    }

}
