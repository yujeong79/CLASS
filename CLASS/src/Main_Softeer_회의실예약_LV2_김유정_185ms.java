import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class reservation implements Comparable<reservation>{
	int startTime;
	int endTime;
	
	public reservation(int startTime, int endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "reservation [startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	@Override
	public int compareTo(reservation o) {
		return this.startTime - o.startTime;
	}
}

public class Main_Softeer_회의실예약_LV2_김유정_185ms {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	
	private static Map<String, List<reservation>> roomList = new LinkedHashMap<>();
	
	private static int N;
	private static int M;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 회의실 수
		M = Integer.parseInt(st.nextToken()); // 예약된 회의의 수
		
		for(int i = 0; i < N; i++) {
			roomList.put(br.readLine(), new ArrayList<reservation>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String room = st.nextToken();
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			roomList.get(room).add(new reservation(start, end));
		}
		
		List<String> keyOrder = new ArrayList<>(roomList.keySet());
		Collections.sort(keyOrder);
		
		for(String room : roomList.keySet()) {
			Collections.sort(roomList.get(room));
		}
		
		for(int k = 0; k < keyOrder.size()-1; k++) {
			String r = keyOrder.get(k);
			sb.append("Room " + r + ":\n");
			printTime(roomList.get(r));
			sb.append("-----\n");
		}
		
		String r = keyOrder.get(keyOrder.size()-1);
		sb.append("Room " + r + ":\n");
		printTime(roomList.get(r));
		
		System.out.println(sb);
	} // end of main
	
	private static void printTime(List<reservation> list) {
		List<String> available = new ArrayList<>();
		
		int start = 9;
		int end = 9;
		
		for(int i = 0; i < list.size(); i++) {
			end = list.get(i).startTime;
			if(start != end) {
				if(start == 9) available.add("09-"+end);
				else available.add(start + "-" + end);
			}
			start = list.get(i).endTime;
		}
		
		if(start < 18) {
			if(start == 9) available.add("09-"+18);
			else available.add(start + "-" + 18);
		}
		if(available.isEmpty()) sb.append("Not available\n");
		else {
			sb.append(available.size() + " available:\n");
			for(String s : available) sb.append(s + "\n");
		}
	}
	
} // end of class
