/* 03/03/2020

Given a list of words  print all anagrams together.

For example  if the given list of words is {but,tac,god,act, dog, cat, tub}
then output would be groups of anagrams [but,tub][tac,act,cat][god, dog]


Example:
Input=  pan nap god bat bag dog tub

Output= [pan, nap]
        [god, dog]
 

Note : 
1) Print the group of anagrams only if the size of group is more than 1
2) Order of words in output should be same as order given in input.
3) Print -1, if no group of anagrams found

*/
package Elite;
import java.util.*;

class FindAnagrams{
    
    public static boolean isAnagram(String a,String b){
        int arr[] = new int[26];
        if(a.length() != b.length()) return false;
        for(int i=0;i<a.length();i++){
            arr[a.charAt(i)-'a']++;
        }
        for(int i=0;i<b.length();i++){
            arr[b.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(arr[i] != 0) return false;
        }
        return true;
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,Boolean> map = new HashMap<>();
        List<String> list = Arrays.asList(sc.nextLine().split(" "));
        int n = list.size();
        for(int i=0;i<n;i++){
            map.put(list.get(i),false);
        }
        LinkedList<List<String>> output = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(map.get(list.get(i)) == true) continue;
            List<String> result = new LinkedList<>();
            result.add(list.get(i));
            for(int j=0;j<n;j++){
                if(i == j) continue;
                if(isAnagram(list.get(i),list.get(j))) result.add(list.get(j));
            }
            if(result.size() >= 2){
                output.add(result);
                for(int k=0;k<result.size();k++){
                    map.put(result.get(k),true);
                }
            }
        }
        for(List<String> l: output){
            System.out.println(l);
        }
        if(output.size() == 0) System.out.println(-1);
    }
}