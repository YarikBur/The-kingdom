package ru.asfick.main;

import ru.asfick.kingdom.Kingdom;
import ru.asfick.kingdom.population.Population;
import ru.asfick.main.Window;

public class Main {
	private static String kingdom[] = {"Red", "Green", "Blue"};                               // Названия королевств (для проверки)
	private static String name[] = {"Yarik", "Anna", "Lisa", "Anastasya", "Alex", "Ivan"};    // Именя людей (для проверки)
	private static int age[] = {16, 16, 16, 16, 18, 18};                                      // Возраст людей (для проверки)
	private static String build[] = {"Tavern", "Church", "Score", "Street", "Street", "Hut"}; // Здания, в которых находятся люди (для проверки)
	private static String type[] = {"Miner", "Cleaner"};                                      // Тип людей (для проверки)
	
	private static Kingdom kd1;                                                               // Королевство 1 (для проверки)
	private static Window window;
	
	public static void main(String[] args) {
		window = new Window(800, 600, "The kingdom", 0, 0);
		window.run();
		
		create();                                                                             // Запускаем метод для заполения динамического массива с классами людей
		out();                                                                                // Выводим все данные людей из динамического массива
		kd1 = new Kingdom(kingdom[0]);                                                        // Создаем Королевство 1 (для проверки)
		
		System.out.println("Strength in \"RED\" kingdom: " + kd1.strength());                 // Выводим численность населения в королевстве "RED"
		System.out.println("Delite 3\n");                                                     // Выводим, что мы удаляем человека из массива по ключу 3
		
		remove(3);                                                                            // Замускаем метод, который удаляет человека из динамического массива по ключу 3
		out();                                                                                // Выводим все данные людей из динамического массива
		
		System.out.println("Strength in \"RED\" kingdom: " + kd1.strength());                 // Выводим численность населения в королевстве "RED"
		Population.addPerson(5, "Test", "Diablo", 1540, "Hell", "Red");                       // Добавляем человека в динамический массив
		check();                                                                              // Запускаем метод, который запускает проверку на добавление человека в определенное королевство 
		Population.addPerson(6, "Test2", "Diablo", 1540, "Hell", "Red");                      // Снова добавляем человека
		check();                                                                              // Запускаем проверку
		
	}
	
	private static void check() {                                                             // Приватный метод, который проверяет добавление человека к королевству 
		if(kd1.isAddedPopulation()) {                                                         // Если человек был добавлен к королевству 1
			System.out.println("Strength in \"RED\" kingdom: " + kd1.strength());             // Выводим новую численность в этом королевстве
			out();                                                                            // Выводим все данные людей из динамического массива
		}
	}
	
	private static void create() {                                                            // Приватный метод, который заполняет динамический массив с людьми
		for(int i=0; i<name.length; i++) {                                                    // Создаем цикл
			Population.addPerson(i, name[i], type[i/3], age[i], build[i], kingdom[i/2]);      // заполняем динамический массив
		}
	}
	
	private static void remove(int key) {                                                     // Приватный метод, который удаляет человека из динамического массива по ключу
		Population.removePerson(key);                                                         // Удалить человека по ключу
	}
	
	private static void out() {                                                               // Приватный метод, который выводит все данные людей в виде таблицы
		System.out.println("  Key  |       Kingdom       |       Name       |       Type       |       Age       |       Build       |       Id"); // Выводит шапку таблицы
		
		for(int i=0; i<Population.getPerson().size(); i++) {                                  // Создает цикл
			System.out.printf("Key: %1s |", i);                                               // Ключ человека в динамическом массиве
			System.out.printf(" Kingdom: %10s |", Population.getCertainKingdomPerson(i));     // В каком королевстве он находится
			System.out.printf(" Name: %10s |", Population.getCertainNamePerson(i));           // Имя человека
			System.out.printf(" Type: %10s |", Population.getCertainTypePerson(i));           // Его тип
			System.out.printf(" Age: %10s |", Population.getCertainAgePerson(i));             // Сколько лет этому человеку
			System.out.printf(" Build: %10s |", Population.getCertainBuildPerson(i));         // В каком здании он щас находится (или на улице)
			System.out.printf(" Id: %10s \n", Population.getCertainIdPerson(i));              // Личный Id человека
		}
	}
}
