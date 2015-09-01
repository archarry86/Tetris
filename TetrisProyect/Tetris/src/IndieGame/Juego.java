package IndieGame;


public class Juego {

	int totalLineas;
	

	final static int COLUMNAS = 10;
	final static int FILAS = 20;
	
	Tablero tablero = null;
	
	public Juego(){
		
	
		tablero = new Tablero();
	
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
			
		//System.out.println();
	}
	
	public void imprimirTablero(){
		
		
	}


	public String toString(){

		String str = new String();
		str += "JUEGO " + '\n';
		str += "PUNTAJE " + '\n';
		str += "TABLERO " + '\n';
		str += tablero.toString();
		return str;
	}
	

	public void renewBoard() {
		// TODO Auto-generated method stub
		tablero = new Tablero();
	}
}
