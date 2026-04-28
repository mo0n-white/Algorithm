import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);    // N 입력
        int N = sc.nextInt();
        int numArr[] = new int[N+1]; // 1부터 N까지의 수 배열
        for(int i = 1; i <= N; i++) {
            numArr[i] = i;
        }

        long sum = numArr[1];
        int count = 1;  // sum == N인 경우 1개로 초기화 
        int start = 1;
        int end = 1;

        while(start < N) {     // 투 포인터
            if(sum < N) {           // sum < N : end++; sum += end;
                end++;
                sum += numArr[end];
            } else if(sum == N) {   // sum == N : count++; end++; sum += end;
                count++;
                end++;
                sum += numArr[end];
            } else {                // sum > N : sum -= start; start++;
                sum -= numArr[start];
                start++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
