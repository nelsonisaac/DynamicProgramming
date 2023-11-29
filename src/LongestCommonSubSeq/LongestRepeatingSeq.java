package LongestCommonSubSeq;

//Given a string "AABB", return the length of the longest subseq which is possible from the given string
// i.e., s1 = AB , s2 = AB output : 2 is the length of longestRapeatingseq
// Here the indices of the AB should be different in s1 and s2 w.r.t the original string
// s1 = AB (0,2 are the indices of AB in given string)
// s2 = AB (1,3 are the indices of AB in given string)
// take str = "AAB", here output = 1 i.e., s1 = A, s2 = A, it cannot be AB(0,2) and again AB(1,2) which has same indices of B in both s1,s2 so cannot take B
public class LongestRepeatingSeq {

    private static int LRS(String s,int n){
        int[][] t = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            t[i][0] = 0;
        }
        for(int j=0;j<=n;j++){
            t[0][j] = 0;
        }

        // here we need to get the values where the characters are equal and also they shouldn't be in same positions(index) i!=j
        // By this we are getting the count of particular char being at diff index
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == s.charAt(j-1) && i!=j){
                    t[i][j] = 1+t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[n][n];
    }

    public static void main(String[] args){
        String s = "AABDDEFFGJJ";
        int n = s.length();
        System.out.println("the longest repeating seq is: "+LRS(s,n));
    }
}
