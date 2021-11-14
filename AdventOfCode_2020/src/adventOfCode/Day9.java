package adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day9 {
    public static void main(String[] args) throws IOException
    {
        Path fileName = Path.of("day9Input.txt");
        
        String input = Files.readString(fileName);

        String[] splitInput = input.split("\n");

        int[] numbers = new int[splitInput.length];

        for (int i = 0; i < splitInput.length; i++) {
            numbers[i] = Integer.parseInt(splitInput[i]);
            System.out.println(numbers[i]);
        }
    }
    
}
