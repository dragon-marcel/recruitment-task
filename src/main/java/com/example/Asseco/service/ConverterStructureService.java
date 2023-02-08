package com.example.Asseco.service;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.Asseco.annotation.KoliberDescription;
import com.example.Asseco.annotation.KoliberFieldDescription;
import com.example.Asseco.exception.NullStructurException;
@Service
public final class ConverterStructureService {
    private final static String INDENTATAION = "  ";
    private final static String SEPARATOR = " - ";

    public void getStructure(Object object) {
	checkIfPossibleConvertToStructur(object);
	convertToStructure(object, 0);
    }

    private void convertToStructure(Object object, int level) {
	Class<?> clazz = object.getClass();
	List<Field> fields = Arrays.asList(clazz.getDeclaredFields());

	fields.stream().forEach(field -> {
	    field.setAccessible(true);
	    String name = field.getName();
	    Object ob = getObjectFromField(field);
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

    private void checkIfPossibleConvertToStructur(Object object) {
	if (Objects.isNull(object))
	    throw new NullStructurException();
    }

    private Object getObjectFromField(Field field) {
	Object ob = null;
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
	return ob;
    }

    private void printTextRowStruct(int n, String name, String value) {
	StringBuilder sb = new StringBuilder();

	for (int i = 0; i < n; i++)
	    sb.append(INDENTATAION);
	sb.append(name).append(SEPARATOR).append(value);

	System.out.println(sb.toString());
    }

}
