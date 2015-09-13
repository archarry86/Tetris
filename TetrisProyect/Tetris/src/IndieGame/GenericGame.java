package IndieGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.Console;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.Random;

import javax.imageio.ImageIO;

import Math.Vector2D;
//import Vista.PnlLineas;
import Vista.PnlLineas;

public class GenericGame extends AbstractGame implements GameContext {

	private volatile Juego j = null;
	private volatile Ficha ficha = null;

	private static int medidaLado ;
	
	public static void SetMedidaLado(int medidaLado){
		GenericGame.medidaLado = medidaLado;
	}
	
	private PnlLineas lineas;
	
	public void setLineas(PnlLineas lineas) {
		this.lineas = lineas;
	}

	public GenericGame() {
		super();

		// addKeyListener(this);
		j = new Juego();

		// Inicializar una lista
		// TODO PASAR CREACION DE FICHAS A UN FACTORY
		ficha = FactoryFichaRandom(this);
		//
		//TODO TEST
		girar();
		
		lista.add(ficha);// , this));
		lista.add(j.tablero);

	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		for (Sprite s : this.lista) {
			s.update();
		}

	}

	@Override
	public void gameRender() {
		// TODO Auto-generated method stub
		Graphics2D g = (Graphics2D) buffer.getGraphics();
		/*
		 * g.setColor(Color.WHITE); g.fillRect(0, 0, Whidt,Height);
		 */

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, GenericGame.Width, GenericGame.Height);

		for (Sprite s : this.lista) {
			s.draw(g);
		}

		//reportarEstadisticas(g);

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			//ficha.move(-1);
			Input.FLECHA_DERECHA = false;
			Input.FLECHA_IZQUIERDA = true;
			break;
		case KeyEvent.VK_RIGHT:
			//ficha.move(1);
			Input.FLECHA_DERECHA = true;
			Input.FLECHA_IZQUIERDA = false;
			break;
		case KeyEvent.VK_SPACE:
			//ficha.rotate();
			// System.out.println(ficha.toString());
			Input.ROTACION = true;
			//System.out.println(Input.ROTACION);
			break;
		case  KeyEvent.VK_DOWN:
			
			Input.FLECHA_ABAJO += 0.04;
			if(Input.FLECHA_ABAJO > 1)
				Input.FLECHA_ABAJO = 1;
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getKeyCode()) {
		case  KeyEvent.VK_DOWN:			
			
				Input.FLECHA_ABAJO = 0;
			break;			
		case KeyEvent.VK_LEFT:			
			Input.FLECHA_IZQUIERDA = false;
			break;
		case KeyEvent.VK_RIGHT:			
			Input.FLECHA_DERECHA = false;			
			break;
		case KeyEvent.VK_SPACE:
			//ficha.rotate();
			// System.out.println(ficha.toString());
			Input.ROTACION = false;
			System.out.println("FALSE ROTACION");
			//System.out.println(Input.ROTACION);
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return GenericGame.Height;
	}

	@Override
	public int getPlayerDirection() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[][] getPlayerPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getSecondsElapsed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWhidth() {
		// TODO Auto-generated method stub
		return GenericGame.Width;
	}

	@Override
	public boolean keyState(Object player, Object button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean colisiono(Sprite s) {
		// TODO Auto-generated method stub
		// for(int i=0;i<)
		boolean result = false;
		for (int i = 0; i < lista.size() && !result; i++) {
			Sprite saux = lista.get(i);
			if (!saux.equals(s)) {
				result = saux.getShape().intersects(s.getShape().getBounds2D());
			}
		}
		return result;
	}

	@Override
	public void paintScreen() {
		// TODO Auto-generated method stub

		Graphics2D g = (Graphics2D) getGraphics();

		g.drawRect(18, 18, GenericGame.Width + 3, GenericGame.Height + 3);
		g.drawRect(19, 19, GenericGame.Width + 1, GenericGame.Height + 1);

		g.drawImage(buffer, 20, 20, this);

	}

	@Override
	public Vector2D getGravedad() {
		// TODO Auto-generated method stub
		int medidalado = GenericGame.Width / Juego.COLUMNAS;
		return new Vector2D(0, medidalado);
	}

	public static int getMedidaLado() {
		return medidaLado;//GenericGame.Width / Juego.COLUMNAS;
	}

	// TODO ATRIBUTO MODEO TEXT

    private volatile int  val =0;
    private volatile int cols = 0;
	@Override
	public void SendMessage(Object obj, String Message) {
		// TODO Auto-generated method stub

		if (Message.equals(Ficha.UBICARFICHA)) {
			// System.out.println(j.toString());
			j.tablero.agregarFicha(ficha);
			int filasCompletadas = j.tablero.limpiarFila(ficha);
			
			if(filasCompletadas > 0){
				j.totalLineas+= filasCompletadas;
				if(lineas != null){
					
				lineas.numeroLineas = ""+j.totalLineas;
				new Thread(){
					
					public synchronized void start() {
						
						lineas.repaint();
					};
					
				}.start();
				
				}
			}
			
			
			//System.out.println("filasCompletadas " + filasCompletadas);
			// System.out.println(j.toString());
			// TODO QUEMADO

			val = (val++ % 8) + 1;
			//recargar la ficha
			int FichaInicial = val;
			ficha.ReloadFicha(FichaInicial);
			
			//test
			//cols ++;
			cols = GenericGame.Width / 2;
			//System.out.println(cols * getMedidaLado());
			ficha.position= new Vector2D(cols,ficha.position.getY());
			//System.out.println("ficha recargada "+ficha);
			girar();
			//System.out.println("ficha girada "+ficha);
			
			// si exite colision al crear la nieva ficha
			if(	j.tablero.existsCollision(ficha))
				j.tablero.reloadMatriz();
		}

		
	
	}

	@Override
	public boolean SendGetMessageBool(Object obj, String Message) {
		// TODO Auto-generated method stub
		boolean result = false;
		if (Message.equals(Ficha.DETECT_COLISION)) {

			result = j.tablero.existsCollision((Ficha) obj);
		}
		return result;
	}

	@Override
	public String SendGetMessageString(Object obj, String Message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tablero getTablero() {
		// TODO Auto-generated method stub
		return j.tablero;
	}
	
	public static Ficha FactoryFichaRandom(GameContext c){
		Random r = new Random();

		int FichaInicial = (int) (r.nextInt(7)) + 1;

		Ficha ficha = new Ficha(FichaInicial);
		ficha._contexto = c;
		return ficha;
	}
	static volatile int stval = 6;
	public static Ficha FactoryFichaSecuencial(GameContext c){
		

		stval = (stval++ % 8) + 1;
		// val= 2;
		int FichaInicial = stval;
		

		Ficha ficha = new Ficha(FichaInicial);
		ficha._contexto = c;
		return ficha;
	}
	
   //TEST METODS
	
	public void girar(){
		int i =new Random().nextInt(9)+1;  
		for(int j= 0;j< i;j++)
			ficha.rotate();
		
	}

}
