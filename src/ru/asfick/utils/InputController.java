package ru.asfick.utils;

import org.lwjgl.glfw.GLFWKeyCallback;
import static org.lwjgl.glfw.GLFW.*;

public class InputController extends GLFWKeyCallback {
	public static boolean[] keys = new boolean[65536];
	
	@Override
	public void invoke(long window, int key, int scancode, int action, int mods) {
		keys[key] = action != GLFW_RELEASE;
	}
	
	public static boolean isKeyDown(int keycode) {
		return keys[keycode];
	}
	
	public static boolean isKeyUp(int keycode) {
		if(isKeyDown(keycode))
			return false;
		else
			return true;
	}
}
