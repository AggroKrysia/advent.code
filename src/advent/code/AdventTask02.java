package advent.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AdventTask02 {

    private final IntStream streamOfInt;
    Path path = Paths.get("D:\\IdeaProjects\\Codevent1\\src\\advent\\code\\measurement.txt");
    Stream<String> streamOfString;


    AdventTask02() {
        try {
            streamOfString = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            streamOfInt = streamOfString.mapToInt(Integer::parseInt);
            //(i -> Integer.parseInt(i))
        }

    }

    public void compare01() {
        Iterator<Integer> it = streamOfInt.iterator();
        int counter = 0;
        Integer A = it.next();
        Integer B = it.next();
        Integer C = it.next();
        int sumprev = 0;
        while (it.hasNext()) {
            sumprev = A + B + C;
            A = B;
            B = C;
            C = it.next();
            if (sumprev < A + B + C) {
                counter++;
            }

        }
        System.out.println(counter);
    }

}
