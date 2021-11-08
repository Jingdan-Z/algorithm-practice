import java.util.*;
public class wordSearch {
    //Requirements: horizontally and vertically not more than once in a word
//output: list of words
//all words are unique
//idea: check each word whether it is contained in the board and return the words in the result if it is

public static List<String> findWords(char[][] board, String[] words) {
    List<String> result = new ArrayList<>();
    
    for(String str : words) {//check each word
        if (board.length * board[0].length < str.length()) {
            continue;
        }
        if (boardContains(board,str)) {
            result.add(str);
        }
    }
    return result;
}
private static boolean boardContains(char[][]board, String str) {//check whether word is in the board
    //use for for loop to find the first char in the board
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            //Set<Character> visited = new HashSet<>();
            if (board[i][j] == str.charAt(0)) {//the first char found
                //visited.add(board[i][j]);
               if (helper(board, str, i, j, 1)) {
                   return true;
               }
            }
        }
    }
    return false;
    
}
private static boolean helper(char[][]board, String str, int row, int col, int index) {
    Set<int[]> visited = new HashSet<>();
    visited.add(new int[]{row,col});
     //change to char not in lowercase letter to indicate it has been visited
    //base case
    if (index == str.length()) {
        return true;
    }
    if (row+1 < board.length && !visited.contains(new int[]{row+1,col}) && board[row+1][col]== str.charAt(index)) {//down
        return helper(board, str, row+1, col, index+1);
    }
    if (col+1 < board[0].length && !visited.contains(new int[]{row,col+1}) &&board[row][col+1] == str.charAt(index)) {//right
        return helper(board, str, row, col+1, index+1);
    }
    if (row-1 >= 0 && !visited.contains(new int[]{row-1,col}) && board[row-1][col] == str.charAt(index)) {//up
        return helper(board, str, row-1, col, index+1);
    }
    if (col-1 >= 0 && !visited.contains(new int[]{row,col-1}) &&board[row][col-1] == str.charAt(index)) {//left
        return helper(board, str, row, col-1, index+1);
    }
    return false;
    
}
public static void main(String[] args) {
    char[][] board = new char[][] {{'a','a'}};

    String[] words = {"aaa"};
    List<String> result = findWords(board, words);
    System.out.println(result);
}
}


