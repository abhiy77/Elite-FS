package Elite;
// 02/01/2020
import java.util.*;
public class MeetingRooms {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<Room> rooms = new LinkedList<>();
		for(int i=0;i<n;i++) {
			Room room = new Room(sc.nextInt(),sc.nextInt());
			if(rooms.isEmpty()) {
				rooms.add(room);
			}
			else {
				int flag = 0;
				for(int j=0;j<rooms.size();j++) {
					Room temp = rooms.get(j);
					
					if(temp.end <= room.start){
						rooms.remove(temp);
						rooms.add(room);
						flag = 0;
						break;
					}
					else if(temp.start >= room.end) {
						flag = 0;
						break;
					}
					else{
						flag = 1;
					}
					
				}
				if(flag == 1) {rooms.add(room);}
			}
		}
		System.out.println(rooms.size());
	}
}

class Room{
	int start,end;
	public Room(int start,int end) {
		this.start = start;
		this.end = end;
	}
}