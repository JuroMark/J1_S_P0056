package mocks;

import java.util.ArrayList;
import java.util.List;

import entity.Worker;

public class Data {
    public static List<Worker> listdata() {
        List<Worker> listdata = new ArrayList<Worker>();
        listdata.add(new Worker("1", "Manh", 18, 300000));
        listdata.add(new Worker("2", "Mang", 32, 3000));
        listdata.add(new Worker("3", "Hien", 52, 4555));
        listdata.add(new Worker("4", "Thao", 19, 200));
        listdata.add(new Worker("5", "linh", 12, 4000));
        return listdata;
    }
}
