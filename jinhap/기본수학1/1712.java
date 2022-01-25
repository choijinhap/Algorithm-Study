package jinhap;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int start = sc.nextInt();
    int cost = sc.nextInt();
    int price = sc.nextInt();
    int answer;
    if (price > cost) answer = start / (price - cost)+1; else answer = -1;
    System.out.println(answer);
    sc.close();
  }
}
