package application;

import java.util.Locale;
import java.util.Scanner;

import util.Calculator;

public class Program {

    public static final double PI = 3.14159; 
    // final para dizer que o valor não pode ser alterado (constante)
    // TUDO EM MAIÚSCULO é o padrão do java para constantes

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        Calculator calc = new Calculator();
        
        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();
        
        double c = calc.circumference(radius);
        double v = calc.volume(radius);
        
        System.out.printf("Circumference: %.2f%n", c);
        System.out.printf("Volume: %.2f%n", v);
        System.out.printf("PI value: %.2f%n", PI);
        
        sc.close();
    }
}
