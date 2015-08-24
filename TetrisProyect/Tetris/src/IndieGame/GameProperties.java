package IndieGame;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GameProperties {

	
	public static void loadProperties() {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			//System.out.println(prop.getProperty("widht"));
			//System.out.println(prop.getProperty("height"));
			
			AbstractGame.Width = Integer.parseInt(prop.getProperty("widht"));
			AbstractGame.Height = Integer.parseInt(prop.getProperty("height"));
			GenericGame.Width = Integer.parseInt(prop.getProperty("widht"));
			GenericGame.Height = Integer.parseInt(prop.getProperty("height"));
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	  }
	
}
