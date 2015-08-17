package IndieGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

import Math.Vector2D;

public class Tablero extends Sprite{
	
	int[][] matrizTablero;	
	
	public Tablero(){

		int c =GenericGame.Width / GenericGame.getMedidaLado();
		int f =GenericGame.Height / GenericGame.getMedidaLado();
	
		matrizTablero = new int[f][c];
		
	}

	public int[][] getTablero(){
		return matrizTablero;
	}
	
	public void setTablero(int[][] m){
		for (int i = 0; i < m.length; i++) 
			for (int j = 0; j < m.length; j++) 
				matrizTablero[i][j] = m[i][j];	
	}
	
	public void reloadMatriz(){
		int c =GenericGame.Width / GenericGame.getMedidaLado();
		int f =GenericGame.Height / GenericGame.getMedidaLado();
	
		matrizTablero = new int[f][c];
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
		
		//System.out.println("MATRIZ TABLERO "+matrizTablero.length+"_" +matrizTablero[0].length);
		int i = 0;
		for (; i < matrizTablero.length; i++) 
		{
		
			for (int j = 0; j < matrizTablero[0].length; j++) 
			{
				//System.out.print("[i"+i+",j"+j);
				//System.out.print("- ip"+(i*medidaLado)+", jp"+(j*medidaLado)+"]");
				if (matrizTablero[i][j] != 0) 
				{
					
					
					g.setColor(new Color( matrizTablero[i][j]));					
					g.fillRect(j*medidaLado, i*medidaLado, medidaLado, medidaLado);
					
					g.setColor(Color.black);
					g.drawRect(j*medidaLado, i*medidaLado, medidaLado, medidaLado);
				}
				
			}
		//	System.out.println();
		}
		
		//System.out.println("I"+i);
		
	}
	///se esta seguro que se colicion con le tablero o con el limite
	public void agregarFicha(Ficha ficha){
		
		Vector2D positionFicha = ficha.position;
		int medidaLado = GenericGame.getMedidaLado();
				
		int im = (int) (positionFicha.getX() / medidaLado);
		int jm = (int) (positionFicha.getY() / medidaLado);
		
		int [][] matriz = ficha.getFicha();
		
		for(int i=0; i< matriz.length;i++)
		{
			for(int j=0; j< matriz[0].length;j++)
			{
				//System.out.println("im " +( im+ i) + " ijm " +( jm+j));
				if(matriz[i][j] != 0)
				matrizTablero[jm+i][im+j]= matriz[i][j];
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
//verificar colicion segun la pocision de la icha
	public boolean existsColision(Ficha ficha) {
		// TODO Auto-generated method stub
		boolean result = false;
		Vector2D positionFicha = ficha.position;
		int medidaLado = GenericGame.getMedidaLado();
		
	
		int im = (int) (positionFicha.getX() / medidaLado);
		int jm = (int) (positionFicha.getY() / medidaLado);
		//System.out.println(im+" "+jm);
	
		for(int i=0; i< matrizTablero.length; i++)
		{
			for(int j=0; j< matrizTablero[0].length;j++)
			{
				System.out.print(matrizTablero[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("im "+ im + " jm "+jm + " posicion X " + positionFicha.getX() + " posicion Y " + positionFicha.getY());
		
		int [][] matriz = ficha.getFicha();
		
		for(int i=0; i< matriz.length&&!result;i++)
		{
			for(int j=0; j< matriz[0].length && !result;j++)
			{
				if(matriz[i][j]!= 0 )
				result =	matrizTablero[jm+i][im+j] != 0;
			}
		}
		
		return result;

	}
	
	
	
}
