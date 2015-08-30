package IndieGame;
import Vista.Frame;


public class Main {

	public static void main(String[] args) {
	
		
	for(int i = 1; i<9;i++)	 {
		
		//System.out.println("FICHA "+i);
		Ficha ficha = new Ficha(i);
		//System.out.println(	ficha);
		ficha.rotate();
		//System.out.println(	ficha);
		ficha.rotate();
		//System.out.println(	ficha);
		ficha.rotate();
		System.out.println(	ficha);
		
		ficha.rotate();
		System.out.println(	ficha);
	}	
	
		/*
		for (int i = 0; i < 4; i++)
		{ 
			for (int j = 0; j < 4; j++) 
				System.out.print(ficha.getFicha()[i][j] + " ");
			System.out.println();
		}	
		*/
		//Juego juego = new Juego();
		
		
		try {
			
	
		Frame f = new Frame();
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(0);
		}
		
	}	
	
}
