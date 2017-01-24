package Command;

import Model.Model;

public class RestartCommand extends Command {
	private Model model;
	
	public RestartCommand(Model m)
	{
		this.model=m;
	}
	
	public void execute() 
	{		
		model.restart();
	}
}
