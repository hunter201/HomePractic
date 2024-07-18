import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

public class InsertionSortArray extends SortArray implements Runnable {
    private final List<Double> list;
    Semaphore sem = new Semaphore(1);
    CommonResource res = new CommonResource();

    public InsertionSortArray(ArrayList<Double> list, CommonResource res, Semaphore sem) {
        this.list = list;
        this.sem = sem;
        this.res = res;
    }

    public List<Double> sort() {
        long time = System.currentTimeMillis();

        for (int i = 0; i < list.size(); i++) {
            if ((i == 0) || (i == (list.size() - 1))) {
                continue;
            }
            if (list.get(i) > list.get(i + 1)) {
                Collections.swap(list, i, i + 1);
                for (int j = i; j > 0; j--) {
                    if (list.get(j) < list.get(j - 1)) {
                        Collections.swap(list, j, j - 1);
                    }
                }
            }
        }
        time = System.currentTimeMillis() - time;
        System.out.println("Время выполнения сортировки выбором составило: " + time + " миллисекунд");
        System.out.println(list);
        return list;
    }

    @Override
    public void run() {
        //this.sort();
        try {
            sem.acquire();
            res.x = 1;
            for (int i = 0; i <= 10; i++) {
                res.x++;
                System.out.println("Insertion sort: " + res.x);
                Thread.sleep(200);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sem.release();
        System.out.println("Insertion ended/ Variable x = " + res.x);
    }
}
