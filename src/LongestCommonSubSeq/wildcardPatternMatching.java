package LongestCommonSubSeq;

public class wildcardPatternMatching {

    private static void patternMatch(String a, String b, int l, int m){
        int i=l,j=m;
        char[] p = a.toCharArray();
        char[] q = b.toCharArray();
        while(i>0 && j>0){
            if((p[i-1] == q[j-1]) || q[j-1] == '?' ){
                i--;
                j--;
            }
            if(q[j-1] == '*'){
                j = j-1;
                i=j;
            }
        }
    }
    public static void main(String[] args){
        String a = "baaabab";
        String b = "ba*a?";
        int l = a.length();
        int m = b.length();

        patternMatch(a,b,l,m);
    }
}
