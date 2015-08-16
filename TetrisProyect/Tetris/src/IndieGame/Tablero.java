package IndieGame;

import java.awt.Color;
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
		
		int medidaLado = GenericGame.getMedidaLado();
		
		for (int i = 0; i <Juego.FILAS; i++) {
			g.setColor(Color.BLACK);
			g.drawLine(0, medidaLado*i,GenericGame.Width,medidaLado*i);
			g.setColor(Color.BLACK);
			g.drawString(""+i, 5, 30 + medidaLado*i);
		}
		
		for (int j = 0; j < Juego.COLUMNAS; j++) {
			g.setColor(Color.BLACK);
			g.drawLine(medidaLado*j,0, medidaLado*j,GenericGame.Height);
			g.setColor(Color.BLACK);
			g.drawString(""+j, medidaLado*j, 30);
		}
		
		
		for (int i = 0; i < matrizTablero.length; i++) 
		{
			for (int j = 0; j < matrizTablero[0].length; j++) 
			{
				if (matrizTablero[i][j] == 0) 
				{
					System.out.println("tetris hpta ");
					
					g.setColor(Color.YELLOW);					
					g.fillRect(i*medidaLado, j*medidaLado, medidaLado, medidaLado);
					
					g.setColor(Color.black);
					g.drawRect(i*medidaLado, j*medidaLado, medidaLado, medidaLado);
				}
				else{
					g.setColor(Color.RED);					
					g.fillRect(i*medidaLado, j*medidaLado, medidaLado, medidaLado);
					
					g.setColor(Color.black);
					g.drawRect(i*medidaLado, j*medidaLado, medidaLado, medidaLado);
					
				}
			}
		}		
		
	}
	
	public void agregarFicha(Ficha ficha){
		
		Vector2D positionFicha = ficha.position;
		int medidaLado = GenericGame.getMedidaLado();
		
		System.out.println("medidaLado " + medidaLado);
		
		int im = (int) (positionFicha.getX() / medidaLado);
		int jm = (int) (positionFicha.getY() / medidaLado);
		
		System.out.println("im " + im + " ijm " + jm);
		
		System.out.println();
		
		
		
		int [][] matriz = ficha.getFicha();
		
		for(int i=0; i< matriz.length;i++)
		{
			for(int j=0; j< matriz[0].length;j++)
			{
				System.out.println("im " +( im+ i) + " ijm " +( jm+j));
				matrizTablero[jm+i][im+j]= matriz[i][j];
			}
		}

		System.out.println("*************************************************************************");
		System.out.println(toString());
		
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
