
package exercise06_31;
import java.util.Scanner;
public class Exercise06_31 {

    public static void main(String[] args) {
        // Prompt the user to enter a number as a long integer
        System.out.println("Enter a credit card number as a long integer: ");
        //Create a scanner object
        Scanner input = new Scanner(System.in);
        
        long number = input.nextLong();
        //Check if the total sum divisible by 10 
        if (isValid(number) == true) {
            System.out.println(number + " is valid");
        }
        else {
            System.out.println(number + " is not valid");
        }
    
    }
       /* Check if the credit card number is less then 16 digits and more than 13; 
       that is starts from 4, 5, 37 or 6; that the sum of odd placed digits
     and even placed digits is divisible by 10 */
    public static boolean isValid(long number) {           
        int totalSum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
           
        if ((totalSum % 10 == 0) && (prefixMatched(number, 1) == true) &&
                (getSize(number) >= 13) && (getSize(number) <= 16) ) {            
            return true;            
        }
        else {            
            return false;            
        }             
       }    
       
    //Sum of the digits in the even places from right to left 
    public static int sumOfDoubleEvenPlace (long number) {
        
        int sum1 = 0;
        number = number / 10;
        
        while (number > 0){   
            int digit = (int)(number % 10) * 2;
            
                if (digit > 9){   //Add up the digits, if the sum is a two-digit number 
                    digit = (digit % 10 + digit / 10);
                }
                    sum1 += digit;
                    number = number / 100;            
            }    
        return sum1;  //System.out.println(sum1) - to check the sum1;
    }
       
   //Sum of the digits in the odd places from right to left        
    public static int sumOfOddPlace (long number) {
        int sum2 = 0;           
        
        while (number > 0) {            
            int digit = (int)(number % 10);
            sum2 += digit; 
            number = number / 100;                            
            }
        return sum2;  //System.out.println(sum2) - to check the sum2;
    }   
   //Check if the credit card number starts with 4, 5, 37 or 6
    public static boolean prefixMatched(long number, int d) {
       
        return (getPrefix(number, d) == 4) || 
                (getPrefix(number, d) == 5) ||
                (getPrefix(number, d) == 6) ||
                (getPrefix(number, d) == 37);
   }
   //Check the size of the credit card number
    public static int getSize(long d) {
       int count = 0;
       while (d > 0) {
           d /= 10;
           count++;
       }
       return count;
   }
    //Check the first k digits from the credit card number for the prefixMatched method
    public static long getPrefix(long number, int k) {
    
        if (getSize(number) < k) {
           return number;      
        }
        else {
            int size = (int)getSize(number);
             for (int i = 0; i < (size - k); i++) {
             number = number / 10;
   }
        return number;
      }
   }
}