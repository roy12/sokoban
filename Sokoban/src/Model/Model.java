package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

import Command.SaveLevelCommand;
import view.GuiDisplayer;
import view.View;

public class Model extends Observable {
	
	private Level lvl=null;
	private String str=null;
	
	
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
	
}

