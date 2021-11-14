/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode_2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @author Ferran
 */
public class Day2 {
    public void CalculateWrapPaper(){
        System.out.println("Day 2 Part 1:");
        int wrapCount = 0;
        
        try {
            File myObj = new File("src/resources/Day2Part1_dimension.txt");
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String dimensions[] = data.split("x");

                int l = Integer.parseInt(dimensions[0]);
                int w = Integer.parseInt(dimensions[1]);
                int h = Integer.parseInt(dimensions[2]);

                int sideOne = w * l;
                int sideTwo = l * h;
                int sideThree = w * h;

                int smallestSide = 0;

                if(sideOne <= sideTwo && sideOne <= sideThree){
                    smallestSide = sideOne;
                }else if(sideTwo <= sideOne && sideTwo <= sideThree){
                    smallestSide = sideTwo;
                }else if(sideThree <= sideTwo && sideThree <= sideOne){
                    smallestSide = sideThree;
                }

                wrapCount += ((sideOne*2) + (sideTwo*2) + (sideThree*2)) + smallestSide;
            }
            
            System.out.println("Needed wrap: " + wrapCount);
            myReader.close();
            
          } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
          }
    }
    
    public void RibbonLength(){
        System.out.println("Day 2 Part 2:");
        int ribbonCount = 0;
        
        try {
            File myObj = new File("src/resources/Day2Part1_dimension.txt");
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String dimensions[] = data.split("x");

                int l = Integer.parseInt(dimensions[0]);
                int w = Integer.parseInt(dimensions[1]);
                int h = Integer.parseInt(dimensions[2]);

                int a = Math.min(l, w);
                int min1 = Math.min(a, h);
                int min2 = 0;
                
                if(min1 == l)
                    min2 = Math.min(w, h);
                else if(min1 == w)
                    min2 = Math.min(l, h);
                else
                    min2 = Math.min(l, w);
                
                ribbonCount += (min1+min1+min2+min2) + (l*w*h);
            }
            
            System.out.println("Needed ribbon: " + ribbonCount);
            myReader.close();
            
          } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
          }
    }
}
