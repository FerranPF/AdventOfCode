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
public class Day3 extends Day{
    
    @Override
    void main() {
        this.PresentHouse();
        this.PresentHouseRobot();
    }
    
    public void PresentHouse(){
        System.out.println("Day 3 Part 1:");
        int houseCount = 1;
        final int offset = 1000;
        
        int[][] positions = new int[2000][2000];
        
        int actualPosX = 0;
        int actualPosY = 0;
        
        positions[actualPosX+offset][actualPosY+offset] = 1; 
        
        try {
            File myObj = new File("src/resources/Day3_houseMoves");
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                for (int i = 0; i < data.length(); i++) {
                    switch(data.charAt(i)){
                        case 'v':
                            actualPosY--;
                            break;
                        case '>':
                            actualPosX++;
                            break;
                        case '<':
                            actualPosX--;
                            break;
                        case '^':
                            actualPosY++;
                            break;
                    }
                    
                    //Check house position
                    if(positions[actualPosX+offset][actualPosY+offset] != 1){
                        positions[actualPosX+offset][actualPosY+offset] = 1;
                        houseCount++;
                    }
                    
                }
            }
            
            System.out.println("Houses visited: " + houseCount);
            myReader.close();
            
          } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
          }
    }
    
    public void PresentHouseRobot(){
        System.out.println("Day 3 Part 2:");
        int houseCount = 1;
        final int offset = 1000;
        
        int[][] positions = new int[2000][2000];
        
        int santaPosX = 0;
        int santaPosY = 0;
        int robotPosX = 0;
        int robotPosY = 0;
        
        positions[santaPosX+offset][santaPosY+offset] = 1;
        positions[robotPosX+offset][robotPosY+offset] = 1;
        
        try {
            File myObj = new File("src/resources/Day3_houseMoves");
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                for (int i = 0; i < data.length(); i++) {
                    if(i%2==0){
                        switch(data.charAt(i)){
                            case 'v':
                                santaPosY--;
                                break;
                            case '>':
                                santaPosX++;
                                break;
                            case '<':
                                santaPosX--;
                                break;
                            case '^':
                                santaPosY++;
                                break;
                        }
                    }else{
                        switch(data.charAt(i)){
                            case 'v':
                                robotPosY--;
                                break;
                            case '>':
                                robotPosX++;
                                break;
                            case '<':
                                robotPosX--;
                                break;
                            case '^':
                                robotPosY++;
                                break;
                        }
                    }
                    
                    //Check house position
                    if(positions[santaPosX+offset][santaPosY+offset] != 1){
                        positions[santaPosX+offset][santaPosY+offset] = 1;
                        houseCount++;
                    }
                    
                    if(positions[robotPosX+offset][robotPosY+offset] != 1){
                        positions[robotPosX+offset][robotPosY+offset] = 1;
                        houseCount++;
                    }
                    
                }
            }
            
            System.out.println("Houses visited: " + houseCount);
            myReader.close();
            
          } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
          }
    }
}
