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
     * update worker's salary based on the status and amount
     * 
     * @param updateworker worker whose salary is being updated.
     * @param status       string determine whether the salary should be increase or
     *                     decrease.
     * @param amount       amount the salary should be adjusted.
     */
    public void updateSalary(SalaryHistory updateworker, String status, int amount) {
        int a;
        if (status.equalsIgnoreCase("up")) {
            a = 1;
        } else {
            a = -1;
        }
        updateworker.setSalary(updateworker.getSalary() + (a * amount));

    }

    /**
     * modifies worker's salary and update information in salary history
     * 
     * @param worker the worker whose salary is to be modified
     * @param amount the amount to be added or deducted from the worker's salary
     */
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
        System.out.printf(
                "%-10s%-20s%-10s%-15s%-10s%-20s\n",
                "Code",
                "Name",
                "Age",
                "Salary",
                "Status",
                "Date");
        for (SalaryHistory salaryworker : listSalary) {
            salaryworker.display();
            System.out.println("");

        }
    }
}
