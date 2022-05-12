package level1;

public class 키패드누르기_해결 {

	public static void main(String [] args) {
		int [] numbers1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		String hand1 = "right";
		
		System.out.println(solution(numbers1, hand1));
		
	}
	
	
	public static String solution(int[] numbers, String hand) {
		int leftHand = 10;
		int rightHand = 12;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < numbers.length; i++) {
			int numNow = numbers[i] == 0 ? 11 : numbers[i];
			if(numNow % 3 == 1) {
				sb.append("L");
				leftHand = numNow;
			}
			else if(numNow % 3 == 0) {
				sb.append("R");
				rightHand = numNow;
			}
			else {
				String h = calLocation(leftHand, rightHand, numNow, hand);
				if(h.equals("L")) leftHand = numNow;
				else if(h.equals("R")) rightHand = numNow;	
				sb.append(h);
			}
		}
        String answer = sb.toString();
        return answer;
    }
	
	public static String calLocation(int l, int r, int num, String hand) {
		int leftCnt = 0;
		int rightCnt = 0;
		if(l%3 == 1) {
			l++;
			leftCnt++;
		}
		if(r%3 == 0) {
			r-=1;
			rightCnt++;
		}
		
		while(l != num || r != num) {
			if(l < num) {
				l += 3;
				leftCnt++;
			}
			else if(l > num) {
				l -= 3;
				leftCnt++;
			}
			if(r < num) {
				r += 3;
				rightCnt++;
			}
			else if(r > num) {
				r -= 3;
				rightCnt++;
			}
		}
		
		if(leftCnt == rightCnt) {
			return hand.equals("left") ? "L" : "R";
		}
		else {
			return leftCnt > rightCnt ? "R" : "L";
		}
	}
}
