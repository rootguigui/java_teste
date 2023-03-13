package models;

public class Member {
    private double salary;
    private String name;
    private int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Member(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Member{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
