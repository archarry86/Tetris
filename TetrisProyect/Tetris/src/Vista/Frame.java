package Vista;

import javax.swing.JFrame;

import IndieGame.AbstractGame;
import IndieGame.GameProperties;
import IndieGame.GenericGame;

public class Frame extends JFrame {

	public  static int ALTO_FRAME = 900;
	public  static int ANCHO_FRAME = 600;
	public  static String TITULO = "Tetris";
	
	private AbstractGame abstractGame;
	
	public Frame(){
		
		super();
		
		GameProperties.loadProperties();
		
		
		abstractGame = new GenericGame();
		ANCHO_FRAME = abstractGame.Width+50;
		ALTO_FRAME = abstractGame.Height+100;
		setSize(ANCHO_FRAME,ALTO_FRAME);
		setTitle(TITULO);
		add(abstractGame);
	
		abstractGame.GameStar();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(abstractGame);
	}
	
}
