package application;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import entities.Product;
import util.PriceUpdate;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));
        
        // Implementação 1 - implementação da interface
        //list.forEach(new PriceUpdate());
        
        // Implementação 2 - reference method com método estático
        //list.forEach(Product::staticPriceUpdate);
        
        // Implementação 3 - reference method com método não estático
        //list.forEach(Product::nonStaticPriceUpdate);
        
        // Implementação 4 - expressão lambda declarada
        double factor = 1.1;
        Consumer<Product> cons = p -> {
            p.setPrice(p.getPrice() * factor);
        };
        list.forEach(cons);
        
        // Implementação 5 - expressão lambda inline
        //list.forEach(p -> p.setPrice(p.getPrice() * factor));
        
        // Reference method para o println
        list.forEach(System.out::println);
    }
}
