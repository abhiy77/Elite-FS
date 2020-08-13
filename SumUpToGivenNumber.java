/* 15/05/2020 - HOME
Cantor, a famous mathematician loves to work on sets.
He will be given a set of integers, He can use them any number of times as he want.
He needs to create new integer sets, whose sum leads to a given integer value T.

Input Format:
    - Two Integers T, S. S is the number of integers in the given set.
    - Next line contains S space sepearated integers.

Output Format:
    - Print an integer denoting the number of ways we can get a sum of T.
    
Sample Input:
5 3
1 2 3
Sample Output:
5

Explanation:
given set-> 1 2 3
1 1 1 1 1   => sum is 5
1 1 1 2     => sum is 5
1 1 3       => sum is 5
1 2 2       => sum is 5
2 3         => sum is 5



******Testcases******
case =1
input =10 4
2 5 3 6
output =5

case =2
input =4 3
1 2 3
output =4

case =3
input =16 4
2 3 4 5
output =17

case =4
input =50 7
3 8 5 9 7 2 4
output =2321

case =5
input =15 6
1 2 3 4 5 6
output =110

case =6
input =25 5
8 9 10 12 7
output =3

case =7
input =35 6
4 5 7 8 9 3
output =107

case =8
input =100 10
2 4 6 8 10 12 14 16 18 20
output =62740

*/
package Elite;
import java.util.*;

public class SumUpToGivenNumber
{
	static HashMap<String, Integer> cache = new HashMap<String, Integer>();
	static protected int count(ArrayList<Integer> coin, int bound, int amount)
	{
		String key=bound+" "+amount;
		if (amount == 0) return 1;
		if (amount < 0) return 0;
		if (bound <= 0 && amount >= 1) return 0;
		if(cache.containsKey(key))
			return cache.get(key);
		int ans=count(coin, bound-1, amount)+count(coin, bound, amount-coin.get(bound-1));
		cache.put(key, ans);
		return ans;
	}

	public static void main(String[] args) 
	{
		ArrayList<Integer> intList = new ArrayList<Integer>();
		int T, S;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		S= sc.nextInt();
		for(int i=0;i<S;i++)
			intList.add(sc.nextInt());
		System.out.println(count(intList, S, T));
	}

}