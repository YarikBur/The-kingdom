package ru.asfick.main;

import ru.asfick.kingdom.population.Population;

public class Main {
	
	private static String kingdom[] = {"Red", "Green", "Blue"};
	private static String name[] = {"Yarik", "Anna", "Lisa", "Anastasya", "Alex", "Ivan"};
	private static String type[] = {"Miner", "Cleaner"};
	
	public static void main(String[] args) {
		create();
		out();
		System.out.println("Delite 1, 3, 5\n");
		remove(1);
		remove(3);
		remove(5);
		out();
	}
	
	private static void create() {
		for(int i=0; i<name.length; i++) {
			Population.addKingdom(i, kingdom[i/2]);
			Population.addName(i, name[i]);
			Population.addType(i, type[i/3]);
		}
	}
	
	private static void remove(int key) {
		Population.removeKingdom(key);
		Population.removeName(key);
		Population.removeType(key);
	}
	
	private static void out() {
		String kingdom, name, type;
		System.out.println("  Key  |     Kingdom     |       Name       |     Type");
		for(int i=0; i<Population.getName().size(); i++) {
			kingdom = Population.getÑertainKingdom(i);
			name = Population.getÑertainName(i);
			type = Population.getÑertainType(i);
			System.out.printf("Key: %1s |", i);
			System.out.printf(" Kingdom: %6s |", kingdom);
			System.out.printf(" Name: %10s |", name);
			System.out.printf(" Type: %8s \n", type);
		}
		System.out.println("-------------------------------------------------------");
	}

}
