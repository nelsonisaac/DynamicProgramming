package LongestCommonSubSeq;

public class LongestCommonSubSeq {

// This is using recursion
	private static int LCS(String a, String b, int la, int lb){
		if(la ==0 || lb == 0){
			return 0;
		}
		if(a.charAt(la-1) == b.charAt(lb-1)){
			return 1+LCS(a,b,la-1,lb-1); 
		}else{
			return Math.max(LCS(a,b,la-1,lb), LCS(a,b,la,lb-1)) ;
		}
	}

	public static void main(String[] args) {
		String a = "abcdef";
		String b = "abdfgh";
		int la = a.length();
		int lb = b.length();
		System.out.println("common sub seq is:" + LCS(a,b,la,lb));

	}

}
