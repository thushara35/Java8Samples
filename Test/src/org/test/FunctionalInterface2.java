package org.test;

@FunctionalInterface  //An informative annotation type
interface sayable3{  
    void say(String msg);   // abstract method  
    // It can contain any number of Object class methods.  
    int hashCode();  
    String toString();  
    boolean equals(Object obj);  
}  
public class FunctionalInterface2 implements sayable3{  
    public void say(String msg){  
        System.out.println(msg);  
    }  
    public static void main(String[] args) {  
    	FunctionalInterface2 fie = new FunctionalInterface2();  
        fie.say("Hello there");  
    }  
}  