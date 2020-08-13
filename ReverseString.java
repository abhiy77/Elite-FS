package Elite;
// 02/01/2020
import java.util.*;
public class ReverseString {
	
	static String str;
	static StringBuilder sb;
	public static String reverse(int i,String str) {
		if(i == str.length()) {return "";}
		if(i < str.length()) {
			sb.append(reverse(i+1,str));
		}
		return Character.toString(str.charAt(i));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		sb = new StringBuilder();
		sb.append(reverse(0,str));
		System.out.println(sb);
	}
}