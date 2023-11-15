package Knapsack.concepts;

public class coinChange {

	private static int coin(int[] c, int sum, int n) {
		int[][] t = new int[n+1][sum+1];
		
		for(int j=0; j<= sum; j++) {
			t[0][j] = 0;
		}
		
		for(int i=0; i<= n; i++) {
			t[i][0] = 1;
		}

// This is same as knapsack unbounded method. i is for number of coins j is for sum
// when we consider the coin i , then we subtract that amount from the total sum j-c[i-1]
// but the i reamins same, as we can take same i any no. of times for getting profit
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=sum;j++) {
				if(c[i-1]<=j) {
					t[i][j] = t[i][j-c[i-1]]+t[i-1][j];
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		
		return t[n][sum];
	}
	
	public static void main(String[] args) {
		int[] c = {1,2,3};
		int sum = 5;
		int n = c.length; 
		
		System.out.println("max num of ways: "+ coin(c,sum,n));
	}

}
