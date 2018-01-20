package ru.asfick.kingdom.building;

/**
 * Класс, возвращающий тип зданий, если он введен правильно
 * @author Yarik
 * @version 0.1
 */
public class Type {
	private static String types[] = {"Home", "Store"};
	
	/**
	 * Возвращает тип здания, если он был введен без ошибок
	 * @param type - тип здания
	 * @return String
	 */
	public static String getType(String type) {
		for(int i=0; i<Type.types.length; i++)
			if(type.equals(Type.types[i]))
				return type;
		
		return null;
	}
	
}
