package adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Day4 {
    public static void main(String[] args) throws IOException
    {
        Path fileName = Path.of("day4Input.txt");
        
        String input = Files.readString(fileName);

        String[] splitInput = input.split("\\n");

        int badPasswords = 0;

        for(int i = 0; i < splitInput.length; i++){
            boolean byr = false;
            boolean iyr = false;
            boolean eyr = false;
            boolean hgt = false;
            boolean hcl = false;
            boolean ecl = false;
            boolean pid = false;

            String[] auxSplit = splitInput[i].split(" ");
            
            for(int j = 0; j < auxSplit.length; j++){

                if(auxSplit[j].compareToIgnoreCase("byr")>0){
                    byr = true;
                }else if(auxSplit[j].compareToIgnoreCase("iyr")>0){
                    iyr = true;
                }else if(auxSplit[j].compareToIgnoreCase("eyr")>0){
                    eyr = true;
                }else if(auxSplit[j].compareToIgnoreCase("hgt")>0){
                    hgt = true;
                }else if(auxSplit[j].compareToIgnoreCase("hcl")>0){
                    hcl = true;
                }else if(auxSplit[j].compareToIgnoreCase("ecl")>0){
                    ecl = true;
                }else if(auxSplit[j].compareToIgnoreCase("pid")>0){
                    pid = true;
                }

                //System.out.println(auxSplit[j]);
            }

            if(!byr){
                badPasswords++;
            }else if(!iyr){
                badPasswords++;
            }else if(!eyr){
                badPasswords++;
            }else if(!hgt){
                badPasswords++;
            }else if(!hcl){
                badPasswords++;
            }else if(!ecl){
                badPasswords++;
            }else if(!pid){
                badPasswords++;
            }
        }

        System.out.println(badPasswords);
    }
}
