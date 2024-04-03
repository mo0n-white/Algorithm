import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] numList = new int[9];
        int maxNum = 0;
        int buffer = 0;
        int count = 0;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            numList[i] = scanner.nextInt();

            buffer = maxNum;
            maxNum = Math.max(numList[i], maxNum);
            count = (buffer == maxNum)? count : i;
        }

        System.out.println(maxNum);
        System.out.println(count+1);
    }
}
