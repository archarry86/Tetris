package Vista;

import javax.swing.JFrame;

import IndieGame.AbstractGame;
import IndieGame.GenericGame;

public class Frame extends JFrame {

	public final static int ALTO_FRAME = 900;
	public final static int ANCHO_FRAME = 600;
	
	private AbstractGame abstractGame;
	
	public Frame(){
		
		abstractGame = new GenericGame();
		
		setSize(ANCHO_FRAME,ALTO_FRAME);
		add(abstractGame);
		
		abstractGame.GameStar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
