package Model;

import java.io.InputStream;

public interface LevelLoader {
	public default Level loadLevel(InputStream in)
	{
		return null;
	}
}
