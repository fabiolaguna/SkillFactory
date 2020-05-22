package net.skillfactory;

import net.skillfactory.interfaces.ISalaryStrategy;
import net.skillfactory.model.AdministrativeSalary;
import net.skillfactory.model.Context;
import net.skillfactory.model.DirectorSalary;
import net.skillfactory.model.Empleado;
import net.skillfactory.model.EmployeeCategory;
import net.skillfactory.model.OperatorSalary;

public class App {

    public static void main( String[] args ) {

        Empleado e1 = new Empleado("Fabio", EmployeeCategory.Operator, 27000D);
        Empleado e2 = new Empleado("Lucas", EmployeeCategory.Administrative, 30000D);
        Empleado e3 = new Empleado("Maria", EmployeeCategory.Director, 45000D);

        System.out.println(String.format("EMPLEADO 1. Nombre: %s - Categoria: %s - Salario: %.2f", e1.getName(), e1.getCategory(), e1.getSalary()));
        System.out.println(String.format("EMPLEADO 2. Nombre: %s - Categoria: %s - Salario: %.2f", e2.getName(), e2.getCategory(), e2.getSalary()));
        System.out.println(String.format("EMPLEADO 3. Nombre: %s - Categoria: %s - Salario: %.2f\n", e3.getName(), e3.getCategory(), e3.getSalary()));

        Context e1Context = new Context(getSalaryImplementation(e1.getCategory()));
        Context e2Context = new Context(getSalaryImplementation(e2.getCategory()));
        Context e3Context = new Context(getSalaryImplementation(e3.getCategory()));

        e1.setSalaryByCategory(e1Context);
        e2.setSalaryByCategory(e2Context);
        e3.setSalaryByCategory(e3Context);

        System.out.println(String.format("EMPLEADO 1. Nombre: %s - Categoria: %s - Nuevo Salario: %.2f", e1.getName(), e1.getCategory(), e1.getSalary()));
        System.out.println(String.format("EMPLEADO 2. Nombre: %s - Categoria: %s - Nuevo Salario: %.2f", e2.getName(), e2.getCategory(), e2.getSalary()));
        System.out.println(String.format("EMPLEADO 3. Nombre: %s - Categoria: %s - Nuevo Salario: %.2f\n", e3.getName(), e3.getCategory(), e3.getSalary()));

    }

    public static ISalaryStrategy getSalaryImplementation(EmployeeCategory category) {

        ISalaryStrategy salary;

        if(category.toString().equalsIgnoreCase("administrative")){
            salary = new AdministrativeSalary();
        } else if(category.toString().equalsIgnoreCase("director")){
            salary = new DirectorSalary();
        } else {
            salary = new OperatorSalary();
        }

        return salary;
    }

}
