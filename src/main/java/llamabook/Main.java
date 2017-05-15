package llamabook;

import llamabook.controller.Controller;
import llamabook.view.LoginScreen;
/**
 *
 * @author ShockWave
 *
 */
public class Main {
    public static void main(String[] args) {
        // Login screen elindítása
    	
        startApp();

    }

    private static void startApp() {
        Controller controller = new Controller();
	controller.startDesktop();
    }

}
