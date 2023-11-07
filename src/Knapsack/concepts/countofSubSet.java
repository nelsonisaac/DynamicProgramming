package Knapsack.concepts;

public class countofSubSet {
	static int countsubset(int[] arr,int sum, int n) {
		int[][] s = new int[n+1][sum+1];
		
		for(int j=0; j <n; j++) {
			s[0][j] = 0;
		}
		for(int i=0; i<sum ; i++) {
			s[i][0] = 1;
		}
		
// The logic is same as subsetSum, but here we add the integers to get the count
// s[i-1][j-arr[i-1]] this is for calculating the sum( j at that moment) so we 
// subtract that with the last item in the arr
// s[i-1][j] this part is to calculate the same sum, without subtracting it, so that
// we can find any repeating numbers, in this case, we have sum =6 in multiple times		
		for(int i=1; i <= n;i++) {
			for(int j=1; j<= sum; j++) {
				if(arr[i-1] <= j) {
					s[i][j] = s[i-1][j-arr[i-1]] + s[i-1][j];
				}
				else {
					s[i][j] = s[i-1][j];
				}
			}
		}
		return s[n][sum];
	}
	
	
	public static void main(String[] args) {
		int[] arr = {2,9,6,6,4,1};
		int sum = 6;
		int n = arr.length;
		
		System.out.println("count is: "+ countsubset(arr, sum, n));
	}

}
