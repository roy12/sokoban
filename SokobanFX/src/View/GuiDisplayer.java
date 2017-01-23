package View;

import Model.Level;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GuiDisplayer extends Canvas {
	
	private Level lvl = null;
	
	public GuiDisplayer(Level lvl) {
		this.lvl=lvl;
		
	}

	public void setData(Level lvl){
		this.lvl = lvl;
		redraw();
	}

	public void redraw(){
		
		double W = lvl.getWidth();
		double H = lvl.getHeight();
		double w = W / lvl.getMap()[0].length;
		double h = H / lvl.getMap().length;
		
		GraphicsContext gc = getGraphicsContext2D();
		
		for(int i=0;i<this.lvl.getHeight();i++){	
			for(int j=0;j<this.lvl.getWidth();j++){
				if(lvl.getMap()[i][j].getType()=='#'){
					gc.fillRect(j*w, i*h, w, h);					
				}
				if(lvl.getMap()[i][j].getType()==' '){
					gc.setFill(Color.WHITE);
					gc.fillRect(j*w, i*h, w, h);
				}
				if(lvl.getMap()[i][j].getType()=='@'){
					gc.setFill(Color.BROWN);
					gc.fillRect(j*w, i*h, w, h);
				}
				if(lvl.getMap()[i][j].getType()=='A'){
					
					gc.setFill(Color.RED);
					gc.fillRect(j*w, i*h, w, h);
				}
		}
		
	}
	}
}
