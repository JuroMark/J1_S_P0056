package bo;

import entity.Worker;
import java.util.List;

public class WorkerBO {
    private List<Worker> list;

    public WorkerBO() {
    }

    public WorkerBO(List<Worker> list) {
        this.list = list;
    }

    public List<Worker> getList() {
        return list;
    }

    public void setList(List<Worker> list) {
        this.list = list;
    }

    public Worker searchWorkerById(String id) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (Worker worker : list) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return worker;
            }
        }
        return null;
    }

    /**
     * Checks if a worker entry is duplicated in the list.
     *
     * @param code   worker code
     * @param name   worker name
     * @param age    worker age to check
     * @param salary worker salary to check
     * 
     * @return true if not duplicated, false if duplicated.
     */
    public boolean checkDuplicate(String id,
            String name, int age, int salary) {
        // check from first to last list doctor
        for (Worker worker : list) {
            if (id.equalsIgnoreCase(worker.getId())
                    && name.equalsIgnoreCase(worker.getName())
                    && age == worker.getAge()
                    && salary == worker.getSalary()) {
                return false;
            }
        }
        return true;
    }

    public void addWorker() {
        Worker worker = new Worker();
        worker.input(this);
        list.add(worker);
    }

    public void display() {
        if (list.isEmpty()) {
            System.out.println("List empty!!");
            return;
        }
        System.out.printf(
                "%-10s%-20s%-10s%-15s\n",
                "Code",
                "Name",
                "Age",
                "Salary");
        for (Worker worker : list) {
            worker.display();
            System.out.println("");

        }
    }
}
