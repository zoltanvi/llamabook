package llamabook;

import llamabook.controller.Controller;


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
