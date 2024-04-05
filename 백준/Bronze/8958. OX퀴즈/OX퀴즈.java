import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int loopNum = scanner.nextInt();
        int count;
        int[] sum = new int[loopNum];
        int i;

        for(i=0; i<loopNum; i++) {
            String testResult = scanner.next();
            char[] arr = testResult.toCharArray();      // char에 분할하는 법, String에 분할하는 법은 따로 또 있음
            int j = 0;

            count = 0;
            sum[i] = 0;


            while(j<testResult.length()) {
                if(arr[j] == 'O') {
                    sum[i] += count+1;
                    count++;
                }
                else {
                    count = 0;
                }
                j++;
            }
        }

        i=0;
        while(i<loopNum) {
            System.out.println(sum[i]);
            i++;
        }
    }
}
