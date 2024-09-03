package com.collection.part01_list.sort.model.vo;

import java.util.Objects;

public class Score implements Comparable<Score> {
	private String name;
	private int score;
	
	public Score() {}
	public Score(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "(name=" + name + ", score=" + score + ")";
	}
	@Override
	public int compareTo(Score o) {
		// 리턴값이 양수냐 음수냐에 따라 자리를 바꿀지 말지 결정.
		// 양수리턴 => 자리 바꾸겠다
		// 음수리턴 => 제자리
		
		//name으로(String) 오름차순 기본 정렬
		String otherName = o.getName();
		return name.compareTo(otherName);
		//String클래스의 compareTo()
		
		
		//"나".compareTo("가");
		//==> 양수 리턴 => 자리 바꿈
		//"가".compareTo("나");
		//==> 음수 리턴 => 자리 안바꿈
		
		//만약 name 내림차순 정렬 하고싶다면?
		//return -name.compareTo(otherName);
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(name, score);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		return Objects.equals(name, other.name) && score == other.score;
	}
	
}
