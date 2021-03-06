package game;

import javafx.animation.AnimationTimer;

public class CustomAnimationTimer extends AnimationTimer {
	private long startTime;
	private double currentTime;

	public double getCurrent() {
		return currentTime;
	}

	@Override
	public void handle(long timestamp) {
		long now = System.currentTimeMillis();
		currentTime = (now - startTime) / 1000.0;
	}

	public void reset() {
		currentTime = 0;
	}

	@Override
	public void start() {
		if (currentTime == 0) {
			startTime = System.currentTimeMillis();
			super.start();
		}
	}
}
