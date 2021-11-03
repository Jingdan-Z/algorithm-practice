import java.util.*;
public class longestSub {
    public static String longestSubsequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][]dp = new int[len1+1][len2+1]; 
        //dp[i][j] represents the longest subsequence 
        //given i excluding i char from str 1 and j excluding j char from str2
        //base case: dp[i][0] = 0 and dp[0][i] = 0
        for (int i = 1; i < len1+1; i++) {
            for (int j = 1; j < len2+1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;//one more char add to the common subsequence
                }else{// not same char
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
           
        }
        int longestLen = dp[len1][len2];
        System.out.println(longestLen);
        //post-processing to find the longest common subsequence
        //start from (len1,len2) point
        char[] result = new char[longestLen];
        int r = len1;
        int c = len2;
        int k = longestLen-1;
        while (k >= 0) {  
            if (str1.charAt(r-1) == str2.charAt(c-1)) {
                result[k] = str1.charAt(r-1);
                 r= r-1;
                 c= c-1;
                 k--;
            }else{
                if (dp[r-1][c] > dp[r][c-1]) {
                    r = r-1;
                    
                }else{
                    c = c-1;
                }
                
            }
        }
        String solution = Arrays.toString(result);
        return solution;
        


    }
    public static void main(String[] args) {
        String str1 = "abacda";
        String str2 = "baaf";
        String common = longestSubsequence(str1, str2);
        System.out.println(common);
    }
}
