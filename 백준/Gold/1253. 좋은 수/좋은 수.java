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

        int start=0;
        int end=1;
        long add = numArr[start] + numArr[end];
        int count = 0;
        
        for (int i=0; i<N; i++) {   // 투 포인터; for i 0~N
            long target = numArr[i];
            start=0;
            end=1;
            if(start == i) {
                start++;
                if(start == end) end++;
            }
            if(end == i) end++;
            add = numArr[start] + numArr[end];

            while(start < N) {      // while start < N
                if(add < target) {  // add < 타겟 x : end++; add = start+end;
                    end++;
                    if(end == i) end++;
                    if(end >= N) {
                        start++;
                        end = start+1;
                        if(start == i) {
                            start++;
                            if(start == end) end++;
                        }
                        if(end == i) end++;
                        if(start >= N || end >= N) break;
                    }
                    add = numArr[start] + numArr[end];
                } else if(add == target) {  // add == x : count++; continue;?
                    count++;
                    break;
                } else {    // add > x : start++; add = start+end;
                    start++;
                    end = start+1;
                    if(start == i) {
                        start++;
                        if(start == end) end++;
                    }
                    if(end == i) end++;
                    if(start >= N || end >= N) break;
                    add = numArr[start] + numArr[end];
                }
            }
        }
        System.out.println(count);
    }
}
