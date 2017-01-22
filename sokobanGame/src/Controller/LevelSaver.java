package Controller;

import java.io.IOException;

import Model.Level;

public interface LevelSaver {
	public default void saveLevel(Level lv) throws IOException{}
}
