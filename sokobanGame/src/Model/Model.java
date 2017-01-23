package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

import Command.SaveLevelCommand;

public class Model extends Observable {
	
	private Level lvl=null;
	
	
	public void move(String s)
	{
		if(s.contains("Down"))
		{
			@SuppressWarnings("unused")
			Movement m=new MoveDown(lvl);
		}
		else if(s.contains("Right"))
		{
			@SuppressWarnings("unused")
			Movement m=new MoveRight(lvl);
		}
		else if(s.contains("Left"))
		{
			@SuppressWarnings("unused")
			Movement m=new MoveLeft(lvl);
		}
		else if(s.contains("Up"))
		{
			@SuppressWarnings("unused")
			Movement m=new MoveUp(lvl);
		}
		else 
		{
			System.out.println("Unknown Command");
		}
		this.setChanged();
		List<String> params = new LinkedList<String>();
		params.add("Display");
		this.notifyObservers(params);
	}
	
	public void load(String str) throws FileNotFoundException
	{
		FileInputStream in = new FileInputStream(str);
		ExtensionFinder ef = new ExtensionFinder(str);
		String str2 = ef.getStr2();
		if (str2.contains("txt")){
			this.lvl = new TextLevelLoader().loadLevel(in);
		}
		else if (str2.contains("xml")){
			this.lvl = new XMLLevelLoader().loadLevel(in);
		}
		else if (str2.contains("ser")){
			this.lvl = new ObjectLevelLoader().loadLevel(in);
		}
		else {
			System.out.println("Wrong Path");
		}
		this.setChanged();
		List<String> params = new LinkedList<String>();
		params.add("Display");
		this.notifyObservers(params);
	}
	
	public void save(String str) throws IOException
	{
		if (lvl !=null)
		{
			ExtensionFinder ef = new ExtensionFinder(str);
			String str2 = ef.getStr2();
			if (str2!=null)
			{
			if (str2.contains("txt")){
				@SuppressWarnings("unused")
				TextLevelSaver textSave = new TextLevelSaver(lvl,str);
			}
			else if (str2.contains("xml")){
				@SuppressWarnings("unused")
				XMLLevelSaver xmlSave = new XMLLevelSaver(lvl, str);
			}
			else if (str2.contains("ser")){
				@SuppressWarnings("unused")
				ObjectLevelSaver objectSave = new ObjectLevelSaver(lvl, str);
			}
			else {
				System.out.println("Wrong Path");
			}
			}
			else
			{
				System.out.println("i dont know to save in that filetype");
			}
		}
		else
		{
			System.out.println("You can't save an empty Level");
	}	
			
		
}
	
	public void exit()
	{
		System.out.println("Save before exit ?");
		String str="";
		while(!str.contains("yes") & !str.contains("no"))
		{
			Scanner s = new Scanner(System.in);
			str = s.nextLine();	
			if (str.contains("yes"))
			{
				System.out.println("save as ? ");
				s = new Scanner(System.in);
				str = s.nextLine();
				SaveLevelCommand save = new SaveLevelCommand(this);
				
				System.exit(0);
			}
			else if(str.contains("no"))
			{
				
				System.exit(0);
			}
			else 
				{System.out.println("yes/no");}
		}
	}
	
	
	public void display() {		
		for(int i=0;i<this.lvl.getHeight();i++){	
			for(int j=0;j<this.lvl.getWidth();j++){
				System.out.print(this.lvl.getMap()[i][j].getType());
				
			}
		System.out.println();
		}
	}
}
