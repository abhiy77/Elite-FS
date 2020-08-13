package Elite;
import java.util.*;

class Emails{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        int emails = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<emails;i++){
            String input = sc.nextLine();
            StringBuffer temp = new StringBuffer();
            int j = 0;
            while(input.charAt(j) != '@'){
                if(Character.isLetterOrDigit(input.charAt(j))){
                    temp.append(Character.toString(input.charAt(j)));
                }
                if(input.charAt(j) == '+'){
                    while(input.charAt(j) != '@'){
                        j++;
                    }
                    j--;
                }
               j++;
            }
            temp.append(input.substring(j+1));
                set.add(temp.toString().toLowerCase());
        }
        System.out.println(set.size());
    }
}
