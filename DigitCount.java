/*
 * 03/01/2020
 * 
 * Given an integer 'd' between 0 and 9 , and two positive integers low and high as lower and upper 
bounds, respectively. Return the number of times that 'd' occur as a digit in all integers 
between low and high , including the bounds low and high .

I/O Format:
Input Format:   an integer, indicates value of 'd'
                an integer, indicates value of 'lower bound'
                an integer, indicates value of 'higher bound'
Output Format:  an integer, indicates number of times that 'd' occur as a digit 
                in all integers between low and high
Example 1:
    Input:  1
            1
            13
    Output: 6

Explanation:
The digit d=1 occurs 6 times in 1,10,11,12,13. Note that the digit d=1 occurs twice in the number 11.

Example 2:
    Input:  3   
            100
            250
    Output: 35

Explanation:
The digit d=3 occurs 35 times in 103,113,123,130,131,...,238,239,243.

Note:
    0 <= N <= 9
    1 <= low <= high <= 2×10^8
 */
package Elite;
import java.util.*;
public class DigitCount {

	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		int digit = sc.nextInt();
		String low = Integer.toString(sc.nextInt());
		String high = Integer.toString(sc.nextInt());
        int count = 0,n = 1;
        String x = "";
        for(int i=1;i<=high.length();i++) {

            int temp = (Integer.parseInt(high) - Integer.parseInt(low)) / (int)(Math.pow(10, i));
            if(low.length() >= i && Integer.parseInt(Character.toString(low.charAt(low.length()-i))) == digit) {temp++;}
            if(Integer.parseInt(Character.toString(high.charAt(high.length()-i))) == digit) {temp++;}

            count += (temp * (int) Math.pow(10, i-1));
            System.out.println("Count" + count);

            if(high.length() == i && high.length() >1 && Integer.parseInt(Character.toString(high.charAt(0))) == digit) {
            	count-= ((int)Math.pow(10, i-1) - Integer.parseInt(high.substring(1))-1 );
            }
            if(low.length() == i && low.length() > 1 && Integer.parseInt(Character.toString(low.charAt(0))) == digit) {
            	count-=Integer.parseInt(low.substring(1));
            }
            if(low.length() == high.length() && low.length() == i) {count-= (Integer.parseInt(low.substring(1)) -((int)Math.pow(10, i-1) - Integer.parseInt(high.substring(1))-1 ));}
            System.out.println(count + "  " + temp);
        }
       System.out.println(count);
	}
}
//if(i > low.length()) {
//x += digit;
//for(int j=1;j<i;j++) {
//	x +="0";
//}
//}
//else {
//x = low;
//// x = low.substring(0,high.length()-1-n);
//// for(int j=0;j<n;j++) {
//// 	x+=digit;
//// }
//}


/*
import java.util.*;
public class DigitCount {

	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		int digit = sc.nextInt();
		String low = Integer.toString(sc.nextInt());
		String high = Integer.toString(sc.nextInt());
        int count = 0,n = 1;
        String x = "";
        for(int i=1;i<=high.length();i++) {
            int temp = (Integer.parseInt(high) - Integer.parseInt(low)) / (int)(Math.pow(10, i));
            if(low.length() >= i && Integer.parseInt(Character.toString(low.charAt(low.length()-i))) == digit) {temp++;}
            if(Integer.parseInt(Character.toString(high.charAt(high.length()-i))) == digit) {temp++;}

            count += (temp * (int) Math.pow(10, i-1));
            if(high.length() == i && high.length() >1 && Integer.parseInt(Character.toString(high.charAt(0))) == digit) {count-= (int)Math.pow(10, i-1) - Integer.parseInt(high.substring(1)) - 1;}
        }
       System.out.println(count);
	}
}*/