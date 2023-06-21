package aeropuerto;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Mapa extends JLabel implements ActionListener {

    
    ImageIcon Mapa, MapaRed, MapaRut;
    Timer timer;
    int x = 1080, y = 519, c = 0;
    BufferedImage image;
    

    public Mapa() {
        Mapa = new ImageIcon("src/Imagenes/mapa.png");
        this.timer = new Timer(1, this);
        setIcon(Mapa);
    }

    public void mapMinRes() {
        x = 1080;
        y = 519;
        c = 0;
        this.timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.timer) {

            if (c < 45) {
                if (c == 1) {
                    setBounds(0, 0, 1080, 519);
                }
                
                x = x - 11;
                y = y - 5;

                MapaRed = new ImageIcon(Mapa.getImage().getScaledInstance(x, y, Image.SCALE_DEFAULT));
                setIcon(MapaRed);
                setBounds(getX() + 11, 5, x, y);
                c++;

                
            } else {
                timer.stop();
                c = 0;
                x = 1080;
                y = 519;
            }

        }
    }

}
