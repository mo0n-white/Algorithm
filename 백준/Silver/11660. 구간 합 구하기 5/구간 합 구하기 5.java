import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arrSize = Integer.parseInt(st.nextToken());     // 표의 크기 N
        int sumCount = Integer.parseInt(st.nextToken());    // 합을 구해야 하는 횟수 M
        int[][] numArr = new int[arrSize][arrSize];
        long[][] sumArr = new long[arrSize+1][arrSize+1];

        for(int i=0; i<arrSize; i++ ) {     // 표(2차원 배열)에 수 저장 - 이중 반복문
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<arrSize; j++) {
                numArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // for(int i=0; i<arrSize; i++) {      // 2차원 합 배열 계산 1. 1행 1열 저장
        //     sumArr[i+1][1] = numArr[0][i];
        //     sumArr[1][i+1] = numArr[i][0];
        // }

        for(int i=1; i<=arrSize; i++) {     // 2차원 합 배열 계산 2. S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + A[i][j]
            for(int j=1; j<=arrSize; j++) {
                sumArr[i][j] = sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1] + numArr[i-1][j-1];
            }
        }

        for(int i=0; i<sumCount; i++) {  // for(0~M)
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());  // 시작 = 첫 두 숫자
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());  // 끝 = 다음 두 숫자
            int y2 = Integer.parseInt(st.nextToken());

            // 구간 합 = S[i2][j2] - S[i1-1][j2] - S[i2][j1-1] + S[i1-1][j1-1]
            long result = sumArr[x2][y2] - sumArr[x1-1][y2] - sumArr[x2][y1-1] + sumArr[x1-1][y1-1];
            System.out.println(result);
        }
    }
}