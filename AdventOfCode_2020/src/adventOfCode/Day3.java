package adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day3 {
    public static void main(String[] args) throws IOException
    {
        Path fileName = Path.of("day3Input.txt");
         
        String input = Files.readString(fileName);

        String[] splitInput = input.split("\n");

        int pos = 0;
        int treeCount = 0;

        for(int i=1; i<splitInput.length; i++){
            pos += 3;

            if(pos >= (splitInput[0].length()-1)){
                pos -=(splitInput[0].length()-1);
            }

            if(splitInput[i].charAt(pos) == '#'){
                treeCount ++;
            }

            //System.out.println("El valor de i es " + (i+1) + " pos: " +pos + " tree: " + splitInput[i].charAt(pos));
        }

        System.out.println("I found " + treeCount + " trees.");
    }

    public static void Right2Down() throws IOException
    {
        
        Path fileName = Path.of("day3Input.txt");
         
        String input = Files.readString(fileName);

        String[] splitInput = input.split("\n");

        int pos = 0;
        int treeCount = 0;

        for(int i=2; i<splitInput.length; i+=2){
            pos += 1;

            if(pos >= (splitInput[0].length()-1)){
                pos -=(splitInput[0].length()-1);
            }

            if(splitInput[i].charAt(pos) == '#'){
                treeCount ++;
            }

            //System.out.println("El valor de i es " + (i+1) + " pos: " +pos + " tree: " + splitInput[i].charAt(pos));
        }

        System.out.println("I found " + treeCount + " trees.");
    }
}
