package Command;

import Model.Model;
import view.View;

public class GuiDisplayerLevelCommand extends Command{

	private Model model;
	private View view;
	
	public GuiDisplayerLevelCommand(Model model, View view) {
		this.model = model;
		this.view = view;
	}	

	@Override
	public void execute() {
		model.guiDisplay(view);
	}
}