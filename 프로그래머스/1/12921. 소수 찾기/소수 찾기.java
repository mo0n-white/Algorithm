import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;

        boolean[] isPrime = new boolean[n + 1];    // 에라토스테네스의 체 배열
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;    // 0과 1은 소수가 아니므로 false로 초기화
        
        for(int i=2; i<n+1; i++) {    // for 2~n까지 i
            if(isPrime[i]) {    // i가 true면 i의 배수들 false로 초기화
                for(int j=i*2; j<n+1; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        
        for(int i=2; i<n+1; i++) {    // 2~n까지 true인 값의 개수 answer에 더하기
            if(isPrime[i]) {
                answer++;
            }
        }

        return answer;
    }
}