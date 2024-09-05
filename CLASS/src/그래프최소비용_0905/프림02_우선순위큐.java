package 그래프최소비용_0905;

import java.util.*;

public class 프림02_우선순위큐 {
	static class Edge implements Comparable<Edge> {
		int A, B, W;

		public Edge(int a, int b, int w) {
			super();
			A = a;
			B = b;
			W = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.W, o.W);
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); // 정점의 수, 정점의 번호는 0번부터 시작
		int E = sc.nextInt(); // 간선의 수
		
		// 인접리스트로 만들어보자
		List<Edge>[] adjList = new ArrayList[V];
		for(int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			adjList[A].add(new Edge(A, B, W)); 
			adjList[B].add(new Edge(B, A, W)); 
		}
		
		
		boolean[] visited = new boolean[V]; // 방문 체크

		PriorityQueue<Edge> pq = new PriorityQueue<>(); // 우선순위큐에는 뽑은 정점과 연결된 다른 정점들을 저장, 우선순위큐에는 새로운 요소를 넣음과 동시에 정렬이 됨
		
		visited[0] = true;
		
		int ans = 0;
		int pick = 1; // 뽑은 정점의 수
		
		// 방법 1.
//		for(int i = 0; i < adjList[0].size(); i++) {
//			pq.add(adjList[0].get(i));
//		}
//		
		// 방법 2.
//		for(Edge e : adjList[0])
//			pq.add(e);
		
		// 방법 3.
		pq.addAll(adjList[0]);
		
		while(pick != V) {
			Edge e = pq.poll(); // 우선수위큐는 가중치가 오름차순으로 이미 정렬되어 있기 때문에 맨 앞을 뽑으면 가장 낮은 애임
			if(visited[e.B]) continue; // 이미 뽑은 친구라면
			
			ans += e.W; // 가중치를 바로 저장
			visited[e.B] = true;
			pick++;
			
			pq.addAll(adjList[e.B]); // 뽑은 정점과 이어진 정점 다 넣어주기
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
