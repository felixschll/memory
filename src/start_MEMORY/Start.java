package start_MEMORY;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import JSON.JSONhandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Changes are reported to Slack as well - This is still under Testing
 * 
 * @author Gruppe 6 - Memory DHBW Mannheim
 */
public class Start extends Application {
	private static JSONhandler jhdl = new JSONhandler();
	private static int gamemode = 1;
	private static Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/MainMenu/Menu.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		stage.setResizable(false);
		stage.initStyle(StageStyle.UNDECORATED);
		setStage(stage);
		stage.show();
		jhdl.pull();
		// initialize MP3Handler
		jhdl.readVolume();
	}

	public static JSONhandler getJhdl() {
		return jhdl;
	}

	public static void setJhdl(JSONhandler jhdl) {
		Start.jhdl = jhdl;
	}

	public static int getGamemode() {
		return gamemode;
	}

	public static void setGamemode(int gamemode) {
		Start.gamemode = gamemode;
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		Start.stage = stage;
	}
}
