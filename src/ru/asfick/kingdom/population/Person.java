package ru.asfick.kingdom.population;

public class Person {
	private String name;
	private String type;
	private int age;
	private String build;
	private String kingdom;
	
	public Person(String name, String type, int age, String build, String kingdom) {
		this.name = name;
		this.type = type;
		this.age = age;
		this.build = build;
		this.kingdom = kingdom;
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
}
