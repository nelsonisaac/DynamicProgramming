package LongestCommonSubSeq;

public class LCSubString {
    private static int LCString(String a,String b,int l,int m){
        int max = 0;
        int[][] t = new int[l+1][m+1];
        for(int i=0;i<=l;i++){
            t[i][0] = 0;
        }
        for(int j=0;j<=m;j++){
            t[0][j] = 0;
        }

        for(int i=1;i<=l;i++){
            for(int j=1;j<=m;j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                    max = Math.max(max,t[i][j]);
                }else{
                    t[i][j] = 0;
                }
            }
        }
        for(int i=0;i<=l;i++){
            for(int j=0;j<=m;j++){
                System.out.print(t[i][j]);
            }
            System.out.println(" ");
        }
        // int i=max,j = max;
        // while(i>=0 && j>=0){
        //     if(i == j){
        //         System.out.print(t[i][j]);
        //     }
        //     i--;
        //     j--;
        // }
        return max;
    }

    public static void main(String[] args) {
		String a = "gabdpe";
		String b = "jabdfle";
		int la = a.length();
		int lb = b.length();
		System.out.println("common sub String is:" + LCString(a,b,la,lb));

	}
}
