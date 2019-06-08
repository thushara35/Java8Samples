package org.test;

import java.util.ArrayList;  
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;   
class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        super();  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}  
public class LambdaExpressionExample11{  
    public static void main(String[] args) {  
        List<Product> list=new ArrayList<>();  
        list.add(new Product(1,"Samsung A5",17000f));  
        list.add(new Product(3,"Iphone 6S",65000f));  
        list.add(new Product(2,"Sony Xperia",25000f));  
        list.add(new Product(4,"Nokia Lumia",15000f));  
        list.add(new Product(5,"Redmi4 ",26000f));  
        list.add(new Product(6,"Lenevo Vibe",19000f));  
          
        // using lambda to filter data  
        Stream<Product> filtered_data = list.stream().filter(p -> p.price > 20000);  
          
        // using lambda to iterate through collection  
        filtered_data.forEach(  
                product -> System.out.println(product.name+": "+product.price)  
        );  
        
        
        
        list.stream().filter(p -> p.price > 20000).forEach(p -> System.out.println(p.name));
        
        
     // using lambda to filter data  
        List<Product> pList = list.stream().filter(p -> p.price > 20000).collect(Collectors.toList());
        
     // Create an AtomicInteger for index 
        AtomicInteger index = new AtomicInteger();
        
        pList.forEach(p -> {
        	index.getAndIncrement();
        	if(index.get()==pList.size())
        		System.out.print(p.name);
        	else 
        		System.out.print(p.name+", ");
        });
    }  
}  