package com.codingshuttle.projects.airbnbClone.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.List;

@Converter
public class StringListConverter implements AttributeConverter<List<String>,String> {

    @Override
    public String convertToDatabaseColumn(List<String> strings) {
        if(strings == null) return null ;
        return String.join(",",strings);
    }

    @Override
    public List<String> convertToEntityAttribute(String s) {
        if(s ==null || s.isEmpty()) return List.of();
        return Arrays.stream(s.split(","))
                .map(String::trim)
                .toList();
    }
}

