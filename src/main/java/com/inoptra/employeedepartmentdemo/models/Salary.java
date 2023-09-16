package com.inoptra.employeedepartmentdemo.models;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/* @Author: Shrikrishna Prabhumirashi
 * @Description:
 * SalaryComponent is dependent upon base salary and can be calculated as baseSalary multiplied by respective factor.
 *  i.e. SalaryComponent_amount = baseSalary * factor;
 *  Actual salary can be calculated as sum of all SalaryComponent amounts.
 * */
@Embeddable
public class Salary {
	private double baseSalary;
	@ElementCollection
	private List<SalaryComponent> salaryComonents;

	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public List<SalaryComponent> getSalaryComonents() {
		return salaryComonents;
	}
	public void setSalaryComonents(List<SalaryComponent> salaryComonents) {
		this.salaryComonents = salaryComonents;
	}
	
}
