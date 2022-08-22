package advent.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AdventTask01 {

    private final IntStream streamOfInt;
    Path path = Paths.get("D:\\IdeaProjects\\Codevent1\\src\\advent\\code\\measurement.txt");
    Stream<String> streamOfString;


    AdventTask01() {
        try {
            streamOfString = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            streamOfInt = streamOfString.mapToInt(Integer::parseInt);
            //(i -> Integer.parseInt(i))
        }
        
    }


    public void printFirst() {
        System.out.println(streamOfInt.iterator().next().toString());
    }

    public void printAll() {
        streamOfInt.forEach(System.out::println);
        //(s -> System.out.println(s))
    }

    public void compare01() {
        Iterator<Integer> it = streamOfInt.iterator();
        int counter = 0;
        Integer current = it.next();
        Integer prev = 0;
        while (it.hasNext()) {
            prev = current;
            current = it.next();
            if (prev < current) {
                counter++;
            }

        }
        System.out.println(counter);
    }

    public void compare02() {
        int[] array = streamOfInt.toArray();
        int current = array[0];
        int counter = 0;
        for (int i = 1; i < array.length; i++) {
            if (current < array[i]) {
                counter++;
            }
            current = array[i];
        }
        System.out.println(counter);
    }
}
