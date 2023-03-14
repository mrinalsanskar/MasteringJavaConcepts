package com.sanskar.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MoreExamples {

	public static void main(String[] args) {
		
		List<Integer> list= Arrays.asList(10,11,323,34,10,112,56,32,32,12,65);
		
		/*
		 * Task1: find out all the numbers starting with 1 using Stream functions
		 */
		list.stream()
		.map(l->l+"") // Convert integer to String 
		.filter(l->l.startsWith("1"))
		.forEach(System.out::println);
		System.out.println("\n");
		
		/*
		 * Task2: find duplicate elements
		 */
		list.stream().collect(Collectors.toSet()).forEach(System.out::println);
		System.out.println("\n");
		
		/*
		 *Task3: find the first element
		 */
		list.stream().findFirst().ifPresent(System.out::println);
		//list.stream().findFirst().collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("\n");
		
		/*
		 * Task4: find the total number of elements present in the list
		 */
		long count= list.stream().count();
		System.out.println(count);
		System.out.println("\n");
		
		/*
		 * Task5: find the maximum value element
		 */
		//compare or compareTo both works
		 int max=list.stream().max(Integer::compareTo).get(); //max gives optional, get converts it to int
		 System.out.println(max);
		 System.out.println("\n");
		 
		 /*
		  * Task6: sort all the values
		  */
		 list.stream().sorted().forEach(System.out::println);
		 System.out.println("\n");
		 
		 /*
		  * Task7: sort all the values present in it in descending order
		  */
		 list.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
		 System.out.println("\n");
		
		 /*
		  * Task8: find out all the odd numbers that exist
		  */
		 list.stream().filter(l->l%2!=0).forEach(System.out::println);
	}

}
