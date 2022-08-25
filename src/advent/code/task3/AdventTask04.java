package advent.code.task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class AdventTask04 {

    Path path = Paths.get("D:\\IdeaProjects\\Codevent1\\src\\advent\\code\\task03.txt");
    Stream<String> streamOfString;
    List<AT03Parameter> listOfMovement = new ArrayList<>();


    public AdventTask04(){

        try {
            streamOfString = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createListOfMovements(){
        Iterator<String> it = streamOfString.iterator();
        String [] pom;
        while(it.hasNext()){
            pom = it.next().split(" ");
            listOfMovement.add(new AT03Parameter(pom[0], Integer.parseInt(pom[1])));
        }
    }

    public void sumOfMovement(){
        int horizontalPosition = 0;
        int depth = 0;
        int aim = 0;
        for (int i = 0; i < listOfMovement.size(); i++) {
            switch (listOfMovement.get(i).movement){
                case "forward":
                    horizontalPosition += listOfMovement.get(i).distant;
                    depth += aim * listOfMovement.get(i).distant;
                    break;
                case "down":
                    aim += listOfMovement.get(i).distant;
                    break;
                case "up":
                    aim -= listOfMovement.get(i).distant;
                    break;
                default:
                    break;
            }
        }

        System.out.println("Forward: " + horizontalPosition);
        System.out.println("Height: " + depth);
        System.out.println("Multiply: " + horizontalPosition*depth);
    }
}
