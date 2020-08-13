package Elite;
import java.util.*;
public class IpAddress {
	
	public static boolean containsLeadingZeroes(String str) {
		boolean zero = false;
		int zeroCount = 0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) > '0' && str.charAt(i) <= '9') {
				if(!zero) return false;
				if(zero) return true;
			}
			else if(str.charAt(i) == '0') {
				zero = true;
				zeroCount++;
			}
		}
		return (zeroCount <= 1 ? false : true);
	}
	
	public static boolean isSafe(String curr) {
		//int arr[] = Arrays.asList(curr.split("\\.")).stream().mapToInt(Integer ::parseInt).toArray();
		String arr[] = curr.split("\\.");
		//System.out.println(Arrays.toString(arr));
		if(arr.length != 4) {
			return false;
		}
		for(int i=0;i<arr.length;i++) {
			if(containsLeadingZeroes(arr[i])) return false;
			else if(Integer.parseInt(arr[i]) < 0 || Integer.parseInt(arr[i]) > 255) {
				return false;
			}
		}
		return true;
	}
	
	public static void findValidAddresses(String str,int count,int i,String curr,LinkedList<String> result) {
		System.out.println(curr);
		if(count == 3) {
			System.out.println("Substring : " + curr+str.substring(i));
			if(isSafe(curr+str.substring(i))) {
				result.add(new String(curr+str.substring(i)));
			}
			return;
		}
		for(int k=i;k<str.length();k++) {
			for(int j=k+1;j<str.length();j++) {
				findValidAddresses(str, count+1, j, curr+str.substring(k,j) +".",result);
			}
			return;
		}
	}

	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		LinkedList<String> result = new LinkedList<>();
		if(str.length()< 4 || str.length() > 12) System.out.println("No valid Ip addresses");
		else findValidAddresses(str,0,0,"",result);
		System.out.println(result);
	}
}