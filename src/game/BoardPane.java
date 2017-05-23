package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import image.IMGhandler;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

public class BoardPane extends FlowPane {

	public TransitionRun TR = new TransitionRun();
	private int cardPairs;
	private double picSize = (this.getPrefWidth() / this.getPrefHeight() * 120);
	private Card selCard;
	private BoardPane board = this;
	private double offset;

	ObservableList<Node> workingCollection;
	List<Card> cardList = new ArrayList<Card>();
	List<Integer> cardValues = new ArrayList<Integer>();

	public BoardPane() {
		super();
		board.setCache(true);
		board.setCacheShape(true);
		board.setStyle("-fx-border-color: Blue");
		board.setVgap(50);
		board.setHgap(50);
		board.setAlignment(Pos.CENTER);
		offset = 0;
	}

	public int getCardPairs() {
		return cardPairs;
	}

	public Card getSelCard() {
		return selCard;
	}

	public void Initialize(int cardPairs) {
		board.cardPairs = cardPairs;
		for (int i = 0; i < board.getCardPairs(); i++) {
			cardValues.add(i);
			cardValues.add(i);
		}
		Collections.shuffle(cardValues);
		for (int val : cardValues) {
			Card c = new Card(offset, offset, picSize, picSize);
			// coordinates must be adapted
			c.setFill(IMGhandler.getImage_card(0));
			c.setCard_Id(val);
			c.setArcHeight(10);
			c.setArcWidth(10);
			c.setCache(true);
			c.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent t) {
					if (!c.isMatched() && !c.isTurned()) {
						c.setCacheHint(CacheHint.QUALITY);
						GameEventhandler.cardturn(c, board);
					}
				}
			});
			cardList.add(c);
		}
		board.getChildren().addAll(cardList);
	}

	public void setCardcount(int cardcount) {
		this.cardPairs = cardcount;
	}

	public void setSelCard(Card selCard) {
		this.selCard = selCard;
	}

	public void Test() {
		this.getChildren().add(new Button("Test"));
	}
	

}
