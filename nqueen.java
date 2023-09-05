public class nqueen {

    public static boolean isSafe(boolean[][]board,int sr,int sc,int[][]dir){
     int n=board.length;
     int m=board[0].length;
     
     for(int d=0;d<dir.length;d++){
     for(int rad=1;rad<Math.max(n,m);rad++){
            int r=sr+rad*(dir[d][0]);
            int c=sc+rad*(dir[d][1]);
            if(r>=0&&c>=0&&r<n&&c<m){
               if(board[r][c]==true)
               return false;
            }
            else
            break;

        }
      }
     return true;
    }

    public static int queen(boolean[][] board, int idx, String psf, int tnq) {
        int n = board.length;
        int m = board[0].length;

        if (tnq == 0) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        int[][]dir={{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (isSafe(board,r,c,dir)&&board[r][c]==false) {
                 board[r][c]=true;
                count += queen(board, 0, psf + "(" + r + ", " + c + ") ", tnq - 1);
                board[r][c]=false;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        int tnq = 4;

        System.out.println(queen(board, 0, "", tnq));
    }
}
