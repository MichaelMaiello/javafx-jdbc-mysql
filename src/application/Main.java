package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Scene mainScene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			ScrollPane crollPane = loader.load();
			
			crollPane.setFitToHeight(true);
			crollPane.setFitToWidth(true);
			
			mainScene = new Scene(crollPane);
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Sample JavaFX application");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Método de acesso 
	public static Scene getMainScene() {
		return mainScene;
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
