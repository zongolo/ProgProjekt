package Old_Package;
import java.awt.Color;
import java.awt.dimension;
import java.awt.Graphics;

import javax.swing.JPanel;


public class SpielFeld {
        
        private final int BREITE = 400;
        private final int HOEHE = 400;
        
        private int posX = BREITE/2;
        private int posY = HOEHE/2;
        
        public SpielFeld(){
                this.setPreferredSize(new Dimension(BREITE, HOEHE));
                this.setBackgroud(Color.BLACK);
        }
        
        public void paint(Graphics g){
                g.setColor(c);
                g.fillOval(x, y, width,  height);
                
        }
}

public class GuiMain {
    public static void main (String [] args) {
        new SpielFenster ();
    }    
}





import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class SpielFenster extends JFrame {

    private final int BREITE = 400;
    private final int HOEHE = 400;

    public SpielFenster () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(BREITE, HOEHE);
        this.setTitle("Canberra Fox - The Key Huntress");
        this.setLayout(new BorderLayout(1,1));
        
        StatusLeiste sl = new StatusLeiste ();
        this.add(sl, BorderLayout.SOUTH);
        
        SpielFeld sf = new SpielFeld ();
        this.addKeyListener(sf);
        this.add(sf, BorderLayout.CENTER);
        
        this.setVisible(true);
    }
    
}




import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class SpielFenster extends JFrame {

    private final int BREITE = 400;
    private final int HOEHE = 400;

    public SpielFenster () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(BREITE, HOEHE);
        this.setTitle("Canberra Fox - The Key Huntress");
        this.setLayout(new BorderLayout(1,1));
        
        StatusLeiste sl = new StatusLeiste ();
        this.add(sl, BorderLayout.SOUTH);
        
        SpielFeld sf = new SpielFeld ();
        this.addKeyListener(sf);
        this.add(sf, BorderLayout.CENTER);
        
        this.setVisible(true);
    }
    
}





import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class StatusLeiste extends JPanel {

    private final int BREITE = 400;
    private final int HOEHE = 15;
    
    public StatusLeiste() {
        this.setPreferredSize (new Dimension(BREITE, HOEHE));
        this.setBackground(Color.GREEN);
    
    }
    
    public void paint (Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.drawString("Canberra Fox", 1, HOEHE-5);
        
    }
}



