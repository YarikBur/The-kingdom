package ru.asfick.kingdom.population;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс, в котором хранятся все люди
 * @author Asfick
 * @version 0.3.1
 */

public class Population {
	/**
	 * Данамический список типа: <Ключ, Класс человека>
	 */
	private static Map<Integer, Person> person = new HashMap<Integer, Person>();
	
	/**
	 * Возвращает список людей
	 * @return Map<Integer, Person>
	 */
	public static Map<Integer, Person> getPerson(){
		return Population.person;
	}
	
	/**
	 * Возвращает определенного человека по ключу
	 * @param key - номер в списке
	 * @return Person
	 */
	public static Person getCertainPerson(int key){
		return Population.person.get(key);
	}

	/**
	 * Возвращает имя определенного человека по ключу
	 * @param key - номер в списке
	 * @return String
	 */
	public static String getCertainNamePerson(int key) {
		return Population.getCertainPerson(key).getName();
	}
	
	/**
	 * Возвращает тип определенного человека по ключу
	 * @param key - номер в списке
	 * @return String
	 */
	public static String getCertainTypePerson(int key) {
		return Population.getCertainPerson(key).getType();
	}
	
	/**
	 * Возвращает возраст определенного человека по ключу
	 * @param key - номер в списке
	 * @return int
	 */
	public static int getCertainAgePerson(int key) {
		return Population.getCertainPerson(key).getAge();
	}
	
	/**
	 * Возвращает здание(в котором он находится(или улица)) определенного человека по ключу
	 * @param key - номер в списке
	 * @return String
	 */
	public static String getCertainBuildPerson(int key) {
		return Population.getCertainPerson(key).getBuild();
	}

	/**
	 * Возвращает королевство(к которому он относится) определенного человека по ключу
	 * @param key - номер в списке
	 * @return String
	 */
	public static String getCertainKingdomPerson(int key) {
		return Population.getCertainPerson(key).getKingdom();
	}
	
	/**
	 * Добавляет Человека в динамический список
	 * @param key - номер в списке
	 * @param name - имя человека
	 * @param type - тип человека
	 * @param age - возраст человека
	 * @param build - здание в котором он находится(или улица)
	 * @param kingdom - королевство, к которому он принадлежин
	 */
	public static void addPerson(int key, String name, String type, int age, String build, String kingdom){
		int id;
		if(Population.getPerson().size()>2)
			id = Population.getCertainPerson(Population.getPerson().size()-1).getId()+1;
		else
			id = Population.getPerson().size();
		Population.person.put(key, new Person(name, type, age, build, kingdom, id));
	}
	
	/**
	 * Возвращает Id пределенного человека по ключу
	 * @param key - номер в списке
	 * @return int
	 */
	public static int getCertainIdPerson(int key) {
		return Population.getCertainPerson(key).getId();
	}
	
	/**
	 * Удалить человека из списка по ключу
	 * @param key - номер в списке
	 */
	public static void removePerson(int key){
		Population.person.remove(key);
		Person n;
		for(int i = key;i<Population.person.size();i++) {                           // Сместить список
			n = Population.person.get(i+1);
			Population.person.put(i, n);
			Population.person.remove(i+1);
		}
	}
	
	/**
	 * Возвращает глобальный ключ определенного человека по id
	 * @param id - личный номер человека
	 * @return int
	 */
	public static int learnTheGlobalKeyById(int id) {
		for(int i=0; i<Population.getPerson().size(); i++) {
			if(Population.getCertainIdPerson(i) == id)
				return i;
		}
		return id;
	}
}