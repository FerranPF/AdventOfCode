package adventofcode_2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Ferran
 */
public class Day2 implements Day{
    
    public void main(){
        this.CalculateDepthIncrease();
        this.CalculateDepthAimIncrease();
    }
    
    public void CalculateDepthIncrease(){
        System.out.println("Day 2 Part 1:");
        int depthIncrease = 0;
        int horizontalIncrease = 0;
        
        try {
            File myObj = new File("src/resources/Day2");
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
                String values[] = myReader.nextLine().split(" ");
                int increaseValue = Integer.parseInt(values[1]);
                
                switch(values[0]){
                    case "up":
                        depthIncrease -= increaseValue;
                        break;
                    case "down":
                        depthIncrease += increaseValue;
                        break;
                    case "forward":
                        horizontalIncrease += increaseValue;
                        break;
                    default:
                        break;
                }
            }
            
            System.out.println("Depth counter: " + depthIncrease*horizontalIncrease);
            myReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    
    public void CalculateDepthAimIncrease(){
        System.out.println("Day 2 Part 2:");
        int depthIncrease = 0;
        int horizontalIncrease = 0;
        int aim = 0;
        
        try {
            File myObj = new File("src/resources/Day2");
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
                String values[] = myReader.nextLine().split(" ");
                int increaseValue = Integer.parseInt(values[1]);
                
                switch(values[0]){
                    case "up":
                        aim -= increaseValue;
                        break;
                    case "down":
                        aim += increaseValue;
                        break;
                    case "forward":
                        depthIncrease += (increaseValue*aim);
                        horizontalIncrease += increaseValue;
                        break;
                    default:
                        break;
                }
            }
            
            System.out.println("Depth counter: " + depthIncrease*horizontalIncrease);
            myReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
