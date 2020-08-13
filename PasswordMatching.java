/* 24/04/2020 - HOME
 * 
 * There are N users registered on a website CuteKittens.com. 
Each of them has a unique password represented by pass[1], pass[2], ..., pass[N]. 
As this a very lovely site, many people want to access those awesomely cute pics of the kittens. 
But the adamant admin does not want the site to be available to the general public, 
so only those people who have passwords can access it.

You, being an awesome hacker finds a loophole in the password verification system. 
A string which is a concatenation of one or more passwords, in any order, 
is also accepted by the password verification system. 
Any password can appear 0 or more times in that string. 
Given access to each of the n passwords, and also have a string 
loginAttempt,determinewhetherthisstringbeacceptedbythepasswordverificationsystemofwebsite.
loginAttempt$ string can be created by concatenating password strings, it is accepted.

For example, if there are 3 users with passwords=[Abra,Ka,Dabra], then some of 
the valid combinations are Abra, KaAbra, KaDabraKa,KaDabraAbra and so on. 
Supplying Abra Ka Dabra, concatenated, passes authentication.

Input Format:
- The first line contains n, the number of users with passwords.
- The second line contains n space-separated strings, passwords[i], 
   that represent the passwords of each user.
- The third line contains a string, loginAttempt, which You must test for acceptance.
Note:passwords[i] contain only lowercase latin characters ('a'-'z').

Output Format
For each valid string, You have to print the actual order of passwords, 
separated by space, whose concatenation results into loginAttempt. 
If loginAttempt can't be accepted by the password verification system, 
then print WRONG PASSWORD.

Sample Input1:
6
because can do must we what
wedowhatwemustbecausewecan
Sample Output1:
we do what we must because we can


Sample Input2:
2
hello planet
helloworld
Sample Output2:
WRONG PASSWORD


Sample Input3:
4
gurwgrb maqz holpkhqx aowypvopu
gurwgrb
Sample Output3:
gurwgrb

Explanation:
Sample #1: "wedowhatwemustbecausewecan" is the concatenation 
of passwords {"we", "do", "what", "we", "must", "because", "we", "can"}. That is
loginAttempt = pass[5] + pass[3] + pass[6] + pass[5] +  pass[4] + pass[1] + pass[5] + pass[2]
Note that any password can repeat any number of times.

Sample #2: We can't create string "helloworld" using the strings {"hello", "planet"}.

Sample #03: We can create loginAttempt ("gurwgrb") from pass[1]. 

========= Testcases Program-1 =========
case =1
input =10
a aa aaa aaaa aaaaa aaaaaa aaaaaaa aaaaaaaa aaaaaaaaa aaaaaaaaaa
aaaaaaaaaab
output =WRONG PASSWORD

case =2
input =4
gurwgrb maqz holpkhqx aowypvopu
gurwgrb
output =gurwgrb

case =3
input =6
because can do must we what
wedowhatwemustbecausewecan
output =we do what we must because we can

case =4
input =2
hello planet
helloworld
output =WRONG PASSWORD

case =5
input =6
xkof medbc mhyewjzsdg vkuzym tbeqv xtbyhn
xtbyhnmedbcmhyewjzsdgxtbyhn
output =xtbyhn medbc mhyewjzsdg xtbyhn

case =6
input =6
alutwfal kkhbqlrxnm qyyx lwdgpchwic rdtgzvw sduh
sduhkkhbqlrxnmsduhsduhqyyx
output =sduh kkhbqlrxnm sduh sduh qyyx

case =7
input =10
yjwcocch wsta elfvzzbxq swwxfq ilwk xiqtb hnxxiot ejxtmxvf jeurpxyf glkhe
elfvzzbxqwstailwkilwk
output =elfvzzbxq wsta ilwk ilwk

case =8
input =10
ddihmxzgdk sutvgb ifvqzlxc tmoccqna qxscvwxaif muihxrmdx olgga xjaqeq vtuc akfwn
xjaqeqvtucsutvgbakfwn
output =xjaqeq vtuc sutvgb akfwn

// This is Word Break Problem

*/
package Elite;
import java.util.*;
public class PasswordMatching {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		List<String> list = Arrays.asList(sc.nextLine().split(" "));
		String password = sc.nextLine();
		int len = password.length();
		boolean dp[] = new boolean[len+1];
		dp[0] = true;
		for(int i=1;i<=len;i++) {
			for(int j=0;j<i;j++) {
				if(dp[j] && list.contains(password.substring(j,i))) {
					dp[i] = true;
					break;
				}
			}
		}
		if(dp[len]) {
			System.out.print(password.charAt(0));
			for(int i=1;i<len;i++) {
				if(dp[i])System.out.print(" "+password.charAt(i));
				else System.out.print(password.charAt(i));
			}
		}
		else {
			System.out.println("WRONG PASSWORD");
		}
	}
}