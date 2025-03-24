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
     * Update worker's salary based on the status and amount.
     * 
     * @param updateworker worker whose salary is being updated.
     * @param status       determines whether the salary should be increased or
     *                     decreased.
     * @param amount       amount the salary should be adjusted.
     */
    public void updateSalary(SalaryHistory updateworker, String status, int amount) {
        if (status.equalsIgnoreCase("up")) {
            updateworker.setSalary(updateworker.getSalary() + amount);
        } else {
            updateworker.setSalary(updateworker.getSalary() - amount);
        }
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
    public void updateWorkerSalary(Worker worker, int newSalary) {
        int currentSalary = worker.getSalary();
        if (newSalary == currentSalary) {
            System.out.println("New salary is same as current salary. No update performed.");
            return;
        }
        String status = newSalary > currentSalary ? "up" : "down";
        int diff = Math.abs(newSalary - currentSalary);

        SalaryHistory sh = new SalaryHistory();
        sh.setId(worker.getId());
        sh.setName(worker.getName());
        sh.setAge(worker.getAge());
        sh.setSalary(currentSalary);
        sh.setStatus(status);
        sh.setDate(java.time.LocalDateTime.now());

        updateSalary(sh, status, diff);
        worker.setSalary(sh.getSalary());
        this.listSalary.add(sh);
        System.out.println("Salary updated successfully. New salary: " + worker.getSalary());
    }

    public void add(Worker worker, int amount) {
        SalaryHistory updateworker = new SalaryHistory();
        updateworker.setId(worker.getId());
        updateworker.setName(worker.getName());
        updateworker.setSalary(worker.getSalary());
        updateworker.setAge(worker.getAge());
        updateworker.input();

        this.updateSalary(updateworker, updateworker.getStatus(), amount);
        worker.setSalary(updateworker.getSalary());
        this.listSalary.add(updateworker);
    }

    public void display() {
        if (listSalary.isEmpty()) {
            System.out.println("List empty!!");
            return;
        }
        System.out.printf("%-10s%-20s%-10s%-15s%-10s%-20s\n",
                "Code", "Name", "Age", "Salary", "Status", "Date");
        for (SalaryHistory salaryworker : listSalary) {
            salaryworker.display();
            System.out.println("");
        }
    }
}
