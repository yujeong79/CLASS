/**
 * prefixSum
 * ps[i][j] = ps[0][0] + ps[0][1] + . . . + ps[0][j]
 * 			+ ps[1][0] + ps[1][1] + . . . + ps[1][j]
 * 			+ ...
 * 			+ ps[i][0] + ps[i][1] + . . . + ps[i][j]
 */

public class 구간합_2차원배열 {
	public static void main(String[] args) {
		int[][] mapOri = {
				{1,2,3,4,5},
				{2,3,4,5,6},
				{3,4,5,6,7},
				{4,5,6,7,8},
				{5,6,7,8,9}
		};
		
		// 구간합의 구현 편의를 위해서 한 행과 한 열을 더 만들자
		// 입력받을 때 쉬프트해서 입력받으면 됨
		int[][] map = {
				{0,0,0,0,0,0},
				{0,1,2,3,4,5},
				{0,2,3,4,5,6},
				{0,3,4,5,6,7},
				{0,4,5,6,7,8},
				{0,5,6,7,8,9},	
		};
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = map[i-1][j] + map[i][j-1] - map[i-1][j-1] + map[i][j];
			}
		}
		
	} // end of main
} // end of class
