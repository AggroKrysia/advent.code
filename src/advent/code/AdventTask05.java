package advent.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

public class AdventTask05 {
    Path path = Paths.get("D:\\IdeaProjects\\Codevent1\\src\\advent\\code\\task05.txt");
    Stream<String> streamOfString;
    int[] ones = new int[12];
    int[] zeros = new int[12];
    String gammaString = "";
    String elypsonString = "";
    int gamma;
    int elypson;


    public AdventTask05(){
        try {
            streamOfString = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createListsOfMostLessBits(){
        Iterator<String> it = streamOfString.iterator();
        String pom;
        char[] pom2;
        while(it.hasNext()){
            pom = it.next();
            pom2 = pom.toCharArray();
            for (int i = 0; i < pom.length(); i++) {
                if(pom2[i] == '1'){
                    ones[i] += 1;
                }
                else{
                    zeros[i] += 1;
                }

            }
        }
    }

    void createGammaAndElypsonBinary(){
        for (int i = 0; i < zeros.length; i++) {
            if(zeros[i] > ones[i]){
                gammaString += '0';
                elypsonString += '1';
            }
            else {
                gammaString += '1';
                elypsonString += '0';
            }
        }
    }

    public void calculateGammaAndElypson(){
        gamma = calculateFromBinary(gammaString);
        elypson = calculateFromBinary(elypsonString);
    }

    private int calculateFromBinary(String binary){
        int pom = 0;
        int powerOfTwo = 0;
        for (int i = binary.length(); i > 0; i--) {
            pom += Integer.parseInt(String.valueOf(binary.charAt(i - 1))) * Math.pow(2,powerOfTwo);
            powerOfTwo++;
        }
        return pom;
    }

    public void calculatePowerConsumption(){
        int power = gamma * elypson;
        System.out.println(power);
    }
}
