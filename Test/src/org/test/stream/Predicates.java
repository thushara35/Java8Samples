package org.test.stream;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;

class Student{
   int stuId; 
   int stuAge;  
   String stuName;  
   Student(int id, int age, String name){
      this.stuId = id;   
      this.stuAge = age;  
      this.stuName = name;  
   }  
   public int getStuId() { 
      return stuId;  
   }  
   public int getStuAge() {  
      return stuAge;  
   } 
   public String getStuName() {  
      return stuName;  
   }  
   public static List<Student> getStudents(){ 
      List<Student> list = new ArrayList<>(); 
      list.add(new Student(11, 28, "Lucy")); 
      list.add(new Student(28, 27, "Tim")); 
      list.add(new Student(32, 30, "Daniel")); 
      list.add(new Student(49, 27, "Steve")); 
      list.add(new Student(49, 27, "Luck"));
      return list; 
   }
}

public class Predicates {
	public static void main(String[] args) { 
	      Predicate<Student> p3 = s -> s.stuAge < 40 && s.stuName.startsWith("L");
	      List<Student> list = Student.getStudents();

	      /* allMatch() method returns true if all the elements of stream satisfy the 
	       * given predicate, else it returns false 
	       */ 

	      /* This will return false because all student names do not start with "A"  
	       */ 
	      boolean b1 = list.stream().allMatch(p3); // check all the elements 
	      System.out.println("list.stream().allMatch(p3): "+b1); 
	      
	      boolean b2 = list.stream().anyMatch(p3); // check all the elements 
	      System.out.println("list.stream().anyMatch(p3): "+b2); 
	      
	      
	      List<String> list2 = Arrays.asList("Mukesh", "Vishal", "Amar");
		    String result = list2.parallelStream().collect(StringBuilder::new,
		    		(response, element) -> response.append(" ").append(element),
		    		(response1, response2) -> response1.append(",").append(response2.toString()))
		    		.toString();
		    
		    System.out.println("Result: " + result);
		    
		    String result2 = list2.stream().collect(Collectors.joining(", "));
		    System.out.println("Result2: " + result2);
		    
		    List<Integer> intList = Arrays.asList(1, 2, 3);	
		    IntSummaryStatistics stats = intList.stream()
	  			     .collect(Collectors.summarizingInt(no -> no));
		    
		    System.out.println("Sum:"+stats.getSum());
		    
		    List<Student> studentList = Student.getStudents();
		    
		    Optional<Student> student = studentList.stream().filter(p3).findAny();
		    
		    System.out.println(student.get().stuName);
		    
		    Optional<Student> student2 = studentList.stream().filter(p3).filter(s -> s.stuAge==27).findFirst();
		    
		    System.out.println(student2.get().stuName);
		    
		    System.out.println("--Using IntStream.rangeClosed--");
			IntStream.rangeClosed(1, 4).map(n->n*n).forEach(s->System.out.print(s +" "));
			System.out.println("\n--Using IntStream.range--");
			IntStream.range(1,4).map(n->n*n).forEach(s->System.out.print(s +" "));
			System.out.println("\n--Sum of range 1 to 10--");
			System.out.print(IntStream.rangeClosed(1,4).sum());
			System.out.println("\n--Sorted number--");
			IntStream.of(13,4,15,2,8).sorted().forEach(s->System.out.print(s +" "));
			
			System.out.println("\n--int list--");
			List<Integer> intList1 = IntStream.rangeClosed(1, 4).map(n->n+n).boxed().collect(Collectors.toList());
			intList1.forEach(s->System.out.print(s.toString() +" "));
			
			System.out.println("\n--forEachOrdered--");
			// Using forEachOrdered(Consumer action) to  
		    // print the elements of stream in encounter order 
			IntStream.of(13,4,15,2,8).boxed().forEachOrdered(s->System.out.print(s.toString() +" ")); 

	}
}
