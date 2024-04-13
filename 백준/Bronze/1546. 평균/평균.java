import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int subCount = scanner.nextInt();
        int[] score = new int[subCount];
        int maxScore = 0;
        int sum = 0;
        double newAvg = 0.0;

        for(int i=0; i<subCount; i++) {
            score[i] = scanner.nextInt();
            sum += score[i];
            maxScore = Math.max(maxScore, score[i]);
        }

        newAvg = ((double)sum/(double)subCount)/(double)maxScore*100;
        System.out.print(newAvg);
    }
}