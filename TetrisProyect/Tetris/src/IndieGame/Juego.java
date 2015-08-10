package IndieGame;


public class Juego {

	
	
	int[][] matrizTablero;	
	final static int COLUMNAS = 10;
	final static int FILAS = 20;
	
	
	public Juego(){
		
		matrizTablero = new int[FILAS][COLUMNAS];	
		/*
		for (int i = 0; i < FILAS -1; i++) {
			for (int j = 0; j < COLUMNAS -1; j++) {
				matrizTablero[i][j] = 1;
				
			}
		}
		borrarLinea(15);
		imprimirTablero();*/
	}
	
	
	

	/**
	 * Actualizar la matriz logica
	 * @param ficha
	 */
	public void avanzarFicha(Ficha ficha){		
		
	}
	
	/**
	 * Acatauliza al momento de que no pueda avanzar
	 * Si se forma una linea debe destruitla 
	 * ahumentar puntaje
	 * @param f
	 */
	public void actualizarMatrizLogica(Ficha f){
		
	}
	
	
	/**
	 * TRUE si la ficha puede avanzar
	 * llego al final o no puede continuar
	 * @param ficha
	 * @return
	 */
	public boolean evaluarAvance(Ficha ficha){
		return false;
	}
	
	
	
	public void borrarLinea(int indice){
		//System.out.println("index  " + indice);
		//for (int i = indice; i < FILAS-1; i++) 
			for (int j = 0; j < COLUMNAS-1; j++) 
			{
				matrizTablero[indice][j] = 0;
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
