package com.study.algorithm.level1.queue;

import java.util.*;

public class GenericQueue {
	public static void main(String[] args) {
		LinkedList<String> qu = new LinkedList<String>();
		
		qu.add("넷");
		qu.add("둘");
		qu.add("셋");
		qu.add("하나");
		
		System.out.println(qu.peek());
		System.out.println(qu);
		
		System.out.println(qu.poll());
		System.out.println(qu);
		System.out.println(qu.remove());
		System.out.println(qu);
		
		qu.remove("하나");
		System.out.println(qu);
		
	}
	
}
