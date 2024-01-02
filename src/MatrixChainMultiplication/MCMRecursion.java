package MatrixChainMultiplication;

public class MCMRecursion {
    
    private static int MCM(int[] p,int r,int s){
        if( r == s){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k=r ; k<s ;k++){
            int sum = MCM(p,r,k) + MCM(p,k+1,s) + p[r-1]*p[k]*p[s];
            if(sum<min){
                min = sum;
            }
        }
        return min;
    }
    public static void main(String[] args)
    {
        int[] p = {4,2,3,1,3};
        int s = p.length;
        System.out.println(MCM(p, 1, s-1));
    }
    
}
