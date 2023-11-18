package Knapsack.concepts;

public class MinCoinChange {
	
	private static int MinimumCoins(int[] c,int sum, int n) {
		int[][] t = new int[n+1][sum+1];
		

		for(int i=0;i<=n;i++) {
			t[i][0] = 0;
		}
// mathematically to get any sum from 0 coins it takes infinite no. of coins 
// so INT_MAX is taken to represent infinity, also INT_MAX-1 becoz the range of INT_MAX cannot go further
// and we may get error if crosses +1	so we take -1.	
		for(int j=0;j<=sum;j++) {
			t[0][j] = Integer.MAX_VALUE-1;
		}

// This is the extra initialization required for the 2nd row i.e., i=2. Here we calculate if sum is a multiple
// of the no. of coins available, so that those many no. of coins are needed to get the required sum.
// We divide and check the no of coins needed to get the required sum and place those values in the 2nd row.
		
		for(int i=1;i<=1;i++) {
			for(int j=1;j<=sum;j++) {
				if(j%c[0] == 0) {
					t[i][j] = j/c[0];
				}else {
					t[i][j] = Integer.MAX_VALUE-1;
				}
			}
		}
		
// Matrix before processing		
System.out.println("before processing");		
		for(int i=0; i<=n;i++) {
			for(int j=0;j<=sum;j++) {
				System.out.print(t[i][j]);
				System.out.print(" ");
			}
			System.out.println(" ");
		}
		
// With the help of the 2nd row(i=2) we now go from top to bottom, same as unbounded knapsack approach
		
		for(int i=2;i<=n;i++) {
			for(int j=1;j<=sum;j++) {
				if(c[i-1]<=j) {
					t[i][j] = Math.min(1+t[i][j-c[i-1]], t[i-1][j]);
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		
// Matrix after processing. the large number indicates it is infinite.		
		System.out.println("after processing");	
		for(int i=0; i<=n;i++) {
			for(int j=0;j<=sum;j++) {
				System.out.print(t[i][j]);
				System.out.print(" ");
			}
			System.out.println(" ");
		}
		
		return t[n][sum];
	}

	public static void main(String[] args) {
		
		int[] c = {4,2,3};
		int sum = 6;
		int n = c.length;
		
		System.out.println("Minimum no. of coins for "+sum+" is: "+MinimumCoins(c, sum, n));
	}

}
