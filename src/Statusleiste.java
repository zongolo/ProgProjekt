import java.awt.Color;
import javax.swing.JPanel;

import java.awt.Dimension;

public class Statusleiste extends JPanel{

        private final int BREITE = 400;
        private final int HOEHE = 15;
        
        public Statusleiste(){
                this.setPreferredSize(new Dimension(BREITE,HOEHE));
                this.setBackground(Color.GREEN);
                
        }
        
}