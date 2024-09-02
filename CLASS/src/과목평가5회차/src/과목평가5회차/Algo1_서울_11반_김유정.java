package 과목평가5회차.src.과목평가5회차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo1_서울_11반_김유정 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기 위한 BufferedReader
	private static StringBuilder sb = new StringBuilder(); // 각 테스트케이스의 출력을 한 번에 모아서 출력하기 위한 StringBuilder
	
	private static int N; // N*N 크기의 게임판
	private static char[][] matrix; // 2차원 배열의 게임판
	private static char[] command; // 주어진 별 블록이 놓일 위치를 char 배열로 저장하기 위한 배열
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine()); // 전체 테스트케이스의 수
		int testCase = 0; // 각 테스트케이스
		while(++testCase <= T) { // 각 테스트케이스가 전체 테스트케이스 수만큼 진행됐으면 종료
			N = Integer.parseInt(br.readLine()); // N*N 크기의 게임판
			matrix = new char[N][N]; // 게임판의 크기를 N*N만큼 할당
			
			String str = br.readLine(); // 별 블록이 놓일 위치를 입력받아 str에 저장
			command = new char[str.length()]; // 별 블록이 놓일 위치를 char 배열로 저장하기 위한 배열의 크기를 str의 크기만큼 할당
			command = str.toCharArray(); // 별 블록이 놓일 각 위치를 char 배열로 저장
			
			play(); // 게임 시작
			
			sb.append("#" + testCase + "\n"); // 각 테스트케이스의 출력값 
			for(char[] arr : matrix) { // 게임판의 행을 하나씩 받아와서
				for(char c : arr) { // 각 행의 요소 하나씩 받아와서
					if(c != '*') sb.append(" "); // *이 아니면 공백을 저장
					else sb.append(c); // *이면 *을 저장
				}
				sb.append("\n"); // 각 행 저장이 완료되면 줄바꿈
			}
			
		} // end of testCase
		System.out.println(sb); // 모든 테스트케이스의 출력값을 출력
	} // end of main

	private static void play() { // 매트릭스를 진행하는 메소드
		for(char c : command) { // 별 블록이 놓일 위치를 하나씩 불러와서
			int column = c - '0'; // char형으로 저장된 해당 위치를 int형으로 바꾼 뒤 column에 저장
			int row = findRow(column); // 해당 열의 *을 넣을 수 있는 row를 findRow 메소드로 찾은 뒤 row에 저장
			matrix[row][column] = '*'; // * 넣기
			isFull(); // 가장 마지막 row가 *이 꽉 차면 없애기
		}
	}
	
	private static void isFull() { // 가장 마지막 row가 *로 꽉 찼는지 확인하고 찼으면 없애주는 메소드
		boolean full = true; // 초기에는 true로 지정
		for(int i = 0; i < N; i++) { // matrix의 각 열을 순회하며
			if(matrix[N-1][i] != '*') full = false; // matrix의 가장 마지막 칸에 *이 없는 곳이 있으면 flag = false
		}
		
		if(full) { // flag가 true이면 마지막 칸이 *로 찼다는 의미
			for(int i = N-2; i >= 0; i--) { // 맨 마지막 row 그 윗줄부터 ~ matrix의 맨 윗줄까지 순회하며 
				for(int j = 0; j < N; j++) { // 각 행의 열을 순회하며
					if(matrix[i][j] == '*') { // 해당 칸이 *이면
						matrix[i][j] = ' '; // 해당 칸을 비워주고
						matrix[i+1][j] = '*'; // 그 밑 칸에 *을 넣어줌으로써 별이 중력에 의해 밑으로 내려가는 것처럼 바꿔주기
					}
					else matrix[i+1][j] = ' '; // 해당 칸이 *이 아니고 비었으면 그 밑 칸도 비워주기
				}
			}
		}
	}

	private static int findRow(int column) { // 해당 열에서 *를 어느 row에 저장할지 찾아주는 메소드
		int row = N - 1; // 일단 처음엔 row를 가장 마지막 줄로 지정
		while(row > 0) { // row가 맨 아래서부터 맨 위까지 돌면서
			if(matrix[row][column] != '*') return row; // 만약 해당 row, column에 *이 쌓여있지 않으면 바로 row를 return
			row--; // *이 쌓여있으면 row를 한 줄 위로 올리기
		}
		return 0; // while문을 다 돌아도 *로 꽉 차 있으면 맨 윗줄 return, 어차피 해당 열이 다 꽉 차 있는 상태에서 무시되거나 덮어쓰거나 똑같으니까
	}
} // end of class

