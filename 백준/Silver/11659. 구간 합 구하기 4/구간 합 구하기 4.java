import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCount = sc.nextInt();    // 수의 개수 N
        int sumCount = sc.nextInt();    // 합을 구해야 하는 횟수 M
        int[] num = new int[numCount];  // 수 배열
        int[] pSum = new int[numCount]; // 합 배열

        num[0] = sc.nextInt();
        pSum[0] = num[0];

        for (int i = 1; i < numCount; i++) {
            num[i] = sc.nextInt();          // 수 배열 입력
            pSum[i] = pSum[i - 1] + num[i]; // 합 배열 계산
        }

        for(int i=0; i<sumCount; i++) {     // 합을 구해야 하는 횟수 M만큼 반복
            int start = sc.nextInt() - 1;   // 시작, 끝 인덱스(i번째 수) 입력
            int end = sc.nextInt() - 1;   
            
            if(start == 0) {  // 시작이 1인 경우, S[j]만 출력
                System.out.println(pSum[end]);
                continue;
            }
            
            System.out.println(pSum[end] - pSum[start-1]);  // S[j] - S[i-1] 계산
        }

        sc.close();
    }
}