package com.sanskar.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sanskar.bean.Employee;

public class Main {
	
	public static void main(String[] args) {
		
		  List<Employee> emp=new ArrayList<Employee>();
		  emp.add(new Employee(1,"Sanskar", 24, "Manager", 200000000));
	      emp.add(new Employee(2,"Tanishq",35,"Manager", 29393292));
		  emp.add(new Employee(3,"Tanya",55,"General Manager", 43323232));
		  emp.add(new Employee(4,"Ashad",25,"Manager", 4221243));
		  emp.add(new Employee(5,"Pari",20,"Developer", 321333));
		  //emp.add(new Employee(1,"Sanskar", 24, "Manager",200000000 ));
		  emp.add(new Employee(6,"Vivek",40,"Manager", 2221122));
		  emp.add(new Employee(7,"Sanjeev",45,"Manager", 2221122));
		  
		  /*
		   * Task: Finding out all the employees whose designation is “Manager” and age is above 30.
		   *  When we didn't use Stream APIs
		   */
		  List<Employee> tempList = new ArrayList<Employee>();
		  
		  for(Employee e : emp){
		    if("Manager".equalsIgnoreCase(e.getDesignation()) && e.getAge() > 30){
		      tempList.add(e);
		    }
		  }
		 
		  for(Employee e : tempList){
		    System.out.println("Name:-"+ e.getName()+" , Designation :- " + e.getDesignation() + " , Age :- " + e.getAge()+" , Salary:-"+e.getSalary());
		  }
		  
		  System.out.println("\n");
		  
		  /*
		   *Task: Finding out all the employees whose designation is “Manager” and age is above 30.
		   * Using Stream APIs
		   */
		  List<Employee> tempEmp= emp.stream()
				  .filter(e->e.getDesignation().equalsIgnoreCase("manager") && e.getAge() >30)
				  .collect(Collectors.toList());
		  tempEmp.forEach(e->System.out.println("Name:-"+ e.getName()+" , Designation :- " + e.getDesignation() + " , Age :- " + e.getAge()+" , Salary:-"+e.getSalary()));
		  
		  System.out.println("\n");
		  
		  /*
		   * Task: To find all employees whose designation contain char “o”
		   */
		  List<Employee> tempEmp2=emp.stream()
				  .filter(e->e.getDesignation().contains("o")).collect(Collectors.toList());
		  tempEmp2.forEach(e->System.out.println("Name:-"+ e.getName()+" , Designation :- " + e.getDesignation() + " , Age :- " + e.getAge()+" , Salary:-"+e.getSalary()));
		  
		  System.out.println("\n");
		  
		  /*
		   * MAP: map() takes a Stream and transform it to another Stream. 
		   * It applies a function on each element of Stream and store return value into new Stream. 
		   * It does not flatten the stream.
		   * Structure before flattening is : [[5, 7, 11, 13], [1, 3, 5], [2, 4, 6, 8]]
		   * Structure after flattening is : [5, 7, 11, 13, 1, 3, 5, 2, 4, 6, 8]
		   * 
		   * Task: To change each Employee name to upper case using map()
		   */
		  List<Employee> tempEmp3 = emp.stream().map(e -> 
		    {
		       e.setName(e.getName().toUpperCase());
		         return e;
		     }).collect(Collectors.toList());
		  tempEmp3.forEach(e->System.out.println("Name:-"+ e.getName()+" , Designation :- " + e.getDesignation() + " , Age :- " + e.getAge()+" , Salary:-"+e.getSalary()));  
		  System.out.println("\n");
		  
		  /*
		   * flatMap() is the combination of a map and a flat operation i.e, it applies a function to elements as well as flatten them.
		   * Stream flatMap(Function mapper) is an intermediate operation. 
		   * These operations are always lazy. 
		   * Intermediate operations are invoked on a Stream instance and after they finish their processing, they give a Stream instance as output.
		   * 
		   * Task: To get the char at position 2 from every employee's name
		   */
		  emp.stream().flatMap(e -> 
          Stream.of(e.getName().charAt(2))).
          forEach(System.out::println);
		  System.out.println("\n");
		  
		  /*
		   * Doing the same with map is not possible
		   * java.util.stream.ReferencePipeline$Head@2d98a335 for every entry of employee 
		   * //gives something like this in o/p, no compilation error though
		   */
		  emp.stream().map(e -> 
          Stream.of(e.getName().charAt(2))).
          forEach(System.out::println);
		  System.out.println("\n");
		  
		 /*
		  * Task: To find name and designation of employees with salary amount that is a even number
		  */
		  List<Employee> tempEmp5=emp.stream().filter(e->e.getSalary()%2==0).collect(Collectors.toList());
		  tempEmp5.forEach(e->System.out.println("Name:-"+ e.getName()+" , Designation :- " + e.getDesignation()));
		  System.out.println("\n");
		  
		  /*
		   * Task: Converting to hashmap
		   */
		  Map<Object, Object> employeesMap =   
		            emp.stream()  
		           .collect(Collectors.toMap(e->e.empId, e->e.name));  
		              
		        System.out.println(employeesMap);  
		        System.out.println("\n");
		        
		    /*
		     * Task: Converting to Set
		     */
		        Set<Long> employeeList =   
		                emp.stream()  
		                .filter(e->e.salary < 20000000)   // filter employee on the base of salary  
		                .map(e->e.salary)  
		                .collect(Collectors.toSet());   // collect it as Set(remove duplicate elements)  
		            System.out.println(employeeList); 
		            System.out.println("\n");
		        
		    /*
		     * Method reference is a compact way of referring to a method of functional interface. 
		     * It is used to refer to a method without invoking it. :: (double colon) is used for describing the method reference. 
		     * The syntax is class::methodName
		     * 
		     * Task: Implement Method References
		     */
		        List<Long> salaryList =   
		                            emp.stream()  
		                            .filter(e -> e.salary > 1000000) // filtering data  
		                            .map(Employee::getSalary)         // fetching salary by referring getSalary method  
		                            .collect(Collectors.toList());  // collecting as list  
		        System.out.println(salaryList);  
		        System.out.println("\n");
		      
		    /*
		     * Task: Employee with maximum salary
		     */
		       Employee maxSal= emp.stream().max((salary1,salary2)->salary1.salary>salary2.salary ? 1 : -1).get();
		       System.out.println(maxSal.salary);
		       System.out.println("\n");
		       
		       
		       /*
			     * Task: Employee with minimum salary
			     */
			       Employee minSal= emp.stream().min((salary1,salary2)->salary1.salary>salary2.salary ? 1 : -1).get();
			       System.out.println(minSal.salary);
			       System.out.println("\n");
		     
			       /*
			        * Sum by Employee's Salary using Collectors Methods
			        */
			       long totalSalary = emp.stream()  
	                        .collect(Collectors.summingLong(e->e.salary));  
	               System.out.println(totalSalary); 
	               System.out.println("\n");
		        
	               
	              /*
	               * reduce() Method in Collection: This method takes a sequence of input elements 
	               * and combines them into a single summary result by repeated operation. 
	               * For example, finding the sum of numbers, or accumulating elements into a list.
	               * 
	               * Task: sum of all the employee's salary by reduce()
	               */
	               long totalSalary2 = emp.stream()  
	                       .map(e->e.salary)  
	                       .reduce(0L,Long::sum);   // accumulating salary, by referring method of Long class  
	               System.out.println(totalSalary2);  
	               System.out.println("\n");
		  
	}
}
