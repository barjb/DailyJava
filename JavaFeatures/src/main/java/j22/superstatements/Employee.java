package j22.superstatements;

public class Employee extends Person{
    int salary;

    public Employee(String name, int age, int salary) {
        if(salary < 0) throw new IllegalArgumentException("salary cannot be lower than 0 PLN");
        super(name, age);
        this.salary = salary;
    }
}
