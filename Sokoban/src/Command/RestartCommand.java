package Command;

import Model.Model;
import Model.MyModel;

public class RestartCommand extends Command {
	private MyModel model;
	
	public RestartCommand(MyModel m)
	{
		this.model=m;
	}
	
	public void execute() 
	{		
		model.restart();
	}
}
