package IndieGame;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;



public abstract class AbstractGame extends JPanel implements Runnable,KeyListener 
{
	public static int Width=400;
	
	public static int Height=800;
	
    public final static int MAX_FRMAES_SKIP=5;
	
	public final static int NO_DELAYS_PER_YIELD=16;
	
	public  static int FPS=5;
	
	protected  long periodo=1000/FPS;
	
    protected volatile boolean runing;
    
    protected volatile boolean isPause;
    
    protected BufferedImage buffer;
    
    protected ArrayList<Sprite> lista;
    
    public abstract void Update();
    
    public abstract void gameRender();
    

    
    public abstract void paintScreen();
    
    
    private long to;
    
    private double frames;
    
    
    protected AbstractGame(){
    	
    
    	runing=true;
    	isPause=false;
    	 lista = new ArrayList<Sprite>();
    	 periodo=(1000/FPS);
    }
    
    public void GameStar()
    {
    	//TODO corregir 
    	addControl();
    	buffer=new BufferedImage(Width,Height,BufferedImage.TYPE_INT_RGB);
    	Thread game=new Thread(this);
    	game.start();
    }
   
	private void addControl()
	{
		addKeyListener(new KeyAdapter()
    	{
    		 public void keyPressed(KeyEvent e)
    	       { int keyCode = e.getKeyCode();
    	         if ((keyCode == KeyEvent.VK_ESCAPE) && e.isControlDown() ) {
    	           runing = false;
    	         }
    	         else if((keyCode == KeyEvent.VK_ENTER))
    	         {
    	        	 isPause=!isPause;
    	         }
    	       }
    	}
    	);
	}
   public void pause()
   {
	   isPause=true;
   }
   public void resume()
   {
	   isPause=false;
   }
   public void stopGame()
   {
	   runing=false;
   }

   public void run() 
   {
		long before,after,excess = 0;
		int nodelays=0;
		long periodo=this.periodo*1000000l;
		long sleep,overSleepTime=0;
		to=System.nanoTime();
		before=to;
		int saltosdaddos=0;
		while(runing)
		{
			Update();
			gameRender();
			paintScreen();
			after=System.nanoTime();
			long timediff=after-before;
			sleep=(periodo-timediff)-overSleepTime;
			
			if(sleep>0)
			{
				try 
				 {
					Thread.sleep(sleep/1000000l);
					
				 } 
				 catch (InterruptedException e) 
				 {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 }
				
				 overSleepTime=(System.nanoTime()-after)-sleep;
				 
			}
			else
			{
				 overSleepTime=0;
				 excess-=sleep;
				  if(++ nodelays>=NO_DELAYS_PER_YIELD)
				  {
				   nodelays=0;
				   Thread.yield();
				  }
			}
			 before=System.nanoTime();
			 frames++;
			 int saltos=0;
			 while((excess>periodo)&&(saltos<MAX_FRMAES_SKIP))
			 {
				 excess-=periodo;
				 Update();
				 saltos++;
				 saltosdaddos++;
			 }
			 frames+=saltos;
		}
		//System.out.println(saltosdaddos);
		System.exit(0);
	}
	
   public void reportarEstadisticas(Graphics2D g)
   {
	   g.setColor(Color.BLACK);
	   long tf=System.nanoTime()-to;
	   g.drawString(""+tf/1000000000+"sec",10,10);
	   double t= tf;
	   long fps=(long) ((frames/t)*1000000000); 
	   g.drawString(""+fps+"/"+FPS,100,10);
   }
   
   
  
	

   
}