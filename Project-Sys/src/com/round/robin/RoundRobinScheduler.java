package com.round.robin;

import java.util.*;

public class RoundRobinScheduler {
	Scanner sc = new Scanner(System.in);
	int[] bur, wai, ta, burst_time;
	int t = 0;
	int flag = 0;
	int total_size, q;
	int b = 0;

	public RoundRobinScheduler(int total_size) {
		this.total_size = total_size;
		ta = new int[total_size];
		burst_time = new int[total_size];
		bur = new int[total_size];
		wai = new int[total_size];

	}

	void get() {
		for (int i = 0; i < total_size; i++) {
			System.out.print("Enter burst time of P" + (i + 1) + ":");
			bur[i] = burst_time[i] = sc.nextInt();
		}
		System.out.print("Enter quantum time:");
		q = sc.nextInt();
	}

	void round() {
		System.out.println("\nRunning Queue (CPU) ");

		do {
			flag = 0;
			for (int i = 0; i < total_size; i++) {
				if (burst_time[i] >= q) {
					System.out.print("P" + (i + 1) + "\t");
					for (int j = 0; j < total_size; j++) {
						if (j == i)
							burst_time[i] = burst_time[i] - q;
						else if (burst_time[j] > 0)
							wai[j] += q;
					}
				} else if (burst_time[i] > 0) {
					System.out.print("P" + (i + 1) + "\t");
					for (int j = 0; j < total_size; j++) {
						if (j == i)
							burst_time[i] = 0;
						else if (burst_time[j] > 0)
							wai[j] += burst_time[i];
					}
				}
			}
			for (int i = 0; i < total_size; i++)
				if (burst_time[i] > 0)
					flag = 1;
		} while (flag == 1);
		
		for (int i = 0; i < total_size; i++)
			ta[i] = wai[i] + bur[i];
	}

	void display() {
		
		System.out.println("\n\nProcess\tBurst\tWaiting\tTurnaround");
		
		for (int i = 0; i < total_size; i++) {
			System.out.println("P" + (i + 1) + "\t" + bur[i] + "\t" + wai[i] + "\t" + ta[i]);
			b += wai[i];
			t += ta[i];
		}
		System.out.println("Average waiting time:" + (b / total_size));
		System.out.println("Average Turnaround time:" + (t / total_size));
	}

	public static void main(String arg[]) {
		Scanner s = new Scanner(System.in);
		System.out.print("Please Enter the total no of process:");
		int n = s.nextInt();
		RoundRobinScheduler obj = new RoundRobinScheduler(n);
		obj.get();
		obj.round();
		obj.display();
	}
	
}
