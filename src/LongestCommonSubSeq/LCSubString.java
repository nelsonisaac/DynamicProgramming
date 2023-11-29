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
        int len = 0;
        int row =0, col = 0;
        for(int i=1;i<=l;i++){
            for(int j=1;j<=m;j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                    if(len<t[i][j]){
                        len = t[i][j];
                        row = i;
                        col = j;
                    }
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
        
        String s = "";
        int i=l,j=m;
        while(t[row][col] != 0){
            if(a.charAt(row-1) == b.charAt(col-1)){
                s=s+a.charAt(row-1);
                row--;
                col--;
            }
            // }else{
            //     if(t[i-1][j]>t[i][j]){
            //         i--;
            //     }else{
            //         j--;
            //     }
            //     s="";
            // }
        }
        String s2 = new StringBuilder(s).reverse().toString();
        System.out.println(s2);
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
