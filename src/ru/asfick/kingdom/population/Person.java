package ru.asfick.kingdom.population;

public class Person {
	private String name;
	private String type;
	private int age;
	private String build;
	private String kingdom;
	private int id;
	
	public Person(String name, String type, int age, String build, String kingdom, int id) {
		this.name = name;
		this.type = type;
		this.age = age;
		this.build = build;
		this.kingdom = kingdom;
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getBuild() {
		return this.build;
	}
	
	public String getKingdom() {
		return this.kingdom;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
