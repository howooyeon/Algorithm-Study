package com.study.algorithm.level1.recursion;

import java.util.Scanner;

// 재귀 함수를 메모화로 구현
public class RecurMemo {
	static String[] memo;
	
	// 메모화를 도입한 recur 메서드
	static void recur(int n) {
		if(memo[n + 1] != null)
			System.out.print(memo[n + 1]);	// 메모로 출력
		else {
			if(n > 0) {
				recur(n - 1);
				System.out.println(n);
				recur(n - 2);
				memo[n + 1] = memo[n] + n + "\n" + memo[n - 1];	// 메모화
			} else {
				memo[n + 1] = "";
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int x = sc.nextInt();
		
		memo = new String[x + 2];
		recur(x);
	}
	
}
