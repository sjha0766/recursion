import java.util.Arrays;

public class Main {

    public static void Display(int[][]arr){
        for(int[]a:arr){
            for(int e:a)
            System.out.print(e+" ");
            System.out.println();
        }
        
    }

    public static void arraySort(int[][]arr){
        
        Arrays.sort(arr,(a,b)->{
            int sum1=0;
            int sum2=0;
          for(int e:a){
           sum1+=e;
          }
          for(int e:b){
            sum2+=e;
          }
          if(sum1>sum2){
            return a[0];
          }
          else 
          return b[0];
          
        });
     Display(arr);
    }
    public static void main(String[] args) {
      int[][]arr={{1,4,5},{1,3,-3},{4,6,-5},{3,7,1}};  
      arraySort(arr);

    }
}
