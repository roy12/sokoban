package view;
	
import java.io.File;

import Controller.MyController;
import Model.MyModel;
import javafx.application.Application;
import javafx.stage.Stage;
import sun.audio.ContinuousAudioDataStream;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
			BorderPane root = (BorderPane)loader.load();
			MainWindowController view = loader.getController();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("SokobanMaster");
			
			//music
			playMusic();
			
			primaryStage.setOnCloseRequest(event -> {
				view.exit();
			});
			init(view);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void init(MainWindowController view) {
		MyModel model = new MyModel();
		MyController controller = new MyController(model, view);
		
		model.addObserver(controller);
		view.addObserver(controller);
		view.start();	
	}
	
	public void playMusic()
	{
		String musicFile = "./recources/MoZZ.mp3";     // For example
		
		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(5);
		mediaPlayer.play();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}