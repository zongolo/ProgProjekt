//Rendert die Map.txt

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import Old_Package.SpriteSheet;

import java.awt.Canvas;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Spiel extends java.awt.Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 160;
	public static final int HEIGHT = WIDTH/12*9;
	public static final int SCALE=3;
	private static final String NAME="Canberra";
	
	private JFrame frame;
	
	private  boolean running = false;
	
	public int tickCount = 0;
	
	private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	private int[]pixels=((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	//SpriteSheet einladen
	private SpriteSheet spriteTest = new SpriteSheet("/pic/sprite_sheet.png"); 

	
//**************************************************************************************	
//					Erstellt das Fenster
//**************************************************************************************	

	public Spiel(){
		setMinimumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		setMaximumSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
		
		frame = new JFrame(NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
	
		frame.add(this,BorderLayout.CENTER);
		frame.pack();
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
		
	//Synchronized Function (Wichtig f�r APPLET
	public synchronized void start() {
		
		running = true;
		//Wenn der Thread gestartet wird, wird die Run Funktion gestartet.
		new Thread(this).start();
		
	}
	public synchronized void stop() {
		running = false;
	}

	public void run(){
	//Weist der Variable lastTime die NanoZeit zu
		long lastTime=System.nanoTime();
		
	//Wieviele Nanosekunden sind in einem tick()
		double nsPerTick=1000000000D/60D;
		
		int frames = 0;
		int ticks = 0;
		
		long lastTimer=System.currentTimeMillis();
	//Wieviele Nanosekunden sind verstrichen.
		double delta=0;
		
	//W�hrend das Spiel l�uft
		while(running){
			long now = System.nanoTime();
			delta += (now-lastTime)/nsPerTick;
			lastTime=now;
			boolean shouldRender = true;
			
			while(delta>=1){
				ticks++;
				tick();
				delta -= 1;
				shouldRender = true;
			}
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(shouldRender){
				frames++;
				render();	
			}
			if(System.currentTimeMillis() - lastTimer >= 1000){
				lastTimer += 1000;
				System.out.println(frames+" frames, "+ticks+" tickss");
				frames = 0;
				ticks = 0;
			}
		//Update die Spielmechanismen
			tick();
		//Update die Darstellung
			render();
		}
	}
	
	//Updatet das Spiel (Die Logik des Spiels)
	public void tick(){
		tickCount++;
		
		for(int i=0;i<pixels.length;i++){
			pixels[i]=i+tickCount;
		}
	}
	//Rendert die Updates
	public void render(){
		
		//Objekt um die Daten zu organisieren im Canvas
		BufferStrategy bs = getBufferStrategy();
		if(bs==null){
			createBufferStrategy(3);
			return; 
		}
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(image, 0,0,getWidth(),getHeight(),null);
		
		g.dispose();
		bs.show();
	}
	
	
	
	
	
}