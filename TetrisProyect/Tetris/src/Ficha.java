import java.awt.Graphics2D;
import java.awt.Shape;

import IndieGame.Sprite;


public class Ficha extends  Sprite {

	public final static int TIPO1 = 1;
	public final static int TIPO2 = 2;
	public final static int TIPO3 = 3;
	public final static int TIPO4 = 4;
	public final static int TIPO5 = 5;
	public final static int TIPO6 = 6;
	public final static int TIPO7 = 7;
	public final static int TIPO8 = 8;
	
	
	private int[][] matrizFicha;
	int tipo;
	
	/* Fichas
	 * 
	 * 1  [] 
	 * 
	 * 2  []  
	 * 	  [][][]	    
	 *
	 * 3  [][] 
	 * 	    [][]	
     *   
     *      [][]    
	 * 4  [][]  
	 *   
	 * 5  [][][][] 
	 * 
	 *      []   
	 * 6  [][][] 
	 * 
	 * 7  [][] 
	 *    [][] 
	 *     
	 * 8  [][][] 
	 * 	  []  []  
	 * */
	public Ficha(int forma){
		matrizFicha = new int[4][4];
		tipo = forma;
		
		switch (forma) {
		case TIPO1:
			matrizFicha[0][0] = 1;
			break;
		case TIPO2:
			matrizFicha[0][0] = 1;			
			matrizFicha[1][0] = 1;
			matrizFicha[1][1] = 1;
			matrizFicha[1][2] = 1;
			break;
		case TIPO3:
			matrizFicha[0][0] = 1;			
			matrizFicha[0][1] = 1;
			matrizFicha[1][1] = 1;
			matrizFicha[1][2] = 1;
			break;
		case TIPO4:
			matrizFicha[0][2] = 1;			
			matrizFicha[0][1] = 1;
			matrizFicha[1][0] = 1;
			matrizFicha[1][1] = 1;
			break;
		case TIPO5:
			matrizFicha[0][0] = 1;			
			matrizFicha[0][1] = 1;
			matrizFicha[0][2] = 1;
			matrizFicha[0][3] = 1;
			break;
		case TIPO6:
			matrizFicha[0][1] = 1;			
			matrizFicha[1][0] = 1;
			matrizFicha[1][1] = 1;
			matrizFicha[1][2] = 1;
			break;
		case TIPO7:
			matrizFicha[0][0] = 1;	
			matrizFicha[0][1] = 1;
			matrizFicha[1][0] = 1;
			matrizFicha[1][1] = 1;
			break;
		case TIPO8:
			matrizFicha[0][0] = 1;			
			matrizFicha[0][1] = 1;
			matrizFicha[0][2] = 1;
			matrizFicha[1][1] = 1;
			break;
			
		default:
			break;
		}		
	}	 	
	
	public int[][] getFicha(){
		return matrizFicha;
	}
	
	public void setFicha(int[][] m){
		for (int i = 0; i < m.length; i++) 
			for (int j = 0; j < m.length; j++) 
				matrizFicha[i][j] = m[i][j];	
	}
	
	public int getTipo(){return tipo;}

	@Override
	protected void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
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
	
}
