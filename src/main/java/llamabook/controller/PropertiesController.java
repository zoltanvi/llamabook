package llamabook.controller;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ShockWave
 */
public class PropertiesController {
        Properties props;
        
        public PropertiesController(){
            this.props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("props.properties"));


		} catch (IOException ex) {
			Logger.getLogger(PropertiesController.class.getName()).log(Level.SEVERE, null, ex);
		}
        }

	public String getProperty(String kulcs) {
		String visszaadom = this.props.getProperty(kulcs);
		return visszaadom;
	}

}
