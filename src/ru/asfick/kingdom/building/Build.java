package ru.asfick.kingdom.building;

import java.util.HashMap;
import java.util.Map;

public class Build {
	private String name;
	private Map<Integer, String> persons = new HashMap<Integer, String>();
	private String type;
	
	public Build(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public Map<Integer, String> getPersons(){
		return this.persons;
	}
	
	public String getCertainNamePerson(int key) {
		return this.persons.get(key);
	}
	
	public void addPerson(int key, String name) {
		this.persons.put(key, name);
	}
	
	public void removePerson(int key) {
		this.persons.remove(key);
		String n;
		for(int i = key;i<this.persons.size();i++) {                           // List offset
			n = this.persons.get(i+1);
			this.persons.put(i, n);
			this.persons.remove(i+1);
		}
	}
	
	public int getStrength() {
		return this.persons.size();
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return type;
	}
}
