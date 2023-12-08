package LongestCommonSubSeq;

import java.util.Collections;
import java.util.Vector;
public class LongestCommonSubSeqTD {

    private static int LCSTD(String a, String b,int l, int m){
        int[][] t = new int[l+1][m+1];
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
        printLCSS(t,a,b,l,m);
        return t[l][m];
    }

// We use the matrix which is filled, to obtain the common subseq
// Here we track backwards from bottom to up,  by comparing each character
// if characters are equal then add in a vector and i--,j--, else move to a position either t[i-1][j] or t[i][j-1] which has max value of t[i][j] and compare again if the characters are equal or not

    private static void printLCSS(int[][] t,String a, String b,int l, int m){
        Vector<Character> v = new Vector<>();
        int i=l,j=m;
        while (i>0 && j>0) {
            if(a.charAt(i-1) == b.charAt(j-1)){
                v.add(a.charAt(i-1));
                i--;
                j--;
            }else{
                if(t[i-1][j]>t[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }
        Collections.reverse(v);
        System.out.println("order is: "+ v );
    }
    public static void main(String[] args) {
        // Code is same for Longest palindrome subseq in a String 
        // Simply reverse the String and send it as a second string in LCS method
        // To get min no of deletions and insertions simply subtract the length 
        // of the string with the common subseq
        // Here no of deletions and insertions are equal because we can either 
        // remove "blab" - 'l' to make it "bab" so no. of insertions = 1 or
        // add 'l' to make it "blalb" which is also a palindrome
		String a = "bbabcbcab";
		String b = "bacbcbabb";

        // Use these Strings for normal LCS case, the above strings for palindrome case
        String l = "abcda";
        String m = "abghna";
		int la = a.length();
		int lb = b.length();
		System.out.println(" common sub seq is:" + LCSTD(a,b,la,lb));
        
        //This is to get the no of insertions and deletions to make a palindrome
        int t = LCSTD(a,b,la,lb);
        System.out.println(" no of insertions/deletions to make it palindrome = "+ (a.length()-t) );

	}
}
