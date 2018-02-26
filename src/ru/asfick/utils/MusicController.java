package ru.asfick.utils;

import java.io.IOException;

import org.newdawn.slick.openal.*;
import org.newdawn.slick.util.ResourceLoader;

public class MusicController{
	// Effects
	@SuppressWarnings("unused")
	private static Audio oggEffect;
	private static Audio wavEffect;
	
	//Music
	@SuppressWarnings("unused")
	private static Audio oggStream;
	private static Audio wavStream;
	
	private static boolean initialized = false;
	
	/**
	 * Выполняется при запуске игры
	 * @param timesOfDay - Время суток (реальных), когда приложение было запущено
	 * @throws IOException 
	 */
	public static void initAudio(String timesOfDay) throws IOException {
		wavEffect = AudioLoader.getStreamingAudio("WAV", ResourceLoader.getResource("/res/music/intro.wav"));
		wavStream = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("res/music/menu.wav"));
		
		initialized = true;
	}
	
	/**
	 * 
	 * @param audio - Аудио, которое нам нужно включить
	 */
	public static void startAudio(String audio) {
		if(initialized) {
			switch(audio) {
			case("intro"):
				if(!wavEffect.isPlaying())
					wavEffect.playAsMusic(1f, 1f, true);
				else
					wavEffect.playAsMusic(1f, 1f, false);
				break;
			case("menu"):
				if(!wavStream.isPlaying())
					wavStream.playAsMusic(1f, 1f, true);
				else
					wavStream.playAsMusic(1f, 1f, false);
				break;
			default:
				System.out.println("An error occurred while assigning music playback");
				break;
			}
			SoundStore.get().poll(0);
		}
	}
}
