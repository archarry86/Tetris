
public class Juego {

	int[][] matrizTablero;	
	final static int FILAS = 20;
	final static int COLUMNAS = 10;
	
	public Juego(){
		
		matrizTablero = new int[FILAS][COLUMNAS];	
		
		for (int i = 0; i < FILAS -1; i++) {
			for (int j = 0; j < COLUMNAS -1; j++) {
				matrizTablero[i][j] = 1;
				
			}
		}
		borrarLinea(15);
		imprimirTablero();
	}
	
	public void crearFicha(int tipoFicha){		
		Ficha ficha = new Ficha(tipoFicha);		
	}
	
	public void avanzarFicha(){		
		
	}
	
	public boolean evaluarAvance(){
		return false;
	}
	
	public void borrarLinea(int indice){
		System.out.println("index  " + indice);
		for (int i = indice; i < FILAS-1; i++) 
			for (int j = 0; j < COLUMNAS-1; j++) 
			{
				matrizTablero[i][j] = 0;
				//System.out.print(matrizTablero[i][j]+ " ");
			}
		//System.out.println();
	}
	
	public void imprimirTablero(){
		
		for (int i = 0; i < FILAS-1; i++)
		{ 
			for (int j = 0; j < COLUMNAS-1; j++) 
				System.out.print(matrizTablero[i][j] + " ");
			System.out.println();
		}	
	}
}
