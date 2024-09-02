package 그래프_0902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 그래프_02_인접리스트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
	
		List<Integer>[] adjList = new ArrayList[V];
		
		// 요소가 List<Integer>인 배열의 각 요소를 new ArrayList<>로 초기화해주어야한다.
		for(int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			int A = Integer.parseInt(br.readLine());
			int B = Integer.parseInt(br.readLine());
			
			adjList[A].add(B); // 각 노드에 연결된 모든 노드들을 각 리스트에 저장
			adjList[B].add(A);
		}
		
		// 인접행렬 VS 인접리스트
		
	}
}
