package org.test;

interface Sayable{  
    public String say1(String name);  
    
   public default void say2(){
	   System.out.println("test 123");
   }
}  
  
public class FunctionalInterface1{  
    public static void main(String[] args) {  
      
        // Lambda expression with single parameter.  
        Sayable s1=(name)->{  
            return "Hello, "+name;  
        };  
        System.out.println(s1.say1("Sonoo"));  
          
        // You can omit function parentheses    
        Sayable s2= name -> "Hello, "+name;
        System.out.println(s2.say1("Sonoo"));  
        
        s1.say2();
        s2.say2();
    }  
}  
