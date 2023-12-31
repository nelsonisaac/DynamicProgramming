package LongestCommonSubSeq;

import java.util.Collections;
import java.util.Vector;
public class ShortestCmnSuperSeq {

    private static int SCSTD(String a, String b,int l, int m){
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
        printSCSS(t,a,b,l,m);
        return t[l][m];
    }

// We use the matrix which is filled, to obtain the common subseq
// Here we track backwards from bottom to up,  by comparing each character
// if characters are equal then add in a vector and i--,j--, else move to a position either t[i-1][j] or t[i][j-1] which has max value of t[i][j] and compare again if the characters are equal or not

    private static void printSCSS(int[][] t,String a, String b,int l, int m){

        String s = "";
       // Vector<Character> v = new Vector<>();
        int i=l,j=m;
        while (i>0 && j>0) {

            if(a.charAt(i-1) == b.charAt(j-1)){
                s = s+ b.charAt(j-1);
                //v.add(b.charAt(j-1));
                i--;
                j--;
            }else{
                if(t[i-1][j]>t[i][j-1]){
                    s = s+a.charAt(i-1);
                   // v.add(a.charAt(i-1));
                    i--;
                }else{
                    s = s+b.charAt(j-1);
                    //v.add(b.charAt(j-1));
                    j--;
                }
            }
        }
        if( j>0 ){
            s = s+b.charAt(j-1);
            //v.add(b.charAt(j-1));
        }
        if( i>0){
            s = s+a.charAt(i-1);
            //v.add(a.charAt(i-1));
        }
        //Collections.reverse(v);
        String s2 = new StringBuilder(s).reverse().toString();
        System.out.println("order is: "+ s2);
    }
    public static void main(String[] args) {
		String a = "abc";
		String b = "abe";
		int la = a.length();
		int lb = b.length();
		System.out.println(" common sub seq is:" + SCSTD(a,b,la,lb));


	}
}
