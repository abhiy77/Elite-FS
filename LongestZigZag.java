package Elite;
/* 07/01/2020
* The longest Zig-Zag subsequence problem is to find length of 
* the longest subsequence of given sequence such that all elements of 
* this are alternating. 
* 
* If a sequence {x1, x2, .. xn} is alternating sequence then its element satisfy 
* one of the following relation :
x1 < x2 > x3 < x4 > x5 < …. xn or 
x1 > x2 < x3 > x4 < x5 > …. xn 

Sample Input:
8
10 22 9 33 49 50 31 60

Sample Output: 
6

Explanation:
The subsequences {10, 22, 9, 33, 31, 60} or
{10, 22, 9, 49, 31, 60} or {10, 22, 9, 50, 31, 60}
are longest Zig-Zag of length 6.


*/

import java.io.*;
import java.util.Scanner; 

class LongestZigZag { 

//Function to return longest  Zig-Zag subsequence length 
static int longestZigZagSubseqLen(int arr[], int n) 
{ 
  int count = 1;
  boolean greater = true;
  if(arr[0] > arr[1]) greater = true;
  else greater = false;
  
  for(int i=1;i<n-1;i++) {
	  if(greater == true) {
		  if(arr[i] < arr[i+1]) {
			  greater = false;
			  count++;
		  }
	  }
	  else {
		  if(arr[i] > arr[i+1]) {
			  greater = true;
			  count++;
		  }
	  }
  }
  return count+1;
} 

public static void main(String[] args) 
{ 
	Scanner sc = new Scanner(System.in);
	int noOfElements = sc.nextInt();
	int[] arr  = new int[noOfElements];
	for(int i=0;i<noOfElements;i++)
		arr[i]=sc.nextInt();
	
	System.out.println(longestZigZagSubseqLen(arr, noOfElements)); 
} 
} 
