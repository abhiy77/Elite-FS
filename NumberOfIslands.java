package Elite;
//31/12/2019

import java.util.*;
public class NumberOfIslands {
	
	static int count = 0;
	
	public static void recurse(int[][] arr,int x,int y,int rows,int cols,int[][] temp) {

		if(x >=0 && x<rows && y>=0 && y<cols && temp[x][y] == 1) {
			temp[x][y] = 0;
			recurse(arr,x+1,y,rows,cols,temp);
			recurse(arr,x-1,y,rows,cols,temp);
			recurse(arr,x,y+1,rows,cols,temp);
			recurse(arr,x,y-1,rows,cols,temp);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int pos = sc.nextInt();
        int arr[][] = new int[rows][cols];
        
        for(int i=0;i<pos;i++) {
        	int x = sc.nextInt();
        	int y = sc.nextInt();
    		int temp[][] = new int[rows][cols];
        	arr[x][y] = 1;
    		for(int j=0;j<rows;j++) {
        		for(int k=0;k<cols;k++) {
        		    temp[j][k] = arr[j][k];
        		}
        	}
        	for(int j=0;j<rows;j++) {
        		for(int k=0;k<cols;k++) {
        			if(temp[j][k] == 1) {
        				recurse(arr,j,k,rows,cols,temp);
        				count++;
        			}
        		}
        	}
        	System.out.println(count);
        	count = 0;
        }
	}
}