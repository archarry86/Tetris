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
		super();
		
		lineas = new String("LINES ");
		numeroLineas = new String("");
		//this.setLocation(arg0)
		this.setSize(100, 100);
	}
	
	
	public void setNumLineas(int n){
		numeroLineas = String.valueOf(n);
	}
	
	@Override
	public void paint(Graphics g) {		
		super.paint(g);
		Font fuente = new Font("Arial", Font.BOLD, 20);		
		
		g.setFont(fuente);
		
		g.drawString(lineas, 50, 50);
		g.drawString(numeroLineas, 50, 100);
	}
	
	
	
		
}
