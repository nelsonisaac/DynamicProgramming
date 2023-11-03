package Knapsack.concepts;

public class equalSumPartition {
	
	static boolean equalsum(int[] arr,int n) {
		
		int sum =0;
		
		for(int i=0;i<n;i++) {
			sum = sum + arr[i];
		}
		if( sum % 2 != 0) {
			return false;
		}
		else {
			boolean[][] s = new boolean[n+1][sum+1];
			
			for(int j=0;j<=sum;j++) {
				s[0][j] = false;
			}
			for(int i=0;i<=n;i++) {
				s[i][0] = true;
			}
			
			for(int i=1; i<= n; i++) {
				for(int j=1; j<= sum/2; j++) {
					if(arr[i-1] <= j ) {
						s[i][j] = s[i-1][j-arr[i-1]] || s[i-1][j];
					}
					else {
						s[i][j] = s[i-1][j];
					}
				}
			}
			
			return s[n][sum/2];
			
		}
		

	}
	
	
	
//	static boolean partition(int[] arr,int n, int sum) {
//		
//		for(int i=0;i<n;i++) {
//			sum = sum + arr[i];
//		}
//		if( sum % 2 == 0) {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
	

	public static void main(String[] args) {
		int[] arr = {1,3,2,6};
		int n = arr.length;

		
		if(equalsum(arr, n) == true) {
			System.out.println(" is possible");
		}
		else if(equalsum(arr, n) == false){
			System.out.println("not possible");
		}

	}

}
