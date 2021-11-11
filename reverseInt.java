import java.util.*;
public class reverseInt {
    public static int solution(Integer a) {
        if (a == 0) {
            return 0;
        }
        //use a list to store each elements of the revered integer
        List<Integer> result = new ArrayList<>();
        while(a > 0){
            int unit = a%10;
            if (unit == 0 && result.isEmpty()){//ignore the leading zeros not add to the list                    
                continue;
            }else{
                result.add(unit);
                System.out.println(unit);
            }
            a = a/10;
        }
        //convert the list to integer
        int reversedInt = 0;
        for (int i = 0; i <result.size();i++) {
            reversedInt =  reversedInt+result.get(i)*(int) Math.pow(10,result.size()-1-i);
            //System.out.println(result.get(i)*Math.pow(10,result.size()-1-i));
        }
        return reversedInt;
    }
    public static void main(String[] args) {
        Integer a = 4321;
        System.out.print(solution(a));

    }
}
