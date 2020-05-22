package net.skillfactory.model;

import net.skillfactory.interfaces.ISalaryStrategy;

public class Context {

    private ISalaryStrategy salaryStrategy;

    public Context(ISalaryStrategy salaryStrategy){
        this.salaryStrategy = salaryStrategy;
    }

    public Double getSalaryByCategory(Double salary){
        return salaryStrategy.applySalary(salary);
    }
}
