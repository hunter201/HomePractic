import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
        public static void main(String[] args) throws IOException {
        List<Actor> actorList = new ArrayList<>();
        List<String[]> namesList;
        //просим пользователя ввести  путь к исходному файлу
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите путь к исходному файлу: ");
        String str = sc.nextLine();
        //читаем данные из файла построчно и помещаем их в коллекцию
        Path pathInput = Paths.get(str);
        namesList = readDataFromFile(pathInput);
        //создаем коллекцию объектов класса Actor на основе данных полученных из файла
        for (String[] names : namesList) {
            Actor actor = new Actor(names[0], names[1]);
            actorList.add(actor);
        }
        //фильтруем коллекцию по условию (name > 4 && name < 7)
        filterActorClass(Paths.get(".\\src\\main\\resources\\results.txt"), actorList);
    }
    private static void filterActorClass(Path path, List<Actor> actorList) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        Stream<Actor> streamActor = actorList.stream();
        FileOutputStream fos = new FileOutputStream(String.valueOf(path), true);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        List<String> list = streamActor.map(Actor::getName)
                .filter(name -> (name.length() > 4 && name.length() < 7))
                .toList();
        bw.write("\nПо итогам фильтрации на " + dtf.format(LocalDateTime.now()) + " нашлось "
                + list.size() + " элементов." + "(" + list + ")");
        bw.close();
        fos.close();
    }
    private static List<String[]> readDataFromFile(Path path) throws IOException {
        List<String[]> namesList = new ArrayList<>();
        FileInputStream fis = new FileInputStream(String.valueOf(path));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.isEmpty()) {
                break;
            }
            namesList.add(line.trim().split(" "));
        }
        bufferedReader.close();
        fis.close();
        return namesList;
    }

}

