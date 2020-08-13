package Elite;
/* 13/02/2020
Write a program to find top 5 students list of all 3 subjects. 
From the lists print the students info who are present in all lists. 

Note : output rollnos in ascending order.


sample output : [14BD1A040F, 14BD1A0414]

*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Details implements Comparable<Details>{
    
    public int compareTo(Details d1){
    	if(this.marks==d1.marks) return 0;
        return -(this.marks-d1.marks);
    }
    
    int marks;
    String rollno;
    Details(String rollno,int marks){
        this.marks = marks;
        this.rollno = rollno;
    }
}

public class CallableFutureTest {
	public static void main(String[] args) throws Exception {
        
         ExecutorService executorService = Executors.newFixedThreadPool(3);  
         
         Callable<ArrayList<Details>> task1 = () -> {
            BufferedReader br = new BufferedReader(new FileReader(new File("maths.txt")));
            ArrayList<Details> list = new ArrayList<>();
            String line = null;
            while((line = br.readLine()) != null){
                String input[] = line.split(" ");
                list.add(new Details(input[0],Integer.parseInt(input[1])));
            }
            Collections.sort(list);
            return list;
        };

        Callable<ArrayList<Details>> task2 = () -> {
            BufferedReader br = new BufferedReader(new FileReader(new File("chemistry.txt")));
            ArrayList<Details> list = new ArrayList<>();
            String line = null;
            while((line = br.readLine()) != null){
                String input[] = line.split(" ");
                list.add(new Details(input[0],Integer.parseInt(input[1])));
            }
            Collections.sort(list);
            return list;
        };

        Callable<ArrayList<Details>> task3 = () -> {
            BufferedReader br = new BufferedReader(new FileReader(new File("physics.txt")));
            ArrayList<Details> list = new ArrayList<>();
            String line = null;
            while((line = br.readLine()) != null){
                String input[] = line.split(" ");
                list.add(new Details(input[0],Integer.parseInt(input[1])));
            }
            Collections.sort(list);
            return list;
        };
         
        List<Callable<ArrayList<Details>>> taskList = Arrays.asList(task1, task2, task3);

        List<Future<ArrayList<Details>>> futures = executorService.invokeAll(taskList);

        LinkedList<String> values = new LinkedList<>();
        LinkedList<String> helper = new LinkedList<>();
        int flag =0;
            for(Future<ArrayList<Details>> future: futures) {
            	ArrayList<Details> list = future.get();
            if(flag == 0){
                int count = 0;
                for(Details d : list){
                if(count == 5) break;
                String num = d.rollno;
                values.add(num);
                count++;
                }
                flag = 1;
            }
            else{
                int count = 0;
                for(Details d :list){
                    if(count == 5) break;
                    if(values.contains(d.rollno)){
                      helper.add(d.rollno);  
                    }
                    count++;
                }
                values.clear();
                values.addAll(helper);
                helper.clear();
            }
        } 
        System.out.println(values);
        executorService.shutdown();
	}
}

//maths.txt
/*12BD1A0502 51
12BD1A0503 47
12BD1A0506 82
12BD1A0508 70
12BD1A050D 5
12BD1A050E 99
12BD1A050F 51
12BD1A050H 16
12BD1A050J 26
12BD1A050K 86
12BD1A050L 50
12BD1A050M 92
12BD1A050P 13
12BD1A050Q 87
12BD1A050T 0
12BD1A050W 36
12BD1A050X 81
12BD1A050Y 97
12BD1A0511 45
12BD1A0512 35
12BD1A0513 37
12BD1A0514 84
12BD1A0515 6
12BD1A0516 97
12BD1A0518 89
12BD1A0519 3
12BD1A051A 47
12BD1A051B 27
12BD1A051C 94
12BD1A051F 91
12BD1A051G 74
12BD1A051H 97
12BD1A051K 63
12BD1A051L 26
12BD1A051P 42
12BD1A051Q 29
12BD1A051T 23
12BD1A051V 26
12BD1A0521 62
12BD1A0522 35
12BD1A0523 86
12BD1A0525 27
12BD1A0528 78
12BD1A0529 9
12BD1A052A 14
12BD1A052C 40
12BD1A052D 61
12BD1A052E 86
12BD1A052F 47
12BD1A052G 78
12BD1A052H 49
12BD1A052J 11
12BD1A052L 10
12BD1A052N 19
12BD1A052P 62
12BD1A052Q 56
12BD1A052U 95
12BD1A052W 5
12BD1A052X 41
*/

//chemistry.txt
/*
12BD1A0502 35
12BD1A0503 66
12BD1A0506 28
12BD1A0508 41
12BD1A050D 22
12BD1A050E 99
12BD1A050F 73
12BD1A050H 3
12BD1A050J 95
12BD1A050K 66
12BD1A050L 47
12BD1A050M 36
12BD1A050P 40
12BD1A050Q 93
12BD1A050T 44
12BD1A050W 43
12BD1A050X 81
12BD1A050Y 78
12BD1A0511 46
12BD1A0512 98
12BD1A0513 51
12BD1A0514 64
12BD1A0515 68
12BD1A0516 99
12BD1A0518 33
12BD1A0519 25
12BD1A051A 26
12BD1A051B 56
12BD1A051C 2
12BD1A051F 43
12BD1A051G 11
12BD1A051H 23
12BD1A051K 85
12BD1A051L 54
12BD1A051P 17
12BD1A051Q 22
12BD1A051T 62
12BD1A051V 46
12BD1A0521 41
12BD1A0522 67
12BD1A0523 16
12BD1A0525 76
12BD1A0528 34
12BD1A0529 41
12BD1A052A 6
12BD1A052C 5
12BD1A052D 6
12BD1A052E 19
12BD1A052F 76
12BD1A052G 25
12BD1A052H 98
12BD1A052J 15
12BD1A052L 83
12BD1A052N 67
12BD1A052P 88
12BD1A052Q 41
12BD1A052U 42
12BD1A052W 88
12BD1A052X 14
*/

//physics.txt

/*
12BD1A0502 36
12BD1A0503 72
12BD1A0506 51
12BD1A0508 39
12BD1A050D 42
12BD1A050E 94
12BD1A050F 44
12BD1A050H 41
12BD1A050J 71
12BD1A050K 31
12BD1A050L 46
12BD1A050M 35
12BD1A050P 36
12BD1A050Q 79
12BD1A050T 85
12BD1A050W 89
12BD1A050X 89
12BD1A050Y 79
12BD1A0511 29
12BD1A0512 7
12BD1A0513 47
12BD1A0514 18
12BD1A0515 49
12BD1A0516 92
12BD1A0518 12
12BD1A0519 87
12BD1A051A 98
12BD1A051B 28
12BD1A051C 47
12BD1A051F 53
12BD1A051G 24
12BD1A051H 60
12BD1A051K 28
12BD1A051L 60
12BD1A051P 16
12BD1A051Q 1
12BD1A051T 59
12BD1A051V 92
12BD1A0521 83
12BD1A0522 38
12BD1A0523 42
12BD1A0525 96
12BD1A0528 55
12BD1A0529 89
12BD1A052A 79
12BD1A052C 30
12BD1A052D 13
12BD1A052E 77
12BD1A052F 43
12BD1A052G 87
12BD1A052H 5
12BD1A052J 66
12BD1A052L 17
12BD1A052N 85
12BD1A052P 77
12BD1A052Q 31
12BD1A052U 22
12BD1A052W 17
12BD1A052X 23
*/