package 위상정렬_0909;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 위상정렬02_Stack {
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		StringBuilder sb = new StringBuilder();
		
		int V = sc.nextInt(); // 정점의 개수, 1번 노드부터 시작
		int E = sc.nextInt(); // 간선의 개수
		
		int[][] adjArr = new int[V+1][V+1];
		int[] degree = new int[V+1]; // 진입 차수를 저장할 배열
		
		for(int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adjArr[A][B] = 1; // 가중치가 따로 없으므로 1
			degree[B]++; // B로 진입하는 것이므로 B의 진입 차수를 증가
		}
		
		// 위상정렬 큐 1장 : 진입 차수가 0인 친구들을 몽땅 넣어라
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i <= V; i++) {
			if(degree[i] == 0) { // i의 진입 차수가 0이면 큐에 i를 넣자 
				queue.add(i);
			}
		}
		
		// 위장정렬 큐 2장 : 큐가 공백 상태가 될 때까지 반복
		// 큐에서 원소를 뽑았을 때 간선을 제거하고(진입 차수를 감소시키고) 진입 차수가 0이 되면 큐에 넣는다.
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(cook[curr] + "\n");
			
			for(int i = 1; i <= V; i++) {
				if(adjArr[curr][i] == 1) { // 현재 curr 노드에서 진출해서 진입하는 노드가 있으면
					degree[i]--; // 진입 차수 깎기
					adjArr[curr][i] = 0; // 간선 없애기 (그런데 사실 안해도 괜찮아!)
					
					if(degree[i] == 0) {
						queue.add(i);
					}
				}
			}
		}
		
		// 밑에서 한 방에 출력하고 싶으면?
		// 방법1. list나 arr에 정점을 저장
		// 방법2. StringBuilder 사용
		System.out.println(sb);
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
