package Knapsack.concepts;

public class subsetSum {
	
	
	static Boolean subset(int[] arr,int sum,int n) {
		
		boolean[][] s = new boolean[n+1][sum+1];
		
        for (int i = 0; i <= n; i++)
            s[i][0] = true;
        
        for (int i = 1; i <= sum; i++)
            s[0][i] = false;

        
// this logic is same as knapsack topdown approach
// we subtract the given sum with every digit in the array and see if the diff exists
// like 6-arr[i-1] = 3, so we check for 3's existence in the matrix
// 3's existence is checked by 3-arr[i-1] = 0, which is true
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=sum;j++) {
				if(arr[i-1]<=j) {
					s[i][j] = s[i-1][j-arr[i-1]] || s[i-1][j];
				}
				else {
					s[i][j] = s[i-1][j];
				}
				
			}
		}
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=sum;j++) {
				
				System.out.print(s[i][j]+ " ");
			}
			System.out.println(" ");
		}
		return s[n][sum];
	}

	public static void main(String[] args) {

		int[] arr = {3,4,5,2};
		int sum = 6;
		int n = arr.length;
		
		System.out.println(subset(arr, sum, n) + " it is possible");

		
	}

}
