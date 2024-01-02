package MatrixChainMultiplication;

// Here we take a 2D array and store the recurion values instead of a variable
// The matrix initially stores the k=1th iteration values by comparing it with
// INT_MAX , we get min as k=1th value.
// When k=2th iteration starts, and is k=1 > k=2th value then, t[a,b] = k=2th value
// This kind of comparision and storing is repeated for each t[a,b] values
public class MCMmemoization {

    private static int MCMmemo(int[][] t,int[] p, int a,int b){
        if( a == b){
            return 0;
        }
        if( t[a][b] != -1){
            return t[a][b];
        }
        t[a][b] = Integer.MAX_VALUE;
        for (int k=a;k<b;k++){
            t[a][b] = Math.min(MCMmemo(t,p,a,k)+MCMmemo(t,p,k+1,b)+(p[a-1]*p[k]*p[b]),t[a][b]);
        }
        return t[a][b];
    }
    public static void main(String[] args){
        int[] arr = {4,2,3,1,3};
        int a = 1;
        int b = arr.length;

        int[][] t = new int[b][b];
        for(int c=0;c<b;c++){
            for(int d=0;d<b;d++){
                t[c][d] = -1;
            }
        }
        System.out.println("min multiplcatoins are: "+MCMmemo(t,arr, a, b-1));
        for(int c=0;c<b;c++){
            for(int d=0;d<b;d++){
                System.out.print(t[c][d]+" ");
            }
            System.out.println(" ");
        }
    }
    
}
