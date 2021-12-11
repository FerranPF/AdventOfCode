package adventofcode_2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ferran
 */
public class Day1 implements Day{

    public void main() {
        this.CalculateDepthIncrease();
        this.CalculateDepthWindowIncrease();
    }
    
    public void CalculateDepthIncrease(){
        System.out.println("Day 1 Part 1:");
        int depthIncrease = 0;
        
        try {
            File myObj = new File("src/resources/Day1_01");
            Scanner myReader = new Scanner(myObj);
            String lastDepth = myReader.nextLine();
            
            while (myReader.hasNextLine()) {
                String actualDepth = myReader.nextLine();

                //System.out.println("Last: " + lastDepth + " Actual: " + actualDepth);
                int depth = Integer.parseInt(lastDepth);
                int newDepth = Integer.parseInt(actualDepth);
                
                if(newDepth > depth)
                    depthIncrease++;
                
                lastDepth = actualDepth;
            }
            
            System.out.println("Depth counter: " + depthIncrease);
            myReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public void CalculateDepthWindowIncrease(){
        System.out.println("Day 1 Part 2:");
        int depthIncrease = 1;
        
        ArrayList<Integer> depthValues = new ArrayList<Integer>();
        
        try {
            File myObj = new File("src/resources/Day1_01");
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
                String value = myReader.nextLine();
                int intValue = Integer.parseInt(value);
                depthValues.add(intValue);
            }
            
            int lastValue = depthValues.get(0) + depthValues.get(1) + depthValues.get(2);
            
            for (int i = 3; i < depthValues.size()-2; i++) {
                
                int first = depthValues.get(i);
                int second = depthValues.get(i+1);
                int third = depthValues.get(i+2);
                
                int actualValue = first + second + third;
                
                if(lastValue < actualValue)
                    depthIncrease++;
                
                lastValue = actualValue;
            }
            
            System.out.println("Depth counter: " + depthIncrease);
            myReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
