import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

public class BubbleSortArray extends SortArray implements Runnable {
    private final List<Double> list;
    Semaphore sem = new Semaphore(1);
    CommonResource res = new CommonResource();

    public BubbleSortArray(ArrayList<Double> list, CommonResource res, Semaphore sem) {
        this.list = list;
        this.res = res;
        this.sem = sem;
    }

    public List<Double> sort() {
        long time = System.currentTimeMillis();

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (j < list.size() - 1) {
                    if (list.get(j) > list.get(j + 1)) {
                        Collections.swap(list, j, j + 1);
                    }
                }
            }
        }
        time = System.currentTimeMillis() - time;

        System.out.println("Время выполнения пузырьковой сортировки составило: " + time + " миллисекунд");

        System.out.println(list);

        return (ArrayList<Double>) list;

    }

    @Override
    public void run() {
//        this.sort();
        System.out.println("Bubble Sort");
        try {
            sem.acquire();
            res.x = 1;
            for (int i = 0; i <= 10; i++) {
                res.x++;
                System.out.println("Bubble Sort: " + res.x);
                Thread.sleep(200);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sem.release();
        System.out.println("Bubble ended. Variable x = " + res.x);
    }
}
