package platformergame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;	

public class PlatformMain implements ActionListener {

	public static PlatformMain game;
	
	public final int WIDTH = 1600, HEIGHT = 900;
	
	public Renderer renderer;
	
	public Movement actions = new Movement(this);
	
	public Graphic graphic = new Graphic(this);
	
	public Controls controls = new Controls(this);
	
	public Rectangle player;
	
	public int ticks, yMotion, xMotion;
	
	public int stoppingTicks = 100;
	public boolean isStoppingLeft = false;
	public boolean isStoppingRight = false;
	
	public boolean canClick = true;
	public int clickTicks;
	
	public int clearTicks;
	
	public int deathCount = 0;
	
	public int levelCount = 0;
	
	public int cur = 0;
	public int first;
	public boolean press = true;
	
	public boolean canJump = true;
	
	public Rectangle floor;
	public Rectangle wall;
	public Rectangle roof;
	
	public ArrayList<Rectangle> obstacle;
	
	public ArrayList<Rectangle> spikes;
	
	public ArrayList<Rectangle> redField;
 	
	public Rectangle block;
	
	public int animTick = 0;
	
	public int bgTick = 0;
	
	public int dir;
	
	public int howX = 1600;
	
	public boolean enter = false;
	
	public int enterCount = 0;
	
	public Rectangle startGame;
	
	public Rectangle howToPlay;
	
	public Rectangle blueScreen;
	
	public boolean  spikesDown = true;	
	
	public boolean howScreen = false;
	
	public PlatformMain(){
		
		JFrame jframe = new JFrame();
		Timer timer = new Timer(15, this);
		
		renderer = new Renderer();
		
		jframe.add(renderer);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.addKeyListener(controls.kl);
		jframe.addMouseListener(controls.ml);
		jframe.setResizable(false);
		jframe.setVisible(true);
		
		player = new Rectangle(100 , HEIGHT - 140, 40, 60);
		
		floor = new Rectangle(WIDTH / 2 - 800, HEIGHT - 90, WIDTH, 100);
		
		wall = new Rectangle(0, 0, 5, HEIGHT - 90);
		
		roof = new Rectangle(0, 0, WIDTH, 5);
		
		blueScreen = new Rectangle(1600, 0, 1600, 900);
		
		obstacle = new ArrayList<Rectangle>();
		spikes = new ArrayList<Rectangle>();
		redField = new ArrayList<Rectangle>();
		
		block = new Rectangle(WIDTH - 700, HEIGHT / 2 + 500, 50, 50);
		
		startGame = new Rectangle(650, 200, 300, 100);
		howToPlay = new Rectangle(540, 350, 510, 100);
		
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		actions.movement();
	}	
	
	public void repaint(Graphics g) {
		
		graphic.graphics(g);
	}
		
	public static void main(String[] args) {

		game = new PlatformMain();
		
	}

	public void controller(KeyEvent e, MouseEvent m){
		
		controls.keyPressed(e);
		controls.keyReleased(e);
		controls.mousePressed(m);
	}
	
}
