import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;

        boolean[] isPrime = new boolean[n + 1];    // 에라토스테네스의 체 배열
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;    // 0과 1은 소수가 아니므로 false로 초기화
        
        for(int i=2; i*i<n+1; i++) {    // for 2~n까지 i -> 합성수는 반드시 제곱근 이하의 약수를 하나 이상 가짐. 제곱근까지만 계산하면 됨. ex) n=100일때 10*10까지만 생각하고 11*11 부터는 생각 x
            if(isPrime[i]) {    // i가 true면 i의 배수들 false로 초기화
                for(int j=i*i; j<n+1; j+=i) {   // i*i로 시작. i 이전 수들은 이미 다 제거된 숫자들.
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