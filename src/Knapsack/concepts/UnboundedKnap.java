package Knapsack.concepts;

public class UnboundedKnap {

	static int rodCut(int[] l,int[] p,int n) {
		int sum = 0;
		for(int i =0; i < n; i++ ) {
			sum = sum+l[i];
		}
		
		System.out.println(sum);
		
// We create a matrix of row and colm with length of rod array and values array
// Initialization of the matrix has all 0 values
// Here i is the values of available cuts and j is the length of the rod		
		
		int[][] s = new int[n+1][n+1];
		
		for(int j=0; j <n; j++) {
			s[0][j] = 0;
		}
		for(int i=0; i<n ; i++) {
			s[i][0] = 0;
		}
		
// We calculate by cutting the rod (p[i-1] + s[i][j-arr[i-1]]) and by not cutting 
// with that particular i value which is s[i-1][j];
// This is same as knapsack but here we dont subtract i even after cutting the rod
// Because i is the avaible profits for each cut, so we can cut the rest of the rod
// again with the same i values if it is much more profitable		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(l[i-1] <= j) {
					s[i][j] = Math.max(p[i-1]+s[i][j-l[i-1]], s[i-1][j]);
				}else {
					s[i][j] = s[i-1][j];
				}
			}
		}
		
		return s[n][n];
	}
	
	public static void main(String[] args) {
		
		int[] l = {1,2,3,4};
		int[] p = {1,5,8,9};
		int n = l.length;
		
		System.out.println("max profitable cut is: " + rodCut(l, p, n));
		
	}

}
