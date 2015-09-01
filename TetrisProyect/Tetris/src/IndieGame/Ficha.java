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
	
	public final static String UBICARFICHA = "UBICARFICHA";
	public final static String DETECT_COLISION = "DETECT_COLISION";
	
	protected Color color = null;
	
	private int filasMatrizL;
	private int colsMatrizL;

	private final int NORMAL = 0;
	
	private final int JIRADO = 1;
	private volatile int  state = NORMAL;
	
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
	
	public Ficha(int forma,int colorc){//, GameContext contexto ){
		
		super();
		orientation = 0;
		medidalado = GenericGame.getMedidaLado();
	
		//position = new Vector2D();		
		position = new Vector2D((GenericGame.Width/2) - medidalado , 0);
		direction = new Vector2D(medidalado, 0);
		
		int vcolor = colorc;
		color = new Color( vcolor);
	
		tipo = forma;
		
		
		switch (forma) {
		case TIPO1:
			
			filasMatrizL = 1;
			colsMatrizL = 1;
			matrizFicha = new int[filasMatrizL][colsMatrizL];
			this._height = medidalado* matrizFicha.length;
			this._width=medidalado* matrizFicha.length;
			
			matrizFicha[0][0] = vcolor;
			
			break;
		case TIPO2:
			filasMatrizL = 2;
			colsMatrizL = 3;
			matrizFicha = new int[filasMatrizL][colsMatrizL];
			this._height = medidalado* 2;//matrizFicha.length;
			this._width=medidalado* 3;//matrizFicha.length;
			
			
			matrizFicha[0][0] = vcolor;			
			matrizFicha[1][0] = vcolor;
			matrizFicha[1][1] = vcolor;
			matrizFicha[1][2] = vcolor;
			
			break;
		case TIPO3:
			filasMatrizL = 2;
			colsMatrizL = 3;
			matrizFicha = new int[filasMatrizL][colsMatrizL];
			this._height = medidalado* 2;//matrizFicha.length;
			this._width=medidalado* 3;//matrizFicha.length;
			
			matrizFicha[0][0] = vcolor;			
			matrizFicha[0][1] = vcolor;
			matrizFicha[1][1] = vcolor;
			matrizFicha[1][2] = vcolor;
			
			break;
		case TIPO4:
			filasMatrizL = 2;
			colsMatrizL = 3;
			matrizFicha = new int[filasMatrizL][colsMatrizL];
			this._height = medidalado* 2;//matrizFicha.length;
			this._width=medidalado* 3;//matrizFicha.length;
			
			matrizFicha[0][2] = vcolor;			
			matrizFicha[0][1] = vcolor;
			matrizFicha[1][0] = vcolor;
			matrizFicha[1][1] = vcolor;
			break;
		case TIPO5:
			
			filasMatrizL = 1;
			colsMatrizL = 4;
			matrizFicha = new int[filasMatrizL][colsMatrizL];
			this._height = medidalado* 1;//matrizFicha.length;
			this._width=medidalado* 4;//matrizFicha.length;			
			
			matrizFicha[0][0] = vcolor;			
			matrizFicha[0][1] = vcolor;
			matrizFicha[0][2] = vcolor;
			matrizFicha[0][3] = vcolor;
			break;
		case TIPO6:
			
			filasMatrizL = 2;
			colsMatrizL = 3;
			matrizFicha = new int[filasMatrizL][colsMatrizL];
			this._height = medidalado* 2;//matrizFicha.length;
			this._width=medidalado* 3;//matrizFicha.length;			
			
			matrizFicha[0][1] = vcolor;			
			matrizFicha[1][0] = vcolor;
			matrizFicha[1][1] = vcolor;
			matrizFicha[1][2] = vcolor;
			break;
		case TIPO7:
			
			filasMatrizL = 2;
			colsMatrizL = 2;
			matrizFicha = new int[filasMatrizL][colsMatrizL];
			this._height = medidalado* 2;//matrizFicha.length;
			this._width=medidalado* 2;//matrizFicha.length;
			matrizFicha[0][0] = vcolor;	
			matrizFicha[0][1] = vcolor;
			matrizFicha[1][0] = vcolor;
			matrizFicha[1][1] = vcolor;
			break;
		case TIPO8:
			
			filasMatrizL = 2;
			colsMatrizL = 3;
			matrizFicha = new int[filasMatrizL][colsMatrizL];
			this._height = medidalado* 2;//matrizFicha.length;
			this._width=medidalado* 3;//matrizFicha.length;			
			
			matrizFicha[0][0] = vcolor;			
			matrizFicha[0][1] = vcolor;
			matrizFicha[0][2] = vcolor;
			matrizFicha[1][0] = vcolor;
			matrizFicha[1][2] = vcolor;
			break;
			
		default:
			break;
		}		
	}
		
	
	public Ficha(int forma){//, GameContext contexto ){
		
		super();
		orientation = 0;
		medidalado = GenericGame.getMedidaLado();
	
		//position = new Vector2D();		
		position = new Vector2D((GenericGame.Width/2) - medidalado , 0);
		direction = new Vector2D(medidalado, 0);
		Random r = new Random();
		int vcolor = (r.nextInt(9) + 1);
		
		vcolor = 6;
		color = new Color( vcolor);
	//System.out.println("color "+vcolor);
		tipo = forma;
		
		
		switch (forma) {
		case TIPO1:
			
			filasMatrizL = 1;
			colsMatrizL = 1;
			matrizFicha = new int[filasMatrizL][colsMatrizL];
			this._height = medidalado* matrizFicha.length;
			this._width=medidalado* matrizFicha.length;
			
			matrizFicha[0][0] = vcolor;
			
			break;
		case TIPO2:
			filasMatrizL = 2;
			colsMatrizL = 3;
			matrizFicha = new int[filasMatrizL][colsMatrizL];
			this._height = medidalado* 2;//matrizFicha.length;
			this._width=medidalado* 3;//matrizFicha.length;
			
			
			matrizFicha[0][0] = vcolor;			
			matrizFicha[1][0] = vcolor;
			matrizFicha[1][1] = vcolor;
			matrizFicha[1][2] = vcolor;
			
			break;
		case TIPO3:
			filasMatrizL = 2;
			colsMatrizL = 3;
			matrizFicha = new int[filasMatrizL][colsMatrizL];
			this._height = medidalado* 2;//matrizFicha.length;
			this._width=medidalado* 3;//matrizFicha.length;
			
			matrizFicha[0][0] = vcolor;			
			matrizFicha[0][1] = vcolor;
			matrizFicha[1][1] = vcolor;
			matrizFicha[1][2] = vcolor;
			
			break;
		case TIPO4:
			
			
			/*      [][]    
			 * 4  [][]  
			 */
			
			filasMatrizL = 2;
			colsMatrizL = 3;
			matrizFicha = new int[filasMatrizL][colsMatrizL];
			this._height = medidalado* 2;//matrizFicha.length;
			this._width=medidalado* 3;//matrizFicha.length;
			
			matrizFicha[0][2] = vcolor;			
			matrizFicha[0][1] = vcolor;
			matrizFicha[1][0] = vcolor;
			matrizFicha[1][1] = vcolor;
			break;
		case TIPO5:
			
			filasMatrizL = 1;
			colsMatrizL = 4;
			matrizFicha = new int[filasMatrizL][colsMatrizL];
			this._height = medidalado* 1;//matrizFicha.length;
			this._width=medidalado* 4;//matrizFicha.length;			
			
			matrizFicha[0][0] = vcolor;			
			matrizFicha[0][1] = vcolor;
			matrizFicha[0][2] = vcolor;
			matrizFicha[0][3] = vcolor;
			break;
		case TIPO6:
			
			filasMatrizL = 2;
			colsMatrizL = 3;
			matrizFicha = new int[filasMatrizL][colsMatrizL];
			this._height = medidalado* 2;//matrizFicha.length;
			this._width=medidalado* 3;//matrizFicha.length;			
			
			matrizFicha[0][1] = vcolor;			
			matrizFicha[1][0] = vcolor;
			matrizFicha[1][1] = vcolor;
			matrizFicha[1][2] = vcolor;
			break;
		case TIPO7:
			
			filasMatrizL = 2;
			colsMatrizL = 2;
			matrizFicha = new int[filasMatrizL][colsMatrizL];
			this._height = medidalado* 2;//matrizFicha.length;
			this._width=medidalado* 2;//matrizFicha.length;
			matrizFicha[0][0] = vcolor;	
			matrizFicha[0][1] = vcolor;
			matrizFicha[1][0] = vcolor;
			matrizFicha[1][1] = vcolor;
			break;
		case TIPO8:
			
			filasMatrizL = 2;
			colsMatrizL = 3;
			matrizFicha = new int[filasMatrizL][colsMatrizL];
			this._height = medidalado* 2;//matrizFicha.length;
			this._width=medidalado* 3;//matrizFicha.length;			
			
			matrizFicha[0][0] = vcolor;			
			matrizFicha[0][1] = vcolor;
			matrizFicha[0][2] = vcolor;
			matrizFicha[1][0] = vcolor;
			matrizFicha[1][2] = vcolor;
			break;
			
		default:
			break;
		}		
	}	 	
	
	public Ficha Copy(){
		Ficha f = new Ficha(tipo, color.getRGB());
		f._contexto = _contexto;
		f.position = this.position.Copy();
		for(int i = 0;i<orientation;i++){
			f.rotate();
		}
		
		
		/*new int[filasMatrizL][colsMatrizL];
		
			for(int i = 0; i< filasMatrizL ;i++ ){
				for(int j = 0; j< colsMatrizL ;j++ ){
					
					f.matrizFicha[i][j]= matrizFicha[i][j];
				}
			}
		*/			
			//System.out.println("FICHA COPIADA "+f);
		return f;
	}
	
	public void  ReloadFicha(int forma){//, GameContext contexto ){
			
			
			orientation = 0;
			medidalado =  GenericGame.Width / Juego.COLUMNAS;
		
			//position = new Vector2D();		
			position = new Vector2D((GenericGame.Width/2) - medidalado , 0);
			direction = new Vector2D(medidalado, 0);
			Random r = new Random();
			int vcolor = r.nextInt();
			color = new Color( vcolor);
		
			tipo = forma;
			
			
			switch (forma) {
			case TIPO1:
				
				filasMatrizL = 1;
				colsMatrizL = 1;
				matrizFicha = new int[filasMatrizL][colsMatrizL];
				this._height = medidalado* filasMatrizL;
				this._width=medidalado* filasMatrizL;
				
				matrizFicha[0][0] = vcolor;
				
				break;
			case TIPO2:
				filasMatrizL = 2;
				colsMatrizL = 3;
				matrizFicha = new int[filasMatrizL][colsMatrizL];
				this._height = medidalado* filasMatrizL;//matrizFicha.length;
				this._width=medidalado* colsMatrizL;//matrizFicha.length;
				
				
				matrizFicha[0][0] = vcolor;			
				matrizFicha[1][0] = vcolor;
				matrizFicha[1][1] = vcolor;
				matrizFicha[1][2] = vcolor;
				
				break;
			case TIPO3:
				filasMatrizL = 2;
				colsMatrizL = 3;
				matrizFicha = new int[filasMatrizL][colsMatrizL];
				this._height = medidalado* filasMatrizL;//matrizFicha.length;
				this._width=medidalado* colsMatrizL;//matrizFicha.length;
				
				matrizFicha[0][0] = vcolor;			
				matrizFicha[0][1] = vcolor;
				matrizFicha[1][1] = vcolor;
				matrizFicha[1][2] = vcolor;
				
				break;
			case TIPO4:
				filasMatrizL = 2;
				colsMatrizL = 3;
				matrizFicha = new int[filasMatrizL][colsMatrizL];
				this._height = medidalado* filasMatrizL;//matrizFicha.length;
				this._width=medidalado* colsMatrizL;//matrizFicha.length;
				
				matrizFicha[0][2] = vcolor;			
				matrizFicha[0][1] = vcolor;
				matrizFicha[1][0] = vcolor;
				matrizFicha[1][1] = vcolor;
				break;
			case TIPO5:
				
				filasMatrizL = 1;
				colsMatrizL = 4;
				matrizFicha = new int[filasMatrizL][colsMatrizL];
				this._height = medidalado* filasMatrizL;//matrizFicha.length;
				this._width=medidalado* colsMatrizL;//matrizFicha.length;			
				
				matrizFicha[0][0] = vcolor;			
				matrizFicha[0][1] = vcolor;
				matrizFicha[0][2] = vcolor;
				matrizFicha[0][3] = vcolor;
				break;
			case TIPO6:
				
				filasMatrizL = 2;
				colsMatrizL = 3;
				matrizFicha = new int[filasMatrizL][colsMatrizL];
				this._height = medidalado* filasMatrizL;//matrizFicha.length;
				this._width=medidalado* colsMatrizL;//matrizFicha.length;			
				
				matrizFicha[0][1] = vcolor;			
				matrizFicha[1][0] = vcolor;
				matrizFicha[1][1] = vcolor;
				matrizFicha[1][2] = vcolor;
				break;
			case TIPO7:
				
				filasMatrizL = 2;
				colsMatrizL = 2;
				matrizFicha = new int[filasMatrizL][colsMatrizL];
				this._height = medidalado* filasMatrizL;//matrizFicha.length;
				this._width=medidalado* colsMatrizL;//matrizFicha.length;
				matrizFicha[0][0] = vcolor;	
				matrizFicha[0][1] = vcolor;
				matrizFicha[1][0] = vcolor;
				matrizFicha[1][1] = vcolor;
				break;
			case TIPO8:
				
				filasMatrizL = 2;
				colsMatrizL = 3;
				matrizFicha = new int[filasMatrizL][colsMatrizL];
				this._height = medidalado* filasMatrizL;//matrizFicha.length;
				this._width=medidalado* colsMatrizL;//matrizFicha.length;			
				
				matrizFicha[0][0] = vcolor;			
				matrizFicha[0][1] = vcolor;
				matrizFicha[0][2] = vcolor;
				matrizFicha[1][0] = vcolor;
				matrizFicha[1][2] = vcolor;
				break;
				
			default:
				break;
			}		
		}	 	
	
	public void move(int scalar) {
		Vector2D direction =  this.direction.Multiply(scalar);
		Vector2D 	newposition = Vector2D.Add(position,direction);
		
		boolean flag = (newposition.getX() >= 0 &&  newposition.getX()+_width <= AbstractGame.Width) && (!_contexto.getTablero().existsCollisionHorizontal(this,direction)) ;
		
		//System.out.println(newposition);
		if(flag)
		position = newposition;
		
	}
	
	public void rotate(){
		
		
		//System.out.println(" rotate ");
		orientation++;
		orientation = orientation % 4;
		
		int aux =_height;
		_height = _width;
		_width = aux;
		
		 aux = filasMatrizL;
		filasMatrizL = colsMatrizL;
		colsMatrizL = aux;
				
		int temp = (int)position.getX() + _width;
		//System.out.println(temp+" comparacion "+ GenericGame.Width);
		if (temp > GenericGame.Width){
		
			Vector2D v = new Vector2D(temp - GenericGame.Width,0).Multiply(-1);	
			//System.out.println("ini correccion "+ position);
			position = Vector2D.Add(position, v);
			//System.out.println("fin correccion "+ position);
		}
		
	
		
		
	}
	
	public int[][] getFicha(){
		
		int[][] matriz = new int[filasMatrizL][colsMatrizL];
		int contador = 0;
		int pivote = filasMatrizL > colsMatrizL? filasMatrizL : colsMatrizL;
		switch (orientation) {
		case 0:
			for(int i = 0;i<matrizFicha.length;i++ ){				
				//int filtemp = contador/filasMatrizL;
					for(int j = 0;j<matrizFicha[0].length;j++,contador++){
						matriz[contador/colsMatrizL][contador%colsMatrizL] = matrizFicha[i][j];
					}
				}
		break;
		case 1:
				
			for(int j = 0;j<matrizFicha[0].length;j++ ){				
				for(int i = matrizFicha.length-1;i>-1;i--,contador++ )	{
						matriz[contador/colsMatrizL][contador%colsMatrizL] = matrizFicha[i][j];
						
						
					}
				}
				
		break;
		case 2:
				for(int i = matrizFicha.length-1; i>-1 ;i-- ){				
					for(int j = matrizFicha[0].length-1; j> -1 ;j--,contador++ ){
						matriz[contador/colsMatrizL][contador%colsMatrizL] = matrizFicha[i][j];
					}
				}
		break;
		case 3:
				
			for(int j = matrizFicha[0].length-1; j>-1 ;j--){				
					for(int i = 0;i<matrizFicha.length;i++ ,contador++ )	{
						matriz[contador/colsMatrizL][contador%colsMatrizL] = matrizFicha[i][j];
					}
				}
		break;				
		}
		
		return matriz;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		int[][] maux = getFicha();
		
		String fichaString = new String();
	/*	for (int i = 0; i < filasMatrizL*colsMatrizL; i++) {
			fichaString = fichaString +  (maux[i/colsMatrizL][i%colsMatrizL]!= 0?1:0 )+ ' ';
			if (i%colsMatrizL == colsMatrizL - 1) {
				fichaString = fichaString + '\n';
			}
		}*/
		fichaString ="tipo "+tipo+" orientacion "+orientation+ '\n';
		for (int i = 0; i < maux.length; i++) {

			for (int j = 0; j < maux[0].length; j++) {
				fichaString = fichaString +  (maux[i][j]!= 0?1:0 )+ ' ';
			}
			fichaString = fichaString + '\n';
		}
		
		return fichaString;
	}
	
	
	public void setFicha(int[][] m){
		for (int i = 0; i < m.length; i++) 
			for (int j = 0; j < m.length; j++) 
				matrizFicha[i][j] = m[i][j];	
	}
	
	public int getTipo(){return tipo;}

	@Override
	protected void draw(Graphics2D g) {
		
		//info
		Vector2D vector = position.Copy().Div(medidalado);
		//game compoent
		//
		g.setColor(Color.RED);
		
		g.drawString(vector.toString(), (int)position.getX(), (int)position.getY()-10);
		//
		
		//gamecomponet
		 vector = position.Copy();
		
		switch (orientation) {
			case 0:
				for(int i = 0;i<matrizFicha.length;i++ ){					
					for(int j = 0;j<matrizFicha[0].length;j++ ){
						
						if(matrizFicha[i][j]!= 0 )
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
						
						if(matrizFicha[i][j]!= 0)
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
						
						if(matrizFicha[i][j]!= 0)
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
						
						if(matrizFicha[i][j]!= 0)
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
		//
		
		
		
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
	
	int counter = 0;
	
	private  int pivote = 30;
	
	private  int pivoteHrizontal = 5;
	
	private static final int pivoteconstante = 30;


	
	public void setVelocity(int pivote) {
		this.pivote = pivote;
	}

	
	public int getVelocity(){
		return pivote ;
	}


	/* (non-Javadoc)
	 * @see IndieGame.Sprite#update()
	 */
	@Override
	protected void update() {
		////
		
	
		if(counter % pivoteHrizontal == 0)
		{
		if (Input.FLECHA_DERECHA) {
			
	
			move(1);
		}
		else if (Input.FLECHA_IZQUIERDA) {
			move(-1);
		}
		}
	System.out.println((state == NORMAL) +" estado real");
		if ( state == NORMAL&& Input.ROTACION ) {                                          
			
			
		 	/*Ficha cp = this.Copy();
		 	cp.rotate();
			boolean resul = 	_contexto.SendGetMessageBool(cp, Ficha.DETECT_COLISION); 
			System.out.println(resul);
			if(!resul)*/
			//System.out.println("ROTACION");
			//System.out.println("original");
			//System.out.println(this);
			
			Ficha  f = this.Copy();
			f.rotate();
			
			int temp = (int)position.getY() + _height;
			
			//si la altura es mayor o igual al largo de la pantalla
			//no se debe hacer la colicion 
			//ya que ae producira un indexbounsexception
			if(!(temp >= GenericGame.Height)&&!_contexto.getTablero().existsCollisionRotacion(f)){
				System.out.println(state);
				state = JIRADO;
				rotate();
			}
				//rotate();
		}
		else if(state == JIRADO&& !Input.ROTACION ){
			System.out.println("COME BACK NORMAL");
			state = NORMAL;
		}
		
		if (Input.FLECHA_ABAJO > 0) {
		
		   if(Input.FLECHA_ABAJO < 0.25)
			pivote = 25;
			 if(Input.FLECHA_ABAJO < 0.5)
				 pivote = 15;
			 if(Input.FLECHA_ABAJO < 0.75)
				 pivote = 1;
		}
		else
			 pivote =pivoteconstante;
		///
		
		//// rogidbody
		// TODO Auto-generated method stub
		
		//System.out.println( this._contexto.GetTime());
		//System.out.println( this._contexto.GetTime()%5);
		//System.out.println(animPeriod);
		/*animTotalTime = (animTotalTime + animPeriod) % (long)(1000 * seqDuration);
		System.out.println(animTotalTime);*/
		counter ++;
		if(counter % pivote == 0)
		{
			Vector2D	auxposition = Vector2D.Add(position, _contexto.getGravedad());
		 	Ficha cp = this.Copy();
			cp.position = auxposition;
			boolean resul = 	auxposition.getY() > GenericGame.Height- _height ||_contexto.SendGetMessageBool(cp, Ficha.DETECT_COLISION) ;
				if( resul ){
					//TODO metodo de ejemplo
					_contexto.SendMessage(this, Ficha.UBICARFICHA);			
				}
				else{
					
					position = auxposition;
					
				}
				
		}
		///
		
	}
	
}
