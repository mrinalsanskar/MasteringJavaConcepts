 package com.sanskar.main;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MoreExamples2 {

	public static void main(String[] args) {
		
		String input= "Sanskar Dwivedi Is Super Awesome!";
		
		/*
		 * Task1: find the first non-repeated character
		 */
		Character result = input.chars() // Stream of String       
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
       System.out.println(result);          
		
       
       /*
		 * Task1: find the first repeated character
		 */
       Character result2 = input.chars() // Stream of String       
               .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
               .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
               .entrySet()
               .stream()
               .filter(entry -> entry.getValue() > 1L)
               .map(entry -> entry.getKey())
               .findFirst()
               .get();
       System.out.println(result2); 

	}

}
