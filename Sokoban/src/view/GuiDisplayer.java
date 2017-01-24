package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Model.Level;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GuiDisplayer extends Canvas{
	
	
private Level lvl = null;
	

	public void setData(Level lvl){
		this.lvl = lvl;
		
	
		
		redraw();
	}

	public void redraw(){
		
		StringProperty wallFiLEName , boxFileName , targetFileName , playerFileName , floorFileName;
		Image  wall=null , box=null , target=null , player=null , floor=null ;
		
		wallFiLEName = new SimpleStringProperty();
		boxFileName = new SimpleStringProperty();
		targetFileName = new SimpleStringProperty();
		playerFileName = new SimpleStringProperty();
		floorFileName = new SimpleStringProperty();
		
		try {
			wall = new Image(new FileInputStream(wallFiLEName.get()));
			box = new Image(new FileInputStream(boxFileName.get()));
			target = new Image(new FileInputStream(targetFileName.get()));
			player = new Image(new FileInputStream(playerFileName.get()));
			floor = new Image(new FileInputStream(floorFileName.get()));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		double W = this.getWidth();
		double H = this.getHeight();
		double w = W / lvl.getMap()[0].length;
		double h = H / lvl.getMap().length;
		
		GraphicsContext gc = getGraphicsContext2D();
		
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
	}
