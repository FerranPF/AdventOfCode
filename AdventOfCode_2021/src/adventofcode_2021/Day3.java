package adventofcode_2021;

import java.util.ArrayList;

/**
 *
 * @author Ferran
 */
public class Day3 implements Day{

    
    public void main() {
        this.PowerConsumition();
        this.LifeSupportRating();
    }
    
    public void PowerConsumition(){
        ArrayList<String> inputs = new ArrayList<String>();
        inputs = Utils.GetInput("Day3");
        
        int[] gammaCount = new int[inputs.get(0).length()];
        int[] epsilonCount = new int[inputs.get(0).length()];
        
        for (int i = 0; i < inputs.size(); i++) {
            
            String input = inputs.get(i);
            
            for (int j = 0; j < input.length(); j++) {
                gammaCount[j] += Integer.parseInt(String.valueOf(input.charAt(j)));
                epsilonCount[j] -= Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }
        
        int gammaValue = 0;
        int epsilonValue = 0;
        
        String gamma = "";
        String epsilon = "";
        
        for (int i = 0; i < gammaCount.length; i++) {
            if(gammaCount[i] > (inputs.size()/2)){
                gamma += "1";
                epsilon += "0";
            }else{
                gamma += "0";
                epsilon += "1";
            }
        }
        
        gammaValue = Integer.parseInt(gamma, 2);
        epsilonValue = Integer.parseInt(epsilon, 2);
        
        System.out.println("Day 3 Part 1: ");
        System.out.println("Power consumition: " + gammaValue*epsilonValue);
    }
    
    
    public void LifeSupportRating(){
        ArrayList<String> inputs = new ArrayList<String>();
        inputs = Utils.GetInput("Day3");
        
        System.out.println("Day 3 Part 2: ");
    }
}
