package fxml_controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import game.GameMaster;
import game.Player;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import sound.MP3handler;
import start_MEMORY.Start;

public class MultiplayerController01 implements Initializable {
	
	@FXML
	private AnchorPane Anchor;
	
	@FXML 
	private Button two;

	
	FXMLLoader loader = new FXMLLoader();
	
	//Set the number of players and redirect to the next scene
	@FXML
	private void handleButtonTwo (ActionEvent event) {
		Start.setGamemode(2);
		loadNextScene();
	}
	@FXML
	private void handleButtonThree (ActionEvent event) {
		Start.setGamemode(3);
		loadNextScene();
	}
	@FXML
	private void handleButtonFour (ActionEvent event) {
		Start.setGamemode(4);
		loadNextScene();
	}
		
	private void loadNextScene() {
		AnchorPane pane;
		try {
			pane = FXMLLoader.load(getClass().getResource("/fxml/Multiplayer/Multiplayer02.fxml"));
			Anchor.getChildren().setAll(pane);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}