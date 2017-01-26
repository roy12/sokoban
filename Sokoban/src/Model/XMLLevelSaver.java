package Model;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XMLLevelSaver implements LevelSaver {
						
		public XMLLevelSaver(Level lvl,String str) throws IOException {
			FileOutputStream out = new FileOutputStream("./recources\\"+str); //to change path
			XMLEncoder xmlOut = new XMLEncoder(new BufferedOutputStream(out));
			xmlOut.writeObject(lvl);
			xmlOut.close();
		}
}
