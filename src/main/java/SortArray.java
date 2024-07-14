import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortArray {

    private final List<Double> list;

    public SortArray(ArrayList<Double> list) {
        this.list = list;
    }

    public List<Double> selectionSort() {
        List<Double> list_final = new ArrayList<>();

        int size = list.size();

        long time = System.currentTimeMillis();

        for (int x = 0; x < size; x++) {

            double min = Collections.min(list);

            list_final.add(min);

            list.remove(min);

        }
        time = System.currentTimeMillis() - time;

        System.out.println("Время выполнения сортировки выбором составило: " + time + " миллисекунд");

        System.out.println(list_final);

        return list_final;
    }

    public List<Double> bubbleSort() {
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

    public List<Double> insertionSort() {
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
}
