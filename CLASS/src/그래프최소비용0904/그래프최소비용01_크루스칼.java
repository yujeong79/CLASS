package 그래프최소비용0904;

import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
	int A, B, W;
	
	public Edge(int a, int b, int w) {
		A = a; // 노드1
		B = b; // 노드2
		W = w; // 가중치
	}
	
	@Override
	public String toString() {
		return "Edge [A=" + A + ", B=" + B + ", W=" + W + "]";
	}

	@Override
	public int compareTo(Edge o) {
		return this.W - o.W;
	}
}

public class 그래프최소비용01_크루스칼 {
	
	static int[] p; // 대표자를 저장할 배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); // 정점의 개수 (정점의 시작번호를 보고)
		int E = sc.nextInt(); // 간선의 개수
		
		Edge[] edges = new Edge[E]; // 간선을 저장한 배열
		
		for(int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			edges[i] = new Edge(A, B, W);
		}
		
		// 크루스칼 제 1장 : 가중치 순으로 정렬을 해라!
		Arrays.sort(edges);
		
		for(Edge e : edges) {
			System.out.println(e);
		}
		
		// 크루스칼 제 2장 : V-1개의 간선을 뽑아라! (사이클이 발생하지 않게)
		// 상호배타집합 (서로소집합, 유니온파인드)
		p = new int[V]; // 대표자를 저장할 배열, 0번부터 V-1번까지
		
		// make-set을 통해 전체 자신을 대표로 만드는 작업을 수행한다.
		for(int i = 0; i < V; i++) {
			p[i] = i; // 따로 makeSet을 사용하지 않고 반복문 하나로 가능!
		}
		
		int ans = 0; // 최소 비용을 저장하기 위한 변수
		int pick = 0; // 내가 뽑은 간선의 개수
		
		for(int i = 0; i < E; i++) { // 간선의 수만큼 반복문을 돌면서
			int x = edges[i].A; // 해당 간선의 노드1
			int y = edges[i].B; // 해당 간선의 노드2
			
			// 사이클이 발생하는지 검사를 해야한다.
//			if(findSet(x) != findSet(y)) {
//				union(x, y);
//				ans += edges[i].W;
//				pick++;
//			}
//			
//			if(pick == (V-1)) break;
			
			int px = findSet(edges[i].A);
			int py = findSet(edges[i].B);
			
			if(px != py) {
				union(px, py);
				ans += edges[i].W;
				pick++;
			}
		}
		
		System.out.println(ans);
		
	} // end of main
	
	static void makeSet(int x) {
		p[x] = x;
	}
	
	static int findSet(int x) {
//		아래의 코드는 똑같은 작업을 중복해서 작업하므로 효율이 낮다.
//		if(x == p[x]) return x; // 자기자신 x의 대표자가 자신과 같으면 return x
//		return findSet(p[x]);
		
//		아래의 코드는 Path compression을 적용한 코드
		if(x != p[x])
			p[x] = findSet(p[x]); // 자기 자신의 대표자로 저장된 p[x]에 다시 대표자를 찾아서 저장
		return p[x];
	}
	
	static void union(int x, int y) {
		// x와 y가 대표자이어야만 한다.
		//p[findSet(y)] = findSet(x); // x그룹에 y 그룹을 넣는 것이다, y의 대표자 자리에 x의 대표자를 넣었으니까
	
		p[y] = x; // union을 할 때 findSet의 중복 연산을 예방하기 위해서, 단 이렇게 하기 위해서는 x와 y가 무조건 대표자이어야 한다.
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
