import java.util.*;
public class largestRange {
    public static int[] solution(int[]input) {
        //sort the int array
        Arrays.sort(input);
        int i = 0;
        int j = 1;
        int left = 0;
        int right = 0;
        int range = Integer.MIN_VALUE;//the max range
        int count = 1; //cur range
        while (j < input.length) {
            if (input[j] == input[j-1]+1 || input[j] == input[j-1] ) {//i and j are continous
                j++;
                count++;
            }else{
                
                i = j;
                j++;
                count = 1;//reset count to 1
            }
            if (range < count) {//need to update
                range = Math.max(range,count); //update the largest global range
                left = i;
                right = j-1;
            }
            
        }
        int[]result = new int[2];
        result[0] = input[left];
        result[1] = input[right];
        return result;
    }
    public static void main(String[] args) {
        int[] input = new int[]{1,11,4,4,3,5,2,18,12,13,14,15,16,17,19,20,19};
        int[]result = solution(input);
        System.out.println(Arrays.toString(result));
    }
    
}
