package baekjoon.nm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*
 * N과 M (10)
 * N개의 자연수와 자연수 M이 주어졌을 때, 
 * 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. 
 * N개의 자연수는 모두 다른 수이다.
 * - N개의 자연수 중에서 M개를 고른 수열
 * - 고른 수열은 비내림차순이어야 한다.
 * -- 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
 */
public class Q15664 {
	static int[] arr;
	static boolean[] visited;
	static int[] value;
	static BufferedWriter out;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		out = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		value = new int[M];
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		solution(M, 0, 0);
		out.flush();
		out.close();
	}

	public static void solution(int M, int count, int start) throws IOException {
		if (count == M) {
			for (int i=0; i<M; i++) {
				out.append(value[i] + " ");
			}
			out.append("\n");
			return;
		}
		HashSet<Integer> used = new HashSet<Integer>();
		//boolean[] used = new boolean[10001]; // 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.
		for (int i=start; i<arr.length; i++) {
			if ((!used.isEmpty() && !used.contains(arr[i]) && !visited[i]) || (used.isEmpty() && !visited[i])) {
				visited[i] = true;
				value[count] = arr[i];
				used.add(arr[i]);
				solution(M, count + 1, i);
				visited[i] = false;
			}

		}
	}
}
