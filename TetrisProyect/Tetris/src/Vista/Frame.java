package Vista;

import java.awt.Graphics;

import javax.swing.JFrame;

import IndieGame.AbstractGame;
import IndieGame.GameProperties;
import IndieGame.GenericGame;

public class Frame extends JFrame {

	public  static int ALTO_FRAME = 900;
	public  static int ANCHO_FRAME = 700;
	public  static String TITULO = "Tetris";
	
	private AbstractGame abstractGame;
	private PnlLineas pnlLineas; 
	
	public Frame(){
		
		super();
		
		GameProperties.loadProperties();		
		
		abstractGame = new GenericGame();
		//ANCHO_FRAME = abstractGame.Width+50;
		//ALTO_FRAME = abstractGame.Height+100;
			
		setSize(ANCHO_FRAME,ALTO_FRAME);
		setTitle(TITULO);
		add(abstractGame);
		
		pnlLineas = new PnlLineas();
		//add(pnlLineas);
			
		abstractGame.GameStar();
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(abstractGame);
	}
	
	
	public void paint(Graphics g){
		
		super.paint(g);
		
		abstractGame.paintScreen();
		pnlLineas.paint(g);
	}
}
