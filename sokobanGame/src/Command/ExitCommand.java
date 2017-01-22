package Command;


import Model.Model;

public class ExitCommand extends Command{
	private Model model;
	
public ExitCommand(Model m)  {
	this.model=m;
}
	public void execute() {
	model.exit();
	}
	
}


