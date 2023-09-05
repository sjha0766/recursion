import java.util.ArrayList;

public class question {

    public static int permutationInfiCoin(int[] coins, String psf, int target) {

        if (target == 0) {
            System.out.println(psf + ".");
            return 1;
        }

        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            if (target - coins[i] >= 0) {
                count += permutationInfiCoin(coins, psf + coins[i] + ", ", target - coins[i]);
            }
        }

        return count;
    }

    public static int combiInfiCoin(int[] coins, String psf, int target, int idx) {
        if (target == 0) {
            System.out.println(psf + ".");
            return 1;
        }

        int count = 0;
        for (int i = idx; i < coins.length; i++) {
            if (target - coins[i] >= 0) {
                count += combiInfiCoin(coins, psf + coins[i] + ", ", target - coins[i], i);
            }
        }

        return count;
    }

    public static int permutationSingfiCoin(int[] coins, String psf, int target, boolean[] vis) {
        if (target == 0) {
            System.out.println(psf + ".");
            return 1;
        }

        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            if (target - coins[i] >= 0 && vis[i] == false) {
                vis[i] = true;
                count += permutationSingfiCoin(coins, psf + coins[i] + ", ", target - coins[i], vis);
                vis[i] = false;
            }
        }

        return count;
    }

    public static int combiSingCoin(int[] coins, String psf, int target, int idx) {
        if (target == 0) {
            System.out.println(psf + ".");
            return 1;
        }

        int count = 0;
        for (int i = idx; i < coins.length; i++) {
            if (target - coins[i] >= 0) {

                count += combiSingCoin(coins, psf + coins[i] + ", ", target - coins[i], i + 1);

            }
        }

        return count;
    }

    public static int permutationInfiCoin_sub(int[] coins, int tar, int idx, String psf, ArrayList<String> ans) {
        if (tar == 0 || idx == coins.length) {
            if (tar == 0) {
                ans.add(psf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0) {
            count += permutationInfiCoin_sub(coins, tar - coins[idx], 0, psf + coins[idx] + "", ans);
            count += permutationInfiCoin_sub(coins, tar, idx + 1, psf, ans);
        }

        return count;
    }

    public static int combiInfiCoin_sub(int[] arr, int tar, int idx, String psf, ArrayList<String> ans) {
        if (tar == 0 || idx == arr.length) {
            if (tar == 0) {
                ans.add(psf);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if (tar - arr[idx] >= 0) {
            count += combiInfiCoin_sub(arr, tar - arr[idx], idx, psf + arr[idx] + "", ans);
            count += combiInfiCoin_sub(arr, tar, idx + 1, psf + "", ans);
        }

        return count;
    }

    public static int permutationSingfiCoin_sub(int[] arr, int tar) {
        return 0;
    }

    public static int combiSingCoin_sub(int[] arr, int tar, int idx, String psf, ArrayList<String> ans) {
        if (tar == 0 || idx == arr.length) {
            if (tar == 0) {
                ans.add(psf);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if (tar - arr[idx] >= 0) {
            count += combiSingCoin_sub(arr, tar - arr[idx], idx + 1, psf + arr[idx] + "", ans);
            count += combiSingCoin_sub(arr, tar, idx + 1, psf + "", ans);
        }

        return count;

    }

    public static int permutation(String str, String psf, ArrayList<String> list, int idx) {
        if (idx == str.length()) {
            list.add(psf);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < str.length(); i++) {

            count += permutation(str, psf + str.charAt(i), list, i + 1);

        }

        return count;
    }

    public static int queenPermu(int tnq, int tnb, int noq, int idx, String psf, boolean[] vis) {
         
        if(noq==tnq){
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for (int i = 0; i<tnb; i++) {
            if (vis[i] == false) {
                vis[i]=true;
                count += queenPermu(tnq, tnb,noq+1, 0 , psf + "( " + "b" + i + "," + "q" + noq + " )", vis);
                vis[i]=false;
            }

        }

        return count;
    }

    public static int queenCombi(int tnq, int tnb, int noq, int idx, String psf) {
        if (noq == tnq || idx == tnb) {
            if (noq == tnq) {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        count += queenCombi(tnq, tnb, noq + 1, idx + 1, psf + "( " + "b" + idx + "," + "q" + noq + " )");
        count += queenCombi(tnq, tnb, noq, idx + 1, psf);

        return count;
    }

    public static int queenPermu_2D(boolean[][] vis,int tnq,int nob,String psf) {
        
        if(tnq==0){
            System.out.println(psf);
            return 1;
        }
        int n=vis.length;
        int m=vis[0].length;
        int count = 0;
        for (int i = 0; i<n*m; i++) {
              int r=i/m;
              int c=i%m;
            if (vis[r][c]== false) {
                vis[r][c]=true;
                count += queenPermu_2D(vis, tnq-1,0, psf + "( " + r + "," +  c + ")");
                vis[r][c]=false;
            }

        }

        return count;  
    }

    public static int queenCombi_2D(int tnq, int tnb,int nob,String psf,int len) {
        
        if ( tnq==0 ||  len==nob) {
            if (tnq==0) {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }
       
        int count=0;
        int r=nob/tnb;
        int c=nob%tnb;
        count+=queenCombi_2D(tnq-1,tnb,nob+1,psf+"("+r+","+c+")",len);
        count+=queenCombi_2D(tnq,tnb,nob+1,psf+"",len);
        

        return count;
        
    }

    public static void main(String[] args) {
        // int[] coins = { 2, 3, 5, 7 };
        // int tar = 10;
        // int idx = 0;

        // boolean[]vis=new boolean[coins.length];

        // System.out.println(combiSingCoin(coins, "", tar,idx));
        // String str = "ABC";
        // boolean[] vis = new boolean[str.length()];
        // ArrayList<String> list = new ArrayList<>();

        int tnq = 3;
        int n =4;
        // int len=n*n;
        

        boolean[][] vis = new boolean[n][n];


        System.out.println(queenPermu_2D( vis,tnq, 0, ""));

    }
}
