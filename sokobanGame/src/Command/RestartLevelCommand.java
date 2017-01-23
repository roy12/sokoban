package Command;

import Model.Model;

public class RestartLevelCommand extends Command {
	private Model model;
	
	public RestartLevelCommand(Model m) {
		this.model=m;
	}
	@Override
	public void execute() {
		model.restart();
		
	}

}
