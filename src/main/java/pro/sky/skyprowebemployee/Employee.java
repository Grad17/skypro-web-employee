package pro.sky.skyprowebemployee;

import java.util.Objects;

public class Employee {

    private String firstName;
    private String lastName;
    private int department;
    private int salary;

    public Employee (String firstName, String lastName, int department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public Employee(int department) {
        this.department = department;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public String toString() {
        return "Имя: " + firstName +
                ", Фамилия: " + lastName;
    }
}