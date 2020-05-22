package net.skillfactory.model;

import net.skillfactory.interfaces.ISalaryStrategy;

public class DirectorSalary implements ISalaryStrategy {

    @Override
    public Double applySalary(Double salary) {
        return salary - (salary * 0.20);
    }
}
