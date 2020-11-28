package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	private EclipseGUI ecgui;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ecgui = new EclipseGUI(primaryStage);
		FXMLLoader fxmll = new FXMLLoader(getClass().getResource("main.fxml"));
		fxmll.setController(ecgui);
		Parent root = fxmll.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Eclipse");
		primaryStage.show();
	}
	
}

