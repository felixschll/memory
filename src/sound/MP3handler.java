package sound;

import java.net.URISyntaxException;
import java.net.URL;

import game.ExceptionHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MP3handler {
	private static MediaPlayer soundPlayer;
	private static MediaPlayer backgroundPlayer;

	private static double volumebg = 0.5;
	private static double volumefx = 0.5;

	public static void play(int SoundID) {
		String musicFile = "";
		switch (SoundID) {
		case 1:
			musicFile += "01_button";
			break;
		default:
			musicFile += "00_idle";
			break;
		}
		musicFile += ".mp3";
		URL url = MP3handler.class.getResource(musicFile);
		Media sound = new Media(url.toString());
		soundPlayer = new MediaPlayer(sound);
		soundPlayer.setVolume(volumefx);
		soundPlayer.play();
	}

	public static void playbackground(int SoundID) {
		String musicFile = "";
		switch (SoundID) {
		default:
			musicFile += "00_idle";
			break;
		case 1:
			musicFile += "bensound-clearday";
			break;
		case 2:
			musicFile += "bensound-funkyelement";
			break;
		}
		musicFile += ".mp3";
		URL url = MP3handler.class.getResource(musicFile);
		Media sound = null;
		try {
			sound = new Media(url.toURI().toString());
		} catch (URISyntaxException e) {
			ExceptionHandler exc = new ExceptionHandler(e, "Error", "Sound Error",
					"Something went wrong with the Sounds", "Oops");
			exc.showdialog();
		}
		backgroundPlayer = new MediaPlayer(sound);
		backgroundPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		backgroundPlayer.setVolume(volumebg);
		backgroundPlayer.play();
	}

	public static void stop() {
		soundPlayer.stop();
	}

	public static void stopbackground() {
		backgroundPlayer.stop();
	}

	public static double getVolumebg() {
		return volumebg;
	}

	public static void setVolumebg(double volumebg) {
		MP3handler.volumebg = volumebg;
		if (!(backgroundPlayer == null)) {
			backgroundPlayer.setVolume(volumebg);
		}
	}

	public static double getVolumefx() {
		return volumefx;
	}

	public static void setVolumefx(double volumefx) {
		MP3handler.volumefx = volumefx;
		if (!(soundPlayer == null)) {
			soundPlayer.setVolume(volumefx);
		}
	}
}
