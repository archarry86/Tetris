package IndieGame;

import java.awt.Graphics2D;
import java.awt.Shape;

import Math.Vector2D;

public class Tablero extends Sprite{
	
	int[][] matrizTablero;	
	
	public Tablero(){
		matrizTablero = new int[10][20];
		
	}

	public int[][] getTablero(){
		return matrizTablero;
	}
	
	public void setTablero(int[][] m){
		for (int i = 0; i < m.length; i++) 
			for (int j = 0; j < m.length; j++) 
				matrizTablero[i][j] = m[i][j];	
	}

	@Override
	protected Shape getShape() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	
	public void agregarFicha(Ficha ficha){
		Vector2D positionFicha = ficha.position;
		int medidaLado = GenericGame.getMedidaLado();
		
		int i = (int)(positionFicha.getX()/medidaLado - 1);
		int j = (int)(positionFicha.getY()/medidaLado - 1);
	}
	
	
	
}
