package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

import IndieGame.GenericGame;

public class PnlLineas extends JPanel{
	
	private String lineas ;
	public String numeroLineas;
	
	public PnlLineas(){		
		
		
		lineas = new String("LINES ");
		numeroLineas = new String("");
		
	}
	
	
	public void setNumLineas(int n){
		numeroLineas = String.valueOf(n);
	}
	
	@Override
	public void paint(Graphics g) {		
		
		Font fuente = new Font("Arial", Font.BOLD, 20);		
		
		g.setFont(fuente);
		
		g.drawString(lineas, 450, 80);
		g.drawString(numeroLineas, 450, 120);
	}
	
	
	
		
}
