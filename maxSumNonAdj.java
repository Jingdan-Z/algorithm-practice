// Example:
// maxNonAdjacentSum([3,4,1,1]) -> 5
// maxNonAdjacentSum([2,1,2,7,3]) -> 9


public class maxSumNonAdj {
    public static void main(String[] args) throws Exception {
       int[] test = new int[]{3,4,5,1,15};
       int maxSum = maxNonAdj(test);
       System.out.print(maxSum); //expected 23
    }
    public static int maxNonAdj(int[] array) {
       int[] A = new int[array.length]; //A[i] represents the maximum sum including array[i]
       if (array == null || array.length == 0) {
           return 0;
       };
       
       if (array.length == 1) {       //A[] = {3}
               return array[1];
        }
       if (array.length == 2) {
               return array[1]>array[0]? array[1] : array[0];
       }; //A[] = {3,4}
        
       A[0] = array[0];
       A[1] = array[1]>array[0]? array[1] : array[0];
       for (int i = 2; i < array.length; i++) {
           //induction rule
           // if i-1 is not included in the current optimal subset
           if (A[i-1] == A[i-2]) {              
               A[i] = A[i-1] + array[i];
           }else{
               if (A[i-2]+array[i] > A[i-1]){          //A[] ={3,4,4,5} ==> 5
                   A[i] = A[i-2]+array[i];
               }else{
                   A[i] = A[i-1];
               }
           }
       }
       return A[array.length - 1];

       }
}
