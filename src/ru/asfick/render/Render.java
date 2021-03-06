package ru.asfick.render;

import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_VIEWPORT;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.opengl.GL;

import ru.asfick.utils.InputController;
import ru.asfick.utils.Text;

/**
 * Класс для прорисовки
 * @author Yarik
 * @version 0.1
 */
public class Render {
	private Text t1;
	
	/**
	 * Инициализирует все шрифты в игре
	 */
	private void initText() {
		t1 = new Text("Verdana", "bold", 20);
	}
	
	/**
	 * Выполняет стандартную настройку перед рендером
	 * @param width - ширина окна
	 * @param height - высота окна
	 */
	public void preRender(int width, int height) {
		initText();
		
		GL.createCapabilities();
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, width, 0, height, 1, -1);
		glMatrixMode(GL_VIEWPORT);
		
		glClearColor(0.8f, 0.2f, 0.2f, 1f);
	}
	
	private void testInputKeyboard() {
		if(InputController.isKeyDown(GLFW_KEY_W))
			System.out.println("W Key Pressed");
	}
	
	/**
	 * Производит расчеты до прорисовки изображения
	 */
	public void updateBeforeDrawing() {
		
	}
	
	/**
	 * Производит отрисовку изображения в окне
	 * @param width - ширина окна
	 * @param height - высота окна
	 */
	public void render(int width, int height) {
		t1.drawString(50, 80, "Hello, World!", Text.color("black"));
	}

	/**
	 * Производит расчеты после прорисовки изображения
	 */
	public void updateAfterDrawing() {
		testInputKeyboard();
	}
}
