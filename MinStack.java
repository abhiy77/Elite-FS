/* 16/01/2020 
create a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

Sample Input:
push 20
push 15
pop
push 44
push 80
getmin

Sample Output :
20


Sample Input:
push 40
push 30
push 85
push 64
pop
pop
top

Sample Output :
30
 */
package Elite;
import java.util.*;
public class MinStack {
	Stack<Integer> stack;
	int min;
	
    MinStack(){
    	stack = new Stack<Integer>();
    	min = Integer.MAX_VALUE;
    }
    
    public void push(Integer num) {
    	if(stack.isEmpty()) {
    		min = num;
    		stack.push(min);
    		return;
    	}
    	if(min > num) {
    		stack.push(min);
    		min = num;
    		stack.push(num);
    	}
    	else stack.push(num);
    }
    
    public int top() {
    	if(stack.isEmpty()) {
    		System.out.println("Stack is empty");
    		return 0;
    	}
    	else {
    		return stack.peek();
    	}
    }
    
    public int getMin() {
    	if(stack.isEmpty()) {
    		System.out.println("Stack is empty");
    		return 0;
    	}
    	else {
    		return min;
    	}
    }
    
    public int pop() {
    	if(stack.isEmpty()) {
    		System.out.println("Stack is empty");
    		return 0;
    	}
    	int x = stack.peek();
    	if(x == min) {
    		stack.pop();
    		min = stack.pop();
    	}
    	else {
    		stack.pop();
    	}
    	
    	return x;
    }

	public static void main(String[] args) {
	   MinStack minStack = new MinStack();
       Scanner sc = new Scanner(System.in);
       
       while(true) {
    	   String str[] = sc.nextLine().split(" ");
    	   switch(str[0]) {
    	   		case "push":
    	   			minStack.push(Integer.parseInt(str[1]));
    	   			break;
    	   			
    	   		case "pop":
    	   			minStack.pop();
    	   			break;
    	   	    
    	   		case "getmin":
    	   			System.out.println(minStack.getMin());
    	   			System.exit(-1);
    	   			
    	   		case "top":
    	   			System.out.println(minStack.top());
    	   			System.exit(-1);
    	   }
       }
	}
}