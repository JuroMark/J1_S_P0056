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
            System.out.println("1. Add doctor");
            System.out.println("2. Update salary");
            System.out.println("3. Display list worker");
            System.out.println("4. Display list salary update");
            System.out.println("5. List Data");
            System.out.println("6. Exit");

            int choice = Validate.getInt("Enter your choice: ",
                    "Out of range 1-6",
                    "Must be a number", 1, 6);

            switch (choice) {
                case 1:
                    workerbo.addWorker();
                    break;
                case 2:
                    String codeupdate = Validate.getString(
                            "Enter worker code you want to update salary: ",
                            IConstant.VALID_ID,
                            IMessage.ENTER_AGAIN);
                    Worker worker = workerbo.searchWorkerById(codeupdate);
                    salarybo.add(worker, 100);
                    break;
                case 3:
                    workerbo.display();
                    break;
                case 4:
                    salarybo.display();
                    break;
                case 5:
                    workerbo.setList(Data.listdata());
                    break;
                case 6:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println(IMessage.ENTER_AGAIN);
                    break;
            }
        }
    }
}
