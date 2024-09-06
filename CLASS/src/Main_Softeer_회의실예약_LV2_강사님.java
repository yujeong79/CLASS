import java.io.*;
import java.util.*;

public class Main_Softeer_회의실예약_LV2_강사님 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 회의실 수 N 1 ~ 50
		int M = Integer.parseInt(st.nextToken()); // 회의실 수 M 1 ~ 100
		
		// key를 사전순으로 정렬하기 위함
		TreeMap<String, Integer> tmRoomName = new TreeMap<>((o1, o2) -> o1.compareTo(o2)); // 회의실명, 사전순 오름차순 정렬
		for(int i = 0; i < N; i++) {
			tmRoomName.put(br.readLine(), i); // 회의실 이름과 (임의로 주어진) 방 번호
		}
		
		boolean[][] time = new boolean[N][19]; // 회의 시작시간 S 종료시간 E가 있을 때, S는 포함하고 E는 포함하지 않는다.
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String r = st.nextToken(); // 회의실 이름
			int s = Integer.parseInt(st.nextToken()); // 회의 시작시간
			int e = Integer.parseInt(st.nextToken()); // 회의 종료시간
			
			for(int j = s; j < e; j++) { // 시작시간 ~ 종료시간 true로 바꾸기 (종료시간은 미포함)
				int idx = tmRoomName.get(r); // 방 번호 불러오기
				time[idx][j] = true;
			}
		}
		
		
		// 해당 회의실의 예약가능한(비어있는) 구간을 출력
		// 회의실 이름 사전순으로 순회
		for(String roomName : tmRoomName.keySet()) { // 이미 tmRoomName에 사전순으로 정렬되어있음
			int idx = tmRoomName.get(roomName); // 방번호 받아오기
			// true -> false면 시작시간, false->true면 종료시간
			// 9시와 18시를 위해서 8번방과 18번방을 true로 바꿔 놓는다.
			time[idx][8] = time[idx][18] = true;
			int cnt = 0; // 예약 가능한 구간의 개수
			String temp = ""; // 예약 가능한 시간이 있는지 없는지에 따라 출력형식이 다르고, cnt를 먼저 출력해야하므로 별도로 출력할 문자열 관리
			for(int i = 9; i <= 18; i++) {
				if(time[idx][i-1] && !time[idx][i]) { // true -> false 시작구간
					temp += (i==9 ? "09" : i) +"-"; // 9시는 09로 출력해야하니까
					cnt++;
				} else if(!time[idx][i-1] && time[idx][i]) { // false -> true 시작구간
					temp += i+"\n";
				}
			}
			sb.append("Room ").append(roomName).append("\n");
			if(cnt == 0) sb.append("Not available\n").append("-----\n"); 
			else {
				sb.append(cnt).append(" available:\n").append(temp).append("-----\n");
			}
		}
		
		sb.setLength(sb.length() - 6); // 마지막 -----를 없애자, 회의가 적어도 1개는 있다고 했으니까 에러가 발생하지 않음
		System.out.println(sb);
	} // end of main
} // end of class
