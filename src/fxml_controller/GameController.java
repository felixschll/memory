package fxml_controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//import game.Board;
import game.BoardPane;
import game.GameEventhandler;
import game.GameMaster;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

/**
 *
 * @author D067928
 */
public class GameController implements Initializable {
	FXMLLoader loader = new FXMLLoader();
	@FXML
	private BoardPane gamepane;

	@FXML
	private void gamestart(ActionEvent event) {
		loader.setLocation(getClass().getResource("/FXML/Menu.fxml"));
		try {
			Parent root = loader.load();
			gamepane.getScene().setRoot(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		GameMaster GM = new GameMaster();
		GM.startGame(1, 16, gamepane);
		// gamepane.Test();
		GameEventhandler.fadein(gamepane);
	}
}