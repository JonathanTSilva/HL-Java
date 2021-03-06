package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {
	public static void main(String[] args) {
		
	    System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Atividade de manipulação de lista");
        System.out.println();
	    
		List<String> listTest = new ArrayList<>();

		listTest.add("Maria");
		listTest.add("Alex");
		listTest.add("Bob");
		listTest.add("Anna");
		listTest.add(2, "Marco"); // Adicionar um elemento na posição 2 da lista

	    System.out.println(listTest.size()); // Imprime o tamanho da lista

	    for (String x : listTest) { // Imprime todos os elementos da lista
	        System.out.println(x);
	    }

	    System.out.println("---------------------");
	    listTest.remove("Anna");
	    listTest.remove(1); // Remover elemento da posição 1
	    listTest.removeIf(x -> x.charAt(0) == 'M'); // Remover o Predicado que pega o valor x e retorna se esse x.charAt(0) é igual 'M'
	    for (String x : listTest) {
	        System.out.println(x);
	    }

	    System.out.println("---------------------");
	    System.out.println("Index of Bob: " + listTest.indexOf("Bob")); // Retorna o index do Bob na lista
	    System.out.println("Index of Marco: " + listTest.indexOf("Marco")); // Quando o indexOf não encontra o elemento, ele retorna -1

	    System.out.println("---------------------");
	    List<String> result = listTest.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList()); // Filtra a lista list e retorna em result todos os elementos que começão com o predicado
	    for (String x : result) {
	        System.out.println(x);
	    }

	    System.out.println("---------------------");
	    String nameTest = listTest.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null); // Pega o primeiro elemento que atenda o predicado
	    System.out.println(nameTest);
		
        /*
         * Fazer um programa para ler um número inteiro N e depois os dados (id, nome e
         * salario) de N funcionários. Não deve haver repetição de id. Em seguida,
         * efetuar o aumento de X por cento no salário de um determinado funcionário.
         * Para isso, o programa deve ler um id e o valor X. Se o id informado não
         * existir, mostrar uma mensagem e abortar a operação. Ao final, mostrar a
         * listagem atualizada dos funcionários,conforme exemplos.
         * 
         * Lembre-se de aplicar a técnica de encapsulamento para não permitir que o
         * salário possa ser mudado livremente. Um salário só pode ser aumentado com
         * base em uma operação de aumento por porcentagem dada.
         */
		
	    Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
	    
		System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Exercício 1 - Vectors");
        System.out.println();
        
		List<Employee> list = new ArrayList<>();
		
		// PART 1 - READING DATA:
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Employee #" + i + ":");
			
			System.out.print("ID: ");
			int id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			list.add(new Employee(id, name, salary));
		}
		
		// PART 2 - UPDATING SALARY OF GIVEN EMPLOYEE:

		System.out.println();
		System.out.print("Enter the employee ID that will have slaray increase: ");
		int id = sc.nextInt();
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("This id does not exist!");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}
		
		// PART 3 - LISTING EMPLOYEES:
		System.out.println();
		System.out.println("List of employees:");
		for (Employee obj : list) {
			System.out.println(obj);
		}
		
		sc.close();
	}
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}
