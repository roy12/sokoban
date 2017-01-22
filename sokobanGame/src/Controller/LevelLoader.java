package Controller;

import java.io.InputStream;

import Model.Level;

public interface LevelLoader {
	public default Level loadLevel(InputStream in)
	{
		return null;
	}
}
