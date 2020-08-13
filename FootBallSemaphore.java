/*04/02/2020
 * 
 Suppose you are given the following code:

class FootBall {
  public void foot() {
    for (int i = 0; i < n; i++) {
      print("foot");
    }
  }

  public void ball() {
    for (int i = 0; i < n; i++) {
      print("ball");
    }
  }
}
The same instance of FootBall will be passed to two different threads. 
Thread A will call foot() while thread B will call ball(). 
Modify the given program to output "football" n times.

 

Example 1:

Input: n = 1
Output: "football"
Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar(). "foobar" is being output 1 time.
Example 2:

Input: n = 2
Output: "footballfootball"
Explanation: "football" is being output 2 times.


 */
package Elite;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
class FootBallSemaphore implements Runnable{
    private int n;
    Semaphore s1 = new Semaphore(0);
    Semaphore s2 = new Semaphore(1);

    public FootBallSemaphore(int n) {
        this.n = n;
    }
    @Override
	public void run() {
    	if("A".equals(Thread.currentThread().getName())) {
    		try {
    			foot(printFoot);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    	if("B".equals(Thread.currentThread().getName())) {
    		try {
    			ball(printBall);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
		
	}
    
    Runnable printFoot = new Runnable() {
        public void run() {
        	 System.out.print("foot");
        	 s1.release();
        }
    };
    
    Runnable printBall = new Runnable() {
        public void run() {
        	 System.out.print("ball");
        	 s2.release();
        }
    };
    
    public void foot(Runnable printFoot) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            s2.acquire();
            printFoot.run();
        }
    }
    public void ball(Runnable printBall) throws InterruptedException {
        for (int i = 0; i < n; i++) {
        	s1.acquire();
            printBall.run();
        }
    }
    public static void main(String[] args) throws IOException {
    	Scanner sc=new Scanner(System.in);
    	int n=sc.nextInt();
        FootBallSemaphore fb = new FootBallSemaphore(n);
        Thread one = new Thread(fb,"A");
        Thread two = new Thread(fb,"B");
        one.start();
        two.start();
    }
}