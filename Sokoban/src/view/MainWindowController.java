package view;

import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import Model.Level;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;

public class MainWindowController extends Observable implements View, Initializable {
	
	@FXML
	GuiDisplayer gd;
	
	public MainWindowController() {
	}
	
	public void handle(KeyEvent event) {		
		
		List<String> params=new LinkedList<String>();
		
		
		if(event.getCode()== KeyCode.UP)
		{			
			params.add("Move");
			params.add("Up");			
		}
		else if(event.getCode()== KeyCode.DOWN)
		{	
			params.add("Move");
			params.add("Down");	
		}
		else if(event.getCode()== KeyCode.RIGHT)
		{	
			params.add("Move");
			params.add("Right");		
		}
		else if(event.getCode()== KeyCode.LEFT)
		{			
			params.add("Move");
			params.add("Left");						
		}
		setChanged();
		notifyObservers(params);		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
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
		if(lvl!=null)
			gd.setData(lvl);		
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
