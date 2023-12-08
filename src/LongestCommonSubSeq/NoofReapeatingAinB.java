package LongestCommonSubSeq;

public class NoofReapeatingAinB {
    private static int ReapeatingAinB(String a, String b, int l, int m){
        if((l==0 && m==0) || m == 0){
            return 1;
        }
        if(l==0){
            return 0;
        }
        // We iterate through each character, from right to left.
        // If characters are equal then we get 2 cases (l-1,m-1) and (l-1,m) so that the character 'm' subtracted in (l-1,m-1) is also included in the next iteration in (l-1,m) because l might contain that eliminated character repeatedly so to include that we take 2 cases
        // We start with l>m, but as iteration progresses, we subtract l-1,m-1 only when equal, so evetually it reaches l==0&&m==0 , so return 1.
        // the same aplies to m=0, that means all the characters in 'm' are iterated since we decrease 'm' only if there is an equal character in 'l'. therfore return 1 when m==0;
        // when l=0, it means eventually nothing matches (not equal to case) so return 0.
        if(a.charAt(l-1) == b.charAt(m-1)){
            return (ReapeatingAinB(a, b, l-1, m-1) + ReapeatingAinB(a, b, l-1, m));
        }else{
            return ReapeatingAinB(a, b, l-1, m);
        }
    }

    public static void main(String[] args){
        String a = "geeksforgeeks";
        String b = "gks";
        int l = a.length();
        int m = b.length();

        System.out.println(ReapeatingAinB(a, b, l, m));
    }
}
