import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectionSortArray extends SortArray implements Runnable {

    private final List<Double> list;

    public SelectionSortArray(ArrayList<Double> list) {
        this.list = list;
    }

    public List<Double> sort() {
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

    public List<Double> quickSort() {

        long time = System.currentTimeMillis();

        List<Double> new_list = new ArrayList<>(list.size());

        int delimeter = list.size() / 2;

        double delimeterValue = list.get(delimeter);

        System.out.println("Delimeter is " + delimeter + " Value is: " + delimeterValue);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > delimeterValue) {
                Collections.swap(list, i, delimeter);
            }
        }

        System.out.println(new_list);
        return null;
    }

    @Override
    public void run() {
        this.sort();
    }
}
