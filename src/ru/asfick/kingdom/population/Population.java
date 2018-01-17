package ru.asfick.kingdom.population;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that keeps all people in the world
 * @author Asfick
 * @version 0.3.1
 */

public class Population {
	private static Map<Integer, Person> person = new HashMap<Integer, Person>();  //Dynamic array storing the key and class of the person
	
	public static Map<Integer, Person> getPerson(){
		return Population.person;
	}
	
	public static Person getCertainPerson(int key){
		return Population.person.get(key);
	}
	
	public static String getCertainNamePerson(int key) {
		return Population.getCertainPerson(key).getName();
	}
	
	public static String getCertainTypePerson(int key) {
		return Population.getCertainPerson(key).getType();
	}
	
	public static int getCertainAgePerson(int key) {
		return Population.getCertainPerson(key).getAge();
	}
	
	public static String getCertainBuildPerson(int key) {
		return Population.getCertainPerson(key).getBuild();
	}
	public static String getCertainKingdomPerson(int key) {
		return Population.getCertainPerson(key).getKingdom();
	}
	
	public static void addPerson(int key, String name, String type, int age, String build, String kingdom){
		Population.person.put(key, new Person(name, type, age, build, kingdom, Population.person.size()));
		
	}
	
	public static int getCertainIdPerson(int key) {
		return Population.getCertainPerson(key).getId();
	}
	
	public static void removePerson(int key){
		Population.person.remove(key);
		Person n;
		for(int i = key;i<Population.person.size();i++) {                           // List offset
			n = Population.person.get(i+1);
			Population.person.put(i, n);
			Population.person.remove(i+1);
		}
	}
}