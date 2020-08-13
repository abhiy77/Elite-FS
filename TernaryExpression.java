/* 06/01/2020
 * Given a string, that is a ternary expressions or nested ternary expression, 
calculate the result of the ternary expression. 

You can always assume that the given string is valid expreession and 
only consists of digits 0-9, ?, :, T and F (T and F represent True and False respectively).

Note:

Each number will contain only one digit.
The condition will always be either T or F. That is, the condition will never be a digit.
The result of the expression will always evaluate to either a digit 0-9, T or F.

Example 1:
	Input=	F?F:T
	Output=	T

Explanation: If FALSE, then result is TRUE; otherwise result is FALSE.

Example 2:
	Input=	T?F?3:4:2
	Output=	4

Explanation: given T -> true, so F?3:4 -> F is false, so output is 4
*/
package Elite;
import java.util.*;
public class TernaryExpression {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        
        for(int i=str.length()-1;i>0;i--) {
        	
        	if(Character.isLetterOrDigit(str.charAt(i))) {
        		stack.push(str.charAt(i));
        	}
        	else if(str.charAt(i) == ':') {
        		continue;
        	}
        	else if(str.charAt(i) == '?') {
        		if(str.charAt(i-1) == 'T') {
        			char temp = stack.pop();
        			stack.pop();
        			stack.push(temp);
        		}
        		else {
        			stack.pop();
        		}
        		i--;
        	}
        }
        System.out.println(stack.pop());
	}
}