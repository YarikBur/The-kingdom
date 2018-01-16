package ru.asfick.kingdom.population;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс, который хранит всех людей в мире
 * @author Yarik
 *
 */

public class Population {
	private static Map<Integer, String> name = new HashMap<Integer, String>();    // Динамический массив, хронящий ключ и имя человека
	private static Map<Integer, String> type = new HashMap<Integer, String>();    // Динамический массив, хронящий ключ и тип человека
	private static Map<Integer, String> kingdom = new HashMap<Integer, String>(); // Динамический массив, хронящий ключ и к какому государству относится человек
	
	public static Map<Integer, String> getName(){
		return Population.name;
	}
	
	public static String getСertainName(int key){
		return Population.name.get(key);
	}
	
	public static void addName(int key, String name){
		Population.name.put(key, name);
	}
	
	public static void removeName(int key){
		Population.name.remove(key);
		String n;
		for(int i = key;i<Population.name.size();i++) {
			n = Population.name.get(i+1);
			Population.name.put(i, n);
			Population.name.remove(i+1);
		}
	}
	
	public static Map<Integer, String> getType(){
		return Population.type;
	}
	
	public static String getСertainType(int key){
		return Population.type.get(key);
	}
	
	public static void addType(int key, String name){
		Population.type.put(key, name);
	}
	
	public static void removeType(int key){
		Population.type.remove(key);
		String n;
		for(int i = key;i<Population.type.size();i++) {
			n = Population.type.get(i+1);
			Population.type.put(i, n);
			Population.type.remove(i+1);
		}
	}
	
	public static Map<Integer, String> getKingdom(){
		return Population.kingdom;
	}
	
	public static String getСertainKingdom(int key){
		return Population.kingdom.get(key);
	}
	
	public static void addKingdom(int key, String name){
		Population.kingdom.put(key, name);
	}
	
	public static void removeKingdom(int key){
		Population.kingdom.remove(key);
		String n;
		for(int i = key;i<Population.kingdom.size();i++) {
			n = Population.kingdom.get(i+1);
			Population.kingdom.put(i, n);
			Population.kingdom.remove(i+1);
		}
	}
}
