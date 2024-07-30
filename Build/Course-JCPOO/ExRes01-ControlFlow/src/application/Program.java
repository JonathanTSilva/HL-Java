package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Exercício 1 - While");
        System.out.println("Ler números inteiros até que um zero seja lido. Ao final mostrar a soma dos números lidos.");
        System.out.println();
        
        int x1 = sc.nextInt();
        int soma1 = 0;
        
        while (x1 != 0) {
          soma1 += x1;
          x1 = sc.nextInt();
        }
        
        System.out.println(soma1);
        
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Exercício 2 - For");
        System.out.println("Ler um valor inteiro N e depois N números inteiros. Ao final, mostrar a soma dos N números lidos.");
        System.out.println();
        
        int N = sc.nextInt();
        int soma2 = 0;
        
        for (int i = 0; i<N; i++) {
          int x2 = sc.nextInt();
          soma2 += x2;
        }
        
        System.out.println(soma2);
        
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Exercício 3 - doWhile");
        System.out.println("Ler uma temperatura em Celsius e mostrar o equivalente em Fahrenheit. Perguntar se o usuário deseja repetir (s/n). Caso o usuário digite \"s\", repetir o programa.");
        System.out.println();
        
        char resposta;
        
        do {
          System.out.print("Digite uma temperatura em Celsius: ");
          double Celsius = sc.nextDouble();
          double Fahrenheit = (9.0 * Celsius/5.0) + 32.0;
          System.out.printf("Equivalente em Fahrenheit: %.1f%n", Fahrenheit);
          System.out.print("Deseja repetir (s/n)? ");
          resposta = sc.next().charAt(0);
        } while (resposta != 'n');
        
        sc.close();
        
    }

}
