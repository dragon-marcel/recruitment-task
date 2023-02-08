package com.example.Asseco.service;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import com.example.Asseco.model.annotation.KoliberDescription;
import com.example.Asseco.model.annotation.KoliberFieldDescription;

public final class StructureUtils {
    private final static String INDENTATAION = "  ";
    private final static String SEPARATOR = " - ";
    
    public static void getStructure(Object object) {
	convertToStructure(object, 0);
    }

    private static void convertToStructure(Object object, int level) {
	Class<?> clazz = object.getClass();
	List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
	
	fields.stream().forEach(field -> {
	    field.setAccessible(true);
	    String name = field.getName();
	    Object ob = field.getType();
	    try {
		if (field.getType().equals(List.class)) {
		    ParameterizedType stringListType = (ParameterizedType) field.getGenericType();
		    Class<?> stringListClass = (Class<?>) stringListType.getActualTypeArguments()[0];
		    ob = stringListClass.newInstance();
		} else {
		    ob = field.getType().newInstance();
		}
	    } catch (InstantiationException | IllegalAccessException e) {
	    }

	    if (field.isAnnotationPresent(KoliberDescription.class)) {
		KoliberDescription koliberDescription = field.getAnnotation(KoliberDescription.class);
		String value = koliberDescription.comment();
		printTextRowStruct(level, name, value);
		convertToStructure(ob, level + 1);

	    }
	    if (field.isAnnotationPresent(KoliberFieldDescription.class)) {
		KoliberFieldDescription koliberFieldDescription = field.getAnnotation(KoliberFieldDescription.class);
		String value = koliberFieldDescription.comment();
		printTextRowStruct(level, name, value);

	    }
	});
	
    }

    static void printTextRowStruct(int n, String name, String value) {
	StringBuilder sb = new StringBuilder();

	for (int i = 0; i < n; i++)
	    sb.append(INDENTATAION);
	sb.append(name).append(SEPARATOR).append(value);

	System.out.println(sb.toString());
    }

}
