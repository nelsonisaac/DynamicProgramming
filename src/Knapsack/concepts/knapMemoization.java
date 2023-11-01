package Knapsack.concepts;

// Memoization stores the values of the recursive calls so that 
// if the same call occurs again then it simply gives the cached/stored result
// instead of calling recursive func again, this saves stack and time
 
public class knapMemoization {

	static int KS(int w[],int p[],int Wmax, int n, int[][] s) {
		if(Wmax == 0 || n == 0 ) {
			return 0;
		}
		
// Here it checks if the particular [n][Wmax] position holds a value other than -1 or not
// If it holds that means that particular value recursive call is already done
// so it skips the call and returns the previos s[n][Wmax]
		
		if(s[n][Wmax] != -1) {
			return s[n][Wmax];
		}
		
// We assign the profit values in the respective [n][Wmax] positions , rest of the cells 
// remain -1, except for the positions [n][Wmax]
		
		if(w[n-1] <= Wmax) {
			return s[n][Wmax] = Math.max(p[n-1] + KS(w,p,Wmax-w[n-1],n-1,s), KS(w,p,Wmax,n-1,s));
		}
		else {
			return KS(w,p,Wmax,n-1,s);
		}
	}
	
// Here we take a 2D array with rows and columns as the parameters 
// of the recursive func which change for every call and fill every block with -1. 	
	
	static int Storage(int[] w,int[] p,int Wmax, int n) {
		
		int[][] s = new int[n+1][Wmax+1];
		
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<Wmax+1; j++) {
				s[i][j] = -1;
			}
		}		
		return KS(w,p,Wmax,n,s);		
	}
	
	public static void main(String[] args) {
		
		int w[] = {4,5,1};
		int p[] = {8,2,6};
		int Wmax = 4;
		int n = w.length;		
		
		System.out.println( Storage(w,p,Wmax,n) + " is the max profit");
		
	}

}
