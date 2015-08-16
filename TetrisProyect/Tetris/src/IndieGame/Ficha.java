package IndieGame;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.Random;

import Math.Vector2D;



public class Ficha extends  Sprite {

	public final static int TIPO1 = 1;
	public final static int TIPO2 = 2;
	public final static int TIPO3 = 3;
	public final static int TIPO4 = 4;
	public final static int TIPO5 = 5;
	public final static int TIPO6 = 6;
	public final static int TIPO7 = 7;
	public final static int TIPO8 = 8;
	
	protected Color color = null;
	
	
	
	
	
	public Color getC() {
		return color;
	}
	
	

	protected  int[][] matrizFicha;
	protected int tipo;
	
	protected int medidalado= 0;
	
	protected int orientation= 0;
	
	
	private Vector2D direction =null;
	
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
	public Ficha(int forma){//, GameContext contexto ){
		
		super();
	
		medidalado =  GenericGame.Width / Juego.COLUMNAS;
	
		//position = new Vector2D();		
		position = new Vector2D((GenericGame.Width/2) - medidalado , 0);
		direction = new Vector2D(medidalado, 0);
		Random r = new Random();
		color = new Color( r.nextInt());
	
		tipo = forma;
		

		
		switch (forma) {
		case TIPO1:
			
			matrizFicha = new int[1][1];
			this._height = medidalado* matrizFicha.length;
			this._width=medidalado* matrizFicha.length;
			
			matrizFicha[0][0] = 1;
			
			break;
		case TIPO2:
			matrizFicha = new int[2][3];
			this._height = medidalado* 2;//matrizFicha.length;
			this._width=medidalado* 3;//matrizFicha.length;
			
			
			matrizFicha[0][0] = 1;			
			matrizFicha[1][0] = 1;
			matrizFicha[1][1] = 1;
			matrizFicha[1][2] = 1;
			
			break;
		case TIPO3:
			matrizFicha = new int[2][3];
			this._height = medidalado* 2;//matrizFicha.length;
			this._width=medidalado* 3;//matrizFicha.length;
			
			matrizFicha[0][0] = 1;			
			matrizFicha[0][1] = 1;
			matrizFicha[1][1] = 1;
			matrizFicha[1][2] = 1;
			
			break;
		case TIPO4:
			matrizFicha = new int[2][3];
			this._height = medidalado* 2;//matrizFicha.length;
			this._width=medidalado* 3;//matrizFicha.length;
			
			matrizFicha[0][2] = 1;			
			matrizFicha[0][1] = 1;
			matrizFicha[1][0] = 1;
			matrizFicha[1][1] = 1;
			break;
		case TIPO5:
			
			matrizFicha = new int[1][4];
			this._height = medidalado* 1;//matrizFicha.length;
			this._width=medidalado* 4;//matrizFicha.length;
			
			
			matrizFicha[0][0] = 1;			
			matrizFicha[0][1] = 1;
			matrizFicha[0][2] = 1;
			matrizFicha[0][3] = 1;
			break;
		case TIPO6:
			matrizFicha = new int[2][3];
			this._height = medidalado* 2;//matrizFicha.length;
			this._width=medidalado* 3;//matrizFicha.length;
			
			
			matrizFicha[0][1] = 1;			
			matrizFicha[1][0] = 1;
			matrizFicha[1][1] = 1;
			matrizFicha[1][2] = 1;
			break;
		case TIPO7:
			matrizFicha = new int[2][2];
			this._height = medidalado* 2;//matrizFicha.length;
			this._width=medidalado* 2;//matrizFicha.length;
			matrizFicha[0][0] = 1;	
			matrizFicha[0][1] = 1;
			matrizFicha[1][0] = 1;
			matrizFicha[1][1] = 1;
			break;
		case TIPO8:
			
			matrizFicha = new int[2][3];
			this._height = medidalado* 2;//matrizFicha.length;
			this._width=medidalado* 3;//matrizFicha.length;
			
			
			matrizFicha[0][0] = 1;			
			matrizFicha[0][1] = 1;
			matrizFicha[0][2] = 1;
			matrizFicha[1][0] = 1;
			matrizFicha[1][2] = 1;
			break;
			
		default:
			break;
		}		
	}	 	
	/**
	 * @param forma
	 * @return
	 */
	/**
	 * @param forma
	 * @return
	 */
	public static Ficha FactoryFicha(int forma){
		Ficha f= null;
//		
//		switch (forma) {
//		case TIPO1:
//			
//			
//			break;
//		case TIPO2:
//		
//			
//			break;
//		case TIPO3:
//			
//			
//			break;
//		case TIPO4:
//			
//			break;
//		case TIPO5:
//			
//			break;
//		case TIPO6:
//			
//			break;
//		case TIPO7:
//			
//			break;
//		case TIPO8:
//		
//			break;
//			
//		default:
//			break;
//		}	
//		
		return f;
	}
	public void move(int scalar) {
		Vector2D 	newposition = Vector2D.Add(position, direction.Multiply(scalar));
		boolean flag =newposition.getX() >= 0 &&  newposition.getX()+_width <= AbstractGame.Width ;
		System.out.println(newposition);
		if(flag)
		position = newposition;
		
	}
	
	public void rotate(){
		orientation++;
		orientation = orientation % 4;
		
		int aux =_height;
		_height = _width;
		_width = aux;
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
		
		Vector2D vector = position.Copy();
		
		
		switch (orientation) {
			case 0:
				for(int i = 0;i<matrizFicha.length;i++ ){
					
					for(int j = 0;j<matrizFicha[0].length;j++ ){
						
						if(matrizFicha[i][j]==1 )
						{
							
							g.setColor(color);
							g.fillRect((int)vector.getX(), (int)vector.getY(), medidalado, medidalado);
							
							g.setColor(Color.black);
							g.drawRect((int)vector.getX(), (int)vector.getY(), medidalado, medidalado);
							
						}
						
						vector = Vector2D.Add(vector, new Vector2D(medidalado,0));
					}
					vector = Vector2D.Add(position, new Vector2D(0,medidalado));
				}
			break;
			case 1:
				
				for(int i = matrizFicha.length-1;i>-1;i-- ){
					
					for(int j = 0;j<matrizFicha[0].length;j++ ){
						
						if(matrizFicha[i][j]==1 )
						{
							
							g.setColor(color);
							g.fillRect((int)vector.getX(), (int)vector.getY(), medidalado, medidalado);
							
							g.setColor(Color.black);
							g.drawRect((int)vector.getX(), (int)vector.getY(), medidalado, medidalado);
							
						}
						
						vector = Vector2D.Add(vector, new Vector2D(0,medidalado));
					}
					vector = Vector2D.Add(position, new Vector2D(medidalado,0));
				}
				
			break;
			case 2:
				for(int i = matrizFicha.length-1; i>-1 ;i-- ){
					
					for(int j = matrizFicha[0].length-1; j> -1 ;j-- ){
						
						if(matrizFicha[i][j]==1 )
						{
							
							g.setColor(color);
							g.fillRect((int)vector.getX(), (int)vector.getY(), medidalado, medidalado);
							
							g.setColor(Color.black);
							g.drawRect((int)vector.getX(), (int)vector.getY(), medidalado, medidalado);
							
						}
						
						vector = Vector2D.Add(vector, new Vector2D(medidalado,0));
					}
					vector = Vector2D.Add(position, new Vector2D(0,medidalado));
				}
				break;
			case 3:
				
				for(int i = 0;i<matrizFicha.length;i++ ){
					
					for(int j = matrizFicha[0].length-1; j>-1 ;j-- ){
						
						if(matrizFicha[i][j]==1 )
						{
							
							g.setColor(color);
							g.fillRect((int)vector.getX(), (int)vector.getY(), medidalado, medidalado);
							
							g.setColor(Color.black);
							g.drawRect((int)vector.getX(), (int)vector.getY(), medidalado, medidalado);
							
						}
						
						vector = Vector2D.Add(vector, new Vector2D(0,medidalado));
					}
					vector = Vector2D.Add(position, new Vector2D(medidalado,0));
				}
				break;
		}
		
		
		
		
		// TODO Auto-generated method stub
		/*switch (tipo) {
		case TIPO1:
			
			break;
		case TIPO2:
			
			break;
		case TIPO3:
			
			break;
		case TIPO4:
			
			break;
		case TIPO5:
		
			break;
		case TIPO6:
		
			break;
		case TIPO7:
		
			break;
		case TIPO8:
			
			break;
			
		default:
			break;
		}	*/	
	}

	@Override
	protected Shape getShape() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub
		position = Vector2D.Add(position, _contexto.getGravedad());
		if(position.getY() > GenericGame.Height- _height){
			//TODO metodo de ejemplo
			_contexto.SendMessage(this, "REMOVER_FICHA");
		}
		
	}
	
}
