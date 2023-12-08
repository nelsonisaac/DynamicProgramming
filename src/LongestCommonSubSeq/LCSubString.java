package LongestCommonSubSeq;

public class LCSubString {
    private static int LCString(String a,String b,int l,int m){
        int[][] t = new int[l+1][m+1];
        for(int i=0;i<=l;i++){
            t[i][0] = 0;
        }
        for(int j=0;j<=m;j++){
            t[0][j] = 0;
        }

        // We only note the values which have same character, else we keep 0 as we dont want any discontinuity, our string should be continuous 
        int len = 0;
        int row =0, col = 0;
        for(int i=1;i<=l;i++){
            for(int j=1;j<=m;j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                    // We store the max value in len, and note the i,j values to print the string from this position in the matrix
                    if(len<t[i][j]){
                        len = t[i][j];
                        row = i;
                        col = j;
                    }
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
        
        // printing the substring , where we recorded the positions of the i,j.
        // from this position we go backward direction until we get 0 which prints our required string
        String s = "";
        while(t[row][col] != 0){
            if(a.charAt(row-1) == b.charAt(col-1)){
                s=s+a.charAt(row-1);
                row--;
                col--;
            }

        }
        String s2 = new StringBuilder(s).reverse().toString();
        System.out.println(s2);
        return len;

    }
    public static void main(String[] args) {

        //To get the longest palindrome substring in a String, simply reverse the string and pass it as a second input string to the lcs substring problem
        //This gives the common substring in a string after reversing, which is a palindrome, return the max length in the matrix for the mas length of the palindrome
        String l = "speepks";
        String m = "skpeeps";

        //This is the normal input for the LCS substring method above inputs are for Longest palindrome substring in a given string
		String a = "gabdpe";
		String b = "jabdfle";
		int la = a.length();
		int lb = b.length();
		System.out.println("common sub String is:" + LCString(l,m,la,lb));

	}
}
