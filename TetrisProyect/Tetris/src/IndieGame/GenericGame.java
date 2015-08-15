package IndieGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;

import Math.Vector2D;


public class GenericGame extends AbstractGame implements GameContext{

	
	private Juego j;
	private Ficha ficha;
	
	public GenericGame(){
		super();
	
		
		//addKeyListener(this);
		j = new Juego();
		
		//Inicializar una lista
		//TODO PASAR CREACION DE FICHAS A UN FACTORY
		Random r = new Random();
		
		int FichaInicial = (int)(r.nextDouble() * 7) + 1;
				
		ficha = new Ficha(FichaInicial);
		ficha._contexto = this;
		//ficha._pto = 
		
		//
		lista.add(ficha);//, this)); 
	

	
   }
	
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		for(Sprite s:this.lista){
			s.update();
		}
		
		
	}

	@Override
	public void gameRender() {
		// TODO Auto-generated method stub
    	Graphics2D g=(Graphics2D) buffer.getGraphics();
    	/*g.setColor(Color.WHITE);
    	g.fillRect(0, 0, Whidt,Height);
    	*/
        	
    	g.setColor(Color.WHITE);
    	g.fillRect(0, 0, GenericGame.Width,GenericGame.Height);    	
    	
    	
    	for(Sprite s:this.lista){
			s.draw(g);
		}
    	
    	reportarEstadisticas(g);
    	
	}



	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Keyressed " + arg0);
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			ficha.Move(-1);
			break;
		case KeyEvent.VK_RIGHT:
			ficha.Move(1);
			break;
		case KeyEvent.VK_SPACE:
			
			break;
		} 
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
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
	//	for(int i=0;i<)
		boolean result= false;
		for(int i=0;i<lista.size()&&!result;i++){
			Sprite saux= lista.get(i);
			if(!saux.equals(s)){
				result=	saux.getShape().intersects(s.getShape().getBounds2D());
			}
		}
		return result;
	}

	@Override
	public void paintScreen() {
		// TODO Auto-generated method stub
		
	    	Graphics2D g=(Graphics2D) getGraphics();
	    	
	    	g.drawRect(18, 18, GenericGame.Width+3, GenericGame.Height+3);
	    	g.drawRect(19, 19, GenericGame.Width+1, GenericGame.Height+1);
	    	
	    	g.drawImage(buffer,20,20,this);
	    
		
	}

	@Override
	public Vector2D getGravedad() {
		// TODO Auto-generated method stub
		int medidalado =  GenericGame.Width / Juego.COLUMNAS;
		return new Vector2D(0, medidalado);
	}
  //TODO ATRIBUTO MODEO TEXT
	int val = 6;
	@Override
	public void SendMessage(Object obj, String Message) {
		// TODO Auto-generated method stub
		//TODO QUEMADO
		
		val =  (val++ %8) + 1;
		int FichaInicial =val;
		ficha = new Ficha(FichaInicial);

		System.out.println(" FichaInicial " + FichaInicial);	
		ficha._contexto = this;
		//
		lista.clear();
		lista.add(ficha);//, this)); 
	}

}
