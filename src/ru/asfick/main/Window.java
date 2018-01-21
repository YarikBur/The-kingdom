package ru.asfick.main;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import ru.asfick.render.Render;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

/**
 * Класс, создающий окно
 * @author Yarik
 * @version 0.1
 */
public class Window {
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
		GL.createCapabilities();
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, width, 0, height, 1, -1);
		glMatrixMode(GL_VIEWPORT);
		
		glClearColor(0.8f, 0.2f, 0.2f, 1f);
		
		while(!glfwWindowShouldClose(window)) {  //отрисовка и расчеты
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			
			rend.updateBeforeDrawing();
			rend.render(width, height);
			rend.updateAfterDrawing();
			
			glfwSwapBuffers(window);
			
			glfwPollEvents();
			
		}
	}
}
