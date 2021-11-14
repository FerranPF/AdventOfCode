/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode_2015;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;
/**
 *
 * @author Ferran
 */
public class Day4 extends Day{
    
    int zeroLength = 0;
    
    @Override
    void main() {
        System.out.println("Day 4 Part 1:");
        this.zeroLength = 5;
        this.LowestPositiveMD5();
        
        System.out.println("Day 4 Part 2:");
        this.zeroLength = 6;
        this.LowestPositiveMD5();
    }
    
    public void LowestPositiveMD5(){
        String password = "yzbqklnj";
        int numbers = 1;
        String myHash = "";
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            boolean founded = false;
            
            do{
                String newPassword = password + String.valueOf(numbers);
                
                md.update(newPassword.getBytes());
                byte[] digest = md.digest();
                myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
                
                int counter = 0;
                
                for(int i = 0; i < zeroLength; i++){
                    
                    if(myHash.charAt(i) == '0')
                        counter++;
                    
                    if(counter == zeroLength){
                        founded = true;
                    }
                }
                
                if(!founded){
                    numbers ++;
                }
                
            }while(!founded);
            
            System.out.println("Hash code: " +myHash);
            System.out.println("Minimum number: " + numbers);
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Day4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
