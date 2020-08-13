package Elite;
//02/01/2020
import java.util.*;
public class OneEditDistance {
	
	public static boolean checkValidity(String str1,String str2) {
		if(str1.length() == str2.length()) {
			int flag = 0;
			for(int i=0;i<str1.length();i++) {
				if(str1.charAt(i) != str2.charAt(i)) {
					flag++;
				}
			}
			if(flag > 1) return false;
			else return true;
		}
		
		else {
			int j=0,count = 0;
			for(int i=0;i<str2.length();i++) {
				if(str1.charAt(j) == str2.charAt(i)) {j++;}
				else {
					j++;count++;i--;
				}
			}
			if(count >1) return false;
			else return true;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
        if(Math.abs(str1.length()-str2.length()) > 1) {
        	System.out.println(false);
        }
        
        else {
        	if(str1.length() >= str2.length())System.out.println(checkValidity(str1,str2));
        	else System.out.println(checkValidity(str2,str1));
        }
	}

}
