package 그래프최소비용_0905;

import java.util.Scanner;
import java.util.*;

public class 프림01_반복문 {
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); // 정점의 수, 정점의 번호는 0번부터 시작
		int E = sc.nextInt(); // 간선의 수
		
		// 인접행렬 방식으로 만들어보자
		int[][] adjArr = new int[V][V];
		
		for(int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			adjArr[A][B] = adjArr[B][A] = W; // 무방향 그래프이므로 (A, B)와 (B, A)에 모두 가중치의 값을 넣어주어야 한다.			
		}
		
		
		boolean[] visited = new boolean[V]; // 방문 체크
		int[] p = new int[V]; // 부모 정점 저장, 사용하지 않아도 됨
		int[] dist = new int[V]; // 선택한 간선의 가중치를 저장할 배열
		
		// 프림 제 1장 : 사용하지 않을 값으로 초기화
		for(int i = 0; i < V; i++) {
			p[i] = -1;
			dist[i] = INF;
		}
		
		Arrays.fill(dist, INF); // 이렇게 메소드를 사용할 수도 있음
		
		// 프림 제 2장 : 시작 정점 선택
		dist[0] = 0; // 시작 정점의 가중치를 0으로 변경, 가중치 배열에서 바로 선택되도록
		
		// 프림 제 3장 : 가중치 배열을 돌면서 가장 값이 낮은 것을 골라서 방문 체크 및 갱신
		for(int i = 0; i < V-1; i++) { // V번 돌아도 괜찮아~
			int min = INF;
			int idx = -1;
			
			// 반복문1. 방문하지 않았으면서 가장 작은 값 가져와
			for(int j = 0; j < V; j++) {
				if(!visited[j] && dist[j] < min) { // 방문하지 않았으면서 min보다 작은 가중치를
					min = dist[j];
					idx = j;
				}
			} // 해당 반복문이 종료되면 idx는 방문하지 않은 정점 중에서 가중치가 제일 작은 정점이 되어있음
			visited[idx] = true; // 방문 처리
			
			// 반복문2. 방문하지 않았고 갱신할 수 있으면 갱신해
			/**
			 * adjArr[idx][j] 뽑힌 정점 idx와 0~V번째 정점을 순회할 때 0이 아닌 다른 값이 있다는 의미는
			 * 가중치가 있다는 의미, 즉 간선으로 연결되어 있다는 의미
			 */
			for(int j = 0; j < V; j++) {
				if(!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
					dist[j] = adjArr[idx][j];
					p[j] = idx; // 필요시에 부모도 갱신
				}
			}
		}
	}
	
	static String input = "7 11\r\n"
			+ "0 1 32\r\n"
			+ "0 2 31\r\n"
			+ "0 5 60\r\n"
			+ "0 6 51\r\n"
			+ "1 2 21\r\n"
			+ "2 4 46\r\n"
			+ "2 6 25\r\n"
			+ "3 4 34\r\n"
			+ "3 5 18\r\n"
			+ "4 5 40\r\n"
			+ "4 6 51";
}
