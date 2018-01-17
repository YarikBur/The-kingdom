package ru.asfick.main;

import ru.asfick.kingdom.Kingdom;
import ru.asfick.kingdom.population.Population;

public class Main {
	private static String kingdom[] = {"Red", "Green", "Blue"};
	private static String name[] = {"Yarik", "Anna", "Lisa", "Anastasya", "Alex", "Ivan"};
	private static int age[] = {16, 16, 16, 16, 18, 18};
	private static String build[] = {"Tavern", "Church", "Score", "Street", "Street", "Hut"};
	private static String type[] = {"Miner", "Cleaner"};
	
	private static Kingdom kd1;
	
	public static void main(String[] args) {
		create();
		out();
		kd1 = new Kingdom(kingdom[0]);
		
		System.out.println("Strength in \"RED\" kingdom: " + kd1.strength());
		System.out.println("Delite 3\n");
		
		remove(3);
		out();
		
		System.out.println("Strength in \"RED\" kingdom: " + kd1.strength());
		Population.addPerson(5, "Test", "Diablo", 1540, "Hell", "Red");
		
		if(kd1.isAddedPopulation()) {
			System.out.println("Strength in \"RED\" kingdom: " + kd1.strength());
			out();
		}
		
	}
	
	private static void create() {
		for(int i=0; i<name.length; i++) {
			Population.addPerson(i, name[i], type[i/3], age[i], build[i], kingdom[i/2]);
		}
	}
	
	private static void remove(int key) {
		Population.removePerson(key);
	}
	
	private static void out() {
		System.out.println("  Key  |       Kingdom       |       Name       |       Type       |       Age       |       Build       |       Id");
		
		for(int i=0; i<Population.getPerson().size(); i++) {
			System.out.printf("Key: %1s |", i);
			System.out.printf(" Kingdom: %10s |", Population.getCertainKingdomPerson(i));
			System.out.printf(" Name: %10s |", Population.getCertainNamePerson(i));
			System.out.printf(" Type: %10s |", Population.getCertainTypePerson(i));
			System.out.printf(" Age: %10s |", Population.getCertainAgePerson(i));
			System.out.printf(" Build: %10s |", Population.getCertainBuildPerson(i));
			System.out.printf(" Id: %10s \n", Population.getCertainIdPerson(i));
		}
	}
}
