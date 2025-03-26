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
        if (list.isEmpty()) {
            return null;
        }
        for (Worker worker : list) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return worker;
            }
        }
        return null;
    }

    public boolean addWorker() {
        Worker worker = new Worker();
        worker.input();
        if (worker.getId() == null) {
            return false;
        }

        list.add(worker);
        return true;
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
