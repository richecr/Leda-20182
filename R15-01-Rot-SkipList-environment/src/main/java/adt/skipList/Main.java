package adt.skipList;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		SkipListImpl<Integer> s = new SkipListImpl<>(5);
		
		s.insert(0, 1, 2);
		s.insert(0, 5, 4);
		System.out.println(s.search(0).getValue());
	}

}
