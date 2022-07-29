package application;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import entities.Product;

public class Program {
    
    public static void main(String[] args) {
        
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Exercício 1 - Map");
        System.out.println("Manipulação das funções do Map.");
        System.out.println();
        
        Map<String, String> cookies = new TreeMap<>();
        
        cookies.put("username", "Maria");
        cookies.put("email", "maria@gmail.com");
        cookies.put("phone", "998237182");
        
        cookies.remove("email");
        cookies.put("phone", "998237183"); // Sobrescreve o valor anterior
        
        System.out.println("Contains 'phone' key: " + cookies.containsKey("phone"));
        System.out.println("Phone number: " + cookies.get("phone"));
        System.out.println("Email: " + cookies.get("email")); // null
        System.out.println("Size: " + cookies.size());
        
        System.out.println("ALL COOKIES:");
        for (String key : cookies.keySet()) {
            // Como estamos usando o TreeMap, ele ordenara a chave por ordem alfabética
            System.out.println(key + ": " + cookies.get(key));
        }
        
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Exercício 2 - Map");
        System.out.println("Problema prático com estoque de produtos.");
        System.out.println();
        
        Map<Product, Double> stock = new HashMap<>();
        
        Product p1 = new Product("Tv", 900.0);
        Product p2 = new Product("Notebook", 1200.0);
        Product p3 = new Product("Tablet", 400.0);
        
        stock.put(p1, 10000.0);
        stock.put(p2, 20000.0);
        stock.put(p3, 15000.0);
        
        Product ps = new Product("Tv", 900.0); // Se não existe o equals e hashCode, ele utiliza comparação de ponteiros e da false
        
        System.out.println("Contains 'ps' key: " + stock.containsKey(ps));
        
    }
    
}
