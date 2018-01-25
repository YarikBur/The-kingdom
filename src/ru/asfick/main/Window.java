package ru.asfick.main;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_ESCAPE;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_TRUE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDefaultWindowHints;
import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwGetWindowSize;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetErrorCallback;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwSetWindowShouldClose;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.nio.IntBuffer;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.system.MemoryStack;

import ru.asfick.render.Render;
import ru.asfick.utils.KeyboardHandler;

/**
 * Класс, создающий окно
 * @author Yarik
 * @version 0.1
 */
public class Window {
	private GLFWKeyCallback keyCallback;
	
	private long window;
	private long monitor;
	private long share;
	
	private String title;
	
	private int height;
	private int width;
	
	private Render rend;
	
	/**
	 * Инициализирует окно
	 * @param width - ширина окна
	 * @param height - высота окна
	 * @param title - название окна
	 * @param monitor - номер монитора
	 * @param share - незнать, что такое(была в доках ;) )
	 */
	public Window(int width, int height, String title, long monitor, long share) {
		this.width = width;
		this.height = height;
		this.title = title;
		this.monitor = monitor;
		this.share = share;
		
		rend = new Render();
	}
	
	
	/**
	 * Запускает окно
	 */
	public void run() {
		System.out.println("Hello, LWJGL " + Version.getVersion() + "!");
		
		init();
		loop();
		
		System.out.println("Bie");
		
		keyCallback.close();
		glfwFreeCallbacks(window);
		glfwDestroyWindow(window);
		
		glfwTerminate();
		glfwSetErrorCallback(null).free();
	}
	
	
	/**
	 * Запускает проверку на возможность создания окна
	 */
	private void init() {
		GLFWErrorCallback.createPrint(System.err).set();
		if(!glfwInit())
			throw new IllegalStateException("Unable to initialize GLFW");
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
		
		window = glfwCreateWindow(width, height, title, monitor, share);
		if(window == NULL) 
			throw new RuntimeException("Failed to create the GLFW window");
		
		glfwSetKeyCallback(window, keyCallback = new KeyboardHandler());
		
		glfwSetKeyCallback(window, (window, key, scancode, action, mods) ->{
			if(key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) glfwSetWindowShouldClose(window, true);
		});
		
		try(MemoryStack stack = stackPush()){
			IntBuffer pWidth = stack.mallocInt(1);
			IntBuffer pHeight = stack.mallocInt(1);
			
			glfwGetWindowSize(window, pWidth, pHeight);
			
			GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
			
			glfwSetWindowPos(window, (vidmode.width() - pWidth.get(0))/2, (vidmode.height() - pHeight.get(0))/2);
		}
		
		glfwMakeContextCurrent(window);
		
		glfwSwapInterval(1);
		
		glfwShowWindow(window);
	}
		
	/**
	 * Бесконечный цикл (пока не закроется окно)
	 */
	private void loop() {
		rend.preRender(width, height);
		
		while(!glfwWindowShouldClose(window)) {  //отрисовка и расчеты
			rend.updateBeforeDrawing();
			
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			
			rend.render(width, height);
			
			glfwSwapBuffers(window);
			glfwPollEvents();
			
			rend.updateAfterDrawing();
		}
	}
}
