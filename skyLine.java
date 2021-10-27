//question:
//given a list of building in form (left,right,height)
//return a skyline of a list of (x-axis, height) to indicate the next point of change of height
//        2 2 2
//  1 1 1 2 2 2 1 1
//  1 1 1 2 2 2 1 1 
//  1 2 3 4 5 6 7 8
//output: {(1,2),(4,3),(7,2),(9,0)}
import java.util.*;
public class skyLine {
    public static List<int[]> skyline(List<int[]> buildings) {
        //create an array which stores [left/right] and buildings height
        int[][] heights = new int[buildings.size()*2][2];
        int i = 0;
        for (int[] building : buildings) {
            heights[i][0] = building[0]; //left
            heights[i][1] = building[2]; //height
            heights[i+1][0] = building[1]; //right
            heights[i+1][1] = building[2]; //height
            i+=2;
        }
        Arrays.sort(heights, new Comparator<int[]>() { //use the left or right to sort the heights
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        List<int[]> result = new ArrayList<>();
        for (int j = 0; j < heights.length - 1; j++) {
            int h = heights[j][1];
            if (j == 0) {
                result.add(heights[0]);
            }
            int next = heights[j+1][1];//next building
            if (h < next) {
                result.add(heights[j+1]);
            }else if (h == next) {
                continue;
            }else{//h > next
                int k = findNextHeights(heights,j);//find the next one higher than or equal to h
                System.out.println(k);
                if (heights[k][1] > h) {
                    result.add(heights[k]);
                    j = k;//since btw j and k are the ones smaller than i and k
                }else if (k == 0) {//not found
                    result.add(heights[j+1]);
                    j +=1;
                }else{
                    j = k; 
                }
            }
            }
            result.add(new int[] {heights[heights.length-1][0]+1,0});
            return result;

        }
        private static int findNextHeights(int[][]heights, int index) {
            int h = heights[index][1];
            int next = 0;
            for (int i = index+1; i < heights.length; i++) {
                if (heights[i][1] >= h) {
                    next = i;
                }
            }
            return next;//not found
        }
        public static void main(String[] args) {
            List<int[]> buildings = new ArrayList<int[]>();
            buildings.add(new int[]{1,3,2});
            buildings.add(new int[]{3,6,3});
            buildings.add(new int[]{5,6,6});
            List<int[]> result = skyline(buildings);
            result.forEach(System.out::println);
            for(int i=0;i<result.size();i++){
                System.out.println(Arrays.toString(result.get(i)));
            } 
            
        }

        
    }
    

