//question: remove all island that do not connect with the boundary
import java.util.*;
public class romoveIsland {
    public static int[][] removeIsland(int[][]matrix) {
        //int[][] result = new int[matrix.length][matrix[0].length];
        int[] island = findBoundaryIsland(matrix);
        Deque<int[]> stack = new ArrayDeque<>();//dfs use to find all island points
        while(island != null) {//still has island not find
            stack.offerFirst(island);
            //boundary = isBoundary(island, matrix);//set the flag it is a boundary point
            while(!stack.isEmpty()) {
                int[] cur = stack.pollFirst();
                matrix[cur[0]][cur[1]] = 2; //2 represents it is a boundary island;
                List<int[]> neighbors = findNeighbors(matrix,cur);
                for (int[] neighbor : neighbors) {
                    stack.offerFirst(neighbor);
                }
            }
            island = findBoundaryIsland(matrix);

        }
        int[] inland = findInnerIsland(matrix);
        while(inland != null) {//still has island not find
            stack.offerFirst(inland);
            while(!stack.isEmpty()) {
                int[] cur = stack.pollFirst();
                matrix[cur[0]][cur[1]] = 0; //2 represents it is a boundary island;
                List<int[]> neighbors = findNeighbors(matrix,cur);
                for (int[] neighbor : neighbors) {
                    stack.offerFirst(neighbor);
                }
            }
            inland = findInnerIsland(matrix);

        }
        return matrix;
    }
   private static int[] findBoundaryIsland(int[][]matrix) {
       
       for (int i = 0; i < matrix[0].length; i++) {
           if (matrix[0][i] == 1) {
               return new int[]{0,i};
           }else if (matrix[matrix.length-1][i] == 1) {
            return new int[]{matrix.length-1,i};
           }
       }
       for (int i = 0; i < matrix.length; i++) {
        if (matrix[i][0] == 1) {
            return new int[]{i,0};
        }else if (matrix[i][matrix[0].length-1] == 1) {
         return new int[]{i,matrix[0].length-1};
        }
    }
    return null;
}
    private static int[] findInnerIsland(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    private static List<int[]> findNeighbors(int[][]matrix, int[]cur) {
        List<int[]> neighbors = new ArrayList<>();
        if (cur[0]-1 >= 0 && matrix[cur[0]-1][cur[1]] == 1) {
            neighbors.add(new int[]{cur[0]-1,cur[1]});
        }
        if (cur[0]+1 < matrix.length  && matrix[cur[0]+1][cur[1]] == 1) {
            neighbors.add(new int[]{cur[0]+1,cur[1]});
        }
        if (cur[1]+1 < matrix[0].length && matrix[cur[0]][cur[1]+1] == 1 ) {
            neighbors.add(new int[]{cur[0],cur[1]+1});
        }
        if (cur[1]-1 >= 0 && matrix[cur[0]][cur[1]-1] == 1) {
            neighbors.add(new int[]{cur[0],cur[1]-1});
        }
        return neighbors;
    }
    public static void main(String[] args) {
        int[][] graph = new int[3][3];
        graph[0][0] = 0;
        graph[0][1] = 0;
        graph[0][2] = 0;
        graph[1][0] = 0;
        graph[2][0] = 1;
        graph[1][1] = 1;
        graph[1][2] = 0;
        graph[2][1] = 0;
        graph[2][2] = 1;
        int[][] result = removeIsland(graph);
        System.out.println(result.length);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
       

    }
   
    }
    

