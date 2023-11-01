//Consider a knapsack bag of weight capacity "W". 
//Given are 2 arrays W[]- weights of different items, 
//P[] prices of those respective items. 
//Add items into the bag with maintaining weight limit to get maximum profit.

package Knapsack.concepts;

import java.lang.Math;

public class knap {
	
	static int KS(int w[],int p[],int Wmax, int n) {
		if(Wmax == 0 || n == 0 ) {
			return 0;
		}
		
// If w<Wmax then add the item into the bag, i.e., Wmax decreases by the 
// amount(Wmax-w(n-1)) of weight added and also the number of items is n-1
// Also we calculate by Considering the item and also Not Considering 
// the item KS(Wmax,n-1) weight wont be decreased but items decrease 
// Max of these 2 ways is taken, as we need profit.		
		
		if(w[n-1] <= Wmax) {
			return Math.max(p[n-1]+KS(w,p,Wmax-w[n-1],n-1) , KS(w,p,Wmax,n-1));
		}
		else {
			return KS(w,p,Wmax,n-1);
		}
	}		

	public static void main(String[] args) {
		
		int w[] = {4,5,1};
		int p[] = {5,2,6};
		int Wmax = 4;
		int n = w.length;
		
		System.out.println(KS(w,p,Wmax,n) + " is the max profit");
		
	}

}
