package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;import java.io.IOException;
import java.io.InputStream;

import Model.Level;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GuiDisplayer extends Canvas{
	
	/*
	private StringProperty wallFileName;
	private StringProperty boxFileName;
	private StringProperty targetFileName;
	private StringProperty playerFileName;
	private StringProperty floorFileName;
	*/
	
	private Image wall;
	private Image box;
	private Image player;
	private Image target;
	private Image floor;
	private Image finish;
	private Level lvl = null;
	
	
	public GuiDisplayer() {
		
		/*
		wallFileName = new SimpleStringProperty();
		boxFileName = new SimpleStringProperty();
		targetFileName = new SimpleStringProperty();
		playerFileName = new SimpleStringProperty();
		floorFileName = new SimpleStringProperty();
		*/
		
		try {
			
			wall = new Image(new FileInputStream("./recources/Wall.png"));
			box = new Image(new FileInputStream("./recources/Box.png"));
			target = new Image(new FileInputStream("./recources/Target.png"));
			player = new Image(new FileInputStream("./recources/Player.png"));
			floor = new Image(new FileInputStream("./recources/Floor.png"));
			finish = new Image(new FileInputStream("./recources/Finish.png"));
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void finishLevel()
	{
		
		double W = this.getWidth();
		double H = this.getHeight();
		double w = W / lvl.getMap()[0].length;
		double h = H / lvl.getMap().length;
		
		GraphicsContext gc = getGraphicsContext2D();
		gc.clearRect(0, 0, W, H);
		
		
	for(int i=0;i<this.lvl.getHeight();i++)
	{	
		for(int j=0;j<this.lvl.getWidth();j++)
		{
			gc.drawImage(finish , j*w, i*h, w, h);
		}
	}
	}
	

	public void setData(Level lvl){
		this.lvl = lvl;
		redraw();
	}

	public void redraw(){

		double W = this.getWidth();
		double H = this.getHeight();
		double w = W / lvl.getMap()[0].length;
		double h = H / lvl.getMap().length;
		
		GraphicsContext gc = getGraphicsContext2D();
		gc.clearRect(0, 0, W, H);
		
		for(int i=0;i<this.lvl.getHeight();i++){	
			for(int j=0;j<this.lvl.getWidth();j++){
				if(lvl.getMap()[i][j].getType()=='#'){	
					gc.drawImage(wall, j*w, i*h, w, h);					
				}
				else if(lvl.getMap()[i][j].getType()==' '){
					gc.drawImage(floor, j*w, i*h, w, h);
				}
				else if(lvl.getMap()[i][j].getType()=='@'){
					gc.drawImage(box ,j*w, i*h, w, h);
				}
				else if(lvl.getMap()[i][j].getType()=='A'){
					gc.drawImage(player , j*w, i*h, w, h);
				}
				else if(lvl.getMap()[i][j].getType()=='o'){
					gc.drawImage(target , j*w, i*h, w, h);
				}
		}
		
}
	
		
}
/*
	public String getWallFiLEName() {
		return wallFileName.get();
	}

	public void setWallFiLEName(String wallFiLEName) {
		this.wallFileName.set(wallFiLEName);
	}

	public String getBoxFileName() {
		return boxFileName.get();
	}

	public void setBoxFileName(String boxFileName) {
		this.boxFileName.set(boxFileName);
	}

	public String getTargetFileNam() {
		return targetFileName.get();
	}

	public void setTargetFileName(String targetFileName) {
		this.targetFileName.set(targetFileName);
	}

	public String getPlayerFileName() {
		return playerFileName.get();
	}

	public void setPlayerFileName(String playerFileName) {
		this.playerFileName.set(playerFileName);
	}

	public String getFloorFileName() {
		return floorFileName.get();
	}

	public void setFloorFileName(String floorFileName) {
		this.floorFileName.set(floorFileName);
	}
	*/
	}
	

