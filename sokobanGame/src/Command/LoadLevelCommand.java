package Command;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Model.ExtensionFinder;
import Model.Level;
import Model.Model;
import Model.ObjectLevelLoader;
import Model.TextLevelLoader;
import Model.XMLLevelLoader;

public class LoadLevelCommand extends Command {
	private Model model;
	
	public LoadLevelCommand(Model m)
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