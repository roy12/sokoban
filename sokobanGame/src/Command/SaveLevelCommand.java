package Command;

import java.io.IOException;


import Model.Model;

public class SaveLevelCommand extends Command {
	private Model model;
	
	public SaveLevelCommand(Model m) {
		this.model=m;
	}

	@Override
	public void execute() {
		String saveAs = params.get(0);
		try {
			model.save(saveAs);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	
}

