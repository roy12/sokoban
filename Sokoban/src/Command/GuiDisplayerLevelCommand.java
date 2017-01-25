package Command;

import Model.Model;
import Model.MyModel;
import view.View;

public class GuiDisplayerLevelCommand extends Command{

	private MyModel model;
	private View view;
	
	public GuiDisplayerLevelCommand(MyModel model, View view) {
		this.model = model;
		this.view = view;
	}	

	@Override
	public void execute() {
		model.guiDisplay(view);
	}
}