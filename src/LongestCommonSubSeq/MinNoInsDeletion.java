package LongestCommonSubSeq;

//This is same as LCS, here we get the common seq by using LCS method

public class MinNoInsDeletion {

    private static int minInsDel(String s1,String s2,int l,int m){

        int[][] t = new int[l+1][m+1]; 
        String s = "";

        //Initialization for i=0 or j=0
        for(int i=0;i<=l;i++){
            t[i][0] = 0;
        }
        for(int j=0;j<=m;j++){
            t[0][j] = 0;
        }

        //Algo for matrix with longest common seq count values
        for(int i=1;i<=l;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        return t[l][m];
/* 
        // to get the string which is common by using back tracking from bottom to top
        // We simply do the reverse tracking of what LCS did above and print only the common String
        int i=l,j=m;
        while( i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                s=s+s1.charAt(i-1);
                i--;
                j--;
            }else{
                if(t[i-1][j]>t[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }

        } */


        //Taking the common out of both the strings gives us the min no of insertions and deletions required to convert s1 to s2


    }

    public static void main (String[] args){
        String s1 = "heap";
        String s2 = "pea";
        int l = s1.length();
        int m = s2.length();

        int len = minInsDel(s1, s2,l,m);
        int ins = m-len;
        int del = l-len;
        System.out.println("to convert "+s1+" to "+s2+" we need");
        System.out.println("min no. of deletions= "+ del);
        System.out.println("min no. of insertions= "+ ins);
    }
    
}
