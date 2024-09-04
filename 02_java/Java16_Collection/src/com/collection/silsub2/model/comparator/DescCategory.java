package com.collection.silsub2.model.comparator;

import java.util.Comparator;

import com.collection.silsub2.model.vo.Book;

public class DescCategory implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		//카테고리순 내림차순으로 정렬
		int s1 = ((Book)o1).getCategory();
		int s2 = ((Book)o2).getCategory();
				
		if(s1<s2) {
			return 1;
		}else if(s1>s2) {
			return -1;
		}else {
			return 0;
		}
	}

}
