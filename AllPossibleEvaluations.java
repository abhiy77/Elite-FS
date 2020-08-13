/* 30/01/2020
 * Given a string of numbers and operators, 
return all possible results from computing all the different 
possible ways to group numbers and operators. 
The valid operators are +, - and *.

Example 1:
	Input: 2-1-1
	Output: [0, 2]
	Explanation: 
	((2-1)-1) = 0 
	(2-(1-1)) = 2

Example 2:
	Input: 2*3-4*5
	Output: [-34, -14, -10, -10, 10]
	Explanation: 
	(2*(3-(4*5))) = -34 
	((2*3)-(4*5)) = -14 
	((2*(3-4))*5) = -10 
	(2*((3-4)*5)) = -10 
	(((2*3)-4)*5) = 10
 */
package Elite;
import java.util.*; 

class AllPossibleEvaluations  
{ 
  
    // Utility function to evaluate a simple expression 
    // with one operator only. 
    public static int evaluate(int a, char op, int b)  
    { 
        if (op == '+') 
        { 
            return a + b; 
        } 
        if (op == '-') 
        { 
            return a - b; 
        } 
        if (op == '*')  
        { 
            return a * b; 
        } 
        return Integer.MAX_VALUE; 
    } 
  
    // This function evaluates all possible values and 
    // returns a list of evaluated values. 
    static LinkedList<Integer> evaluateAll(String expr, 
                                    int low, int high)  
    { 
        // To store result (all possible evaluations of 
        // given expression 'expr') 
        LinkedList<Integer> res = new LinkedList<Integer>(); 
  
        // If there is only one character, it must 
        // be a digit (or operand), return it. 
        if (low == high)  
        { 
            res.add(expr.charAt(low) - '0'); 
            return res; 
        } 
  
        // If there are only three characters, middle 
        // one must be operator and corner ones must be 
        // operand 
        if (low == (high - 2))  
        { 
            int num = evaluate(expr.charAt(low) - '0',  
                         expr.charAt(low + 1), 
                        expr.charAt(low + 2) - '0'); 
  
            res.add(num); 
            return res; 
        } 
  
        // every i refers to an operator 
        for (int i = low + 1; i <= high; i += 2)  
        { 
              
            // l refers to all the possible values 
            // in the left of operator 'expr[i]' 
            LinkedList<Integer> l = evaluateAll(expr, low, i - 1); 
  
            // r refers to all the possible values 
            // in the right of operator 'expr[i]' 
            LinkedList<Integer> r = evaluateAll(expr, i + 1, high); 
  
            // Take above evaluated all possible 
            // values in left side of 'i' 
            for (int s1 = 0; s1 < l.size(); s1++)  
            { 
                  
                // Take above evaluated all possible 
                // values in right side of 'i' 
                for (int s2 = 0; s2 < r.size(); s2++)  
                { 
                      
                    // Calculate value for every pair 
                    // and add the value to result. 
                    int val = evaluate(l.get(s1), expr.charAt(i), r.get(s2)); 
                    res.add(val); 
                } 
            } 
        } 
        return res; 
    } 
  
    // Driver program 
    public static void main(String[] args)  
    { 
    	Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        LinkedList<Integer> ans = evaluateAll(expr, 0, expr.length() - 1); 
  
        for (int i = 0; i < ans.size(); i++)  
        { 
            System.out.println(ans.get(i)); 
        } 
    } 
} 