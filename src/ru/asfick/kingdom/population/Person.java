package ru.asfick.kingdom.population;

/**
 * Класс человека
 * @author Asfick
 * @version 0.2
 */
public class Person {
	private String name;
	private String type;
	private int age;
	private String build;
	private String kingdom;
	private int id;
	
	/**
	 * Инициализирует личные данные человека  
	 * @param name - имя человека
	 * @param type - тип человека
	 * @param age - возраст человека
	 * @param build - здание в котором он находится(или улица)
	 * @param kingdom - королевство, к которому он относится
	 * @param id - личный номер
	 */
	public Person(String name, String type, int age, String build, String kingdom, int id) {
		this.name = name;
		this.type = type;
		this.age = age;
		this.build = build;
		this.kingdom = kingdom;
		this.id = id;
	}
	
	/**
	 * Возвращает имя человека
	 * @return String
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Возвращает тип человека
	 * @return String
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Меняет тип человека
	 * @param type - тип человека
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Возвращает его возраст
	 * @return int
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * Меняет возраст человека
	 * @param age - возраст человека
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Возвращает здание, в котором он находится
	 * @return String
	 */
	public String getBuild() {
		return this.build;
	}

	/**
	 * Меняет здание человека, в котором он находится(или улица)
	 * @param build - здание(или улица) человека
	 */
	public void setBuild(String build) {
		this.build = build;
	}
	
	/**
	 * Возвращает Королевство, к которому он относится
	 * @return String
	 */
	public String getKingdom() {
		return this.kingdom;
	}
	
	/**
	 * Возвращает Id человека
	 * @return int
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Изменить Id человека(Нежелательно)
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
}
