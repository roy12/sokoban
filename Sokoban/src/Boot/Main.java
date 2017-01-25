package Boot;

import java.io.IOException;

import Controller.MyController;
import Model.Model;
import Model.MyModel;
import view.CLI;


public class Main {

	public static void main(String[] args) throws IOException {
		
		MyModel model = new MyModel();
		CLI view = new CLI();
		MyController controller = new MyController(model, view);
		
		model.addObserver(controller);	// listen to model
		view.addObserver(controller);	// listen to view
		
		view.start();
	}

}

//Load C:\\Users\\moshe\\Desktop\\מדעי המחשב\\שנה ב'\\פיתוח תכנה מתקדם\\אבן דרך\\1\\textLvls\\level2.txt
//Load C:\\Users\\moshe\\Desktop\\Level2.txt
//Load C:\\Users\\Admin\\Desktop\\sokoban\\level1.txt
//Load C:\\Users\\ligyor1\\Desktop\\sokobanGame\\level1.txt
