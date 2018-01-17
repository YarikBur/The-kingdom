package ru.asfick.kingdom;

import java.util.HashMap;
import java.util.Map;

import ru.asfick.kingdom.population.Person;
import ru.asfick.kingdom.population.Population;

public class Kingdom {
	private String name;
	
	private Map<Integer, Person> population = new HashMap<Integer, Person>();
	
	public Kingdom(String name) {
		this.name = name;
		int key =0;
		for(int i=0; i<Population.getPerson().size(); i++) {
			if(Population.getCertainKingdomPerson(i).equals(name)) {
				population.put(key, Population.getCertainPerson(i));
				key++;
			}
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public Map<Integer, Person> getPopulation() {
		return this.population;
	}
	
	public int strength() {
		return population.size();
	}
	
	public boolean isAddedPopulation() {
		boolean newPerson = false;
		int b=0;
		for(int i=0; i<population.size(); i++) {
			for(int a=0; a<Population.getPerson().size(); a++) {
				if(!population.get(i).getName().equals(Population.getCertainKingdomPerson(a))) {
					newPerson = true;
					b = a;
				} else
					newPerson = false;
			}
			if(newPerson) {
				System.out.println("Added new Person: " + Population.getCertainPerson(b).getName());
				population.put(Population.getCertainPerson(b).getId(), Population.getCertainPerson(b));
				return true;
			}
		}
		return false;
	}
	
	public void removePopulation() {
		
	}
}
