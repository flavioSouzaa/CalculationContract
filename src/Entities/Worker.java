package Entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Entities.Enum.WorkeLevel;

public class Worker {
	private String name;
	private WorkeLevel level;
	private double baseSalary;

	private Department department;
	private List<HourContract> contracts = new ArrayList<>();

	public Worker() {
	}

	public Worker(String name, WorkeLevel level, double baseSalary, Department department) {
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

	public WorkeLevel getLevel() {
		return level;
	}

	public void setLevel(WorkeLevel level) {
		this.level = level;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContract() {
		return contracts;
	}

	public void AddContract(HourContract contract) {
		contracts.add(contract);
	}

	public void RemoveContract(HourContract contract) {
		contracts.remove(contract);
	}

	public double Icome(Integer year, Integer month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_Year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (year == c_Year && month == c_month) {
				sum += c.TotalValue();
			}
		}
		return sum;
	}

}
