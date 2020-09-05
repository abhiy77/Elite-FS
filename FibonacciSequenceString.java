/* 05/09/2020 - (ELITE DAY - 116)
 * 
 * Pramod is working on Strings consist of digits only. 
He wants to findout, whether the given string can form Fibonacci sequence or not.

A String can form a Fibonacci Sequence, if it contains at least three numbers,
and numbers are in the following order:
first, second, third  = first + second, fourth = third + second, .. so on.

Return true, if the given string can form fibonacci sequence,
otherwise, return false.

Note: Numbers in the fibonacci sequence contains no leading 0's.
for example, 2, 03,5 or 2,3,05 or 02,3,5 are not valid.

Input Format:
-------------
A String consist of digits only

Output Format:
--------------
Print a boolean value as result.


Sample Input-1:
---------------
23581321

Sample Output-1:
----------------
true

Explanation: 
------------
Fibonacci Sequence is : 2, 3, 5, 8, 13, 21
2, 3, 2+3=5, 3+5=8, 5+8=13, 8+13=21.

Sample Input-2:
---------------
199100199

Sample Output-2:
----------------
true

Explanation: 
------------
Fibonacci Sequence is : 1 99 100 199
1, 99, 1+99=100, 99+100=199.


Sample Input-3:
---------------
56011017

Sample Output-3:
----------------
false

Explanation: 
------------
Sequence is : 5 6 011 017
There should not be leading zeros.
So return false.

******* FibonacciString *******
case =1
input =8914423337761098715972584
output =true

case =2
input =199100199
output =true

case =3
input =101102203305508813
output =true

case =4
input =1011022033055
output =false

case =5
input =123456789
output =false

case =6
input =11111122233355588
output =true

case =7
input =1111122233355588
output =false

case =8
input =89144233377610987159725844171
output =false

case =9
input =1012003015018021303210534085513
output =true

case =10
input =101200301501802130302105034085513
output =false


 */
package Elite;
import java.math.BigInteger;
import java.util.*;

public class FibonacciSequenceString {

	public static boolean isFibonacciString(String str,String num1,String num2,int count) {
		if(str.isEmpty() && count >= 3) {
			return true;
		}
		if(num1.isEmpty()) {
			for(int i=1;i<=str.length();i++) {
				num1 = str.substring(0,i);
				if(isFibonacciString(str.substring(i),num1,num2,count+1))return true;
			}
		}
		else if(num2.isEmpty()) {
			for(int i=1;i<=str.length();i++) {
				num2 = str.substring(0,i);
				if(isFibonacciString(str.substring(i),num1,num2,count+1))return true;
			}
		}
		else {
			BigInteger firstNum = new BigInteger(num1);
			BigInteger secondNum = new BigInteger(num2);
			BigInteger thirdNum = firstNum.add(secondNum);
			String num3 = thirdNum.toString();
			//System.out.println(num1 + " " + num2 + " " + num3);
			int len = num3.length();
			if(str.length() < len)return false;
			else if(str.substring(0,len).equals(num3)) {
				if(isFibonacciString(str.substring(len), num2,num3,count+1)) return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(isFibonacciString(str,"","",0));
	}
}