import java.io.*;
import java.util.*;

public class Main_Softeer_회의실예약_LV2 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	
	private static int N;
	private static int M;
	
	private static Map<String, boolean[]> reservation = new LinkedHashMap<>();
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 회의실 수
		M = Integer.parseInt(st.nextToken()); // 예약된 회의의 수

		for(int i = 0; i < N; i++) {
			reservation.put(br.readLine(), new boolean[19]);
		}
		
		List<String> keyOrder = new ArrayList<>(reservation.keySet());
		Collections.sort(keyOrder);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String room = st.nextToken();
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			for(int t = start; t <= end; t++) {
				reservation.get(room)[t] = true;
			}
		}
		for(int k = 0; k < keyOrder.size()-1; k++) {
			String r = keyOrder.get(k);
			sb.append("Room " + r + ":\n");
			List<Integer> available = new ArrayList<>();
			for(int i = 9; i <= 18; i++) {
				if(!reservation.get(r)[i]) available.add(i);
			}
			if(available.isEmpty()) sb.append("Not available\n");
			else {
				int cnt = 0;
				for(int t = 0; t < available.size()-1; t++) {
					if(available.get(t)+1 != available.get(t+1)) cnt++;
				}
				sb.append((cnt+1) + " available:\n");
				printTime(available);
			}
			sb.append("-----\n");
		}
		String r = keyOrder.get(keyOrder.size()-1);
		sb.append("Room " + r + ":\n");
		List<Integer> available = new ArrayList<>();
		for(int i = 9; i <= 18; i++) {
			if(!reservation.get(r)[i]) available.add(i);
		}
		if(available.isEmpty()) sb.append("Not available\n");
		else {
			int cnt = 0;
			for(int t = 0; t < available.size()-1; t++) {
				if(available.get(t)+1 != available.get(t+1)) cnt++;
			}
			sb.append((cnt+1) + " available:\n");
			printTime(available);
		}
		
		System.out.println(sb);
	}

	private static void printTime(List<Integer> list) {
		if(!list.isEmpty()) {
			int idx = 0;
			int start = list.get(0) - 1 <= 9 ? 9 : list.get(0)-1;
			int end = start + 1;
			int last = list.get(list.size()-1);
			for(int i = idx; end < last && i < list.size()-1; i++) {
				end = list.get(i)+1;
				if(list.get(i+1) - list.get(i) != 1) {
					if(start <= 9) 
						sb.append("09-" + end + "\n");
					else sb.append(start + "-" + end + "\n");
					start = list.get(i+1) - 1;
					end = start + 1;
				}
			}
			end = last == 18 ? 18 : last + 1;
			if(start <= 9) 
				sb.append("09-" + end + "\n");
			else sb.append(start + "-" + end + "\n");
		}
	}
	
} // end of class
