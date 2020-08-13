/* 27/06/2020 - HOME
 * REFERENCE LEETCODE - 418
 */
package Elite;
import java.util.Scanner;

class SentenceScreenFitting
{
	static int wordsTyping(String[] sentence, int rows, int cols) {
        int[] nextIndex = new int[sentence.length];
        int[] times = new int[sentence.length];
        for(int i=0;i<sentence.length;i++) {
            int curLen = 0;
            int cur = i;
            int time = 0;
            while(curLen + sentence[cur].length() <= cols) {
                curLen += sentence[cur++].length()+1;
                if(cur == sentence.length) {
                    cur = 0;
                    time++;
                }
            }
            nextIndex[i] = cur;
            times[i] = time;
        }
        int ans = 0;
        int cur = 0;
        for(int i=0; i<rows; i++) {
            ans += times[cur];
            cur = nextIndex[cur];
        }
        return ans;
    }
		
	public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
	int r=sc.nextInt();
	int c=sc.nextInt();
	sc.nextLine();
	String str=sc.nextLine();
	
	System.out.println(wordsTyping(str.split(" "), r,c));
	}
}