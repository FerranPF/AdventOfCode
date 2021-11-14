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
public class Day5 extends Day{

    @Override
    void main() {
        this.NaughtyOrNicePart1();
        this.NaughtyOrNicePart2();
    }
    
    public void NaughtyOrNicePart1(){
        System.out.println("Day 5 Part 1:");
        int goodWordCount = 0;
        
        try {
            File myObj = new File("src/resources/Day5_input");
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                
                if(ValidWord(data)){
                    goodWordCount++;
                }
            }
            
          } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
          }
        
        System.out.println("Good word counter: " + goodWordCount);
    }
    
    public void NaughtyOrNicePart2(){
        System.out.println("Day 5 Part 2:");
        int goodWordCount = 0;
        
        try {
            File myObj = new File("src/resources/Day5_input");
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                
                if(ValidWord2(data)){
                    goodWordCount++;
                }
            }
            
          } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
          }
        
        System.out.println("Good word counter: " + goodWordCount);
    }
    
    public static boolean ValidWord(String word){
        String vowels = "aeiou";
        String[] invalidStrings = {"ab", "cd", "pq", "xy"};
        int count = 0;
        boolean threeVowels = false;
        boolean doubleLetter = false;
        
        for (int i = 0; i < invalidStrings.length; i++) {
            if(word.contains(invalidStrings[i])){
                return false;
            }
        }
        
        for (int i = 0; i < word.length(); i++) {
            
            if(i < word.length()-1 && !doubleLetter){
                if(word.charAt(i) == word.charAt(i+1)){
                    doubleLetter = true;
                }
            }
            
            if(!threeVowels){
                String letter = String.valueOf(word.charAt(i));
                if(vowels.contains(letter)){
                    count++;
                }

                if(count == 3){
                    threeVowels = true;
                }
            }
            
            if(doubleLetter == true && threeVowels == true){
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean ValidWord2(String word){
        
        boolean pairOfTwo = false;
        boolean repeatLetter = false;
        
        for (int i = 0; i < word.length()-3; i++) {
            String pair = String.valueOf(word.charAt(i)) + String.valueOf(word.charAt(i+1));
            for (int j = i+2; j < word.length()-1; j++) {
                String pair2 = String.valueOf(word.charAt(j)) + String.valueOf(word.charAt(j+1));
                if(pair.equals(pair2)){
                    pairOfTwo = true;
                    break;
                }
            }
            if(pairOfTwo)
                break;
        }
        
        if(!pairOfTwo)
            return false;
        
        for (int i = 0; i < word.length()-2; i++) {
            if(word.charAt(i) == word.charAt(i+2)){
                repeatLetter = true;
                break;
            }
        }
        
        return repeatLetter;
    }
}
