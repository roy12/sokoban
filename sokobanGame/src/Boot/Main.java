package Boot;

import java.io.IOException;

import Controller.MyController;
import Model.Model;
import View.CLI;


public class Main {

	public static void main(String[] args) throws IOException {
		Model model = new Model();
		CLI view = new CLI();
		MyController controller = new MyController(model, view);
		
		model.addObserver(controller);	// listen to model
		view.addObserver(controller);	// listen to view
		
		view.start();
	}

}