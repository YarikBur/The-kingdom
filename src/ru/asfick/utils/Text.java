package ru.asfick.utils;


import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public class Text {
	private Font font;
	private TrueTypeFont trueTypeFont;
	
	/**
	 * Инициализирует текст
	 * @param font - шрифт
	 * @param style - стиль
	 * @param size - размер
	 */
	public Text(String font, String style, int size) {
		switch(style.toLowerCase()) {
		case("bold"):
			this.font = new Font(font, Font.BOLD, size);
			break; //ITALIC PLAIN
		default:
			this.font = new Font(font, Font.CENTER_BASELINE, size);
			break;
		}
		
		trueTypeFont = new TrueTypeFont(this.font, true);
	}
	
	/**
	 * Возвращает подготовленный шрифт
	 * @return TrueTypeFont
	 */
	public TrueTypeFont getTrueTypeFont() {
		return this.trueTypeFont;
	}
	
	/**
	 * Возврящает шрифт
	 * @return Font
	 */
	public Font getDont() {
		return this.font;
	}
	
	/**
	 * Возвращет цвет текста для рисовки на экране. Стандартный цвет - черный
	 * @param color - цвет который нужно вернуть
	 * @return Color
	 */
	public static Color color(String color) {
		switch(color.toLowerCase()) {
		case("white"):
			return Color.white;
		case("red"):
			return Color.red;
		case("green"):
			return Color.green;
		case("blue"):
			return Color.blue;
		case("rgb"):
			
		default:
			return Color.black;
		}
	}
	
	/**
	 * Создает свой цвет
	 * @param red (0-255)
	 * @param green (0-255)
	 * @param blue (0-255)
	 * @param alpha (0-1)
	 * @return Color
	 */
	public static Color color(int red, int green, int blue, float alpha) {
		return new Color(red/255f, green/255f, blue/255f, alpha);
	}
	
	/**
	 * Рисует текст по координатам
	 * @param x - x координата
	 * @param y - y координата
	 * @param text - текст, который надо нарисовать
	 * @param color - цвет текста
	 */
	public void drawString(float x, float y, String text, Color color) {
		trueTypeFont.drawString(x, y, text, color);
	}
}
