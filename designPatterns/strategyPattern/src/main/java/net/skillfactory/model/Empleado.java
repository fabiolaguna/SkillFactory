package net.skillfactory.model;

public class Empleado {

    private String name;
    private EmployeeCategory category;
    private Double salary;

    public Empleado(String name, EmployeeCategory category, Double salary) {
        this.name = name;
        this.category = category;
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }
    public String getName() {
        return name;
    }
    public EmployeeCategory getCategory() {
        return category;
    }

    public void setSalaryByCategory(Context context){
        this.salary = context.getSalaryByCategory(this.salary);
    }
}
