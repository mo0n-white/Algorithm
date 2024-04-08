import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);

        int num = scanner.nextInt();
        int[] numArr = new int[num];
        int count = 0;

        for(int i=0; i<num; i++)
            numArr[i] = scanner.nextInt();

        for(int j=0; j<num; j++) {
            if(numArr[j] == 1) {
                ;
            } else if (numArr[j] == 2) {
                count++;
            } else {
                int buf = 0;
                for(int k=2; k<numArr[j]; k++) {
                    buf += (numArr[j]%k == 0)? 1 : 0;
                }
                count += (buf > 0)? 0 : 1;
            }
        }
        System.out.print(count);
    }
}
