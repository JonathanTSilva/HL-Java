package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {
    public static void main(String[] args) {
    
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
    
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Exercício 1 - Vectors");
        System.out.println("Ler um número inteiro N e os dados (nome e preço) de N Produtos. Armazenar os N produtos em um vetor. Em seguida, mostrar o preço médio dos produtos.");
        System.out.println();
        
        int n = sc.nextInt();
        double sum = 0.0;
        Product[] vect = new Product[n];
    
        for (int i=0; i<vect.length; i++) {
          sc.nextLine();
          String name = sc.nextLine();
          double price = sc.nextDouble();
          vect[i] = new Product(name, price);
          sum += vect[i].getPrice();
        }
    
        double avg = sum / vect.length;
    
        System.out.printf("AVERAGE PRICE = %.2f%n", avg);
    
        sc.close();
    }
}
