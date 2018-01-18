package ru.asfick.kingdom.building;

import java.util.HashMap;
import java.util.Map;

public class Building {
	private static Map<Integer, Build> building = new HashMap<Integer, Build>();
	
	public void addBuild(int key, String name, String type) {
		Building.building.put(key, new Build(name, type));
	}
	
	public Map<Integer, Build> getBuilding(){
		return Building.building;
	}
	
	public Build getCertainBuild(int key) {
		return Building.building.get(key);
	}
	
	public Map<Integer, String> getNameBuild(int key){
		return Building.building.get(key).getPersons();
	}
	
	public void removeBuild(int key) {
		Building.building.remove(key);
		Build n;
		for(int i = key;i<Building.building.size();i++) {                           // List offset
			n = Building.building.get(i+1);
			Building.building.put(i, n);
			Building.building.remove(i+1);
		}
	}
}
