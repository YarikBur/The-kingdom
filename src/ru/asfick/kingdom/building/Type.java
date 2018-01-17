package ru.asfick.kingdom.building;

public class Type {
	private static String types[] = {"Home", "Store"};
	
	public static String getType(String type) {
		for(int i=0; i<Type.types.length; i++)
			if(type.equals(Type.types[i]))
				return type;
		
		return null;
	}
	
}
