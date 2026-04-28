import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 수의 개수 N, 나누는 수 M 입력
        int M = Integer.parseInt(st.nextToken());

        /*
        // 1) 메모리 초과
        int num[] = new int[N+1];           // 누적 합이 아니라 구간 합을 저장해야 하므로 수 배열 저장 필요함 // + 메모리가 얘 문젠가 싶어서 long으로도 바꿔봄
        long pSum[][] = new long[N+1][N+1]; // 구간 합 저장할 2차원 배열
        int count = 0;
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++) {   // N개의 수 배열 입력
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) { // 구간 합 생성(2차원 배열로 1~N, 2~N, ...)
            for(int j=i; j<=N; j++) {
                pSum[i][j] = pSum[i][j-1] + num[j];
                if(pSum[i][j] % M == 0) {   // 생성과 동시에 M으로 나누어떨어지는 구간의 개수 카운트
                    count++;
                }
            }
        }
        */

        /*
        // 2) 시간 초과
        long pSum[] = new long[N+1]; // 구간 합 저장할 배열
        int count = 0;
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++) {   // 누적 합 생성
            pSum[i] = pSum[i-1] + Long.parseLong(st.nextToken());
        }

        for(int i=1; i<=N; i++) {
            for(int j=i-1; j>=0; j--) {             // 주의
                if((pSum[i] - pSum[j]) % M == 0) {  // M으로 나누어떨어지는 구간의 개수 카운트
                    count++;
                }
            }
        }
        */

        int remain[] = new int[M];  // 나머지가 x인 수의 개수를 저장하는 배열
        long pSum[] = new long[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {    // N개의 수를 입력받음과 동시에 누적 합을 생성하고, 이를 M으로 나눈 나머지로 바로 저장
            pSum[i] = (pSum[i-1] + Long.parseLong(st.nextToken())%M)%M;
            remain[(int)pSum[i]]++;   // 나머지가 x인 수의 개수를 하나 증가 시킨다.
        }

        long count = (long)remain[0];
        for(int i=0; i<M; i++) {    // 0인 건 이미 count 했지만, 동일한 나머지값에도 포함해야 함!
            if(remain[i] < 2) continue;
            count += (long)remain[i]*(remain[i]-1)/2;   // nC2로 2개의 누적합범위를 선택하는 경우의 수
        }

        System.out.println(count);
    }
}