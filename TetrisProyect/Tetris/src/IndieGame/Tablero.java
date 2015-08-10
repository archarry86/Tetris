package IndieGame;

public class Tablero {
	
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
	
	
	
}
