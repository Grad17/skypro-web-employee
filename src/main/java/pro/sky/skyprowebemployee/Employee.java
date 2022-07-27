package pro.sky.skyprowebemployee;

import java.util.Objects;

public class Employee {

    private final String firstName;
    private final String lastName;


    public Employee (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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