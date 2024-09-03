package com.collection.part03_map.hashMap;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestHashMap {
	public void testHashMap() {
		HashMap hmap = new HashMap();
		//Map hmap2 = new HashMap();
		
		//Map은 Collection의 하위클래스가 아니므로 오류발생.
		//Collection hmap3 = new HashMap();
		
		//키&밸류로 저장.
		hmap.put("one", new Date());
		hmap.put(12, "apple");
		hmap.put(3.3, 123);
		
		System.out.println("hmap: " + hmap);
		
		//키는 중복 저장 되지 않는다.
		hmap.put(12, "banana");
		System.out.println("hmap: " + hmap);
		
		//벨류는 중복 저장 된다.
		hmap.put(11, "banana");
		hmap.put(13, "banana");
		System.out.println("hmap: " + hmap);

		System.out.println("키 13의 벨류 값: " + hmap.get(13));
		
		hmap.remove(13);
		System.out.println("hmap: " + hmap);
		
		System.out.println("hmap에 저장된 객체 수: " + hmap.size());
		
		
		
		System.out.println("=====================");
		//Map에 저장된 객체 연속 처리
		hmap.clear();

		hmap.put("one", "물");
		hmap.put("two", "마우스");
		hmap.put("three", "키보드");
		hmap.put("four", "이어폰");
		hmap.put("five", "휴대폰");
		
		System.out.println(hmap);
		
		
		//1. keySet() : 키만 따로 set으로 만들어 리턴해주는 메소드.
		//	iterator()로 키에 대한 목록 만든다.
		Set set = hmap.keySet();
		Iterator keyIter = set.iterator();
		
		while(keyIter.hasNext()) {
			String key = (String)keyIter.next();
			String value = (String)hmap.get(key);
			System.out.println(key+"="+value);	
		}
		
		//2. values() : 벨류만 Collection 만들어 리턴
		Collection values = hmap.values();
		
		Iterator valIter = values.iterator();
		while(valIter.hasNext()) {
			System.out.println(valIter.next());
		}
		
		Object[] valArr = values.toArray();
		for(int i=0; i<valArr.length; i++) {
			System.out.println(i+"="+valArr[i]);
		}
		
		//3.entrySet() : Entry들을 set으로 만들어 리턴
		Set eSet = hmap.entrySet();
	
		Iterator entryIter = eSet.iterator();
		while(entryIter.hasNext()) {
			Map.Entry entry = (Map.Entry)entryIter.next();
			
			System.out.println(entry.getKey()+"="+entry.getValue());	
		}
	}
}
