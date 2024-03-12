package com.study.algorithm.level1.queue;

public class IntArrayQueue {
	private int[] queue;	// 큐용 배열
	private int max;		// 큐 용량
	private int pointer;	// 현재 데이터 개수
	
	public IntArrayQueue(int capacity) {
		max = capacity;
		pointer = 0;
		queue = new int[max];
	}
	
	public void enqueue(int value) {
		if(pointer >= max) {
			throw new IllegalStateException("큐가 가득 찼습니다.");
		}
		queue[pointer++] = value;
	}
	
	public int dequeue() {
		if(pointer <= 0) {
			throw new IllegalStateException("큐가 비어 있습니다.");
		}
		int value = queue[0];
		reconstruct();
		pointer--;
		return value;
	}
	
	public int peek() {
		if(pointer <= 0) {
			throw new IllegalStateException("큐가 비어있습니다.");
		}
		return queue[0];
	}
	
	public boolean isEmpty() {
		return pointer == 0;
	}
	
	public boolean isFull() {
		return pointer == max;
	}
	
	public int size() {
		return pointer;
	}
	
	public void clear() {
		pointer = 0;
	}
	
	private void reconstruct() {
		for(int i = 1 ; i < pointer; i++) {
			queue[i- 1] = queue[i];
		}
		queue[pointer - 1] = 0;
	}
	
	

}
