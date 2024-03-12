package com.study.algorithm.level1.recursion;

import java.util.Scanner;

public class RecurX1 {
	static void recur(int n) {
		if (n > 0) {
			recur(n - 1);
			System.out.println(n);
			// 꼬리 재귀를 제거
			n = n - 2;
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.print("정수를 입력하세요 : ");
		int x = stdIn.nextInt();

		recur(x);
	}
}
