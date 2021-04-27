package adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
 
public class Day2 
{
    public static void main(String[] args) throws IOException 
    {
        Path fileName = Path.of("day2Input.txt");
         
        String input = Files.readString(fileName);

        String[] splitInput = input.split("\n");

        int[] minCount = new int[input.length()];
        int[] maxCount = new int[input.length()];
        String[] stringInput = new String[input.length()];
        char[] charCompare = new char[input.length()];

        int badInput = 0;

        for(int i = 0; i < splitInput.length; i++){
            String[] auxString = splitInput[i].split(" ");
            String[] minMax = auxString[0].split("-");

            minCount[i] = Integer.parseInt(minMax[0]);
            maxCount[i] = Integer.parseInt(minMax[1]);
            
            String charToCompare = auxString[1].replace(":", "");
            charCompare[i] = charToCompare.charAt(0);

            stringInput[i] = auxString[2];

            int count = 0;
            for(int j = 0; j < stringInput[i].length(); j++){
                if(stringInput[i].charAt(j) == charCompare[i]){
                    count++;
                }
            }

            if(count < minCount[i]){
                badInput++;
            }else if(count > maxCount[i]){
                badInput++;
            }
        }

        System.out.println("Se han encontrado " + badInput + " datos erroneos.");
    }
}