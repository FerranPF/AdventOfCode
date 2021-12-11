/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode_2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ferran
 */
public class Utils {
    public static ArrayList<String> GetInput(String fileName){
        ArrayList<String> inputs = new ArrayList<String>();
        
        try {
            File myObj = new File("src/resources/" + fileName);
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
                inputs.add(myReader.nextLine());
            }
            myReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        return inputs;
    }
}
