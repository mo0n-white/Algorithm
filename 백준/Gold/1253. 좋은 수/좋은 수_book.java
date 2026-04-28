import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // N 입력

        st = new StringTokenizer(br.readLine());
        long numArr[] = new long[N];    // N개의 수 배열 입력
        for (int i = 0; i < N; i++) {
            numArr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(numArr);    // 정렬 <-이거 조금 더 알아보기

        int start;
        int end;
        long add;
        int count = 0;
        
        for (int i=0; i<N; i++) {   // 투 포인터; for i 0~N
            if(N == 1 || N == 2) break;

            start =  0;
            end = N-1;

            if(start == i) start++;
            if(end == i) end--;

            add = numArr[start] + numArr[end]; // 런타임 에러 N이 1인 경우, start와 end가 1이 되어버림

            long target = numArr[i];

            while(start < end) {
                if (add < target) {         // add < target : start++; add = start + end; 
                    start++;
                    if(start == i) start++;
                    if(start >= end) break; // 런타임에러 방지
                    add = numArr[start] + numArr[end];
                } else if (add > target) {  // add > target : end--; add = start + end;
                    end--;
                    if(end == i) end--;
                    if(start >= end) break; // 런타임에러 방지
                    add = numArr[start] + numArr[end];
                } else {                    // add == target : count++;
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
