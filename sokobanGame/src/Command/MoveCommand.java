package Command;

import Model.Model;

public class MoveCommand extends Command {
	private Model model;
	
public MoveCommand(Model m) {
	this.model=m;
	}

@Override
public void execute() {
	String direction = params.get(0);		
	model.move(direction);
	
}
	
	

}
