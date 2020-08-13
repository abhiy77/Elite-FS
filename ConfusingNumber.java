package Elite;
//30/12/2019
import java.util.*;
class ConfusingNumber{

    public static boolean isSafe(String str , Map<Integer , String> map){
        if(reverseNum(str,map).equals(str))  return false;
        return true;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer , String> map = new HashMap<>();
        map.put(0,"0"); map.put(1,"1"); map.put(6,"9"); map.put(8,"8"); map.put(9,"6");
        
        int target = sc.nextInt() ,flag = 0;
        int conf_nums[] = {0,1,6,8,9};

        if(target < 6) System.out.println(0);
        else if(6 <= target && target < 9) System.out.println(1);
        else if(target == 9) System.out.println(2);
        else{
            int count = 2;
            Queue<String> queue = new LinkedList<>();

            queue.add(Integer.toString(1));
            queue.add(Integer.toString(6));
            queue.add(Integer.toString(8));
            queue.add(Integer.toString(9));

            while(flag != 1){
                String num1 = queue.poll();

                for(int i = 0 ; i < 5 ; i++){
                    String num2 = num1;
                    num2 += conf_nums[i];

                    if(Integer.parseInt(num2) <= target){
                        if(isSafe(num2,map)){
                            count++;
                        }
                            queue.add(num2);
                    }
                    else{
                        flag = 1;
                        break;
                    }
                }
            }

            System.out.println(count);
        }
        sc.close();
    }
    
    public static String reverseNum(String str , Map<Integer , String> map){
        int num = Integer.parseInt(str);
        String rev = "";
        while(num>0){
            rev += map.get(num % 10);
            num /= 10;
        }
        return rev;
    }
}