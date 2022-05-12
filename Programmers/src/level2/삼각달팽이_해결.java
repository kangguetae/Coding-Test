package level2;

import java.util.ArrayList;
import java.util.Scanner;

public class 삼각달팽이_해결 {

	
	
	public static void main(String[] args) {
		
		
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		
		
		int area = N * (1 + N) / 2;
		int [] answer = new int[area];
		answer[0] = 1;
		ArrayList<int[]> piramid = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			int[] a = new int[i];
			piramid.add(a);
		}
		piramid.get(0)[0] = 0;

		int horizontal = 0;
		int vertical = 0;
		int cnt = 1;
		int way = 1; // way : 1아래, 2오른쪽, 3 대각선위로

		int maxUp = 1;
		int maxDown = N - 1;
		int maxRight = N - 1;
		
		
		
		while (cnt <= area) {
			int[] nowArr = piramid.get(vertical);
			nowArr[horizontal] = cnt;

			if (way == 1) {//down
				if (vertical  == maxDown) {
					way = 2;
					maxDown -= 1;
					horizontal += 1;
				} 
				else {
					vertical += 1;
				}
			}
			else if (way == 2) {//right
				if (horizontal == maxRight) {
					way = 3;
					maxRight -= 2;
					horizontal -= 1;
					vertical -= 1;
				}
				else {
					horizontal += 1;
				}
			}
			else if (way == 3) {//left+up
				if (vertical  == maxUp) {
					way = 1;
					maxUp += 2;
					vertical+=1;
				}
				else {
					horizontal -= 1;
					vertical -= 1;
				}
			}
			
			cnt++;
	
		}
		
		int t = 1;
		for (int i = 1; i < piramid.size(); i++) {
			for (int j = 0; j < piramid.get(i).length; j++) {
				answer[t++] = piramid.get(i)[j];
			}
			
		}

	}
}
