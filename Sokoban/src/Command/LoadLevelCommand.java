package Command;


import java.io.FileNotFoundException;
import Model.Model;
import Model.MyModel;


public class LoadLevelCommand extends Command {
	private MyModel model;
	
	public LoadLevelCommand(MyModel m)
	{
		this.model=m;
	}

	@Override
	public void execute() {
		String path = params.get(0);
		try {
			
			model.load(path);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
}