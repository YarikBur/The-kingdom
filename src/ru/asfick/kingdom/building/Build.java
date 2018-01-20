package ru.asfick.kingdom.building;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс здания
 * @author Yarik
 * @version 0.2
 */
public class Build {
	private String name;
	private Map<Integer, String> persons = new HashMap<Integer, String>();
	private String type;
	
	/**
	 * Инициализирует здание
	 * @param name - название здания
	 * @param type - тип здания
	 */
	public Build(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	/**
	 * Возвращает все имена людей, который находятся в этом здании
	 * @return Map<Integer, String>
	 */
	public Map<Integer, String> getPersons(){
		return this.persons;
	}
	
	/**
	 * Возвращает определенное имя по ключу
	 * @param key - номер в локальном списке
	 * @return
	 */
	public String getCertainNamePerson(int key) {
		return this.persons.get(key);
	}
	
	/**
	 * Добавляет имя человека в локальный список
	 * @param key - номер в локальном списке
	 * @param name - имя человека
	 */
	public void addPerson(int key, String name) {
		this.persons.put(key, name);
	}
	
	/**
	 * Удаляет Имя человека из локального списка со смещение
	 * @param key - номер в локальном списке
	 */
	public void removePerson(int key) {
		this.persons.remove(key);
		String n;
		for(int i = key;i<this.persons.size();i++) {                           // List offset
			n = this.persons.get(i+1);
			this.persons.put(i, n);
			this.persons.remove(i+1);
		}
	}
	
	/**
	 * Возвращает численность людей, находящемся в этом здании
	 * @return int
	 */
	public int getStrength() {
		return this.persons.size();
	}
	
	/**
	 * Возвращает название здания
	 * @return String
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Возвращает тип здания
	 * @return String
	 */
	public String getType() {
		return type;
	}
}
