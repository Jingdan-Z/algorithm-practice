/*question: find the size of the rive
1 represents the river and the river can expand from down/up/left/right side
return the size of all rivers in the graph
example:
1 1 0
1 1 0
1 0 1
return: [5,1] river with size 5 and 1 in the graph
*/
/*high level idea: use graph seearch algorithms ==> BFS (queue) or DFS (stack)
add all neighbors to the stack and find the size of one lake
notice: remember to record the visited position
*/
import java.util.*;
public class riverSize {
    static class position{
        int col;
        int row;
        public position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static List<Integer> river(int[][]graph) {
        List<Integer> result = new ArrayList<>();
        Deque<position> stack = new ArrayDeque<>();
        position start = findOne(graph);//find one in the graph as a starting point
        //corner case
        if (start == null) {
            return result;
        }
        while(start != null) {
            stack.offerFirst(start);//indicated it is visited
            graph[start.row][start.col] = 0;
            int size = 0;
            while (!stack.isEmpty()) {
                position cur = stack.pollFirst();
             
                size++;
                List<position> neighbors = findNeighbors(graph,cur);
                    if (!neighbors.isEmpty()) {//has neighbors
                        for(position point : neighbors) {//put all neighbors into the stack
                                stack.offerFirst(point);
                                graph[point.row][point.col] = 0;
                            }
                    }else{//no neighbor anymore
                        continue;
                    }
            }
            result.add(size);
            start = findOne(graph);//next one to start
        }
    return result;


    }
    private static position findOne(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == 1) {
                    position result = new position(i,j);
                    return result;
                }
            }
        }
        return null;


    }
    private static List<position> findNeighbors(int[][]graph, position cur) {
        List<position> result = new ArrayList<>();
        int row = cur.row;
        int col = cur.col;
        if (row-1 >= 0 && graph[row-1][col] == 1) {
            result.add(new position(row-1, col));
        } 
        if (col-1 >= 0 && graph[row][col-1] == 1) {
            result.add(new position(row, col-1));
        }
        if (row+1 < graph.length && graph[row+1][col] == 1) {
            result.add(new position(row+1, col));
        }
        if (col+1 < graph.length && graph[row][col+1] == 1) {
            result.add(new position(row, col+1));
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] graph = new int[3][3];
        graph[0][0] = 0;
        graph[0][1] = 1;
        graph[0][2] = 0;
        graph[1][0] = 1;
        graph[2][0] = 1;
        graph[1][1] = 1;
        graph[1][2] = 0;
        graph[2][1] = 0;
        graph[2][2] = 1;
        List<Integer> result = river(graph);
        System.out.println(result);

    }
}
