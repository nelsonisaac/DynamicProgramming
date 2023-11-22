package LongestCommonSubSeq;

//This method is using Memoization, by storing recursive values in a 2D array
public class LongestCommonSubSeqMem {

	private static int LCSM(String a, String b, int la, int lb,int[][] t){
		if(la ==0 || lb == 0){
			return t[la][lb] = 0;
		}
        if(t[la][lb] != -1){
            return t[la][lb];
        }
		if(a.charAt(la-1) == b.charAt(lb-1)){
			return t[la][lb] = 1+LCSM(a,b,la-1,lb-1,t); 
		}else{
			return t[la][lb] = Math.max(LCSM(a,b,la-1,lb,t), LCSM(a,b,la,lb-1,t)) ;
		}
        // return t[la][lb];
	}


    public static void main(String[] args) {
		String a = "abc";
		String b = "abe";
		int la = a.length();
		int lb = b.length();

        int[][] t = new int[la+1][lb+1];
        for(int i=0;i<=la;i++){
            for(int j=0;j<=lb;j++){
                t[i][j] = -1;
            }
        }
		System.out.println("common sub seq is:" + LCSM(a,b,la,lb,t));
        for(int i=0;i<=la;i++){
            for(int j=0;j<=lb;j++){
                System.out.print(t[i][j]+" ");
            }
            System.out.println(" ");
        }
	}
}
