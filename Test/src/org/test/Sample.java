package org.test;

interface sayable4{  
    void say(String msg);   // abstract method  
}  
//@FunctionalInterface  
interface Doable extends sayable4{  
    // Invalid '@FunctionalInterface' annotation; Doable is not a functional interface  
    void doIt();  
}  