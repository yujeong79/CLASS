package 그래프탐색_0903;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 그래프탐색02_BFS {
	static int V, E; // 정점의 개수와 간선의 개수
	static List<Integer>[] adj; // 인접리스트
	static boolean[] visited; // 방문 체크
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		adj = new ArrayList[V+1]; // 요소의 타입이 List인 배열만 만들어진 것이고 각 요소의 List가 생성되지는 않은 상태
		for(int i = 1; i <= V; i++) { // 노드의 시작이 1번이니까
			adj[i] = new ArrayList<>();
		}
		
		visited = new boolean[V+1];
		
		for(int i = 0; i < E; i++) { // 간선의 수만큼 반복
			int from = sc.nextInt(); // 시작 노드
			int to = sc.nextInt(); // 끝 노드
			
			adj[from].add(to);
			adj[to].add(from); 
		}
		
		
	} // end of main
	
	/**
	 * @param v : 시작 정점
	 */
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(v); // 시작 정점을 큐에 넣고 시작
		visited[v] = true; // 시작 정점을 방문 체크
		
		while(!q.isEmpty()) { // 큐가 공백이 되면 종료
			int curr = q.poll(); // 노드 하나를 꺼냄
			System.out.println(curr);
			
			// curr에 인접하면서 방문하지 않은 노드들을 방문하자
			for(int w : adj[curr]) { // adj[curr] 안에는 curr과 인접한 노드들이 리스트 형태로 저장되어 있음
				if(!visited[w]) { // 방문하지 않았다면
					q.add(w);
					visited[w] = true;
				}
			}
		}
	}
	
	
	static String input = "7 9\r\n"
			+ "1 2\r\n"
			+ "1 3\r\n"
			+ "1 6\r\n"
			+ "2 4\r\n"
			+ "2 7\r\n"
			+ "3 4\r\n"
			+ "4 7\r\n"
			+ "5 6\r\n"
			+ "5 7";
	
} // end of class
