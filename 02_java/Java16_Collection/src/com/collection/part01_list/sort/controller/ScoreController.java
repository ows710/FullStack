package com.collection.part01_list.sort.controller;

import java.util.ArrayList;

import com.collection.part01_list.sort.model.vo.Score;

public class ScoreController {
	public void scoreSort() {
		
		ArrayList list = new ArrayList();
		
		
		list.add(new Score("이창진",99));
		list.add(new Score("김창진",75));
		list.add(new Score("박창진",82));
		
		list.add(new Score("강창진",59));
		list.add(new Score("최창진",68));
		list.add(new Score("정창진",86));
		
		System.out.println("list: "+list);
		
		list.sort(null);
		System.out.println("list: "+list);
		
		list.sort(new ScoreSorting());
		System.out.println("list: "+list);
		
		list.sort(new ScoreSorting2());
		System.out.println("list: "+list);
		
	}
}
