package day0607.DartTest;

import java.util.Scanner;

public class DartGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("다트입력 : ");
        String dartResult = scanner.nextLine();

        DartResultAnalyzer ra = new DartResultAnalyzer(dartResult);
        int DartScore = ra.getDartScore();
        String DartScoreEquation = ra.getDartScoreEquation();

        System.out.printf("score : %s     equation : %s", DartScore, DartScoreEquation);
    }
}
