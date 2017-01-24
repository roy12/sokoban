package Command;

import Model.Model;
import view.View;

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