package advent.code.task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class AdventTask03 {

    Path path = Paths.get("D:\\IdeaProjects\\Codevent1\\src\\advent\\code\\task03.txt");
    Stream<String> streamOfString;
    List<AT03Parameter> listOfMovement = new ArrayList<>();


    public AdventTask03(){

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
        int forward = 0;
        int height = 0;
        for (int i = 0; i < listOfMovement.size(); i++) {
            switch (listOfMovement.get(i).movement){
                case "forward":
                    forward += listOfMovement.get(i).distant;
                    break;
                case "down":
                    height -= listOfMovement.get(i).distant;
                    break;
                case "up":
                    height += listOfMovement.get(i).distant;
                    break;
                default:
                    break;
            }
        }

        System.out.println("Forward: " + forward);
        System.out.println("Height: " + height);
        System.out.println("Multiply: " + forward*height);
    }

}
