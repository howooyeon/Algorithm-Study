package com.study.algorithm.level1.queue;

public class IntArrayQueueTester {

	public static void main(String[] args) {
		IntArrayQueue queue = new IntArrayQueue(5);
		
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		
		System.out.println("큐의 크기: " + queue.size());
		System.out.println("큐가 가득 찼는가? " + queue.isFull());
		
		System.out.println("큐의 맨 앞 요소: " + queue.peek());
		
		
		int removedValue = queue.dequeue();
		System.out.println("제거한 값 : " + removedValue);
		System.out.println("큐의 크기: " + queue.size());
		
	}

}
