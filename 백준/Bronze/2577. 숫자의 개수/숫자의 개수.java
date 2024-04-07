import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 1;
        int[] numArr = new int[10];
        String numStr;

        for(int i=0; i<3; i++)
            num *= scanner.nextInt();

        numStr = Integer.toString(num);

        for(int j=0; j<10; j++) {
            for(int k=0; k<numStr.length(); k++)
                if(numStr.charAt(k) == (char)(j+'0'))
                    numArr[j]++;
            System.out.println(numArr[j]);
        }
    }
}