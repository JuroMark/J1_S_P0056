package main;

import bo.SalaryHistoryBO;
import bo.WorkerBO;
import constant.IMessage;
import constant.IConstant;
import entity.Worker;
import java.util.ArrayList;
import mocks.Data;
import utils.Validate;

public class Main {
    public static void main(String[] args) {
        WorkerBO workerbo = new WorkerBO(new ArrayList<>());
        SalaryHistoryBO salarybo = new SalaryHistoryBO(new ArrayList<>());
        while (true) {
            System.out.println("\nWELCOME TO WORKER MANAGEMENT");
            System.out.println("1. Create Worker");
            System.out.println("2. Update Salary");
            System.out.println("3. Display List Worker");
            System.out.println("4. Display List Salary Update");
            System.out.println("5. Load sample data");
            System.out.println("6. Exit");

            int choice = Validate.getInt("Please choose an option (1-6): ",
                    "Out of range (1-6)", "Please input a number.", 1, 6);
            switch (choice) {
                case 1:
                    System.out.println("===== Create Worker =====");
                    workerbo.addWorker();
                    break;
                case 2:
                    System.out.println("===== Update Salary =====");
                    String idupdate = Validate.getString(
                            "Enter worker code you want to update salary: ",
                            IConstant.VALID_ID, IMessage.ENTER_AGAIN);
                    Worker worker = workerbo.searchWorkerById(idupdate);
                    if (worker == null) {
                        System.out.println("Worker not found!");
                        break;
                    }

                    int newSalary = Validate.getInt("Enter new salary: ",
                            "Invalid salary", "Please input a number.", 1, Integer.MAX_VALUE);
                    salarybo.updateWorkerSalary(worker, newSalary);
                    break;
                case 3:
                    System.out.println("===== List Worker =====");
                    workerbo.display();
                    break;
                case 4:
                    System.out.println("===== List Salary Update =====");
                    salarybo.display();
                    break;
                case 5:
                    System.out.println("===== Load Sample Data =====");
                    workerbo.setList(Data.listdata());
                    System.out.println("Sample data loaded successfully.");
                    break;
                case 6:
                    System.out.println("Exit");
                    return;
            }
        }
    }
}
