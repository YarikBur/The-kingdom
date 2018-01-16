package ru.asfick.kingdom.population;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that keeps all people in the world
 * @author Yarik
 * @version 0.2
 */

public class Population {
	private static Map<Integer, String> name = new HashMap<Integer, String>();    // Dynamic array that stores the key and name of the person
	private static Map<Integer, String> type = new HashMap<Integer, String>();    // A dynamic array that stores the key and type of a person
	private static Map<Integer, String> kingdom = new HashMap<Integer, String>(); // Dynamic array storing the key and to which state the person belongs
	
	public static Map<Integer, String> getName(){
		return Population.name;
	}
	
	public static String get—ertainName(int key){
		return Population.name.get(key);
	}
	
	public static void addName(int key, String name){
		Population.name.put(key, name);
	}
	
	public static void removeName(int key){
		Population.name.remove(key);
		String n;
		for(int i = key;i<Population.name.size();i++) {                           // List offset
			n = Population.name.get(i+1);
			Population.name.put(i, n);
			Population.name.remove(i+1);
		}
	}
	
	public static Map<Integer, String> getType(){
		return Population.type;
	}
	
	public static String get—ertainType(int key){
		return Population.type.get(key);
	}
	
	public static void addType(int key, String name){
		Population.type.put(key, name);
	}
	
	public static void removeType(int key){
		Population.type.remove(key);
		String n;
		for(int i = key;i<Population.type.size();i++) {                           // List offset
			n = Population.type.get(i+1);
			Population.type.put(i, n);
			Population.type.remove(i+1);
		}
	}
	
	public static Map<Integer, String> getKingdom(){
		return Population.kingdom;
	}
	
	public static String get—ertainKingdom(int key){
		return Population.kingdom.get(key);
	}
	
	public static void addKingdom(int key, String name){
		Population.kingdom.put(key, name);
	}
	
	public static void removeKingdom(int key){
		Population.kingdom.remove(key);
		String n;
		for(int i = key;i<Population.kingdom.size();i++) {                        // List offset
			n = Population.kingdom.get(i+1);
			Population.kingdom.put(i, n);
			Population.kingdom.remove(i+1);
		}
	}
}
