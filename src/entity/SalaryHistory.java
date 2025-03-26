package entity;

import constant.IMessage;
import constant.IConstant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import utils.Validate;

public class SalaryHistory extends Worker {
    private String status;
    private LocalDateTime date;

    public SalaryHistory() {
    }

    public SalaryHistory(String id, String status, LocalDateTime date, String name, int age, int salary) {
        super(id, name, age, salary);
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void input() {
        this.status = Validate.getString(
                "Enter worker status: ",
                IConstant.UP_DOWN,
                IMessage.ENTER_AGAIN);
        this.date = LocalDateTime.now();
    }

    public void display() {
        super.display();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        String formattedDate = this.date.format(formatter);
        System.out.printf("%-10s%-20s",
                this.status,
                formattedDate);
    }

}
