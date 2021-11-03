import java.util.*;
public class sameLinePoints {
    public static int maxPoints(int[][]input) {
        Map<Integer,Integer> slopes = new HashMap<>(); //key: slope value: number of points
        int globalMax = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            int sameX = 1;
            for (int j = i+1; j < input.length; j++){
                //get the slope
                //case 1 : has a slope case 2: no slope get perpendicular to the x axis
                if (input[i][0] == input[j][0]) {
                    sameX++;
                    globalMax = Math.max(sameX,globalMax);
                }else{
                    int k = (input[i][1] - input[j][1]) / (input[i][0] - input[j][0]);
                
                Integer count = slopes.get(k);
                if (count != null) {//has points on the line before
                    count += 1;
                    slopes.put(k, count);
                    globalMax = Math.max(globalMax,count);
                }else{//add to the hashmap
                    slopes.put(k,2); //i and j on the same line
                }
                }
            }
            slopes.clear();//clear the hashmap

        }
        return globalMax;
    }
    public static void main(String[] args) {
        int[][]input = new int[][]{{1,1},{1,2},{1,3},{4,0}};
        int result = maxPoints(input);
        System.out.println(result);
    }
}
