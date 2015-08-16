package IndieGame;
import Vista.Frame;


public class Main {

	public static void main(String[] args) {
		
		
		
		Ficha ficha = new Ficha(8);
		System.out.println(	ficha);
		ficha.rotate();
		System.out.println(	ficha);
		ficha.rotate();
		System.out.println(	ficha);
		ficha.rotate();
		System.out.println(	ficha);
	
	
		/*
		for (int i = 0; i < 4; i++)
		{ 
			for (int j = 0; j < 4; j++) 
				System.out.print(ficha.getFicha()[i][j] + " ");
			System.out.println();
		}	
		*/
		//Juego juego = new Juego();
		
		
		
		Frame f = new Frame();
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		
		
	}	
	
}
