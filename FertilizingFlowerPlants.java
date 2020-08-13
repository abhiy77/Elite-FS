/* 03/04/2020 - HOME
 * /*

Roy is the owner of a flower plant farm and sells flower plants for a living.
Now the problem with flower plants is that they wither in a night if not taken care of. 
So at the end of the day, to make flower plants wither-resistant Roy uses special fertilizers.

There are N number of plants not sold on one particular day (say today), 
but Roy can sell them the next day (say tomorrow) if he fertilizes them tonight.
Roy sells a flower plant for Rs. X. Cost of fertilizing a plant is Rs. Y.
Currently Roy has P Rupees with him.

Given the selling price X and fertilizing cost Y of N plants, 
your task is to find minimum amount A (A ≤ P) 
that he should spend in fertilizing plants such that the total money B he has 
after selling plants on the next day is maximized. 

Assume that all the fertilized plants are sold on the next day.

Input Format:

First line contains two space separated integers N and P.
Following N lines each contain two space separated integers X and Y.

Output Format:
Print the two space separated integers A and B in a new line. 


Sample Input :
    5 100
    100 40
    50 40
    40 50
    60 20
    100 50

Sample Output :
    90 210


Explanation :
    Profit for each of the plants is 60, 10, -10, 40, 50 respectively. He has Rs. 100 with him. 
    The optimal selection would be fertilize first and last plant. 
    So Minimum Amount to spend is Rs. 90 and 
    total money he has after selling the plants is 100 - 40 - 50 + 100 + 100 =210



========= TestCases Prog-3 =========

case =1
input =5 100
100 40
50 40
40 50
60 20
100 50
output =90 210

case =2
input =7 100
100 30
134 65
142 23
152 74
125 50
145 26
165 78
output =99 413

case =3
input =4 100
100 70
50 40
40 50
60 20
output =90 170

case =4
input =6 100
100 20
50 40
100 30
40 50
60 20
100 60
output =70 290

case =5
input =10 100
100 20
50 40
100 30
40 50
60 20
100 60
100 70
50 40
40 50
60 20
output =90 330

case =6
input =4 120
100 30
134 65
145 26
165 78
output =104 326

case =7
input =9 150
100 30
134 65
142 23
152 74
125 50
145 26
165 78
100 60
150 65
output =144 543

case =8
input =5 125
100 40
120 58
130 75
90 45
150 60
output =118 277
 */
package Elite;
import java.util.*;

public class FertilizingFlowerPlants {
	
	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
			int n=ob.nextInt();
			int p=ob.nextInt();
			int x[]=new int[n];
			int y[]=new int[n];
			for(int i=0;i<n;i++){
				x[i]=ob.nextInt();
				y[i]=ob.nextInt();
			}
			int dp[][]=new int[n+1][p+1];
			for(int i=1;i<=n;i++){
				for (int j=1;j<=p;j++){
					if(j<y[i-1])
						dp[i][j]=dp[i-1][j];
					else
						dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-y[i-1]]+x[i-1]);
				}
			}
			int max=0,i,j=0;
			for(i=0;i<=p;i++){
				if(max<dp[n][i]-i+p){
					max=dp[n][i]-i+p;
					j=i;
				}
			}
			System.out.println(j+" "+max);	
	}
}

//public static void main(String[] args) {
//Scanner sc = new Scanner(System.in);
//int plants = sc.nextInt();
//int money = sc.nextInt();
//LinkedList<PlantPair> plantPairs = new LinkedList<>();
//int max = 0;
//for(int i =0;i<plants;i++) {
//	plantPairs.add(new PlantPair(sc.nextInt(), sc.nextInt()));
//	max += (plantPairs.get(i).sellingCost - plantPairs.get(i).fertilizeCost);
//}
//int dp[][] = new int[plants][max+1];
//for(int i=0;i<plants;i++) dp[i][0] = 0;
//for(int i=0;i<max+1;i++) {
//	if(i >= plantPairs.get(0).fertilizeCost)dp[0][i] =  plantPairs.get(0).sellingCost-plantPairs.get(0).fertilizeCost;
//}
//for(int i=1;i<plants;i++) {
//	for(int j=1;j<max+1;j++) {
//		if(j < plantPairs.get(i).fertilizeCost) dp[i][j] = dp[i-1][j];
//		else {
//			dp[i][j] = Math.max(dp[i-1][j], plantPairs.get(i).sellingCost + dp[i-1][j-plantPairs.get(i).fertilizeCost]);
//		}
//	}
//}
//System.out.println(dp[plants-1][max]);
//
//}


//class PlantPair implements Comparable<PlantPair>{
//	int sellingCost,fertilizeCost;
//
//	public PlantPair(int sellingCost, int fertilizeCost) {
//		super();
//		this.sellingCost = sellingCost;
//		this.fertilizeCost = fertilizeCost;
//	}
//	public String toString() {
//		return "["+sellingCost+","+fertilizeCost+"]";
//	}
//	@Override
//	public int compareTo(PlantPair o) {
//		if((sellingCost-fertilizeCost) > (o.sellingCost-o.fertilizeCost)) return -1;
//		else if((sellingCost-fertilizeCost) == (o.sellingCost-o.fertilizeCost)) {
//			if(sellingCost > o.sellingCost) return 1;
//			if(sellingCost < o.sellingCost) return -1;
//		}
//		return 0;
//	}
//}