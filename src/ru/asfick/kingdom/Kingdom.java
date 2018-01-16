package ru.asfick.kingdom;

import java.util.HashMap;
import java.util.Map;

import ru.asfick.kingdom.building.Building;
import ru.asfick.kingdom.population.Population;

public class Kingdom {
	private Population p;
	private Building b;
	
	private String name;
	private Map<String, String> population = new HashMap<String, String>();
	private Map<String, String> building = new HashMap<String, String>();
	
	public Kingdom(String name, Map<String, String> population, Map<String, String> building) {
		this.name = name;
		this.population = population;
		this.building = building;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Map<String, String> getPopulation() {
		return this.population;
	}
	
	public void addPopulation(String Name, String type) {
		this.population.put(type, Name);
	}
	
	public void removePopulation(int population, String type) {
//		this.population -= population;
	}
	
	public Map<String, String> getBuilding() {
		return this.building;
	}
	
	public void addBuilding(int building, String type) {
//		this.building += building;
	}
	
	public void removeBuilding(int building, String type) {
//		this.building -= building;
	}
	
	private void checkBuilding() {
		
	}
	
	private void checkPopulation() {
		
	}
}
