import java.util.*
public class sudoku {
    public static int[][] sudoku(int[][]matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] result = new int[r][c];
        int[] toStart = toFill(matrix);
        helper(matrix, toStart[0], toStart[1]);
        return result;

    }
    private static int[] toFill(int[][]m) {//find the position we need to fill
        int[] space = new int[] {-1,-1};//initialize to r = -1 & c = -1
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 0) {
                    space[0] = i;
                    space[1] = j;
                    break;
                }
            }
        }
        return space;


    }
    private static boolean helper(int[][]m, int r, int c) {
        //base case
        if (r == -1 && c == -1) {//all spaces are filled
            return true;
        }
        //recusion rule
        for (int i = 1; i <= 9; i++) {//at each level the space can be filled with 1-9 numbers
            if (isValid(m,r,c,i)) {//if it is valid to put i at this position
                m[r][c] = i;
                int[] next = toFill(m);
                boolean flag = helper(m, next[0], next[1]);
                if (flag) {
                    return true;
                }else{
                    m[r][c] = 0;
                }
            }else{
                continue;
            }

        }
        return false;
    }
    private static boolean isValid(int[][]m, int row, int col, int num) {
        int[][] newOne = m;
        newOne[row][col] = num;
        Map<Integer, Integer> occur = new HashMap<>();
        for (int i = 1; i <= 9; i++) {//create a hashmap with 1-9 number 
            occur.put(i,0);
        }
        //check the row
        for (int i = 0; i < newOne[row].length; i++) {
            if (occur.get(newOne[row][i]) == 0) {
                occur.put(newOne[row][i],1);
            }else{
                return false;
            }
        }
        //check column
        for (int i = 0; i < newOne.length; i++) {
            if (occur.get(newOne[i][col]) == 1) {
                occur.put(newOne[i][col],2);
            }else{
                return false;
            }
        }
        //check the 3by3 matrix
        int gapR = row%3;
        int gapC = col%3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (occur.get(newOne[i+row-gapR+1][j+col-gapC+1]) == 1) {
                occur.put(newOne[i+row-gapR+1][j+col-gapC+1],2);
            }else{
                return false;
            }
            }
            
        }
        return true;

    }
    
}
