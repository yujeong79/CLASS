package 그래프탐색_0903;

import java.io.*;
import java.util.*;

/**
 * input
 * 	첫 줄에는 정점의 개수와 간선의 개수가 공백으로 구분되어 입력
 * 	다음 줄은 간선의 수 만큼 인접한 정점 2개가 공백으로 구분되어 입력
 * 7 9
 * 1 2 1 3 1 6 2 4 2 7 3 4 4 7 5 6 5 7
 */

public class 그래프탐색02_BFS {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int V; // 정점의 개수
	private static int E; // 간선의 개수
	
	private static List<Integer>[] adjList; // 정점과 인접한 정점들을 저장할 리스트
	private static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[V+1];
		for(int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < E; i++) {
			int n1 = Integer.parseInt(st.nextToken()); 
			int n2 = Integer.parseInt(st.nextToken());
			
			adjList[n1].add(n2);
			adjList[n2].add(n1);
		}
		
		isVisited = new boolean[V+1];
		bfs(1);
	}

	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(v);
		isVisited[v] = true; // 큐에 넣는 순간 방문 체크
		
		while(!queue.isEmpty()) {
			int curr = queue.poll(); 
			System.out.println(curr);
			
			for(int w : adjList[curr]) { // 현재 노드의 인접한 노드 중 방문하지 않은 노드들을 큐에 넣기
				if(!isVisited[w]) {
					queue.add(w);
					isVisited[w] = true;
				}
			}
		}
	}

	
} // end of class
