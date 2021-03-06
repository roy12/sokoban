package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import Model.Level;
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
	@SuppressWarnings("unused")
	private Image player;
	private Image target;
	private Image floor;
	private Image finish;
	private Level lvl = null;
	private Image movedown;
	private Image moveup;
	private Image moveright;
	private Image moveleft;
	
	public GuiDisplayer() {
		
		/*
		wallFileName = new SimpleStringProperty();
		boxFileName = new SimpleStringProperty();
		targetFileName = new SimpleStringProperty();
		playerFileName = new SimpleStringProperty();
		floorFileName = new SimpleStringProperty();
		*/
		
		try {
			
			wall = new Image(new FileInputStream("./recources/LevelObjects/Wall.png"));
			box = new Image(new FileInputStream("./recources/LevelObjects/Box.png"));
			target = new Image(new FileInputStream("./recources/LevelObjects/Target.png"));
			player = new Image(new FileInputStream("./recources/Players/Cartman/Player_Down.png"));
			floor = new Image(new FileInputStream("./recources/LevelObjects/Floor.png"));
			finish = new Image(new FileInputStream("./recources/FinishLevel/Finish.png"));
			movedown = new Image(new FileInputStream("./recources/Players/Saya/Player_Down.png"));
			moveup = new Image(new FileInputStream("./recources/Players/Saya/Player_Up.png"));
			moveright = new Image(new FileInputStream("./recources/Players/Saya/Player_Right.png"));
			moveleft = new Image(new FileInputStream("./recources/Players/Saya/Player_Left.png"));
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void finishLevel()
	{
		
		double W = this.getWidth();
		double H = this.getHeight();
		@SuppressWarnings("unused")
		double w = W / lvl.getMap()[0].length;
		@SuppressWarnings("unused")
		double h = H / lvl.getMap().length;
		
		GraphicsContext gc = getGraphicsContext2D();
		
		gc.clearRect(0, 0, W, H);		
		
			
			gc.drawImage(finish , 5,5, W, H);
	
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
					if (lvl.getLastMove().equals("Down"))
						gc.drawImage(movedown , j*w, i*h, w, h);
					else if(lvl.getLastMove().equals("Up"))
					{
						gc.drawImage(moveup , j*w, i*h, w, h);
					}
					else if(lvl.getLastMove().equals("Left"))
					{
						gc.drawImage(moveleft , j*w, i*h, w, h);
					}
					else if(lvl.getLastMove().equals("Right"))
					{
						gc.drawImage(moveright , j*w, i*h, w, h);
					}
				}
				else if(lvl.getMap()[i][j].getType()=='o'){
					gc.drawImage(target , j*w, i*h, w, h);
				}
		}
		
}
	
		
}
	
	public void displayOpenPage()
	{
		try {
			Image openPage  = new Image(new FileInputStream("./recources/OpenGame/Open_Game2.png"));
			if(openPage!=null){
			GraphicsContext gc = getGraphicsContext2D();
			@SuppressWarnings("unused")
			double w = getWidth();
			@SuppressWarnings("unused")
			double h = getHeight();
			
			gc.drawImage(openPage,0,0);
			
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	

