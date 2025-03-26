package mocks;

import java.util.ArrayList;
import java.util.List;

import entity.Worker;

public class Data {
    public static List<Worker> listdata() {
        List<Worker> listdata = new ArrayList<Worker>();
        listdata.add(new Worker("Duy", 18, 300000));
        listdata.add(new Worker("Huy", 32, 3000));
        listdata.add(new Worker("Huong", 20, 4555));
        listdata.add(new Worker("Han", 19, 200));
        listdata.add(new Worker("Thao", 24, 4000));
        return listdata;
    }
}
