package IndieGame;

import java.awt.Graphics2D;
import java.awt.Shape;

import Math.Vector2D;

public class Tablero extends Sprite{
	
	int[][] matrizTablero;	
	
	public Tablero(){
		matrizTablero = new int[Juego.FILAS][Juego.COLUMNAS];
		
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
		
		int in = 18;//(int)(positionFicha.getX()/medidaLado );
		int jn = 4;//(int)(positionFicha.getY()/medidaLado);
		System.out.println(in);
		System.out.println(jn);
		int[][] fichamatriz =ficha.getFicha();
		System.out.println(ficha);
		int contador = 0;
		int r = in+ fichamatriz.length;
		int col = jn + fichamatriz[0].length;
		System.out.println(r);
		System.out.println(col);
		for(int i = in; i< r; in++){
			for(int j = jn; j< col; jn++, contador++){
				
				matrizTablero[i][j] = fichamatriz[contador/col][contador%col];
			}
			
		}
	}
	
	public String toString(){

		String str = new String();
		for (int i = 0; i < matrizTablero.length*matrizTablero[0].length; i++) {
			str = str +  matrizTablero[i/matrizTablero[0].length][i%matrizTablero[0].length] + ' ';
			if (i%matrizTablero[0].length == matrizTablero[0].length - 1) {
				str = str + '\n';
			}
		}
		return str;
	}
	
	
	
}
