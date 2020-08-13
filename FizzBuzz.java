/* 04/02/2020
Write a program that outputs the string representation of numbers from 1 to n, however:

If the number is divisible by 3, output "fizz".
If the number is divisible by 5, output "buzz".
If the number is divisible by both 3 and 5, output "fizzbuzz".
For example, for n = 15, we output: 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz.

Suppose you are given the following code:

class FizzBuzz {
  public FizzBuzz(int n) { ... }               // constructor
  public void fizz(printFizz) { ... }          // only output "fizz"
  public void buzz(printBuzz) { ... }          // only output "buzz"
  public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
  public void number(printNumber) { ... }      // only output the numbers
}
Implement a multithreaded version of FizzBuzz with four threads. The same instance of FizzBuzz will be passed to four different threads:

Thread A will call fizz() to check for divisibility of 3 and outputs fizz.
Thread B will call buzz() to check for divisibility of 5 and outputs buzz.
Thread C will call fizzbuzz() to check for divisibility of 3 and 5 and outputs fizzbuzz.
Thread D will call number() which should only output the numbers.

Sample :
Input:  15
Output: 1
        2
        fizz
        4
        buzz
        fizz
        7
        8
        fizz
        buzz
        11
        fizz
        13
        14
        fizzbuzz

*/
package Elite; 
import java.io.*;
import java.util.Scanner;

class One implements Runnable{
     FizzBuzz common;
     public One(FizzBuzz fb){
         common=fb;
     }
     public void run() {
         try{
         common.fizz();
         }
         catch(Exception e){
             
         }
     }
 }
 
 class Two implements Runnable{
     FizzBuzz common;
     public Two(FizzBuzz fb){
         common=fb;
     }
     public void run(){
         try{
         common.buzz();
          }
         catch(Exception e){
             
         }
     }
 }
 
 
 class Three implements Runnable{
     FizzBuzz common;
     public Three(FizzBuzz fb){
         common=fb;
     }
     public void run(){
         try{
         common.fizzbuzz();
     }
         catch(Exception e){
             
         }
     }
 }
 
 class Four implements Runnable{
     FizzBuzz common;
     public Four(FizzBuzz fb){
         common=fb;
     }
     public void run(){
         try{
         common.number();
         }
         catch(Exception e){
             
         }
     }
 }



class FizzBuzz {
    int count,n=1;
  public FizzBuzz(int n) { 
      count=n;
  }               // constructor
  public synchronized void fizz() throws InterruptedException{
      
      while(n<=count){
          if(n%3==0 && n%5!=0){
              System.out.println("fizz");
               n=n+1;
              notifyAll();
          }
          else{            
              wait();
          }
      }
      
  }    
  
   public synchronized void buzz() throws InterruptedException{
      
      while(n<=count){
          if(n%5==0 && n%3!=0){
              System.out.println("buzz");
               n=n+1;
              notifyAll();
          }
          else{
              wait();
          }
      }
      
  }   
  
  
   public synchronized void fizzbuzz() throws InterruptedException {
      
      while(n<=count){
          if(n%5==0 && n%3==0){
              System.out.println("fizzbuzz");
              n=n+1;
              notifyAll();
          }
          else{
              wait();
          }
      }
      
  }  
  
   public synchronized void number() throws InterruptedException {
      
      while(n<=count){
          if(n%5!=0 && n%3!=0){
              System.out.println(n);
               n=n+1;
              notifyAll();
          }
          else{
              wait();
          }
      }
      
  } 
  	public static void main(String[] args) throws IOException {
    	Scanner sc=new Scanner(System.in);
    	int n=sc.nextInt();
    	FizzBuzz f= new FizzBuzz(n);
    	One o=new One(f);
    	Two t=new Two(f);
    	Three th=new Three(f);
    	Four fo=new Four(f);
    	Thread t1=new Thread(o);
    	Thread t2=new Thread(t);
    	Thread t3=new Thread(th);
    	Thread t4=new Thread(fo);
    	t1.start();
    	t2.start();
    	t3.start();
    	t4.start();
    }
}