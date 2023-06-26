package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSlary;
	
	
	//Associações
	private Departament departament;
	private List<HourContracts> contratos = new ArrayList<>();
	
	public Worker() {}

	public Worker(String name, WorkerLevel workerLevel, Double baseSlary, Departament departamentName) {
		this.name = name;
		this.level = workerLevel;
		this.baseSlary = baseSlary;
		this.departament = departamentName;
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

	public double getBaseSlary() {
		return baseSlary;
	}

	public void setBaseSlary(Double baseSlary) {
		this.baseSlary = baseSlary;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public List<HourContracts> getContratos() {
		return contratos;
	}
	
	public void AddContract(HourContracts contracts) {
		contratos.add(contracts);
	}
	
	public void RemoveContract(HourContracts contracts) {
		contratos.remove(contracts);
	}
	
	public double income(int year, int month) {
		double soma = this.baseSlary;
		Calendar cal = Calendar.getInstance();
		
		for(HourContracts c : contratos) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
		    int c_month = 1 + cal.get(Calendar.MONTH);
		    
		    if(year == c_year && month == c_month) {
		    	
		    	soma+= c.totalValue();
		    }
		}
		
		return soma;
	}
	
}
