package Knapsack.concepts;

import java.util.Vector;

public class SubsetCountwithDiff {

	static int subsetDiffCount(int[] arr, int n,int diff) {
		int sum=0;
		for(int i=0;i<n;i++) {
			sum = sum+arr[i];
		}
		
		int[][] s = new int[n+1][sum+1];
		for(int j=0;j<=sum;j++) {
			s[0][j] = 0;
		}
		for(int i=0;i<=n;i++) {
			s[i][0] = 1;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=sum;j++) {
				if(arr[i-1]<=j) {
					s[i][j] = s[i-1][j-arr[i-1]] + s[i-1][j];
				}else {
					s[i][j] = s[i-1][j];
				}
			}
		}
		
		System.out.println("matrix is");
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=sum;j++) {
				System.out.print(s[i][j]);
			}
			System.out.println(" ");
		}

// We solve equations s1+s2 = R, and s1-s2 = diff,
// We get final equation as s1 = (diff+R)/2 , with this we get the sum of subset value
// Now return the value in subset matrix which has count values of each sum.
// return only the value whose sum = s1, i.e., s[n][s1];		
		int s1 = (diff+sum)/2;
		return s[n][s1];
		
	}
	public static void main(String[] args) {

		int[] arr = {1,1,2,3};
		int n = arr.length;
		int diff = 1;
		System.out.println("count is: "+ subsetDiffCount(arr, n, diff));
	}

}
