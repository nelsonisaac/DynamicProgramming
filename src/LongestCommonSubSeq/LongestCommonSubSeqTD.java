package LongestCommonSubSeq;

import java.util.Vector;
public class LongestCommonSubSeqTD {

    private static int LCSTD(String a, String b,int l, int m){
        int[][] t = new int[l+1][m+1];
        Vector<Character> v = new Vector<Character>();
        for(int i=0;i<=l;i++){
            t[i][0] = 0;
        }
        for(int j=0;j<=m;j++){
            t[0][j] = 0;
        }

// we store the values in a 2D array. If characters are same in both then add +1 and 
// subtract them from both the strings. If they are not equal then there are 2 cases
// subtract one of the string and compare with the other, similarly the case
        for(int i=1;i<=l;i++){
            for(int j=1;j<=m;j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                    v.add(a.charAt(i-1));
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        for(int i=0;i<=l;i++){
            for(int j=0;j<=m;j++){
                System.out.print(t[i][j]);
            }
            System.out.println(" ");
        }
// For printing the subsequence
        for(int i=0; i<v.size();i++){
            System.out.print(v.get(i));
        }

        return t[l][m];
    }

    public static void main(String[] args) {
		String a = "abcd";
		String b = "abed";
		int la = a.length();
		int lb = b.length();
		System.out.println(" common sub seq is:" + LCSTD(a,b,la,lb));

	}
}
