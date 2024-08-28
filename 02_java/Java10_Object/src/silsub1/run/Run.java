package silsub1.run;

import silsub1.model.vo.Member;

public class Run {
	public static void main(String[] args) {
		Member m1 = new Member();
		m1.setMemberId("id");
		m1.setMemberPwd("pwd");
		m1.setMemberName("name");
		m1.setAge(20);
		m1.setGender('남');
		m1.setPhone("010-2222-1234");
		m1.setEmail("email@gmail.com");
		System.out.println(m1.getMemberId()+", "+m1.getMemberPwd()+", "+m1.getMemberName()+", "+m1.getAge()+", "+m1.getGender()+", "+m1.getPhone()+", "+m1.getEmail());
	}

}
