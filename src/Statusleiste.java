package livecoding;

import javax.awt.Color;
import javax.swing.JPanel;

import java.awt.Dimension;

javax.swing.JPanel;

public class Statusleiste extends JPanel{

        private final int BREITE = 400;
        private final int HOEHE = 15;
        
        public StatusLeiste(){
                this.setPreferredSize(new Dimension(BREITE,HOEHE));
                this.setBackground(Color.GREEN);
                
        }
        
}