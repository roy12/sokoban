package View;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import Model.Level;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;

public class FXMainController extends Observable implements View {
	@FXML
	
	public void moveDown(){
		List<String> params = new LinkedList<String>();
		params.add("Move");
		params.add("Down");
		setChanged();
		notifyObservers(params);
	}

	
	public void openFile(){
				
		List<String> params = new LinkedList<String>();	
		
		FileChooser fc = new FileChooser();
		fc.setTitle("Choose File");
		fc.setInitialDirectory(new File("./recources"));
		File chosen = fc.showOpenDialog(null);
		if(chosen!=null)
			System.out.println(chosen.getName());
		
		params.add("Load");
		params.add(chosen.getPath());
		setChanged();
		notifyObservers(params);
	}


	@Override
	public void displayLevel(Level lvl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayError(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}
	
}
