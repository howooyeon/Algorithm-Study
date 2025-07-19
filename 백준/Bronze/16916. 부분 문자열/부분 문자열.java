import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();   // 전체 문자열 S
        String pattern = sc.next(); // 부분 문자열 P

        if (kmp(text, pattern)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    // KMP 알고리즘
    public static boolean kmp(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);
        int i = 0; // text index
        int j = 0; // pattern index

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) {
                    return true; // 패턴이 매칭됨
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return false;
    }

    // 부분 일치 테이블 (LPS 배열) 생성
    public static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0; // 이전 lps 길이
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
