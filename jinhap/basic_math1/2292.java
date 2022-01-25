package jinhap.basic_math1;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int line = 1;
    int tmp = 1;
    int input = sc.nextInt();
    while (tmp < input) {
      tmp += 6*line;
      line++;
    }
    System.out.println(line);
    sc.close();
  }
}
