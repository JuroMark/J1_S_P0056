package bo;

import entity.SalaryHistory;
import entity.Worker;
import java.util.List;

public class SalaryHistoryBO {
    private List<SalaryHistory> listSalary;

    public SalaryHistoryBO() {
    }

    public SalaryHistoryBO(List<SalaryHistory> listSalary) {
        this.listSalary = listSalary;
    }

    public List<SalaryHistory> getList() {
        return listSalary;
    }

    public void setList(List<SalaryHistory> listSalary) {
        this.listSalary = listSalary;
    }

    /**
     * Updates worker's salary using the new salary value provided.
     * It calculates the difference, determines the status ("up" or "down"),
     * updates the salary in the history record, synchronizes the worker's salary,
     * and adds the record to the salary history list.
     * 
     * @param worker    the worker whose salary is to be updated.
     * @param newSalary the new salary value.
     */

    public void add(Worker worker, int newSalary) {
        int currentSalary = worker.getSalary();
        if (newSalary == currentSalary) {
            System.out.println("New salary is same as current salary. No update performed.");
            return;
        }
        String status = newSalary > currentSalary ? "up" : "down";
        SalaryHistory updateworker = new SalaryHistory();
        updateworker.setName(worker.getName());
        updateworker.setAge(worker.getAge());
        updateworker.setStatus(status);
        updateworker.setDate(java.time.LocalDateTime.now());
        worker.setSalary(newSalary);
        updateworker.setSalary(newSalary);
        this.listSalary.add(updateworker);
        System.out.println("Salary updated successfully. New salary: " + worker.getSalary());
    }

    public void display() {
        if (listSalary.isEmpty()) {
            System.out.println("List empty!!");
            return;
        }
        System.out.printf("%-10s%-20s%-10s%-15s%-10s%-20s\n",
                "ID", "Name", "Age", "Salary", "Status", "Time");
        for (SalaryHistory salaryworker : listSalary) {
            salaryworker.display();
            System.out.println("");
        }
    }
}
