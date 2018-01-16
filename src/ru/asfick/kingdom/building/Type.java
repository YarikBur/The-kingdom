package ru.asfick.kingdom.building;

public class Type {
	private static String home = "Home";
	private static String store = "Store";
	
	public static String getType(String type) {
		switch(type) {
		case "home":
			return home;
		case "store":
			return store;
		default:
			return "null";
		}
	}
	
}
