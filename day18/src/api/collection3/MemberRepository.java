package api.collection3;

import java.util.HashMap;
import java.util.Map;

public class MemberRepository {
	private Map<String, String> members = new HashMap<>();
	
	public MemberRepository() {
		members.put("testuser", "test1234");
		members.put("student", "std1234");
		members.put("admin", "adm1234");
		members.put("client", "client1234");
	}
	
	public boolean login(String id, String pw) {
		return members.containsKey(id) && members.get(id).equals(pw);
	}
}
