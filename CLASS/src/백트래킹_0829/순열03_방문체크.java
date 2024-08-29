package 백트래킹_0829;

public class 순열03_방문체크 {
	static int[] nums;
	static int N;
	
	public static void main(String[] args) {
		nums = new int[] {1, 2, 3};
		N = nums.length;
		
		// 이렇게 하면 요소가 많아질 수록 하기가 어려워진다.
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i != j) // 요소의 중복을 제거하기 위함
				for(int k = 0; k < N; k++) {
					if(i != k && j != k)
						System.out.println(nums[i] + ", " + nums[j] + ", " + nums[k]);
				}
			}
		}
	}
}
