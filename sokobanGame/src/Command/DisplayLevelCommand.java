package Command;

import Model.Level;
import Model.Model;
import View.Display;
import View.View;

public class DisplayLevelCommand extends Command{

	private Model model;
	private View view;
	
	public DisplayLevelCommand(Model model, View view) {
		this.model = model;
		this.view = view;
	}	
	
	@Override
	public void execute() {
		model.display();
	}

}