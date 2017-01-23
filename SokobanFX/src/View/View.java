package View;

import Model.Level;

public interface View {
	void displayLevel(Level lvl);
	void displayError(String msg);
	void start();
}
