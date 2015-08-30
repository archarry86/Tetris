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
		///gamecomponente
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
		///
		//System.out.println("MATRIZ TABLERO "+matrizTablero.length+"_" +matrizTablero[0].length);
		///game compoente
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
		///game compoente
		//System.out.println("I"+i);
		
	}
	///se esta seguro que se colicion con le tablero o con el limite
	public void agregarFicha(Ficha ficha){
		
		Vector2D positionFicha = ficha.position;
		int medidaLado = GenericGame.getMedidaLado();
				
		int im = (int) (positionFicha.getX() / medidaLado);
		int jm = (int) (positionFicha.getY() / medidaLado);
		
		int [][] matriz = ficha.getFicha();
		//System.out.println("agregrar ficha");
		//System.out.println(this);
		//System.out.println(ficha);
		//System.out.println("im "+ im + " jm "+jm + " posicion X " + positionFicha.getX() + " posicion Y " + positionFicha.getY());
		
		
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
	
	public boolean existsCollision(Ficha ficha) {
		// TODO Auto-generated method stub
		boolean result = false;
		Vector2D positionFicha = ficha.position;
		int medidaLado = GenericGame.getMedidaLado();
		
	
		int im = (int) (positionFicha.getX() / medidaLado);
		int jm = (int) (positionFicha.getY() / medidaLado);
		
		//System.out.println("existsColision");
		//System.out.println(this);
		//System.out.println(ficha);
		//System.out.println("im "+ im + " jm "+jm + " posicion X " + positionFicha.getX() + " posicion Y " + positionFicha.getY());
		
		
		//System.out.println(im+" "+jm);
	
	//	System.out.println(this);
		//System.out.println("im "+ im + " jm "+jm + " posicion X " + positionFicha.getX() + " posicion Y " + positionFicha.getY());
		
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
	
	/**
	 * Detecta si hubo una colicion horizontal con elementos del tablero
	 * precondicion se ha validado que la ficha este en los limites del tablero
	 * @param ficha
	 * @param direction
	 * @return
	 */
	public boolean existsCollisionHorizontal(Ficha ficha, Vector2D direction){
		System.out.println("existsCollisionHorizontal");
		boolean result = false;
		
		
		Vector2D positionFicha = ficha.position;
		int medidaLado = GenericGame.getMedidaLado();
		
		int [][] matriz = ficha.getFicha();
	
	

		if(direction.getX() > 0){
			//al mover a la derecha 
			
			int minimum = (matrizTablero[0].length - matriz[0].length);
			
			int im = (int) (positionFicha.getX() / medidaLado);
			int jm = (int) (positionFicha.getY() / medidaLado);
			
			if(im+1 <= minimum){
				im  += 1;
			
			}
			
			 
			/*
			for(int i = jm ; i<jm+matriz.length && !result;i++ ){
				System.out.println("i  "+ i + " im "+im + " posicion X " + positionFicha.getX() + " posicion Y " + positionFicha.getY());
				
				result = 	matrizTablero[i][im] !=0;
			}*/
			for(int i=0; i< matriz.length&&!result;i++)
			{
				for(int j=0; j< matriz[0].length && !result;j++)
				{
					try{
						//System.out.print("i"+i+",j"+j);
					
						if(matriz[i][j]!= 0 )
						result =	matrizTablero[jm+i][im+j] != 0;
						
					}catch (Exception e) {
						// TODO: handle exception
						System.out.println("ERROR "+(jm+i)+" "+(im+j));
						e.printStackTrace();
						System.exit(0);
					}
				}
				System.out.println();
			}
			
		}else if(direction.getX() < 0){
			// al mover a la izquerda 
			int im = (int) (positionFicha.getX() / medidaLado)-1;
			int jm = (int) (positionFicha.getY() / medidaLado);
			
			//System.out.println("im "+ im + " jm "+jm + " posicion X " + positionFicha.getX() + " posicion Y " + positionFicha.getY());
			
		
			for(int i=0; i< matriz.length&&!result;i++)
			{
				for(int j=0; j< matriz[0].length && !result;j++)
				{
					try{
						
					
					if(matriz[i][j]!= 0 )
					result =	matrizTablero[jm+i][im+j] != 0;
					}catch (Exception e) {
						// TODO: handle exception
						System.out.println((jm+i)+" "+(im+j));
						e.printStackTrace();
						System.exit(0);
					}
				}
			}
			
			/*
			for(int i = jm ; i<jm+matriz.length&& !result;i++ ){
				System.out.println("i  "+ i + " im "+im + " posicion X " + positionFicha.getX() + " posicion Y " + positionFicha.getY());
				
				result = 	matrizTablero[i][im] !=0;
			}*/
		}
		
		
		return result;
	
	}
	
	/**Valida si una o más fila fueron completadas 
	 * @param ficha
	 * @return numero de filas completadas
	 */
	
	public int limpiarFila(Ficha ficha){
		
		Vector2D positionFicha = ficha.position;
		int medidaLado = GenericGame.getMedidaLado();
				
		int im = (int) (positionFicha.getX() / medidaLado);
		int jm = (int) (positionFicha.getY() / medidaLado);
		
		int [][] matriz = ficha.getFicha();
		int filasCompletadas = 0;		
		
		for(int i=jm; i< jm + matriz.length;i++) // validar todas de la matriz del tablero que fueron ocupadas por la nueva ficha
		{
			boolean filaCompleta = true;			
			buscarFilaCompleta: for( int j =0; j< matrizTablero[0].length;j++)
			{
				if (matrizTablero[i][j] == 0) {// recorrer la fila completa buscando espacios en blanco
					filaCompleta = false;					
					break buscarFilaCompleta;
				}
			}
			if (filaCompleta) // desplazar desde esa posicion la matriz hacia abajo  
			{			
				filasCompletadas++;
				desplazarLineas: for (int indice = i; indice > 0; indice--) 
				{					
					boolean filaVacia = true;
					for (int j = 0; j < matrizTablero[0].length; j++) 
					{
						matrizTablero[indice][j] = matrizTablero[indice-1][j]; 
						if (matrizTablero[indice-1][j] != 0) // valida si hay fichas o espacios en blanco
							filaVacia = false;
						if (j == matrizTablero[0].length - 1)  // valida en la ultima columna de la fila
							if (filaVacia) //La fila esta llena de 0 
								break desplazarLineas;	
					}	
				}
			}
		}
		return filasCompletadas;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){

		String str = new String();
	/*	for (int i = 0; i < matrizTablero.length*matrizTablero[0].length; i++) {
			
			int aux = (matrizTablero[i/matrizTablero[0].length][i%matrizTablero[0].length]!= 0 ?1:0 );
			str = str +  aux+ ' ';
			if (i%matrizTablero[0].length == matrizTablero[0].length - 1) {
				str = str + '\n';
			}
		}*/
		
		for (int i = 0; i < matrizTablero.length; i++) {
			for (int j = 0; j < matrizTablero[0].length; j++) {
				int aux = (matrizTablero[i][j]!= 0 ?1:0 );
				str = str +  aux+ ' ';
			}
			str = str + '\n';
		}
		return str;
	}
//verificar colicion segun la pocision de la icha
	
	
	
}
