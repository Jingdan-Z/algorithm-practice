import java.util.*;
public class switchString{
    public static boolean solution (String str1, String str2) {
        //corner case
        if (str1.length() != str2.length()) {
            return false;
        }
        //use i to traverse str1 and j to traverse str2
    int i = 0;
    int j = 0;
    while(j < str2.length() && i < 2*str1.length()) {
        int position = i % str1.length();
        if (str1.charAt(position) == str2.charAt(j)) {
            i++;
            j++;
        }else{//if i and j is not the same char
             //we need to reset j
                 j =0;
                 i++;     
        }
    }
    //post-processing
    if (j < str2.length()) {//a2 has not been fully satisfied
       return false;
    }else{
        return true;
        }
}
public static void main(String[] args) {
    String str1 = "eftga";
    String str2 = "aeftg";
    System.out.print(solution(str1,str2));
    
}
}