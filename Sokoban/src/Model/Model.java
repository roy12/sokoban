package Model;

import java.io.FileNotFoundException;
import java.io.IOException;


import java.util.Observable;



public class Model extends Observable {
	
	private Level lvl=null;
	private String str=null;
	
	public Model() {
		// TODO Auto-generated constructor stub
	}
	
	public void move(String s)
	{		
	}
	
	public void load(String str) throws FileNotFoundException
	{		
	}
	
	public void save(String str) throws IOException
	{			
	}
	
	public void exit()
	{		
	}
	
	public void display()
	{		
	}

	public Level getLvl() {
		return lvl;
	}

	public void setLvl(Level lvl) {
		this.lvl = lvl;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
}

