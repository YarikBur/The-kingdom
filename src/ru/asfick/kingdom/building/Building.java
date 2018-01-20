package ru.asfick.kingdom.building;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс, хранящий все здания в мире
 * @author Yarik
 * @version 0.2
 */
public class Building {
	private static Map<Integer, Build> building = new HashMap<Integer, Build>();
	
	/**
	 * Добавляет здание в глобальный список
	 * @param key - номер в списке
	 * @param name - название здания
	 * @param type - тип здания
	 */
	public void addBuild(int key, String name, String type) {
		Building.building.put(key, new Build(name, Type.getType(type)));
	}
	
	/**
	 * Возвращает глобальный список всех зданий
	 * @return Map<Integer, Build>
	 */
	public Map<Integer, Build> getBuilding(){
		return Building.building;
	}
	
	/**
	 * Возвращает определенное здание из глобального здания по ключу
	 * @param key - номер в списке
	 * @return Build
	 */
	public Build getCertainBuild(int key) {
		return Building.building.get(key);
	}
	
	/**
	 * Возвращает все имена в определенном здании по ключу
	 * @param key - номер в списке
	 * @returnMap<Integer, String>
	 */
	public Map<Integer, String> getNameBuild(int key){
		return Building.building.get(key).getPersons();
	}
	
	/**
	 * Удаляет здание по ключу со смещением списка
	 * @param key - номер в списке
	 */
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
