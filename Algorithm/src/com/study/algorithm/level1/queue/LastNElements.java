package com.study.algorithm.level1.queue;

import java.util.Scanner;

public class LastNElements {
	// 원하는 개수만큼 값을 계속 입력받고, 요솟수가 N인 배열에 마지막에 N개를 저장
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		final int N = 10;
		int[] a = new int[N];	// 입력받은 값을 저장
		int cnt = 0;			// 입력받은 개수
		int retry;				// 다시 한번?
		
		System.out.println("정수를 입력하세요.");
		
		do {
			System.out.printf("%d번째 정수 : ", cnt + 1);
			a[cnt++ % N] = stdIn.nextInt();
			
			System.out.println("계속 할까요? (예.1/아니요.0): ");
			retry = stdIn.nextInt();
		} while (retry == 1);
		
		int i = cnt - N;
		if(i < 0) i = 0;
		
		for(; i< cnt; i++) 
			System.out.printf("%2d번째 정수 = %d\n", i + 1, a[i % N]);
	}
}
