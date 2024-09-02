package 그래프_0902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그래프_01_인접행렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// V, E의 갯수를 준다.
		int V = Integer.parseInt(br.readLine()); // 정점의 개수
		int E = Integer.parseInt(br.readLine()); // 간선의 개수
		
		int[][] adjArr = new int[V][V]; // 만약 시작 정점이 1이라면 [V+1][V+1]
		
		for(int i = 0; i < E; i++) {
			int A = Integer.parseInt(br.readLine()); // 정점1
			int B = Integer.parseInt(br.readLine()); // 정점2
			
//			int W = Integer.parseInt(br.readLine()); // 가중치가 있다면 값은 3개
			
			adjArr[A][B] = 1; // 가중치가 없다면 1을, 있다면 W를 저장하겠다.
			adjArr[B][A] = 1; // 만약 무향 그래프라면 반대의 경우도 같이 작성해주어야 한다!
			
		} // E개의 간선을 입력 받을 반복문
		
	}
}
