package 분할정복_0828;

public class 거듭제곱02_분할정복 {
	public static void main(String[] args) {
		int C = 2;
		int N = 10;
	}
	
	static int pow(int C, int N) {
		if(N == 1) return C;
		
		// 짝수인 경우 / 홀수인 경우를 나눠서
		if(N % 2 == 0) {
			return pow(C, N/2) * pow(C, N/2); // 그런데 이렇게 결국 똑같이 pow를 두 번 호출하면 결국 또 낭비
		} else {
			return pow(C, (N-1)/2) * pow(C, (N-1)/2) * C;
		}
	}
	
	static int pow2(int C, int N) {
		if(N == 1) return C;
		
		// 짝수인 경우 / 홀수인 경우를 나눠서
		if(N % 2 == 0) {
			int tmp = pow2(C, N/2);
			return tmp * tmp; 
		} else {
			int tmp = pow2(C, (N-1)/2);
			return tmp * tmp * C;
		}
	}
	
}
