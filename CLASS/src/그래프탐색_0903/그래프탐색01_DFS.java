package 그래프탐색_0903;

import java.util.Scanner;

public class 그래프탐색01_DFS {
	static int V, E; // 정점의 개수와 간선의 개수
	static int[][] adj; // 인접행렬, 2차원 배열로 각 노드가 자신을 제외한 다른 모든 노드들과 인접해있는지 체크(1)
	static boolean[] visited; // 방문 체크
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		adj = new int[V+1][V+1]; // 시작 정점의 번호가 1번부터 시작하므로 +1 크기의 배열 선언
		visited = new boolean[V+1];
		
		for(int i = 0; i < E; i++) { // 간선의 수만큼 반복
			int from = sc.nextInt(); // 시작 노드
			int to = sc.nextInt(); // 끝 노드
			adj[from][to] = adj[to][from] = 1; // 방향이 없는 그래프
		}
		
		dfs(1);
		
		
	} // end of main
	
	/**
	 * @param v : 현재 내가 있는 정점
	 */
	static void dfs(int v) {
		visited[v] = true;
		System.out.println(v);
		
		// 나와 인접하면서 방문하지 않은 정점을 방문하겠다.
		for(int i = 1; i <= V; i++) {
			if(!visited[i] && adj[v][i] == 1) { // 방문하지 않았으면
				dfs(i); // 방문~
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
