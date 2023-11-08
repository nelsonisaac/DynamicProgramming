package Knapsack.concepts;

import java.util.Vector;

public class minSubsetDiff {
	
	static int minSubset(int[] arr, int n) {
		
// We are getting max sum value as "r"		
		int r = 0;
		for(int i=0; i<n; i++) {
			r = r+ arr[i];
		}
		System.out.println(r);
		
// Using the max sum "r", we use subsetSum approach to get the matrix		
		boolean[][] s = new boolean[n+1][r+1];
		
		for(int j=0 ; j< r; j++) {
			s[0][j]  = false;
		}
		
		for(int i=0; i<n; i++) {
			s[i][0] = true;
		}
		
		for(int i=1; i <= n; i++) {
			for(int j=1; j<= r; j++) {
				if(arr[i-1] <= j) {
					s[i][j] = s[i-1][j-arr[i-1]] || s[i-1][j];
				}else {
					s[i][j] = s[i-1][j];
				}
			}
		}
		
// We take a vector and add only the last line of the matrix, which includes all the
// items of the array. We only consider values with true. i.e.,
// True in the sense, the values that are possible to form a subset and give the 
// required sum. (Same as subsetSum method)		
		
	
		Vector<Integer> v = new Vector<Integer>();
		
		for(int j=0; j<r; j++) {
			if(s[n][j] == true ) {
				v.add(j);
			}
		}
		
// min1 is for the reference to a max number, with help of this, we get the min of all 
// the values in the vector
		
		int min1 = Integer.MAX_VALUE;
		System.out.println("This is the vector of acceptable values");

		for(int i=1;i<v.size();i++) {
			System.out.print(v.get(i));
			System.out.print(" ");
			
// We are using mathematical approach, by solving equations s1+s2=R and s1-s2=min
// We get min = R-2s1, we take min value by substituting all the s1 values from the vector			
// The s2 or s1 value cannot exceed r/2, if so it gives negative values			
			if(v.get(i)<=r/2) {
				min1 = Math.min(min1,r - (2*v.get(i)));
			}else {
				continue;
			}
		}
		return min1;
	}
	
	public static void main(String[] args) {
		int[] arr = {8,4,5,6};
		int n = arr.length;
		
		System.out.print("min value is: "+ minSubset(arr, n));
		
	}

}
