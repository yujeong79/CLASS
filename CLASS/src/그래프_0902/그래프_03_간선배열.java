package 그래프_0902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 그래프_03_간선배열 {
	
	static class Edge {
		int A, B, W; // 시작노드, 끝노드, 가중치

		public Edge(int a, int b, int w) {
			super();
			A = a;
			B = b;
			W = w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		Edge[] edges = new Edge[E]; // 객체 배열
		
		for(int i = 0; i < E; i++) {
			int A = Integer.parseInt(br.readLine());
			int B = Integer.parseInt(br.readLine());
			int W = Integer.parseInt(br.readLine());
			
			edges[i] = new Edge(A, B, W); // 어차피 간선만 받아서 저장하니까 순서는 상관없음
		}
		
		//////////////////////////////////////////////////////////
		// 굳이 객체까지 만들어야 하나? 0 : 시작노드, 1 : 도착노드, 2 : 가중치
		int[][] edges2 = new int[E][3];
		
		for(int i = 0; i < E; i++) {
			edges2[i][0] = Integer.parseInt(br.readLine());
			edges2[i][1] = Integer.parseInt(br.readLine());
			edges2[i][2] = Integer.parseInt(br.readLine());
		}
	}
}
