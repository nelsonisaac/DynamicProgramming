package Knapsack.concepts;

public class knapTopDown {
	
	static int  KS(int w[],int p[],int Wmax, int n) {
		
		int[][] t = new int[n+1][Wmax+1];
		
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=Wmax;j++) {
				if( i==0 || j==0) {
					t[i][j] = 0;
				}
				else if(w[i-1]<=j) {
					t[i][j] = Math.max(p[i-1] + t[i-1][j-w[i-1]] , t[i-1][j]);
				}
				else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][Wmax];
	}
	

	public static void main(String[] args) {
		
		int w[] = {4,5,1};
		int p[] = {8,2,6};
		int Wmax = 4;
		int n = w.length;
		
		System.out.println(KS(w,p,Wmax,n) + " is the max profit");
		// TODO Auto-generated method stub

	}

}
