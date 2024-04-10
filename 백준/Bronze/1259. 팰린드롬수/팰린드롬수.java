import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        while (input != 0) {
            String inputStr = Integer.toString(input);
            String output;
            char[] outputStr = inputStr.toCharArray();
            int len = inputStr.length();

            for (int i=0; i<len/2; i++) {
                swap(outputStr, i, len-1-i);
            }

            output = Arrays.toString(outputStr).replaceAll("\\[","").replaceAll("\\]","").replaceAll(",","").replaceAll(" ", "");

            if(inputStr.equals(output))
                System.out.println("yes");
            else
                System.out.println("no");

            input = scanner.nextInt();
        }
    }
    public static void swap(char[] arr, int n1, int n2) {
        char temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

}
