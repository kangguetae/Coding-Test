package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 오픈채팅방_해결 {
	public static void main(String [] args) {
		String [] s = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
				"Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		
		String [] result = solution(s);
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
		
	}
	
	public static String[] solution(String[] record) {
		StringTokenizer st;
		
		ArrayList<String []> id_do = new ArrayList<>();
		Map<String, String> id_nickName = new HashMap<>();
		
		for (int i = 0; i < record.length; i++) {
			st = new StringTokenizer(record[i], " ");
			String inNOut = st.nextToken();
			String uId = st.nextToken();
			
			
			if(inNOut.equals("Leave")) {
				id_do.add(new String [] {uId, inNOut});
			}
			else if(inNOut.equals("Change")) {
				String nickname = st.nextToken();
				if(id_nickName.containsKey(uId)) {
					id_nickName.put(uId, nickname);
				}
				
			}
			else { // enter
				String nickname = st.nextToken();
				id_do.add(new String[] {uId, inNOut});
				id_nickName.put(uId, nickname);
			}
			
		}
		
		
		String [] answer = new String[id_do.size()];
		
		for (int i = 0; i < id_do.size(); i++) {
			StringBuilder sb = new StringBuilder();
			
			sb.append(id_nickName.get(id_do.get(i)[0]));
			switch(id_do.get(i)[1]){
				case "Enter":
					sb.append("님이 들어왔습니다.");
					break;
				case "Leave":
					sb.append("님이 나갔습니다.");
					break;
			}
			answer[i] = sb.toString();
		
		}
        return answer;
    }
}
