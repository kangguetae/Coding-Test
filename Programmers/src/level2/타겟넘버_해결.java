package level2;

public class 타겟넘버_해결 {
	
	public static void main(String [] args) {
		int [] n = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(n, target));
		int [] n2 = {4, 1, 2, 1};
		target = 4;
		System.out.println(solution(n2, target));
				
	}
	
	 public static int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer += dfs(numbers, 0, target, 0);
        
        
        
        return answer;
	 }
	 
	 public static int dfs(int [] n, int index, int t, int curr) {
		 int cnt = 0;
		 if(index == n.length) {
			 if(curr == t) {
				 return 1;
			 }
			 else {
				 return 0;
			 }
		 }
		 int numNow = n[index];
		 cnt += dfs(n, index+1, t, curr+numNow);

		 cnt += dfs(n, index+1, t, curr-numNow);
		 
		 
		 return cnt;
	 }
}
