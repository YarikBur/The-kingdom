package ru.asfick.kingdom;

import java.util.HashMap;
import java.util.Map;

import ru.asfick.kingdom.population.Person;
import ru.asfick.kingdom.population.Population;

/**
 * 
 * @author Asfick
 * @version 0.3.2
 */
public class Kingdom {
	private String name;
	
	private Map<Integer, Person> population = new HashMap<Integer, Person>();
	
	/**
	 * Инициализирует королевство и заполняет список людей, которые к нему относятся
	 * @param name - название королевства
	 */
	public Kingdom(String name) {
		int key =0;
		this.name = name;
		for(int i=0; i<Population.getPerson().size(); i++) {
			if(Population.getCertainKingdomPerson(i).equals(name)) {
				this.population.put(key, Population.getCertainPerson(i));
				key++;
			}
		}
	}
	
	/**
	 * Возвращает название королевства
	 * @return String
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Возвращает список людей, которые относятся к этому королевству 
	 * @return Map<Integer, Person>
	 */
	public Map<Integer, Person> getPopulation() {
		return this.population;
	}
	
	/**
	 * Возвращает численность королевства на данный момент
	 * @return int
	 */
	public int strength() {
		return this.population.size();
	}
	
	/**
	 * Проверка, которую надо выполнять после любого изменения списка Population, хранящегося в классе Population. Если новый человек, который был добавлен, относится к этому королевству, то он добавляется в локальный список 
	 * @return boolean
	 */
	public boolean isAddedPopulation() {
		boolean newPerson = false;
		int b=0;
		for(int i=0; i<this.population.size(); i++) {
			for(int a=0; a<Population.getPerson().size(); a++) {
				if(!this.population.get(i).getName().equals(Population.getCertainKingdomPerson(a))) {
					newPerson = true;
					b = a;
				} else
					newPerson = false;
			}
			if(newPerson) {
				System.out.println("Added new Person: " + Population.getCertainPerson(b).getName());
				this.population.put(Population.getCertainPerson(b).getId(), Population.getCertainPerson(b));
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Удаляет человека в локальном списке
	 * @param key - номер человека в локальном списке 
	 */
	public void removePopulation(int key) {
		int id = this.population.get(key).getId();
		this.population.remove(key);
		Population.removePerson(Population.learnTheGlobalKeyById(id));
		Person n;
		for(int i = key;i<this.population.size();i++) {                           // Сместить список
			n = this.population.get(i+1);
			this.population.put(i, n);
			this.population.remove(i+1);
		}
	}
}
