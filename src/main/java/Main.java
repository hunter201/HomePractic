import java.io.*;
import java.util.*;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        ArrayList<Double> row = new ArrayList<>();
        Semaphore sem = new Semaphore(1);
        CommonResource res = new CommonResource();

//        for (int i = 0; i < 10; i++) {
//            row.add(Math.round(new Random().nextDouble(100) * 100) / 100.0);
//
//        }
//
//        SortArray sort = new SortArray(row);
//
//        System.out.println(row);
//        new Thread(new BubbleSortArray(row, res, sem)).start();
//
//        new Thread(new InsertionSortArray(row, res, sem)).start();

        Singleton singleton = Singleton.getInstance("Hello World");

        singleton.printValue();

    }

}

