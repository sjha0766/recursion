import java.util.ArrayList;

public class Basic {

    public static void pirntInc(int a, int b) {
        if (a > b) {
            return;
        }
        System.out.println(a);
        pirntInc(a + 1, b);
    }

    public static void printDec(int a, int b) {
        if (a > b) {
            return;
        }
        printDec(a + 1, b);
        System.out.println(a);
    }

    public static void printIncDec(int a, int b) {

        if (a > b) {
            return;
        }
        System.out.println(a);
        printIncDec(a + 1, b);
        System.out.println(a);
    }

    public static void OodEven(int a, int b) {
        if (a > b) {
            return;
        }

        if (a % 2 != 0) {
            System.out.println(a);
        }
        OodEven(a + 1, b);
        if (a % 2 == 0) {
            System.out.println(a);
        }
    }

    public static ArrayList<String> mazePath(int sr, int sc, int dr, int dc, int[][] dir, String[] dirS) {

        if (sr == dr - 1 && sc == dc - 1) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> myans = new ArrayList<>();
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if (r >= 0 && c >= 0 && r < dr && c < dc) {
                ArrayList<String> rans = mazePath(r, c, dr, dc, dir, dirS);
                for (String s : rans) {
                    myans.add(dirS[d] + s);
                }
            }
        }
        return myans;

    }

    public static int mazePath2(int sr, int sc, int dr, int dc, ArrayList<String> ans, String psf, int[][] dir,
            String[] dirS) {

        if (sr == dr - 1 && sc == dc - 1) {
            ans.add(psf);
            return 1;
        }

        int count = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if (r >= 0 && c >= 0 && r < dr && c < dc) {
                count += mazePath2(r, c, dr, dc, ans, psf + dirS[d], dir, dirS);
            }
        }
        return count;
    }

    public static class Pair {
        String str;
        int len;

        Pair() {
            this.str = "";
            this.len = (int) 1e9;
        }
    }

    public static Pair maxMazePath(int[][] maze, int sr, int sc, int dr, int dc, int[][] dir, String[] dirS,
            String psf) {
        if (sr == dr - 1 && sc == dc - 1) {
            Pair bres = new Pair();
            bres.len = psf.length();
            bres.str = psf;
            return bres;
        }
        maze[sr][sc] = 0;
        Pair myans = new Pair();
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if (r >= 0 && c >= 0 && r < dr && c < dc && maze[r][c] != 0) {
                Pair rans = maxMazePath(maze, r, c, dr, dc, dir, dirS, psf + dirS[d]);
                if (rans.len > myans.len) {
                    myans.len = rans.len;
                    myans.str = rans.str;
                }
            }
        }
        maze[sr][sc] = 1;
        return myans;
    }

    public static Pair minMazePath(int[][] maze, int sr, int sc, int dr, int dc, int[][] dir, String[] dirS,
            String psf) {
        if (sr == dr - 1 && sc == dc - 1) {
            Pair bres = new Pair();
            bres.len = psf.length();
            bres.str = psf;
            return bres;
        }
        maze[sr][sc] = 0;
        Pair myans = new Pair();
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if (r >= 0 && c >= 0 && r < dr && c < dc && maze[r][c] != 0) {
                Pair rans = minMazePath(maze, r, c, dr, dc, dir, dirS, psf + dirS[d]);
                if (rans.len < myans.len) {
                    myans.len = rans.len;
                    myans.str = rans.str;
                }
            }
        }
        maze[sr][sc] = 1;
        return myans;
    }
    // public ArrayList<Integer> mazePathMulti(int sr,int sc,int dir, int dc){

    // }

    // public int mazePathMulti2(int sr,int sc,int dr,int dc,
    // ArrayList<Integer>ans){

    // }

    public static int equSet(int[] arr, int idx, int sum1, int sum2, String set1, String set2) {
        if (idx == arr.length) {
            if (sum1 == sum2) {
                System.out.println(set1 + "=" + set2);
                return 1;
            }
            return 0;
        }

        int count = 0;
        count += equSet(arr, idx + 1, sum1 + arr[idx], sum2, set1 + arr[idx] + " ", set2);
        count += equSet(arr, idx + 1, sum1, sum2 + arr[idx], set1, set2 + arr[idx] + " ");

        return count;
    }

    public static int permutation(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }
        char prev = '$';
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch1 = str.charAt(i);
            if (ch1 != prev) {
                count += permutation(str.substring(0, i) + str.substring(i + 1), ans + ch1);
            }
            prev = ch1;
        }
        return count;
    }

    public static void main(String[] args) {

        int n = 3;
        int m = 3;
        int[][] maze = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };

        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        String[] dirS = { "R", "D", "L", "U" };
        int[] arr = { 10, 20, 30, 40, 45, 54, 1 };

        String str = "aaa";

        System.out.println(permutation(str, ""));

    }
}