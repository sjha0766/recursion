package HashMap;

public class basic1 {
    
    public static int heightOfTree(int[]arr,int idx){
       if(idx>=arr.length)
       return -1;
        
        int lh=heightOfTree(arr, 2*idx+1);
        int rh=heightOfTree(arr, 2*idx+2);

        return Math.max(lh,rh)+1;
    }
    public static void main(String[] args) {
       int[]arr={10,20,30,-2,-3,-4,5,6,7,8,9,22,11,13};
       
      int ans= heightOfTree(arr,0);

      System.out.println(ans);
    }
}
