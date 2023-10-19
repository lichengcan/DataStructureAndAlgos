package com.wy.datastructure.hash;

import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "wuyong");
		map.put(2, null);
		map.put(1, null);
		System.out.println(map.size());

		HashTable table = new HashTable();
		table.put(3,"xiaocan");
		table.put(4,null);
		table.put(5,1);
		System.out.println("table = " + table);
	}

}
