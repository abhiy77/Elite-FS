package Elite;

import java.util.*;

class Calculator{
	
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        String str = sc.nextLine();
	        str = str.replace(" ", "");

	        char letters = 'a'; 
	        int index = 0;

	        HashMap<String,Integer> map = new HashMap<>();

	        for(int i = 0 ; i < str.length() ; i++){
	            char c = str.charAt(i);
	            String s = "";
	            while(Character.isDigit(c)){
	                s += c;
	                if(i == str.length() - 1){
	                    break;
	                }
	                else{
	                    i++;
	                    c = str.charAt(i);
	                }    
	            }
	            if(s != ""){
	                if(!map.containsValue(Integer.parseInt(s))){
	                    map.put(Character.toString(letters), Integer.parseInt(s));
	                    letters+=1;
	                    index++;
	                }
	            }  
	        }
	        letters = 'a';
	        for(int i = 0 ; i < index ; i++){
	            str = str.replace(Integer.toString(map.get(Character.toString(letters))) , Character.toString(letters));
	            letters+=1;
	        }
	        str = infixToPostfix(str);
	        System.out.println(evaluate(str,map));
	        sc.close();
	    }
   
    static String infixToPostfix(String str)
    {
        str = str.replace(" ","");
        String result = new String("");
         
        Stack<Character> stack = new Stack<>();
         
        for (int i = 0; i<str.length(); ++i)
        {
            char c = str.charAt(i);
               
            if (Character.isLetterOrDigit(c))
                result += c;
               
            else if (c == '(')
                stack.push(c);
             
            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();
                 
                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid";                  
                else
                    stack.pop();
            }
            else
            {
                while (!stack.isEmpty() && checkPrecedence(c) <= checkPrecedence(stack.peek())){
                    if(stack.peek() == '(')
                        return "Invalid";
                    result += stack.pop();
             }
                stack.push(c);
            }  
        }
       
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid";
            result += stack.pop();
         }
        return result;
    }
    
    static int checkPrecedence(char ch)
    {
        switch (ch)
        {
        case '*':
        case '/':
            return 2;
       
        case '+':
        case '-':
            return 1;
        
        }
        return -1;
    }

    static int evaluate(String exp,HashMap<String,Integer> map)
    {  
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);  
            if(Character.isLetterOrDigit(c)){
                stack.push(map.get(Character.toString(c)));
            }
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();
                 
                switch(c)
                {
                    case '+':
                    stack.push(val2+val1);
                    break;
                     
                    case '-':
                    stack.push(val2- val1);
                    break;
                     
                    case '/':
                    stack.push(val2/val1);
                    break;
                     
                    case '*':
                    stack.push(val2*val1);
                    break;
              }
            }
        }
        return stack.pop();    
    }
}