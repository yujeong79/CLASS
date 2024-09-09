package 위상정렬_0909;

import java.util.Scanner;
import java.util.Stack;

public class 위상정렬01_Queue {
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };
	private static int V, E;
	private static int[][] adjArr;
	private static int[] degree;
	private static boolean[] visited;
	private static Stack<Integer> ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		StringBuilder sb = new StringBuilder();
		
		V = sc.nextInt(); // 정점의 개수, 1번 노드부터 시작
		E = sc.nextInt(); // 간선의 개수
		
		adjArr = new int[V+1][V+1]; // 인접 행렬
		degree = new int[V+1]; // 진입 차수를 저장할 배열
		visited = new boolean[V+1]; // 방문 체크
		ans = new Stack<>(); // 정답을 담을 스택 
		
		for(int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adjArr[A][B] = 1; // 가중치가 따로 없으므로 1
			degree[B]++; // B로 진입하는 것이므로 B의 진입 차수를 증가
		}
		
		for(int i = 1; i <= V; i++) {
			if(degree[i] == 0)
				dfs(i);
		}
		
		while(!ans.empty()) {
			sb.append(cook[ans.pop()] + "\n");
		}
		
		System.out.println(sb);
		
	}
	
	private static void dfs(int curr) { 
		visited[curr] = true; // 방문, 이번에 방문했다고 해서 이번에 답 스택에 넣는 것이 아니다 => 현재 노드에서 진출하여 방문할 수 있는 노드를 다 방문한 뒤에 현재 노드를 출력해야한다.
		
		for(int i = 1; i <= V; i++) {
			if(adjArr[curr][i] == 1 && !visited[i]) { // 간선으로 curr 노드와 연결되어 있고, 아직 방문하지 않았으면
				dfs(i);
			}
		}
		
		ans.push(curr); // 연결되어 있는 모든 정점을 다 방문하였으면 ans 스택에 넣기
		
	}

	// 진출 노드, 진입 노드
	public static String input = "9 9\r\n"
			+ "1 4\r\n"
			+ "1 8\r\n"
			+ "2 3\r\n"
			+ "4 3\r\n"
			+ "8 5\r\n"
			+ "3 5\r\n"
			+ "5 6\r\n"
			+ "9 6\r\n"
			+ "6 7";

}
