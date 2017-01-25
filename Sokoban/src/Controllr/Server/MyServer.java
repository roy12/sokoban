package Controllr.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Observable;

public class MyServer extends Observable {
	
	private int port;
	private boolean stop;
	
	
	public MyServer(int port)
	{
		this.port=port;
		stop = false;
	}
	
	
	public void runServer() throws IOException{
		
		String commandKey;
		ServerSocket server = new ServerSocket(port);
		server.setSoTimeout(1000);
		Socket aClient = server.accept();
		BufferedReader br = new BufferedReader(new InputStreamReader(aClient.getInputStream()));
		LinkedList<String> params= new LinkedList<String>();
		while(!stop)
		{
			
			commandKey = br.readLine();
			String[] list = commandKey.split(" ");
			for(String s : list)
				params.add(s);
			notifyObservers(params);
			
		}
		server.close();
		
	}

	public void start(){
		new Thread(new Runnable(){
			public void run(){
				try{runServer(); } catch (IOException e){e.printStackTrace(); }
			}
		}).start();
	}

	public void stop()
	{
		stop=true;
	}
	
}
