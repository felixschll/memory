package game;

import javafx.animation.Interpolator;
import javafx.animation.Transition;

public class TransitionRun implements Runnable {
	private Transition anim;
	
	public Transition getAnim() {
		return anim;
	}

	public void setAnim(Transition anim) {
		this.anim = anim;
	}

	@Override
	public void run() {
		anim.setInterpolator(Interpolator.EASE_BOTH);
		anim.play();
	}

}
