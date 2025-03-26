package entity;

import utils.Validate;
import constant.IMessage;
import constant.IConstant;

public class Worker {
    private static int count = 1;
    private String id;
    private String name;
    private int age;
    private int salary;

    public Worker() {
        this.id = "W" + count++;
    }

    public Worker(String id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void input() {
        this.id = String.format("W%d", count++);
        this.name = Validate.getString(
                "Enter Worker name: ",
                IConstant.REGULAR_STRING,
                IMessage.ENTER_AGAIN);
        this.age = Validate.getInt(
                "Enter Worker age: ",
                "Age is out of range 18-50",
                IMessage.ENTER_AGAIN,
                18, 50);
        this.salary = Validate.getInt(
                "Enter Worker salary: ",
                "Salary is out of range",
                IMessage.ENTER_AGAIN,
                0, Integer.MAX_VALUE);
    }

    public void display() {
        System.out.printf("%-10s%-20s%-10d%-15d",
                this.id,
                this.name,
                this.age,
                this.salary);
    }

    public void updateSalary(String status, int amount) {
        if (status.equalsIgnoreCase("up")) {
            this.salary += amount;
        } else {
            this.salary -= amount;
        }
    }
}
