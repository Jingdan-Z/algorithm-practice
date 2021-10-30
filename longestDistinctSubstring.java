import java.util.*;
public class longestDistinctSubstring {
    public static String longestString(String input) {
        //corner case
        if (input == null || input.isEmpty()) {
            return input;
        }
        //create a hashmap to record the char in the substring
        //key: char value: index of char in the input
        Map<Character,Integer> occurs = new HashMap<>();
        char[] str = input.toCharArray();
        int len = str.length;
        int maxLen = 0;
        int left = 0;
        int right = 0;
        int i = 0;//start of the substring
        int j = 0;//end of the substring
        while(i < len && j <len){
            if (occurs.get(str[j]) == null) {//not in the substring already
                occurs.put(str[j],j);
                j++;
            }else{//occurs before
                int index = occurs.get(str[j]);
                i = i > index+1 ? i : index+1; //exclude char before and including i
                occurs.put(str[j],j);
                j++;
            }
            maxLen = Math.max((j-i+1), maxLen);
                if (maxLen == j-i+1) {
                    right = j;
                    left = i;
                }
        }
        return input.substring(left,right);
    }
    public static void main(String[] args) {
        String input = new String("abcdcefbg");
        String result = longestString(input);
        System.out.println(result);
    }
}
