package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	// Associações
	private Department department;
	private List<HourContract> contracts = new ArrayList<>(); // Como um Worker tem vários contratos (1,*), é representado com uma lista
	// IMPORTANTE! Quando se tem uma composição tem muitos, a lista não é incluída no construtor, mas simplesmente iniciada vazia aqui.
	
	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	
	// Têm-se estes dois métodos para fazer ou desfazer a associação entre um trabalhador e um contrato. Add ou remove da lista.
	// Assim, é preciso remover o setContracts do Setters, pois de maneira alguma, eu posso trocar essa lista de contratos por outra nova.
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		
		Calendar cal = Calendar.getInstance();
		
		// Percorre por todos os contratos da lista, testando se o contrato é desse mês e ano passado.
		// Se sim, ele entra na soma do salário.
		for (HourContract c : contracts) {
			// Se fosse a soma de todos os contratos, seria sum += c.totalValue();
			// Entretanto, queremos a soma desse mes e ano
			cal.setTime(c.getDate()); // Pega a data do contrato e define ela como sendo a data do calendário
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
	
}
